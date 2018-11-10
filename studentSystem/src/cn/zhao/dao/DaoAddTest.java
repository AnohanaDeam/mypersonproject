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
	 * ��Matertal�������Ϣ
	 * ������
	 */
	public void addToMatertal() {
		int k=10/0;
		CourseManageDao courseManageDao=(CourseManageDao) applicationContext.getBean("courseManageDao");
		MaterialEntity matertalEntity=new MaterialEntity("1020", "xiao", 50, "�»��緢��", "�ߵ���ѧB1");
		courseManageDao.addToMaterial(matertalEntity);
	}
	
	@Test
	/**
	 * ��Course�������Ϣ
	 *������
	 */
	public void addToCourse() {
		int k=10/0;
		CourseManageDao courseManageDao=(CourseManageDao) applicationContext.getBean("courseManageDao");
		CourseEntity courseEntity=new CourseEntity("�ߵ���ѧ",2,null);
		courseManageDao.addToCourse(courseEntity);
	}
	
	@Test
	/**
	 * Ϊ����ʦ����ӵ�½��Ϣ
	 * ����Ĭ��:123456
	 * ������
	 */
	public void addToLogin() {
		int k=10/0;
		RegisterDao registerDao=(RegisterDao)applicationContext.getBean("registerDao");
		registerDao.addRadomToLogin();
	}
	@Test
	/**
	 * ��������ѧ����Ϣ
	 * ������
	 */
	public void randomStudentDateAdd() {
		int k=10/0;
		RegisterDao registerDao=(RegisterDao)applicationContext.getBean("registerDao");
		StudentEntity studentEntity=new StudentEntity();
		for (int i = 0; i < 10000; i++) {
			int a = (int) Math.abs(academyName.length * Math.random());
			int b = (int) Math.abs(departName[a].length * Math.random());
			String classM=departName[a][b]+"רҵ"+(int)((Math.random()*3)+1)+"��";
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
	 * ����ѧԺ��Ϣ
	 * ������
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
	 * ���ɽ�ʦ��Ϣ
	 * ������
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
	 * ����ϵ��Ϣ
	 * ������
	 */
	public void addDataToDep() {
		int k=10/0;
		DataAddingDao dataAdding = (DataAddingDao)applicationContext.getBean("dataAdding");
		DepartmentEntity departmentEntity=new DepartmentEntity();
		//(2)���������1�����ͣ����´���
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
			{"��е����","��ҵ���"},
			{"��������","��ͨ����","������ѧ","�������񹤳�","��������"},
			{"��ѧ�����빤��","Ӧ�û�ѧ","ʳƷ��ѧ�빤��","���﹤��","��ҩ����","��֯����"},
			{"����ѧ","ҩѧ","ҽѧ���鼼��","����","����","ҽѧӰ����","��ǻ����","������������"},
			{"��ľ����","����ѧ","���̹���","�������"},
			{"�������ѧ�뼼��","ͨ�Ź���","����ý�弼��","������̺�����������"},
			{" ���̹���","��ҵ����","��������","��Ϣ��������Ϣϵͳ","������Դ����","������ҵ����","�г�Ӫ��"},
			{"��Ϣ������ѧ","ͳ��ѧ","��ѧ��Ӧ����ѧ"},
			{"�������ѧ��Ӧ������ѧ"},
			{" �������","����ѧ","����ѧ","���ʾ�����ó��","��������","���ѧ"},
	};
	String[] academyName = {
			"��е����ѧԺ","�����뽻ͨѧԺ","�����뻯ѧ����ѧԺ","ҽѧԺ","��ľ��������ѧԺ","�������ͨ�Ź���ѧԺ",
			"����ѧԺ","��ѧԺ","�����ѧԺ","�ƾ�ѧԺ"
	};
}
