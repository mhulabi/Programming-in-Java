package com.mohi.imax;

public class MagSafeCharger extends Accessories  {

	public MagSafeCharger(String modelName, int price, int stock) {
		super(modelName, price, stock);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void displayAccessories() {
		if (getStock() > 0) {
			System.out.println("MagSafe Charger " + getModelName() + " ($"+ getPrice() +"): " + getStock() + " remaining in stock");
		}
		else {
			System.out.println("MagSafe Charger " + getModelName() + " OUT OF STOCK");
		}
	}

	@Override
	public void buyMagSafeCharger(String modelName) {
		setStock(getStock() - 1);
	}

	//Will remain unimplemented since I do not need them
	@Override
	public void buyCase(String modelName, String color) {
		// TODO Auto-generated method stub
		
	}

	//Will remain unimplemented since I do not need them
	@Override
	public void buyAirPods(String modelName) {
		// TODO Auto-generated method stub
		
	}

}
