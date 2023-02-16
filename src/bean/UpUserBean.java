package bean;
import java.io.Serializable;

public class UpUserBean implements Serializable{
	private String userid;
    private String username;
	private String userdob;
	private int addressid;
	private String addressphonenumber;
	private String addressaddress;
	private String addresspostcode;
	private boolean state;





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
	public String getUserdob() {
		return userdob;
	}
	public void setUserdob(String userdob) {
		this.userdob = userdob;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getAddressphonenumber() {
		return addressphonenumber;
	}
	public void setAddressphonenumber(String addressphonenumber) {
		this.addressphonenumber = addressphonenumber;
	}
	public String getAddressaddress() {
		return addressaddress;
	}
	public void setAddressaddress(String addressaddress) {
		this.addressaddress = addressaddress;
	}
	public String getAddresspostcode() {
		return addresspostcode;
	}
	public void setAddresspostcode(String addresspostcode) {
		this.addresspostcode = addresspostcode;
	}
	public boolean getState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}

}
