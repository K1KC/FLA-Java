package factories;

import java.util.List;

import models.Chocolate;
import models.Truffle;

public class TruffleFactory extends ChocolateFactory{

	@Override
	public Chocolate createChocolate(String name, String flavor, List<String> ingredients, double price) {
		return new Truffle(name, flavor, ingredients, price);
	}

}
