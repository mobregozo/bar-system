package model;

public class Table {

	private final String id;
	private final String name;

	public Table(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
