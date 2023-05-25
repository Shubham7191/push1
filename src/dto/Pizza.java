package dto;


import java.util.List;

public class Pizza {
    private MentItem menuItem;
    private Crust crust;
    private List<Topping> toppings;
    
    

    public Pizza(MentItem menuItem, Crust crust, List<Topping> toppings) {
        this.menuItem = menuItem;
        this.crust = crust;
        this.toppings = toppings;
    }

	public MentItem getMenuItem() {
		return menuItem;
	}

	public void setMenuItem(MentItem menuItem) {
		this.menuItem = menuItem;
	}

	public Crust getCrust() {
		return crust;
	}

	public void setCrust(Crust crust) {
		this.crust = crust;
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}

	@Override
	public String toString() {
		return "Pizza [menuItem=" + menuItem + ", crust=" + crust + ", toppings=" + toppings + "]";
	}

    
}