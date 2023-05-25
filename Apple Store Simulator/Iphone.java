package com.mohi.imax;

public abstract class Iphone {

	private String modelName;
	private String color;
	private int storage;
	private int price; //changes with setStorage therefore does not require a set function
	private int stock;
	private int ID;
	
	public Iphone(String color, int storage, int stock) {
		this.color = color;
		this.storage = storage;
		this.stock = stock;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getModelName() {
		return modelName;
	}
	
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getStorage() {
		return storage;
	}
	
	public void setStorage(int storage) {
		this.storage = storage;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public abstract void displayStock();
	
	public abstract void buyPhone(int storage, String color);

};
