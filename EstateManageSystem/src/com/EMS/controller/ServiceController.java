package com.EMS.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.EMS.model.service.BusinessService;
import com.EMS.model.service.EasyCheck;
import com.EMS.model.service.HousingProjectService;
import com.EMS.model.service.RoomrecordService;
import com.EMS.model.vo.BusinessVo;
import com.EMS.model.vo.HousingProjectVo;
import com.EMS.model.vo.RoomrecordVo;
import com.EMS.test.RandomValue;

/**
 * �������
 * @author JTXY
 *
 */
@Controller       //ע�������
@RequestMapping(value="/Admin")
public class  ServiceController{
	
	@Autowired
	private BusinessService businessService; 
	@Autowired
	private RoomrecordService roomrecordService;    
	@Autowired
	private HousingProjectService housingProjectService;
	@Autowired
	private EasyCheck easyCheck;
	/**
	 * ��ת����ҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/acceptance",method = RequestMethod.GET) //���巽����
    public String accept(Model model){
		try {
			List<BusinessVo> businessVos = businessService.selectBusinessAll();
			for (BusinessVo businessVo : businessVos) {
				businessVo.setServiceVo(
						easyCheck.getServiceVo(
								businessVo.getF_service(), businessVo.getService_number()));
			}
			model.addAttribute("businesses",businessVos);
			return "acceptance";
		} catch (Exception e) {
			model.addAttribute("msg", "��ѽѽ�����������޷�����");
			e.printStackTrace();
			return "service";
		}
		
    }
	
	@RequestMapping(value="/checkMaterial",method = RequestMethod.GET)
	public String checkMaterial(Model model,String number) {
		try {
			BusinessVo businessVo = businessService.selectBusinessByBNumber(number);
			RoomrecordVo roomrecordVo = roomrecordService.selectRoomrecordAllByNumber(number);
			HousingProjectVo housingProjectVo = housingProjectService.selectByItem_no(roomrecordVo.getItem_no());
			model.addAttribute("businessVo", businessVo);
			model.addAttribute("roomrecordVo", roomrecordVo);
			model.addAttribute("housingProjectVo", housingProjectVo);
			return "checkMaterial";
		} catch (Exception e) {
			model.addAttribute("msg", "��ѽѽ�����������޷�����");
			e.printStackTrace();
			return "service";
		}
	}
	
	@RequestMapping(value="/AcceptBusiness",method = RequestMethod.GET)
	public String AcceptBusiness(String number,Model model) {
		try {
			businessService.updateService_time(number);
			model.addAttribute("msg", "ҵ������ɹ�");
		} catch (Exception e) {
			model.addAttribute("msg", "��ѽѽ�����������޷�����");
		}
		return "redirect:acceptance?msg=ҵ������ɹ�";
	}
	/**
	 * ��������ʱ��Ϊ��Ϊ�շ���(������ҵ��)
	 * @param num
	 * @return
	 */
	@RequestMapping(value="/timenonull",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getnolist(int num){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<BusinessVo> businessVos = businessService.selectTimeNoNull((num-1)*5);
			SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd-HH:mm:ss"); 
			for (BusinessVo businessVo : businessVos) {
				businessVo.setServiceVo(
						easyCheck.getServiceVo(
								businessVo.getF_service(), businessVo.getService_number()));
				businessVo.setService_timestr(df.format(businessVo.getService_time()));
			}
			map.put("businessVos", businessVos);
			map.put("count", businessService.selectNoNullCount()/5);
		} catch (Exception e) {
			map.put("msg", "��ѽѽ�����������޷�����");
			e.printStackTrace();
		}
		return map;
		
	}
	/**
	 * ��������ʱ��Ϊ�շ���(δ����ҵ��)
	 * @param num
	 * @return
	 */
	@RequestMapping(value="/timenull",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getlist(int num){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<BusinessVo> businessVos = businessService.selectTimeNull((num-1)*5);
			
			for (BusinessVo businessVo : businessVos) {
				businessVo.setServiceVo(
						easyCheck.getServiceVo(
								businessVo.getF_service(), businessVo.getService_number()));
			}
			map.put("businessVos", businessVos);
			map.put("count", businessService.selectNullCount()/5);
		} catch (Exception e) {
			map.put("msg", "��ѽѽ�����������޷�����");
			e.printStackTrace();
		}
		return map;
	}
}
