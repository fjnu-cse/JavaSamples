package edu.fjnu;

/**
 * This is a class to demonstrate a singleton instance construction。
 * @author ll
 *
 */
public class ChocolateBoiler {
	private boolean empty;
	private boolean boiled;
	
	//static singleton instance
	private static ChocolateBoiler boiler;	
	
	/**
	 * Private constructor, only used in the class.
	 */
	private ChocolateBoiler() {	
		empty = true;
		boiled = false;
	}
	
	/**
	 * If boiler is null, make a new one; else return the instance. 
	 * @return the singleton instance
	 */
	public static ChocolateBoiler getInstance() {
		if(boiler == null) {
			boiler = new ChocolateBoiler();
		}
		return boiler;
	}
	
	public void fill() {
		if(isEmpty()) {
			empty = false;
			boiled = false;
			//Do something here to fill the mixture of milk and chocolate.
			System.out.println("Fill the mixture of milk and chocolate.");
		}
	}
	
	public void boil() {
		if(!isEmpty() && !isBoiled()) {
			//Do something here to boil the mixture.
			System.out.println("Boil the mixture");
			boiled = true;
		}
	}
	
	public void drain() {
		if(isBoiled()) {
			//Do something here to drain the mixture.
			System.out.println("Drain the mixture");
			empty = true;
		}
	}
	
	public boolean isEmpty() {
		return empty;
	}
	
	public boolean isBoiled() {
		return boiled;
	}
	
}
