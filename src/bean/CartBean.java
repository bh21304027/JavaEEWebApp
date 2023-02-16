package bean;

import java.io.Serializable;

public class CartBean implements Serializable{
	private int productid;
	private int shoesid;
	private Float shoessize;
	private String shoesname;
	private String shoescolor;
	private int shoesprice;
	private String shoespicturepath;
    public CartBean() {
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getShoesid() {
		return shoesid;
	}
	public void setShoesid(int shoesid) {
		this.shoesid = shoesid;
	}
	public String getShoesname() {
		return shoesname;
	}
	public void setShoesname(String shoesname) {
		this.shoesname = shoesname;
	}
	public String getShoescolor() {
		return shoescolor;
	}
	public void setShoescolor(String shoescolor) {
		this.shoescolor = shoescolor;
	}
	public int getShoesprice() {
		return shoesprice;
	}
	public void setShoesprice(int shoesprice) {
		this.shoesprice = shoesprice;
	}
	public String getShoespicturepath() {
		return shoespicturepath;
	}
	public void setShoespicturepath(String shoespicturepath) {
		this.shoespicturepath = shoespicturepath;
	}
	public Float getShoessize() {
		return shoessize;
	}
	public void setShoessize(Float shoessize) {
		this.shoessize = shoessize;
	}




}