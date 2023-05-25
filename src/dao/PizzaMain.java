package dao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Crust;
import dto.Inventory;
import dto.MentItem;
import dto.Order;
import dto.Pizza;
import dto.PizzaFactoryService;
import dto.Topping;

public class PizzaMain {
    public static void main(String[] args) {
        // Create menu items
        MentItem deluxeVeggie = new MentItem("Deluxe Veggie", createPriceMap(150, 200, 325), true);
        MentItem cheeseAndCorn = new MentItem("Cheese and Corn", createPriceMap(175, 375, 475), true);
        // ... create other menu items

        // Create crust types
        Crust newHandTossed = new Crust("New hand tossed");
        Crust wheatThinCrust = new Crust("Wheat thin crust");
        // ... create other crust types

        // Create toppings
        Topping blackOlive = new Topping("Black olive", 20, false);
        Topping capsicum = new Topping("Capsicum", 25, false);
        

        // Create inventory
        List<Topping> availableToppings = Arrays.asList(new Topping("Black Olive"), new Topping("Capsicum"));
        List<Crust> availableCrusts = Arrays.asList(new Crust("New Hand Tossed"), new Crust("Wheat Thin Crust"));
        Inventory inventory = new Inventory(availableToppings, availableCrusts);

     // Create PizzaFactoryService instance
        List<MentItem> availablePizzas = Arrays.asList(
            new MentItem("Deluxe Veggie", Arrays.asList(10.99, 12.99)),
            new MentItem("Cheese and Corn", Arrays.asList(9.99, 11.99))
        );
        PizzaFactoryService pizzaFactoryService = new PizzaFactoryService(availablePizzas, inventory);

        // Get the menu
        List<MentItem> menu = pizzaFactoryService.getMenu();
        System.out.println("Menu:");
        for (MentItem menuItem : menu) {
            System.out.println(menuItem.getName() + " - " + menuItem.getPrices());
        }

        // Get the inventory
        Inventory currentInventory = pizzaFactoryService.getInventory();
        System.out.println("\nInventory:");
        System.out.println("Available crusts: " + currentInventory.getAvailableCrusts());
        System.out.println("Available toppings: " + currentInventory.getAvailableToppings());
        
        

        // Create an order
        List<Pizza> pizzas = Arrays.asList(
                new Pizza(deluxeVeggie, newHandTossed, Arrays.asList(blackOlive, capsicum)),
                new Pizza(cheeseAndCorn, wheatThinCrust,Arrays.asList(blackOlive, capsicum))
        );
        List<MentItem> sides = Arrays.asList();
        Order order = new Order(pizzas, sides);

        
        
        
        
        // Validate the order
        boolean isValidOrder = pizzaFactoryService.validateOrder(order);
        if (isValidOrder) {
            System.out.println("\nOrder is valid!");
            
         // Place the order
            String confirmationMessage = pizzaFactoryService.createOrder(order);
            System.out.println("\n order is confirmed \n" + confirmationMessage);
        
        } else {
            System.out.println("\nInvalid order!");
            String confirmationMessage = pizzaFactoryService.createOrder(order);
            System.out.println("\n order is Not  confirmed \n" + confirmationMessage);
        }

        
        
        
        
        
    }

    
    
    // Helper method to create price map
    private static Map<String, Integer> createPriceMap(int regularPrice, int mediumPrice, int largePrice) {
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Regular", regularPrice);
        prices.put("Medium", mediumPrice);
        prices.put("Large", largePrice);
        return prices;
    }
}
