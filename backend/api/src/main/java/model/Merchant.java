package model;

import java.util.List;

public class Merchant {
	
	private final String id;
	private final String name;
	private final List<Table> tables;

	public Merchant(String id, String name, List<Table> tables) {
		this.id = id;
		this.name = name;
		this.tables = tables;
	}

	public List<Table> getTables() {
		return tables;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
