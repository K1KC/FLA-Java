package factories;

import java.util.List;

import models.Chocolate;
import models.ChocolateBar;

public class ChocolateBarFactory extends ChocolateFactory {

	@Override
	public Chocolate createChocolate(String name, String flavor, List<String> ingredients, double price) {
		// TODO Auto-generated method stub
		return new ChocolateBar(name, flavor, ingredients, price);
	}

}
