package com.EMS.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.EMS.model.service.BusinessService;
import com.EMS.model.service.CertificateService;
import com.EMS.model.service.CheckService;
import com.EMS.model.service.EasyCheck;
import com.EMS.model.service.FileService;
import com.EMS.model.service.HousingProjectService;
import com.EMS.model.service.RoomrecordService;
import com.EMS.model.service.ServiceService;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.CertificateVo;
import com.EMS.model.vo.CheckVo;
import com.EMS.model.vo.FileVo;
import com.EMS.model.vo.HousingProjectVo;
import com.EMS.model.vo.RoomrecordVo;
import com.EMS.model.vo.ServiceVo;

import com.EMS.test.RandomValue;

@Controller
@RequestMapping(value="/Admin")
public class CheckController {
	@Autowired
	HousingProjectService housing;
	@Autowired
	private BusinessService businessservice;
	@Autowired
	private RoomrecordService roomrecord;
	@Autowired
	private CheckService check;
	@Autowired
	private ServiceService service;
	@Autowired
	private EasyCheck easy;
	@Autowired
	private FileService file;
	@Autowired
	private CertificateService certificate;
	private String i;
	private String t;
	private String g;
	private RandomValue R = new RandomValue();

	/**
	 * 初审
	 */
	@RequestMapping(value = "/addsav")
	public String add(CheckVo Check, RedirectAttributesModelMap model) {
		g=t;
		List<CheckVo> c=check.selectCheckAllByNumber(t);
         if(c.isEmpty())  {
		Check.setBusiness_number(t);
		if (Check.getFirst_trial_case().equals("否")) {
			Check.setOne_time(R.getNowTime());
		}	
		System.out.print(Check);
		if (!Check.getOne_opinion().trim().equals("")) {
			check.addCheck(Check);	
			model.addFlashAttribute("msg", "提交成功");
			return "redirect:sav1";
		} else {
		model.addFlashAttribute("msg", "提交失败");
			return "redirect:sav1";
		}
		}
         else{
 
       model.addFlashAttribute("msg", "改业务已经被处理,请勿重复处理");
        	 return "redirect:sav1";
         }
		}
	

	/**
	 * 显示一审核页面
	 */
	@RequestMapping(value = "/sav")
	public String save(Model model, String yy) {
		i = yy;
		List<BusinessVo> business = businessservice.selectCheckAllNoServicetime();
	/*	List<BusinessVo> business = businessservice.selectBusinessAll();
		List<CheckVo> check1 = check.selectbyfirst2();
		for (int i = 0; i < check1.size(); i++) {
			for (int j = 0; j < business.size(); j++) {
				if (check1.get(i).getBusiness_number().equals(business.get(j).getBusiness_number()))
					business.remove(j);
			}
		}*/
		model.addAttribute("business", business);
		return "examine";

	}

	/**
	 * 待二审业务信息
	 */
	@RequestMapping(value = "/2sav")
	public String save2(Model model, String yy) {
		List<BusinessVo> business1 = new ArrayList<>();
		List<CheckVo> checkVos = check.selectbyfirst("是");
		for (CheckVo checkVo : checkVos) {
			BusinessVo bu = businessservice.selectBusinessByBNumber(checkVo.getBusiness_number());
			business1.add(bu);
		}
		i = yy;
		for (BusinessVo businessVo : business1) {
			String a = easy.getservice_number(businessVo.getF_service(), businessVo.getService_number());
			businessVo.setService_name(a);
		}
		model.addAttribute("business2", business1);
		return "2";
	}

	/**
	 * 待三审业务信息
	 */
	@RequestMapping(value = "/3sav")
	public String save3(Model model, String yy) {
		i = yy;
		List<BusinessVo> business1 = new ArrayList<>();
		List<CheckVo> checkVos = check.selectbySencond("是");
		for (CheckVo checkVo : checkVos) {
			BusinessVo bu = businessservice.selectBusinessByBNumber(checkVo.getBusiness_number());
			business1.add(bu);
		}
		for (BusinessVo businessVo : business1) {
			String a = easy.getservice_number(businessVo.getF_service(), businessVo.getService_number());
			businessVo.setService_name(a);
		}
		model.addAttribute("business3", business1);
		return "3";
	}

