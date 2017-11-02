package edu.fjnu;

import java.util.Scanner;

public class FactoryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplePizzaFactory factory = new SimplePizzaFactory();
		PizzaStore store = new PizzaStore(factory);
		System.out.println("Enter which type of pizza you want to: cheese, clam or pepperoni.");
		Scanner scanner = new Scanner(System.in);
		String type = scanner.nextLine();
		store.orderPizza(type);
		scanner.close();
	}

}
