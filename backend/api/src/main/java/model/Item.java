package model;

public class Item {
	
	private final String name;
	private final String price;
	private final String category;
	private final String imageLink;

	public Item(String name, String price, String category, String imageLink) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.imageLink = imageLink;
	}

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}

	public String getImageLink() {
		return imageLink;
	}

}
