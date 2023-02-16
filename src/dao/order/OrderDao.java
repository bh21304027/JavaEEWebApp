package dao.order;

import java.util.ArrayList;

import bean.OrderBean;

public interface OrderDao{
	public void addOrder(int id,int ccount,String userid);
	public void updateOrder(OrderBean o);
	public void deleteOrder(String userid,String orderid);
	public void deleteUserOrder(String userid);
	public ArrayList<OrderBean> getOrder(String userid);
	//public ArrayList getAllOrders();
}
