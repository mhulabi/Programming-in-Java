package com.mohi.imax;

public class Case extends Accessories{ //Abstract because no need to implement all methods from accessories

	String color;
	
	public Case(String modelName, int price, int stock, String color) {
		super(modelName, price, stock);
		this.color = color;
		// TODO Auto-generated constructor stub
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public void displayAccessories() {
		if (getStock() > 0) {
				System.out.println(getColor() + " Case " + getModelName() + " ($"+ getPrice() +"): " + getStock() + " remaining in stock");
			
		}
		else {
			System.out.println(getColor() + " Case " + getModelName() + " OUT OF STOCK");
		}		
	}

	@Override
	public void buyCase(String modelName, String color) {
		// TODO Auto-generated method stub
		setStock(getStock() - 1);
	}

	//Will remain unimplemented since I do not need them
	@Override
	public void buyMagSafeCharger(String modelName) {		
	}

	//Will remain unimplemented since I do not need them
	@Override
	public void buyAirPods(String modelName) {
		
	}
	
	public void displayCaseColors(String modelName) {
		if (modelName.equals("iPhone SE")) {
			System.out.println("Red or Black");
		}
		else if (modelName.equals("iPhone 12")) {
			System.out.println("White or Blue");
		}
		else {
			System.out.println("Yellow or Green");
		}
	}
	
	public boolean verifyCaseColor(String modelName, String color) {
		if (modelName.equals("iPhone SE")) {
			if (color.equals("Red") || color.equals("Black")) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (modelName.equals("iPhone 12")) {
			if (color.equals("White") || color.equals("Blue")) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (color.equals("Yellow") || color.equals("Green")) {
				return true;
			}
			else {
				return false;
			}
		}
	}

};
