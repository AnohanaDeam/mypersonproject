package com.EMS.model.vo;

import java.util.Date;
/**
 * �����
 * @author JTXY
 *
 */
public class CheckVo {
	/**
	 * ҵ�������
	 */
	private String business_number;
	/**
	 * һ�����
	 */
	private String first_trial_case;
	/**
	 * �������
	 */
	private String second_case;
	/**
	 * �������
	 */
	private String three_case;
	/**
	 * һ�����
	 */
	private String one_opinion;
	private String two_opinion;//�������
	private String three_opinion;//�������
	private Date one_time;//һ��δͨ��ʱ��
	private Date two_time;//����δͨ��ʱ��
	private Date three_time;//����δͨ��ʱ��
	private String one_material;//һ���貹�����
	private String two_material;//�����������
	private String three_material;//�����������
	private String one_realcheck;//һ��ʵ�ؿ������
	private String two__realcheck;
	private String three_realcheck;
	
	
	public String getTwo__realcheck() {
		return two__realcheck;
	}
	public void setTwo__realcheck(String two__realcheck) {
		this.two__realcheck = two__realcheck;
	}
	public String getThree_realcheck() {
		return three_realcheck;
	}
	public void setThree_realcheck(String three_realcheck) {
		this.three_realcheck = three_realcheck;
	}
	public String getOne_realcheck() {
		return one_realcheck;
	}
	public void setOne_realcheck(String one_realcheck) {
		this.one_realcheck = one_realcheck;
	}
	public String getBusiness_number() {
		return business_number;
	}
	public void setBusiness_number(String business_number) {
		this.business_number = business_number;
	}
	public String getFirst_trial_case() {
		return first_trial_case;
	}
	public void setFirst_trial_case(String first_trial_case) {
		this.first_trial_case = first_trial_case;
	}
	public String getSecond_case() {
		return second_case;
	}
	public void setSecond_case(String second_case) {
		this.second_case = second_case;
	}
	public String getThree_case() {
		return three_case;
	}
	public void setThree_case(String three_case) {
		this.three_case = three_case;
	}
	public String getOne_opinion() {
		return one_opinion;
	}
	public void setOne_opinion(String one_opinion) {
		this.one_opinion = one_opinion;
	}
	public String getTwo_opinion() {
		return two_opinion;
	}
	public void setTwo_opinion(String two_opinion) {
		this.two_opinion = two_opinion;
	}
	public String getThree_opinion() {
		return three_opinion;
	}
	public void setThree_opinion(String three_opinion) {
		this.three_opinion = three_opinion;
	}
	public Date getOne_time() {
		return one_time;
	}
	public void setOne_time(Date one_time) {
		this.one_time = one_time;
	}
	public Date getTwo_time() {
		return two_time;
	}
	public void setTwo_time(Date two_time) {
		this.two_time = two_time;
	}
	public Date getThree_time() {
		return three_time;
	}
	public void setThree_time(Date three_time) {
		this.three_time = three_time;
	}
	public String getOne_material() {
		return one_material;
	}
	public void setOne_material(String one_material) {
		this.one_material = one_material;
	}
	public String getTwo_material() {
		return two_material;
	}
	public void setTwo_material(String two_material) {
		this.two_material = two_material;
	}
	public String getThree_material() {
		return three_material;
	}
	public void setThree_material(String three_material) {
		this.three_material = three_material;
	}

	public CheckVo(){}
	@Override
	public String toString() {
		return "CheckVo [business_number=" + business_number + ", first_trial_case=" + first_trial_case
				+ ", second_case=" + second_case + ", three_case=" + three_case + ", one_opinion=" + one_opinion
				+ ", two_opinion=" + two_opinion + ", three_opinion=" + three_opinion + ", one_time=" + one_time
				+ ", two_time=" + two_time + ", three_time=" + three_time + ", one_material=" + one_material
				+ ", two_material=" + two_material + ", three_material=" + three_material + ", one_realcheck="
				+ one_realcheck + ", two__realcheck=" + two__realcheck + ", three_realcheck=" + three_realcheck + "]";
	}
	public CheckVo(String business_number, String first_trial_case, String second_case, String three_case,
			String one_opinion, String two_opinion, String three_opinion, Date one_time, Date two_time, Date three_time,
			String one_material, String two_material, String three_material, String one_realcheck,
			String two__realcheck, String three_realcheck) {
		super();
		this.business_number = business_number;
		this.first_trial_case = first_trial_case;
		this.second_case = second_case;
		this.three_case = three_case;
		this.one_opinion = one_opinion;
		this.two_opinion = two_opinion;
		this.three_opinion = three_opinion;
		this.one_time = one_time;
		this.two_time = two_time;
		this.three_time = three_time;
		this.one_material = one_material;
		this.two_material = two_material;
		this.three_material = three_material;
		this.one_realcheck = one_realcheck;
		this.two__realcheck = two__realcheck;
		this.three_realcheck = three_realcheck;
	}
	/*����*/
	public CheckVo(String business_number, String three_case, String three_opinion, Date three_time,
			String three_material) {
		super();
		this.business_number = business_number;
		this.three_case = three_case;
		this.three_opinion = three_opinion;
		this.three_time = three_time;
		this.three_material = three_material;
	}
	/*һ��*/
	public CheckVo(String first_trial_case, String one_opinion, Date one_time, String one_material,
			String one_realcheck) {
		super();
		this.first_trial_case = first_trial_case;
		this.one_opinion = one_opinion;
		this.one_time = one_time;
		this.one_material = one_material;
		this.one_realcheck = one_realcheck;
	}
	
}
