package model;

public class OrderItem {

	private final String name;
	private final String quantity;
	
	public OrderItem(String name, String quantity) {
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public String getQuantity() {
		return quantity;
	}
}
