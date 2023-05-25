package dto;

import java.util.List;
import java.util.Map;

public class MentItem {
	 
	
	private String name;
    private Map<String, Integer> prices;
    private boolean isVegetarian;

    public MentItem(String name, Map<String, Integer> string, boolean isVegetarian) {
        this.name = name;
        this.prices = string;
        this.isVegetarian = isVegetarian;
    }

    
    
    
    public MentItem(String string, List<Double> asList) {
		// TODO Auto-generated constructor stub
	}




	



	public void setName(String name) {
		this.name = name;
	}


	public void setPrices(Map<String, Integer> prices) {
		this.prices = prices;
	}


	public void setVegetarian(boolean isVegetarian) {
		this.isVegetarian = isVegetarian;
	}


	public String getName() {
        return name;
    }

    public Map<String, Integer> getPrices() {
        return prices;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }




	@Override
	public String toString() {
		return "MentItem [name=" + name + ", prices=" + prices + ", isVegetarian=" + isVegetarian + "]";
	}
    
    
}