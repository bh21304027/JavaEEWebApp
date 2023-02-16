package dao.product;

import java.util.ArrayList;

import bean.ShoesBean;
import bean.ShoesProductBean;

public interface ProductInformationDao {
	public ArrayList<ShoesBean> getProductListInformation();
	public ArrayList<ShoesProductBean> getProductSizeStock(int shoesid);
	public ArrayList<ShoesBean> getProductListInformation(int gender);
	public ArrayList<ShoesBean> getProductListInformation(int gender,int category);
	public ShoesProductBean getProduct(int productid);
}
