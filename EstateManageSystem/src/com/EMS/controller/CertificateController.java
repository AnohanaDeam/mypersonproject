package com.EMS.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.EMS.model.service.BusinessService;
import com.EMS.model.service.CertificateService;
import com.EMS.model.service.EasyCheck;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.CertificateVo;
/**
 * 证件领取表
 * @author JTXY
 *
 */
@Controller
@RequestMapping(value="/Admin")
public class CertificateController {
	@Autowired
	private BusinessService businessService;
	@Autowired
	private EasyCheck easyCheck;
	@Autowired
	private CertificateService certificateService;
	
	/*
	 * 显示缮证信息
	 */
	/*@RequestMapping(value="/selectCertificate",method=RequestMethod.GET)
	public String Certificate(BusinessVo businessVo,Model model){
		List<BusinessVo> businessList = businessService.selectBusinessAll();
		for(BusinessVo bv : businessList){
			String service_name = easyCheck.getservice_number(bv.getF_service(), bv.getService_number());
			bv.setService_name(service_name);
		}
		model.addAttribute("businessList", businessList);
		return "certificate";
	}*/
	@RequestMapping(value="/goCertificate-new",method=RequestMethod.GET)
	public String Certificate(CertificateVo certificateVo,Model model){
		List<CertificateVo> certificateList = certificateService.selectAll();
		model.addAttribute("certificateList", certificateList);
		return "certificate-new";
	}
	
	/*
	 * 修改证件领取表
	 */
	@RequestMapping(value="/updateCertificate",method=RequestMethod.POST)
	public String UpdateCertificate(String business_number){
		System.out.println("business_number-->"+business_number);
		CertificateVo cv = new CertificateVo(business_number, "是");
		certificateService.updateReceive(cv);
		return "redirect:/Admin/goCertificate-new";
	}
	/*
	 * 搜索框查询证件领取表信息
	 */
	/*@RequestMapping(value="/selectBySearch",method=RequestMethod.POST)
	public String selectBySearch(String searchInput,String searchSelect,Model model) {
		List<CertificateVo> certificateList;
		if(searchInput != null || searchInput.equals("")){
			switch (searchSelect) {
			case "1":
				certificateList = certificateService.selectByCertificateId(searchInput);
				model.addAttribute("certificateList", certificateList);
				System.out.println("1:certificateList-->"+certificateList);
				break;
			case "2":
				certificateList = certificateService.selectByBusinessTypes(searchInput);
				model.addAttribute("certificateList", certificateList);
				break;
			case "3":
				certificateList = certificateService.selectByBusinessNumber(searchInput);
				model.addAttribute("certificateList", certificateList);
				break;
			case "4":
				certificateList = certificateService.selectByOwner(searchInput);
				model.addAttribute("certificateList", certificateList);
				break;
			}
		}else{
			certificateList = null;
			model.addAttribute("certificateList", certificateList);
			System.out.println("certificateList-->"+certificateList);
		}
		return "certificate-new";
	}*/
	
	/*
	 * 模糊查询
	 */
	@RequestMapping(value="/prompt",method=RequestMethod.GET)
	public @ResponseBody List<CertificateVo> prompt(String searchVal,int selectVal) {
		System.out.println("输入框="+searchVal+" "+"select:"+selectVal);
		List<CertificateVo> cl = certificateService.selectPrompt(searchVal,selectVal);
		/*System.out.println(cl);*/
		return cl;
	}
}
