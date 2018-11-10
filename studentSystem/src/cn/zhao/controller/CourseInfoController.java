package cn.zhao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zhao.Service.CourseService;
import cn.zhao.Service.TeacherService;
import cn.zhao.entity.SegmentCouidEntity;
import cn.zhao.entity.VwTeaToScoreEntity;
import cn.zhao.entity.vwCoMaToTeaEntity;

@Controller
public class CourseInfoController {
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(value="showScores")
	public String showScores(String cou_id,Model model,HttpServletRequest request) {
		try {
			String account=(String)request.getSession().getAttribute("account");
			List<vwCoMaToTeaEntity> vwCoMaToTeaEntities=teacherService.getCoMaToTea(account);
			if (vwCoMaToTeaEntities.size()!=0) {
				model.addAttribute("vwCoMaToTeaEntities", vwCoMaToTeaEntities);
			} else {
				model.addAttribute("vwCoMaToTeaEntities", "0");
			}
		} catch (Exception e) {
			return "index";
		}
		try {
			String account=(String)request.getSession().getAttribute("account");
			System.out.println("showScores-cou_id:"+cou_id);
			List<VwTeaToScoreEntity> vwTeaToScoreEntities=teacherService.getVwTeaToScore(account,cou_id);
			for (VwTeaToScoreEntity vwTeaToScoreEntity : vwTeaToScoreEntities) {
				System.out.println(vwTeaToScoreEntity);
			}
			if (vwTeaToScoreEntities.size()!=0&&vwTeaToScoreEntities!=null) {
				model.addAttribute("vwTeaToScoreEntities", vwTeaToScoreEntities);
			}else {
				model.addAttribute("vwTeaToScoreEntities", "0");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "index";
		}
		try {
			model.addAttribute("Course", courseService.getCourseInfo(cou_id));
			System.out.println("Course="+courseService.getCourseInfo(cou_id));
			model.addAttribute("maxscore", courseService.getMaxScore(cou_id));
			model.addAttribute("minscore", courseService.getMinScore(cou_id));
			model.addAttribute("avgscore", courseService.getAvgScore(cou_id));
			model.addAttribute("bandscore", courseService.getCountForFeil(cou_id,
							"scores>=0 and scores<=100"));
		} catch (NullPointerException e) {
			model.addAttribute("maxscore", "0");
			model.addAttribute("minscore", "0");
			model.addAttribute("avgscore", "0");
			model.addAttribute("bandscore", "0");
		}
		return "CourseInfo";
	}
	
	@RequestMapping(value="SorceSegment")
	public String SorceSegment(SegmentCouidEntity segmentCouidEntity,Model model,HttpServletRequest request) {
		System.out.println(segmentCouidEntity);
		try {
			String account=(String)request.getSession().getAttribute("account");
			List<vwCoMaToTeaEntity> vwCoMaToTeaEntities=teacherService.getCoMaToTea(account);
			if (vwCoMaToTeaEntities.size()!=0) {
				model.addAttribute("vwCoMaToTeaEntities", vwCoMaToTeaEntities);
			} else {
				model.addAttribute("vwCoMaToTeaEntities", "0");
			}
		} catch (Exception e) {
			return "index";
		}
		try {
			String account=(String)request.getSession().getAttribute("account");
			System.out.println("showScores-cou_id:"+segmentCouidEntity.getCou_id());
			List<VwTeaToScoreEntity> vwTeaToScoreEntities=teacherService.getVwTeaToScore(account,segmentCouidEntity.getCou_id());
			for (VwTeaToScoreEntity vwTeaToScoreEntity : vwTeaToScoreEntities) {
				System.out.println(vwTeaToScoreEntity);
			}
			if (vwTeaToScoreEntities.size()!=0) {
				model.addAttribute("vwTeaToScoreEntities", vwTeaToScoreEntities);
			}else {
				model.addAttribute("vwTeaToScoreEntities", "0");
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "index";
		}
		try {
			model.addAttribute("Course", courseService.getCourseInfo(segmentCouidEntity.getCou_id()));
			System.out.println(courseService.getCourseInfo(segmentCouidEntity.getCou_id()));
			model.addAttribute("maxscore", courseService.getMaxScore(segmentCouidEntity.getCou_id()));
			model.addAttribute("minscore", courseService.getMinScore(segmentCouidEntity.getCou_id()));
			model.addAttribute("avgscore", courseService.getAvgScore(segmentCouidEntity.getCou_id()));
			model.addAttribute("bandscore", courseService.getCountForFeil(segmentCouidEntity.getCou_id(),
					segmentCouidEntity.getSegment()));
		} catch (NullPointerException e) {
			model.addAttribute("maxscore", "0");
			model.addAttribute("minscore", "0");
			model.addAttribute("avgscore", "0");
			model.addAttribute("bandscore", "0");
		}
		
		return "CourseInfo";
	}
}
