package com.mohi.imax;

public class IphoneTw extends Iphone{
	
	static boolean[] Id = new boolean[16];

	public IphoneTw(String color, int storage, int stock) {
		super(color, storage, stock);
		setModelName("iPhone 12");
		if (storage == 64) {
			setPrice(350);
		}
		else {
			setPrice(400);
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
		System.out.println("64 GB or 128 GB");
	}
	
	public boolean verifyStorage(int storage) {
		if (storage == 64 || storage == 128) {
		return true;
		}
		
		else {
			return false;
		}
	}
	
	public void displayColors() {
		System.out.println("White or Black or Blue");
	}
	
	public boolean verifyColor(String color) {
		if (color.equals("Black") || color.equals("White") || color.equals("Blue")) {
			return true;
			}
			
			else {
				return false;
			}
	}
	
	public boolean verifyAccessory(String accessory) {
		if (accessory.equals("Case") || accessory.equals("MagSafe Charger")) {
			return true;
			}
			
			else {
				return false;
			}
	}
	
};
