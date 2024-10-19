package models;

import java.util.List;

public interface Chocolate {
	String getType();
	String getName();
	String getFlavor();
	List<String> getIngredients();
	double getPrice();
}
