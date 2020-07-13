package com.training.bean;

public class LoginBean {
	private String proName;
	private String meta;
	private String model;
	private String price;
	private String category;
	private String disQuantity;
	private String disPrice;
	private String point;

	public LoginBean() {
	}

	public LoginBean(String proName, String meta, String model,String price,String category, String disQuantity,String disPrice, String point) {
		super();
		this.proName = proName;
		this.meta = meta;
		this.model = model;
		this.price = price;
		this.category = category;
		this.disQuantity = disQuantity;
		this.disPrice = disPrice;
		this.point = point;
	
	}

	public String getproName() {
		return proName;
	}

	public void setproName(String proName) {
		this.proName = proName;
	}

	public String getmeta() {
		return meta;
	}

	public void setmeta(String meta) {
		this.meta = meta;
	}

	public String getmodel() {
		return model;
	}

	public void setmodel(String model) {
		this.model = model;
	}
	public String getprice() {
		return price;
	}

	public void setprice(String price) {
		this.price = price;
	}
	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}
	public String getdisQuantity() {
		return disQuantity;
	}

	public void setdisQuantity(String disQuantity) {
		this.disQuantity = disQuantity;
	}
	public String getdisPrice() {
		return disPrice;
	}

	public void setdisPrice(String disPrice) {
		this.disPrice = disPrice;
	}
	public String getpoint() {
		return point;
	}

	public void setpoint(String point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "LoginBean [proName=" + proName + ", meta=" + meta + ", model=" + model+", price="+price + ", category="+category + ", disQuantity=" + disQuantity + ", disPrice="+ disPrice + ", point=" + point+"]";
	}

}
