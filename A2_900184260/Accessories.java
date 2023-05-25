package com.mohi.imax;

public abstract class Accessories {

	private String modelName;
	private int price; //changes with setStorage therefore does not require a set function
	private int stock;
	
	public Accessories(String modelName, int price, int stock) {
		super();
		this.modelName = modelName;
		this.price = price;
		this.stock = stock;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public abstract void displayAccessories();
	
	public abstract void buyMagSafeCharger(String modelName);
	
	public abstract void buyCase(String modelName, String color);
	
	public abstract void buyAirPods(String modelName);
	

}
