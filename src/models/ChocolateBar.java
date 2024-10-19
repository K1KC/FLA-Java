package models;

import java.util.List;

public class ChocolateBar implements Chocolate {

	private String name;
	private String flavor;
	private List<String> ingredients;
	private double price;
	
	public ChocolateBar(String name, String flavor, List<String> ingredients, double price) {
		super();
		this.name = name;
		this.flavor = flavor;
		this.ingredients = ingredients;
		this.price = price;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Chocolate Bar";
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String getFlavor() {
		// TODO Auto-generated method stub
		return flavor;
	}

	@Override
	public List<String> getIngredients() {
		// TODO Auto-generated method stub
		return ingredients;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

}
