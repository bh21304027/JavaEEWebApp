package dao.cart;

import java.util.ArrayList;

import bean.CartBean;
import bean.CartsBean;

public interface CartDao{
	public void addCart(CartsBean cbs);
	//public void updateCart(CartBean c);
	public CartBean deleteCart(int cartid);
	public void deleteUserCart(String userid);
	public ArrayList<CartsBean> getCart(String userid);
	public CartBean getCartProduct(int productid);
	//public ArrayList getAllCarts();
	public int getCartidMax();
}
