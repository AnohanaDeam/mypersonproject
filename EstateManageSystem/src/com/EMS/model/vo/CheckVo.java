package com.EMS.model.vo;

import java.util.Date;
/**
 * 三审表
 * @author JTXY
 *
 */
public class CheckVo {
	/**
	 * 业务受理号
	 */
	private String business_number;
	/**
	 * 一审情况
	 */
	private String first_trial_case;
	/**
	 * 二审情况
	 */
	private String second_case;
	/**
	 * 三审情况
	 */
	private String three_case;
	/**
	 * 一审意见
	 */
	private String one_opinion;
	private String two_opinion;//二审意见
	private String three_opinion;//三审意见
	private Date one_time;//一审未通过时间
	private Date two_time;//二审未通过时间
	private Date three_time;//三审未通过时间
	private String one_material;//一审需补充材料
	private String two_material;//二审所需材料
	private String three_material;//三审所需材料
	private String one_realcheck;//一审实地考察情况
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
	/*三审*/
	public CheckVo(String business_number, String three_case, String three_opinion, Date three_time,
			String three_material) {
		super();
		this.business_number = business_number;
		this.three_case = three_case;
		this.three_opinion = three_opinion;
		this.three_time = three_time;
		this.three_material = three_material;
	}
	/*一审*/
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
