package dto;

public class Topping {
	private String name;
    private double price;
    private boolean isNonVegetarian;

    public Topping(String name, double price, boolean isNonVegetarian) {
        this.name = name;
        this.price = price;
        this.isNonVegetarian = isNonVegetarian;
    }

	public Topping(String string) {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
		
		
		
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	 public boolean isNonVegetarian() {
	        return isNonVegetarian;
	    }

	@Override
	public String toString() {
		return "Topping [name=" + name + ", price=" + price + ", isNonVegetarian=" + isNonVegetarian + "]";
	}
	 
	

    
}
