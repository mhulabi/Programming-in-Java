package com.mohi.imax;

public class IphoneTh extends Iphone{
	
	static boolean[] Id = new boolean[12];
	
	public IphoneTh(String color, int storage, int stock) {
		super(color, storage, stock);
		setModelName("iPhone 13");
		if (storage == 128) {
			setPrice(450);
		}
		else {
			setPrice(500);
		}
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
		setStock(getStock() - 1);
	}
	
	public void displayStorages() {
		System.out.println("128 GB or 256 GB");
	}
	
	public boolean verifyStorage(int storage) {
		if (storage == 128 || storage == 256) {
		return true;
		}
		
		else {
			return false;
		}
	}
	
	public void displayColors() {
		System.out.println("White or Black or Red");
	}
	
	public boolean verifyColor(String color) {
		if (color.equals("Black") || color.equals("White") || color.equals("Red")) {
			return true;
			}
			
			else {
				return false;
			}
	}
	
	public boolean verifyAccessory(String accessory) {
		if (accessory.equals("Case") || accessory.equals("MagSafe Charger") || accessory.equals("Airpods")) {
			return true;
			}
			
			else {
				return false;
			}
	}

};
