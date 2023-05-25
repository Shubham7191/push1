package dto;


import java.util.List;

public class Order {
	private List<Pizza> pizzas;
    private List<MentItem> sides;

    public Order(List<Pizza> pizzas, List<MentItem> sides) {
        this.pizzas = pizzas;
        this.sides = sides;
    }

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}

	public List<MentItem> getSides() {
		return sides;
	}

	public void setSides(List<MentItem> sides) {
		this.sides = sides;
	}

	@Override
	public String toString() {
		return "Order [pizzas=" + pizzas + ", sides=" + sides + "]";
	}

    
}