	/**
	 * 查看初审、二审、三审信息
	 */
	@RequestMapping(value = "/sav1")
	public String reexamination(Model model, String xx) {
		t = xx;
		if(t==null){
			t=g;
			}
		CheckVo Check = new CheckVo();
		
		BusinessVo businessvo = new BusinessVo();
		RoomrecordVo roomrecord1 = new RoomrecordVo();
		businessvo = businessservice.selectBusinessByBNumber(t);
		roomrecord1 = roomrecord.selectRoomrecordAllByNumber(t);
		HousingProjectVo housing1 = housing.selectByItem_no(roomrecord1.getItem_no());
		roomrecord1.setAddress(housing1.getAddress());
		Check = check.selectCheckByNumber(t);
		model.addAttribute("business1", businessvo);
		model.addAttribute("roomrecord", roomrecord1);
		model.addAttribute("check1", Check);
		if (i.equals("1")) {
			return "trialDetails";
		} else if (i.equals("2")) {
			
			return "reexamination";

		} else {
			return "approvalDetails";
		}
	}

	/**
	 * 提交二审意见
	 */
	@RequestMapping("/sav3")
	public String sava(CheckVo check1,RedirectAttributesModelMap model) {
		check1.setBusiness_number(t);
		System.out.print("wwwwwwwww");
		System.out.print(check1);
		g=t;
		CheckVo c=check.selectCheckByNumber(t);
         if(c.getSecond_case()==null)  {
        
		if (check1.getSecond_case().equals("否")) {
			check1.setTwo_time(R.getNowTime());
		}
			if (!check1.getTwo_opinion().trim().equals("")) {
				
				check.updateByBusiness_number2(check1);
				model.addFlashAttribute("msg1", "提交成功");
				return "redirect:sav1";
			} else {
				System.out.print("````````");
		model.addFlashAttribute("msg1", "提交失败");
				return "redirect:sav1";
			}

         }
         else{
        model.addFlashAttribute("msg1", "该业务已被处理，请勿重复处理");
        	 return "redirect:sav1";
         }
	}

	/**
	 * 提交三审意见
	 */
	@RequestMapping("/sav4")
	public String sava3(CheckVo check1,RedirectAttributesModelMap model) {
		g=t;
		CheckVo q=check.selectCheckByNumber(t);
		if(q.getThree_case()==null){
		RoomrecordVo room = roomrecord.selectRoomrecordAllByNumber(t);
		String j;
		HousingProjectVo housing1 = housing.selectByItem_no(room.getItem_no());
		FileVo file1 = new FileVo();
		CertificateVo c = new CertificateVo();
		BusinessVo business = businessservice.selectBusinessByBNumber(t);
		String a = easy.getservice_number(business.getF_service(), business.getService_number());
		j = business.getId_number().substring(10, 18);
		check1.setBusiness_number(t);
		if (check1.getThree_case().equals("否")) {
			check1.setThree_time(R.getNowTime());
		}
		if(!check1.getThree_opinion().trim().equals("")){
		check.updateByBusiness_number3(check1);
		/**
		 * 判断三审是否都通过，并存入证件表和档案表
		 */
		CheckVo check2 = check.selectCheckByNumber(t);
		// 证件表
		c.setBusiness_number(t);
		c.setOwner(business.getApplicant_name());
		c.setReceive("否");
		c.setCertificate_id("RE" + j);
		c.setBusiness_types(a);
		certificate.save(c);
		// 档案表
		file1.setBusiness_number(t);
		file1.setBusiness_types(a);
		file1.setProperty_owner(business.getApplicant_name());
		file1.setAddress(housing1.getAddress());	
		file.save(file1);
		model.addFlashAttribute("msg2", "提交成功");
		return "redirect:sav1";
		}
		else{
			model.addFlashAttribute("msg2", "提交失败");
			return "redirect:sav1";
		}
		}
		else{
			model.addFlashAttribute("msg2", "该业务已被处理，请勿重复处理");
			return "redirect:sav1";
		}
	}


}