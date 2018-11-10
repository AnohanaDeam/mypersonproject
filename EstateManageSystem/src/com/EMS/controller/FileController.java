package com.EMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EMS.model.service.BusinessService;
import com.EMS.model.service.FileService;
import com.EMS.model.service.HousingProjectService;
import com.EMS.model.service.RoomrecordService;
import com.EMS.model.vo.FileVo;

@Controller
@RequestMapping(value="/Admin")
public class FileController {
	@Autowired
	private FileService fileService;
	
	@Autowired
	private RoomrecordService roomrecordService;
	
	@Autowired
	private HousingProjectService housingProjectService;

	@RequestMapping(value = "/fileIn")
	public String file2(Model model) {
		try {
			List<FileVo> fileVos = fileService.selectAll();
			for (FileVo fileVo : fileVos) {
				fileVo.setAddress(
						housingProjectService.selectByItem_no(
								roomrecordService.selectRoomrecordAllByNumber(
								fileVo.getBusiness_number()
								).getItem_no()
							).getAddress()
						);
			}
			model.addAttribute("files", fileVos);
			System.out.println(fileVos.toString());
			return "fileIn";
		} catch (Exception e) {
			model.addAttribute("msg", "请求出现错误，无法继续，帮你回到首页");
			e.printStackTrace();
			return "file";
		}
		
	}
	
	@RequestMapping(value = "/file")
	public String file1(Model model) {
		try {
			return "file";
		} catch (Exception e) {
			model.addAttribute("msg", "请求出现错误，无法继续，帮你回到首页");
			e.printStackTrace();
			return "service";
			
		}
		
	}
	
	@RequestMapping(value = "/file-management")
	public String file(Model model) {
		try {
			model.addAttribute("files", fileService.selectAll());
			//System.out.println(fileService.selectAll());
			return "file-management";
		} catch (Exception e) {
			model.addAttribute("msg", "请求出现错误，无法继续，帮你回到首页");
			e.printStackTrace();
			return "file";
		}
		
	}

	@RequestMapping(value = "/updateFile", method = RequestMethod.GET)
	public String updateFile(Model model, String business_number) {
		FileVo fileVo = fileService.selectByBusiness_number(business_number);
		System.out.println(fileVo);
		model.addAttribute("fileVo", fileVo);
		return "updateFile";
	}
	
    @RequestMapping(value="/updatefileIn", method=RequestMethod.POST)
    public String updateFileIn(FileVo fileVo,Model model){
    	try {
    		//System.out.println("11--11--"+fileVo);
        	fileService.updateByBusiness_number(fileVo);
        	return "file";
		} catch (Exception e) {
			model.addAttribute("msg", "请求出现错误，无法继续，帮你回到首页");
			e.printStackTrace();
			return "file";
		}
    }
    
    
    
	@RequestMapping(value = "/updateFile", method = RequestMethod.POST)
	public String updateFile11111(FileVo fileVo,Model model) {
		try {
			fileService.updateByBusiness_number(fileVo);
			return "redirect:file-management";
		} catch (Exception e) {
			model.addAttribute("msg", "请求出现错误，无法继续，帮你回到首页");
			e.printStackTrace();
			return "file";
		}
		
	}
	
	@RequestMapping(value="/deleteFile",method = RequestMethod.GET)
	public String deleteFile(String business_number,Model model){
		try {
			fileService.deleteByBusiness_number(business_number);
			model.addAttribute("msg", "操作成功！");
			return "file";
		} catch (Exception e) {
			model.addAttribute("msg", "请求出现错误，无法继续，帮你回到首页");
			e.printStackTrace();
			return "file";
		}
	
	}
	
	 /**
	  * 通过产权人模糊查询获得档案 
	  * @param name
	  * @return
	  */
	@RequestMapping(value = "/FgetInfoLike", method = RequestMethod.GET)
	public @ResponseBody List<FileVo> FgetInfoLike(String property_owner) {
		System.out.println(property_owner);
		List<FileVo>  list =  fileService.selectForLike(property_owner);
		System.out.println(list.toString());
		return list;
	}
	
	/**
	 * 通过业务宗号模糊查询获得档案
	 * @param number
	 * @return
	 */
	@RequestMapping(value = "FgetInfonumber", method = RequestMethod.GET)
	public @ResponseBody List<FileVo> FgetInfonumber(String business_number) {
		System.out.println("业务号"+business_number);
		List<FileVo>  list =  fileService.selectFornumber(business_number);
		return list;
	}
	
	/**
	 * 通过业务类型模糊查询获得档案
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "FgetInfotype", method = RequestMethod.GET)
	public @ResponseBody List<FileVo> FgetInfotype(String business_types) {
		System.out.println("业务类型"+business_types);
		List<FileVo>  list =  fileService.selectFortype(business_types);
		return list;
	}
}
