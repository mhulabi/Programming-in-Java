package com.mohi.imax;

public class AirPods extends Accessories{

	public AirPods(String modelName, int price, int stock) {
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyAirPods(String modelName) {
		// TODO Auto-generated method stub
		setStock(getStock() - 1);
	}

	//Will remain unimplemented since I do not need them
	@Override
	public void buyMagSafeCharger(String modelName) {
		// TODO Auto-generated method stub
		
	}

	//Will remain unimplemented since I do not need them
	@Override
	public void buyCase(String modelName, String color) {
		// TODO Auto-generated method stub
		
	}

}
