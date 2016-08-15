package model;

import java.util.List;

public class Order {

	private final String merchantId;
	private final String tableId;
	private final List<OrderItem> tables;

	public Order(String merchantId, String tableId, List<OrderItem> tables) {
		this.merchantId = merchantId;
		this.tableId = tableId;
		this.tables = tables;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public String getTableId() {
		return tableId;
	}

	public List<OrderItem> getTables() {
		return tables;
	}
	
	
}
