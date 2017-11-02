package edu.fjnu;

public class SingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChocolateBoiler boiler = ChocolateBoiler.getInstance();
		
		//Now we are producing chocolate bars.
		boiler.fill();
		boiler.boil();
		boiler.drain();
	}

}
