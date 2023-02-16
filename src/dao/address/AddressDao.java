package dao.address;

import bean.AddressBean;

public interface AddressDao{
	public void addAddress(AddressBean a);
	public AddressBean getAddress(String userid);
	public void updateOrAddAddress(AddressBean a);
	public void deleteAddress(String addressid,String userid);
	public void deleteAllAddress(String userid);
}
