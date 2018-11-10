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
	 * ����table.jspҳ��
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/table", method = RequestMethod.GET)
	public String ApplyBusiness(String f_service, String service_number, Model model) {
		System.out.println(f_service + "+" + service_number);
		// ע��f_service,service_number��BusinessVo
		BusinessVo businessVo = new BusinessVo();
		businessVo.setF_service(f_service);
		businessVo.setService_number(service_number);
		businessVo.setBusiness_number(f_service + service_number + randomValue.getServiceNumber());
		businessVo.setService_name(easyCheck.getservice_number(f_service, service_number));

		List<BAndMVo> bAndMVos = easyCheck.getBAndMVo(f_service, service_number);
		List<HousingProjectVo> housingProjectVos = housingProjectService.selectAll();
		
		// ������table.jspҳ�棬����table input����
		// ����������б�
		model.addAttribute("bAndMVos", bAndMVos);
		System.out.println(bAndMVos.toString());
		// �������б�
		model.addAttribute("banks", RandomValue.getBank());
		model.addAttribute("roomrecordVo", new RoomrecordVo());
		model.addAttribute("businessVo", businessVo);
		System.out.println(businessVo);
		//��������Ŀ
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
			msg.put("msg", "�ύ�ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
			msg.put("msg", "�ύʧ��,ҵ���:"+businessVo.getBusiness_number()+"���������Ƿ�����");
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
			msg.put("msg", "�ύ�ɹ�!");
		} catch (Exception e) {
			msg.put("msg", "�ύʧ��,ҵ���:"+roomrecordVo.getBusiness_number()+"���������Ƿ�����");
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
					//���ô洢·��
					String leftPath = httpSession.getServletContext().getRealPath("/upfile");
					//�����ļ��� ҵ���+��������
					String filename = business_number+bAndMVos.get(i).getMaterial_number();
					
					//�����ļ���׺����֧��jpg��png
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
						model.addAttribute("msg", "���ҵ��ɹ�");
					}else {
						String suffix = filename.substring(filename.lastIndexOf(".") + 1);
						roomrecordService.deleteByBusiness_number(business_number);
						businessService.deleteBybusiness_number(business_number);
						model.addAttribute("msg", "��֧��"+suffix+"��ʽ���ļ��������png,jpgͼƬ");
					}
				} else {
					roomrecordService.deleteByBusiness_number(business_number);
					businessService.deleteBybusiness_number(business_number);
					model.addAttribute("msg", "�����ϴ����ļ�");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			roomrecordService.deleteByBusiness_number(business_number);
			businessService.deleteBybusiness_number(business_number);
			model.addAttribute("msg", "���ҵ��ʧ�ܣ���ȷ���ļ���С�Ƿ�С��10M����ΪͼƬ��ʽ");
		}
		model.addAttribute("business_number", business_number);
		return "message";
	}
	
	/**
	 * ѡ���Ӧ�ķ�����Ŀ���ص�ַ
	 * @param item_no
	 * @return
	 */
	@RequestMapping(value="/housingitemchange",method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> housingitemchange(String item_no) {
		Map<String, Object> map = new HashMap<>();
		if (item_no==null||"".equals(item_no)) {
			map.put("address","��δѡ�񷿲���Ŀ");
		} else {
			map.put("address", housingProjectService.selectByItem_no(item_no).getAddress());
		}
		return map;
		
	}
	
	/**
	 * ���business_number��Ӧ�Ĳ���ͼƬ
	 * ���󷽷�getImages?business_number=��ҵ���
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
