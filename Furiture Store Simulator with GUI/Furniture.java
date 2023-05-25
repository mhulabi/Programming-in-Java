package com.mohi.ifurnex;

import java.awt.image.BufferedImage;

//import java.awt.Image;

public abstract class Furniture {
	
	private BufferedImage image; //Image or ImageIcon
	private String title;
	private int stock;
	private double price;
	
	public Furniture(BufferedImage image, String title, int stock, double price) {
		this.image = image;
		this.title = title;
		this.stock = stock;
		this.price = price;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
		
	public abstract void buyFurniture();
		
};
