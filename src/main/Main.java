package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import adapters.CardPaymentAdapter;
import adapters.CashPaymentAdapter;
import adapters.DigitalWalletPaymentAdapter;
import adapters.PaymentAdapter;
import factories.ChocolateBarFactory;
import factories.ChocolateFactory;
import factories.TruffleFactory;
import models.Chocolate;
import singleton.ChocolateDatabase;

public class Main {
	
	public void orderChocolate(Scanner scan, ChocolateDatabase db) {
		System.out.print("Enter Chocolate Type: ");
		String type = scan.nextLine();
		System.out.print("Enter Chocolate Name: ");
		String name = scan.nextLine();
		System.out.print("Enter Chocolate Flavor: ");
		String flavor = scan.nextLine();
		List<String> ingredients = new ArrayList<>();
		System.out.print("Enter Chocolate Price: ");
		double price = Double.parseDouble(scan.nextLine());
		
		System.out.print("Enter Payment Method: ");
		String payment = scan.nextLine();
		PaymentAdapter paymentAdapter = null;
		switch(payment) {
			case "Cash":
				paymentAdapter = new CashPaymentAdapter();
				break;
			case "Card":
				paymentAdapter = new CardPaymentAdapter();
				break;
			case "Digital Wallet":
				paymentAdapter = new DigitalWalletPaymentAdapter();
				break;
			default:
				System.out.println("Invalid Payment Method");
		}
		
		price = paymentAdapter.getPriceinPayment(price);
		System.out.println("Chocolate ordered successfully");
		
		ChocolateFactory factory = type.equals("Chocolate Bar") ? new ChocolateBarFactory() : new TruffleFactory();
		
		Chocolate chocolate = factory.createChocolate(name, flavor, ingredients, price);
		
		db.addChocolate(chocolate);
	}
	
	public void viewChocolateOrders(ChocolateDatabase db) {
		List<Chocolate> chocolates = db.getChocolates();
		
		if(chocolates.isEmpty()) {
			System.out.println("No orders found");
		}
		else {
			for(Chocolate chocolate : chocolates) {
				System.out.println(chocolate.getType());
				System.out.println(chocolate.getName());
				System.out.println(chocolate.getFlavor());
				System.out.println(chocolate.getIngredients());
				System.out.println(chocolate.getPrice());
			}
		}
	}

	public Main () {
		Scanner scan = new Scanner(System.in);
		ChocolateDatabase db = ChocolateDatabase.getInstance();
		
		while(true) {
			System.out.println("1. Order Chocolate");
			System.out.println("2. View Chocolates Order");
			System.out.println("3. Exit");
			System.out.print(">> ");
			
			int choice = Integer.parseInt(scan.nextLine());
			
			if(choice==1) {
				orderChocolate(scan, db);
			}
			else if (choice == 2) {
				viewChocolateOrders(db);
			}
			else if (choice == 3) {
				break;
			}
		}
	}
	public static void main(String[] args) {
		new Main();
	}

}
