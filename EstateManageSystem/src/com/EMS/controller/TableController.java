package com.EMS.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.EMS.model.service.BAndMService;
import com.EMS.model.service.BusinessService;
import com.EMS.model.service.EasyCheck;
import com.EMS.model.service.HousingProjectService;
import com.EMS.model.service.MaterialService;
import com.EMS.model.service.MtypeService;
import com.EMS.model.service.RoomrecordService;
import com.EMS.model.service.ServiceService;
import com.EMS.model.vo.BAndMVo;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.HousingProjectVo;
import com.EMS.model.vo.MaterialVo;
import com.EMS.model.vo.RoomrecordVo;
import com.EMS.model.vo.ServiceVo;
import com.EMS.test.RandomValue;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Attr;

@Controller
public class TableController {

	@Autowired
	private BusinessService businessService;

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private BAndMService bAndMService;
	
	@Autowired
	private RoomrecordService roomrecordService;
	
	@Autowired
	private MaterialService materialService;
	
	@Autowired
	private MtypeService mtypeService;
	
	@Autowired
	private EasyCheck easyCheck;
	
	@Autowired
	private HousingProjectService housingProjectService;

	private RandomValue randomValue = new RandomValue();

	/**
	 * 请求table.jsp页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String ApplyBusiness(String f_service, String service_number, Model model) {
		System.out.println(f_service + "+" + service_number);
		// 注入f_service,service_number到BusinessVo
		BusinessVo businessVo = new BusinessVo();
		businessVo.setF_service(f_service);
		businessVo.setService_number(service_number);
		businessVo.setBusiness_number(f_service + service_number + randomValue.getServiceNumber());
		businessVo.setService_name(easyCheck.getservice_number(f_service, service_number));

		List<BAndMVo> bAndMVos = easyCheck.getBAndMVo(f_service, service_number);
		List<HousingProjectVo> housingProjectVos = housingProjectService.selectAll();
		
		// 传对象到table.jsp页面，用于table input构成
		// 传所需材料列表
		model.addAttribute("bAndMVos", bAndMVos);
		System.out.println(bAndMVos.toString());
		// 传银行列表
		model.addAttribute("banks", RandomValue.getBank());
		model.addAttribute("roomrecordVo", new RoomrecordVo());
		model.addAttribute("businessVo", businessVo);
		System.out.println(businessVo);
		//传房产项目
		model.addAttribute("housingProjectVos", housingProjectVos);
		return "table";
	}

	@RequestMapping(value = "/ApplyBusiness", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ApplyBusiness(@RequestBody BusinessVo businessVo, Model model) {
		
		businessVo.setbAndMVos(easyCheck.getBAndMVo(
				businessVo.getF_service(), businessVo.getService_number()));
		businessVo.setService_name(easyCheck.getservice_number(
				businessVo.getF_service(), businessVo.getService_number()));
		Map<String, Object> msg = new HashMap<>();
		System.out.println(businessVo.toString());
		try {
			businessService.saveBusiness(businessVo);
			msg.put("msg", "提交成功!");
		} catch (Exception e) {
			e.printStackTrace();
			msg.put("msg", "提交失败,业务号:"+businessVo.getBusiness_number()+"请检查所填是否完整");
			roomrecordService.deleteByBusiness_number(businessVo.getBusiness_number());
			businessService.deleteBybusiness_number(businessVo.getBusiness_number());
		}
		return msg;
	}

	@RequestMapping(value="/ApplyRoomrecord",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> ApplyRoomrecord(@RequestBody RoomrecordVo roomrecordVo,Model model){
		
		Map<String, Object> msg = new HashMap<>();
		try {
			roomrecordService.saveRoomrecord(roomrecordVo);
			msg.put("msg", "提交成功!");
		} catch (Exception e) {
			msg.put("msg", "提交失败,业务号:"+roomrecordVo.getBusiness_number()+"请检查所填是否完整");
			roomrecordService.deleteByBusiness_number(roomrecordVo.getBusiness_number());
			businessService.deleteBybusiness_number(roomrecordVo.getBusiness_number());
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/upfile1", method = RequestMethod.POST)
	public String addfile(@RequestParam("materials") MultipartFile[] materials,
			HttpServletRequest request, HttpSession httpSession,Model model)
			throws Exception {
		String business_number = request.getParameter("business_number"); 
	    String f_service = request.getParameter("f_service"); 
	    String service_number = request.getParameter("service_number");
	    List<BAndMVo> bAndMVos = easyCheck.getBAndMVo(f_service, service_number);	    
		try {
			for (int i = 0; i < materials.length; i++) {
				if (materials[i].getSize() > 0) {
					//设置存储路径
					String leftPath = httpSession.getServletContext().getRealPath("/upfile");
					//设置文件名 业务号+材料类型
					String filename = business_number+bAndMVos.get(i).getMaterial_number();
					
					//设置文件后缀，仅支持jpg和png
					if (materials[i].getOriginalFilename().endsWith("jpg")||materials[i].getOriginalFilename().endsWith("png")) {
						File file;
						if (materials[i].getOriginalFilename().endsWith("jpg")) {
							filename+=".jpg";
						}else {
							filename+=".png";
						}
						file = new File(leftPath, filename);
						materials[i].transferTo(file);
						MaterialVo materialVo = new MaterialVo();
						materialVo.setBusiness_number(business_number);
						materialVo.setFile_name(filename);
						materialVo.setFile_size(""+materials[i].getSize());
						materialVo.setForm(""+materials[i].getContentType());
						materialVo.setMaterial_type_number(bAndMVos.get(i).getMaterial_number());
						materialVo.setMaterial_address(leftPath+filename);
						materialService.save(materialVo);
						model.addAttribute("msg", "添加业务成功");
					}else {
						String suffix = filename.substring(filename.lastIndexOf(".") + 1);
						roomrecordService.deleteByBusiness_number(business_number);
						businessService.deleteBybusiness_number(business_number);
						model.addAttribute("msg", "不支持"+suffix+"格式的文件，请添加png,jpg图片");
					}
				} else {
					roomrecordService.deleteByBusiness_number(business_number);
					businessService.deleteBybusiness_number(business_number);
					model.addAttribute("msg", "不能上传空文件");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			roomrecordService.deleteByBusiness_number(business_number);
			businessService.deleteBybusiness_number(business_number);
			model.addAttribute("msg", "添加业务失败，请确认文件大小是否小于10M，或为图片格式");
		}
		model.addAttribute("business_number", business_number);
		return "message";
	}
	
	/**
	 * 选择对应的房屋项目返回地址
	 * @param item_no
	 * @return
	 */
	@RequestMapping(value="/housingitemchange",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> housingitemchange(String item_no) {
		Map<String, Object> map = new HashMap<>();
		if (item_no==null||"".equals(item_no)) {
			map.put("address","还未选择房产项目");
		} else {
			map.put("address", housingProjectService.selectByItem_no(item_no).getAddress());
		}
		return map;
		
	}
	
	/**
	 * 获得business_number对应的材料图片
	 * 请求方法getImages?business_number=填业务号
	 * @param model
	 * @param business_number
	 * @return
	 */
	@RequestMapping(value="/getImages",method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Object> getImages(String business_number){
		
        List<MaterialVo> materialVos = materialService.selectByBusiness_number(business_number);
        ArrayList<Object> materialnames = new ArrayList<>();
        for (MaterialVo materialVo : materialVos) {
        	Map<String, Object> map = new HashMap<>();
        	map.put("file_name", materialVo.getFile_name());
        	map.put("file_type", mtypeService.selectMaterial_name(
        			materialVo.getMaterial_type_number()).getMaterial_name());
        	materialnames.add(map);
		}
		return materialnames;
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(Model model,String business_number){
		model.addAttribute("business_number", business_number);
		return "message";
	}
}
