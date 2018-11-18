package entity;

public class Pokemon {
	
	private int id;
	private String name;
	private String type;
	private int level;
	
	public Pokemon(int id, String name, String type, int level) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.level = level;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
