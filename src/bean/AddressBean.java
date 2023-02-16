package bean;

import java.io.Serializable;

public class AddressBean implements Serializable {

	private int addressid;
	private String addressphonenumber;
	private String addressaddress;
	private String addresspostcode;
	private String userid;
	private boolean state;

	public AddressBean() {

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
