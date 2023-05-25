package com.mohi.ifurnex;

import java.awt.image.BufferedImage;

public class Couch extends Furniture {

	public Couch(BufferedImage image, String title, int stock, double price) {
		super(image, title, stock, price);
	}

	@Override
	public void buyFurniture() {
		this.setStock(this.getStock() - 1);		
	}

};
