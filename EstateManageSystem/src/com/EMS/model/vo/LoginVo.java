package com.EMS.model.vo;
/**
 * 登录表
 * @author JTXY
 *
 */
public class LoginVo {
	/**
	 * 用户名
	 */
	private String user_name;
	/**
	 * 密码
	 */
	private String user_pass;
	/**
	 * 身份
	 */
	private String identity;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public LoginVo(String user_name, String user_pass, String identity) {
		super();
		this.user_name = user_name;
		this.user_pass = user_pass;
		this.identity = identity;
	}
	public LoginVo(String user_name, String user_pass) {
		this.user_name = user_name;
		this.user_pass = user_pass;
	}
	@Override
	public String toString() {
		return "LoginVo [user_name=" + user_name + ", user_pass=" + user_pass + ", identity=" + identity + "]";
	}
	

}
