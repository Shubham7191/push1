package dto;

import java.util.List;

public class Inventory {

	 private List<Topping> availableToppings;
	    private List<Crust> availableCrusts;

	    public Inventory(List<Topping> availableToppings, List<Crust> availableCrusts) {
	        this.availableToppings = availableToppings;
	        this.availableCrusts = availableCrusts;
	    }

		public List<Topping> getAvailableToppings() {
			return availableToppings;
		}

		public void setAvailableToppings(List<Topping> availableToppings) {
			this.availableToppings = availableToppings;
		}

		public List<Crust> getAvailableCrusts() {
			return availableCrusts;
		}

		public void setAvailableCrusts(List<Crust> availableCrusts) {
			this.availableCrusts = availableCrusts;
		}

		@Override
		public String toString() {
			return "Inventory [availableToppings=" + availableToppings + ", availableCrusts=" + availableCrusts + "]";
		}

	   
		
		
	}
