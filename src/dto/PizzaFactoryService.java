package dto;

import java.util.List;

public class PizzaFactoryService {

	 private List<MentItem> menu;
	    private Inventory inventory;

	    public PizzaFactoryService(List<MentItem> availablePizzas, Inventory inventory) {
	        this.menu = availablePizzas;
	        this.inventory = inventory;
	        
	    }

	    
	    
	    public List<MentItem> getMenu() {
	        return menu;
	    }

	    public Inventory getInventory() {
	        return inventory;
	    }
	    
	    
	    
	    
	    

	    public String createOrder(Order order) {
	        StringBuilder confirmationMessage = new StringBuilder();

	        // Check if the ordered pizzas and sides are available
	        
	        
	        
	        boolean isOrderValid = validateOrder(order);
	        if (!isOrderValid) {
	            return "Invalid order. Please check your selections.";
	        }

	        // Update inventory
	        for (Pizza pizza : order.getPizzas()) {
	            MentItem menuItem = pizza.getMenuItem();
	            Crust crust = pizza.getCrust();
	            List<Topping> toppings = pizza.getToppings();

	            // Check crust availability
	            if (!inventory.getAvailableCrusts().contains(crust)) {
	                return "Crust " + crust.getName() + " is not available.";
	            }

	            // Check topping availability
	            for (Topping topping : toppings) {
	                if (!inventory.getAvailableToppings().contains(topping)) {
	                    return "Topping " + topping.getName() + " is not available.";
	                }
	            }

	            // Remove used crust from inventory
	            inventory.getAvailableCrusts().remove(crust);

	            // Remove used toppings from inventory
	            inventory.getAvailableToppings().removeAll(toppings);
	        }

	        
	        
	        // Generate confirmation message
	        confirmationMessage.append("Order confirmed. Details:\n");

	        for (Pizza pizza : order.getPizzas()) {
	            confirmationMessage.append("- ").append(pizza.getMenuItem().getName())
	                    .append(" (").append(pizza.getCrust().getName()).append(")\n");

	            for (Topping topping : pizza.getToppings()) {
	                confirmationMessage.append("  - ").append(topping.getName()).append("\n");
	            }
	        }

	        for (MentItem side : order.getSides()) {
	            confirmationMessage.append("- ").append(side.getName()).append("\n");
	        }

	        return confirmationMessage.toString();
	    }


	    
	    //this is an method to validate
	    
	    public boolean validateOrder(Order order) {
	        for (Pizza pizza : order.getPizzas()) {
	            MentItem menuItem = pizza.getMenuItem();
	            Crust crust = pizza.getCrust();
	            List<Topping> toppings = pizza.getToppings();

	            // Validate crust selection
	            if (inventory.getAvailableCrusts().contains(crust)) {
	                return true;
	            }

	            // Validate topping selection
	            for (Topping topping : toppings) {
	                if (inventory.getAvailableToppings().contains(topping)) {
	                    return true;
	                }
	            }

	            // Validate business rules for vegetarian and non-vegetarian pizzas
	            if (menuItem.isVegetarian()) {
	                for (Topping topping : toppings) {
	                    if (topping.isNonVegetarian()) {
	                        return false;
	                    }
	                }
	            } else {
	                boolean hasNonVegTopping = false;
	                for (Topping topping : toppings) {
	                    if (topping.isNonVegetarian()) {
	                        if (hasNonVegTopping) {
	                            return false;
	                        } else {
	                            hasNonVegTopping = true;
	                        }
	                    }
	                }
	            }
	        }

	        return true;
	    }

	}
