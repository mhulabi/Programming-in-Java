package com.mohi.ifurnex;

import java.awt.image.BufferedImage;

public class Table extends Furniture {

	public Table(BufferedImage image, String title, int stock, double price) {
		super(image, title, stock, price);
	}

	@Override
	public void buyFurniture() {
		this.setStock(this.getStock() - 1);
	}

};
