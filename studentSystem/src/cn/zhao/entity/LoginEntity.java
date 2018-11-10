package cn.zhao.entity;

public class LoginEntity {
	private String account;
	private String identity;
	private String password;
	public LoginEntity(String account, String identity, String password) {
		super();
		this.account = account;
		this.identity = identity;
		this.password = password;
	}
	
	public LoginEntity() {}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginEntity [account=" + account + ", identity=" + identity + ", password=" + password + "]";
	}

	
}
