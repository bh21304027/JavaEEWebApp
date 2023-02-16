package bean;

import java.io.Serializable;

public class UserBean implements Serializable{
    private String userid;
    private String username;
	private String userpass;
	private String userdob;
	private int usergender;


	public UserBean() {
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserpass() {
		return userpass;
	}


	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}


	public String getUserdob() {
		return userdob;
	}


	public void setUserdob(String userdob) {
		this.userdob = userdob;
	}


	public int getUsergender() {
		return usergender;
	}


	public void setUsergender(int usergender) {
		this.usergender = usergender;
	}


}