package bean;

import java.io.Serializable;

public class ShoesBean implements Serializable{
    private int shoesid;
    private String shoesname;
	private int shoesprice;
	private int categoryid;
	private int shoesgender;
	private String shoespicture;

	public ShoesBean() {
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
	public int getShoesprice() {
		return shoesprice;
	}
	public void setShoesprice(int shoesprice) {
		this.shoesprice = shoesprice;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getShoesgender() {
		return shoesgender;
	}
	public void setShoesgender(int shoesgender) {
		this.shoesgender = shoesgender;
	}
	public String getShoespicture() {
		return shoespicture;
	}
	public void setShoespicture(String shoespicture) {
		this.shoespicture = shoespicture;
	}

}