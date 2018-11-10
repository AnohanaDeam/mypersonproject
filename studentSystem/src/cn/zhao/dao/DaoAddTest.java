package cn.zhao.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.zhao.entity.AcademyEntity;
import cn.zhao.entity.CourseEntity;
import cn.zhao.entity.DepartmentEntity;
import cn.zhao.entity.MaterialEntity;
import cn.zhao.entity.StudentEntity;
import cn.zhao.entity.TeacherEntity;
import cn.zhao.value.RandomValue;

public class DaoAddTest {

	ApplicationContext applicationContext =
			new ClassPathXmlApplicationContext("bean.xml");
	
	@Test
	/**
	 * 向Matertal里添加信息
	 * 已运行
	 */
	public void addToMatertal() {
		int k=10/0;
		CourseManageDao courseManageDao=(CourseManageDao) applicationContext.getBean("courseManageDao");
		MaterialEntity matertalEntity=new MaterialEntity("1020", "xiao", 50, "新华社发行", "高等数学B1");
		courseManageDao.addToMaterial(matertalEntity);
	}
	
	@Test
	/**
	 * 向Course里添加信息
	 *已运行
	 */
	public void addToCourse() {
		int k=10/0;
		CourseManageDao courseManageDao=(CourseManageDao) applicationContext.getBean("courseManageDao");
		CourseEntity courseEntity=new CourseEntity("高等数学",2,null);
		courseManageDao.addToCourse(courseEntity);
	}
	
	@Test
	/**
	 * 为所有师生添加登陆信息
	 * 密码默认:123456
	 * 已运行
	 */
	public void addToLogin() {
		int k=10/0;
		RegisterDao registerDao=(RegisterDao)applicationContext.getBean("registerDao");
		registerDao.addRadomToLogin();
	}
	@Test
	/**
	 * 添加随机的学生信息
	 * 已运行
	 */
	public void randomStudentDateAdd() {
		int k=10/0;
		RegisterDao registerDao=(RegisterDao)applicationContext.getBean("registerDao");
		StudentEntity studentEntity=new StudentEntity();
		for (int i = 0; i < 10000; i++) {
			int a = (int) Math.abs(academyName.length * Math.random());
			int b = (int) Math.abs(departName[a].length * Math.random());
			String classM=departName[a][b]+"专业"+(int)((Math.random()*3)+1)+"班";
			Map map=RandomValue.getAddress();
			studentEntity.setAcademy(academyName[a]);
			studentEntity.setDepartment(departName[a][b]);
			studentEntity.setGpa(0);
			studentEntity.setClassM(classM);
			studentEntity.setSex((String)map.get("sex"));
			studentEntity.setStu_name((String)map.get("name"));
			studentEntity.setTotalcredits(0);
			registerDao.addToStudent(studentEntity);
		}
	}
	
	@Test
	/**
	 * 生成学院信息
	 * 已运行
	 */
	public void randomAcademyDateAdd() {
		int k=10/0;
		DataAddingDao dataAdding=(DataAddingDao)applicationContext.getBean("dataAdding");
		AcademyEntity academyEntity = new AcademyEntity();;
		for (int i = 0; i < academyName.length; i++) {
			Map m = RandomValue.getAddress();
			academyEntity.setAca_dean((String) m.get("name"));
			academyEntity.setAca_name(academyName[i]);
			academyEntity.setDeansex((String) m.get("sex"));
			dataAdding.addToAcademy(academyEntity);
		}
	}
	@Test
	/**
	 * 生成教师信息
	 * 已运行
	 */
	public void randomTeacherDateAdd() {
		int k=10/0;
		RegisterDao registerDao=(RegisterDao)applicationContext.getBean("registerDao");
		TeacherEntity teacherEntity=new TeacherEntity();
		for (int i = 0; i < 300; i++) {
			int a = (int) Math.abs(departName.length * Math.random());
			int b = (int) Math.abs(departName[a].length * Math.random());
			int age=(int)(Math.random()*42)+28;
			Map map=RandomValue.getAddress();
			teacherEntity.setDepartment(departName[a][b]);
			teacherEntity.setTea_name((String)map.get("name"));
			teacherEntity.setPost(RandomValue.PercentagePostRandom());
			teacherEntity.setAge(age);
			registerDao.addToTeacher(teacherEntity);
		}
	}
	
	@Test
	/**
	 * 生成系信息
	 * 已运行
	 */
	public void addDataToDep() {
		int k=10/0;
		DataAddingDao dataAdding = (DataAddingDao)applicationContext.getBean("dataAdding");
		DepartmentEntity departmentEntity=new DepartmentEntity();
		//(2)、如果数字1是整型，如下处理：
		DecimalFormat dfA=new DecimalFormat("000");
		DecimalFormat dfD=new DecimalFormat("00");
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < academyName.length; i++) {
			for (int j = 0; j < departName[i].length; j++) {
				String id1=dfA.format(i+1);
				String id2=dfD.format(j+1);
				Map map=RandomValue.getAddress();
				String dep_phone = (String)map.get("tel");
				while(!list.contains(dep_phone)){
	                list.add(dep_phone);
	                departmentEntity.setDep_phone(dep_phone);
	            }
				departmentEntity.setAcademy(academyName[i]);
				departmentEntity.setDep_id(id1+id2);
				departmentEntity.setDep_name(departName[i][j]);
				dataAdding.addToDepartment(departmentEntity);
			}
		}
	}
	
	String[][] departName = {
			{"机械工程","工业设计"},
			{"车辆工程","交通运输","工程力学","汽车服务工程","物流工程"},
			{"化学工程与工艺","应用化学","食品科学与工程","生物工程","制药工程","纺织工程"},
			{"护理学","药学","医学检验技术","护理","助产","医学影像技术","口腔技术","公共卫生管理"},
			{"土木工程","建筑学","工程管理","工程造价"},
			{"计算机科学与技术","通信工程","数字媒体技术","软件工程和物联网工程"},
			{" 工商管理","工业工程","物流管理","信息管理与信息系统","人力资源管理","公共事业管理","市场营销"},
			{"信息与计算科学","统计学","数学与应用数学"},
			{"外国语言学及应用语言学"},
			{" 财务管理","金融学","经济学","国际经济与贸易","国际商务","会计学"},
	};
	String[] academyName = {
			"机械工程学院","汽车与交通学院","生物与化学工程学院","医学院","土木建筑工程学院","计算机与通信工程学院",
			"管理学院","理学院","外国语学院","财经学院"
	};
}
