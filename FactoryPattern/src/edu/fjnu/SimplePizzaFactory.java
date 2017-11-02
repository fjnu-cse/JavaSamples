package edu.fjnu;

public class SimplePizzaFactory {
	
	public SimplePizzaFactory() {}
	
	/**
	 * Object factory of Pizza.
	 * @param type
	 * @return
	 */
	public Pizza createPizza(String type) {
		Pizza pizza=null;
		
		if(type.equals("cheese")) {
			pizza = new CheesePizza();
		} else if(type.equals("clam")) {
			pizza = new ClamPizza();
		} else if(type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
		}
		
		return pizza;
	}
}
