package model;

public class Item {
	
	private String nameItem;
	private String type;
	private String colorItem;
	private String sizeItem;
	private String existInStore;
	private int howMuch; 
	private String pathPicture; 
	private int price;
	
	public Item()
	{
		
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColorItem() {
		return colorItem;
	}

	public void setColorItem(String colorItem) {
		this.colorItem = colorItem;
	}

	public String getSizeItem() {
		return sizeItem;
	}

	public void setSizeItem(String sizeItem) {
		this.sizeItem = sizeItem;
	}

	public String getExistInStore() {
		return existInStore;
	}

	public void setExistInStore(String existInStore) {
		this.existInStore = existInStore;
	}

	public int getHowMuch() {
		return howMuch;
	}

	public void setHowMuch(int howMuch) {
		this.howMuch = howMuch;
	}

	public String getPathPicture() {
		return pathPicture;
	}

	public void setPathPicture(String pathPicture) {
		this.pathPicture = pathPicture;
	}
}
