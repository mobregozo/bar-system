package model;

import java.util.List;

public class Menu {
	
	private final long merchantId;
	private final String name;
	private final List<Item> items;

	public Menu(long merchantId, String name, List<Item> items) {
		this.merchantId = merchantId;
		this.name = name;
		this.items = items;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public String getName() {
		return name;
	}

	public List<Item> getItems() {
		return items;
	}

}
