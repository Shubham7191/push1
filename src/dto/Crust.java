package dto;

public class Crust {
	
	private String name;

    public Crust(String name) {
        this.name = name;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Crust [name=" + name + "]";
	}

    
}
