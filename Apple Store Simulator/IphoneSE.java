package com.mohi.imax;

public class IphoneSE extends Iphone{
	
	static boolean[] Id = new boolean[6];

	public IphoneSE(String color, int storage, int stock) {
		super(color, storage, stock);
		setPrice(300);
		setModelName("iPhone SE");
		for (int i = 0; i < stock; i++) {
			if (!Id[i]) {
				setID(i+1);
				Id[i] = true;
				break;
			}
		}
	}

	@Override
	public void displayStock() {
		if (getStock() > 0) {
			System.out.println(getColor() + " " + getModelName() + " " + getStorage() + "GB ($"+ getPrice() +"): " + getStock() + " remaining in stock");
			
		}
		else {
			System.out.println(getColor() + " " + getModelName() + " " + getStorage() + "GB OUT OF STOCK");
		}
	}

	@Override
	public void buyPhone(int storage, String color) {
		// TODO Auto-generated method stub
		setStock(getStock() - 1);
	}
	
	public void displayColors() {
		System.out.println("White or Black");
	}
	
	public boolean verifyColor(String color) {
		if (color.equals("Black") || color.equals("White")) {
			return true;
			}
			
			else {
				return false;
			}
	}
	
	public boolean verifyAccessory(String accessory) {
		if (accessory.equals("Case")) {
			return true;
			}
			
			else {
				return false;
			}
	}

};
