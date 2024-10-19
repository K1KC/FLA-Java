package factories;

import java.util.List;

import models.Chocolate;

public abstract class ChocolateFactory {
	public abstract Chocolate createChocolate(String name, String flavor, List<String> ingredients, double price);
}
