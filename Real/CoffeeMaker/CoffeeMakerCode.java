public class Main{
	public static void printInfo(Coffee c){
		System.out.println("Cost: " + c.getCost() + "; ingredients: " + c.getIngredients());
	}
	
	public static void main(String[] args){
		Coffee c = new SimpleCoffee();
		printInfo(c);
		c = new withMilk(c);
		printInfo(c);
		c = withSprinkles(c);
		printInfo(c);
	}
}



public interface Coffee{
	public double getCost();
	public String getIngredients();
}

//Extension of a simple coffee without any extra ingredients
public class SimpleCoffee implements Coffee{
	@Override
	public double getCost(){
		return 1;
	}
	@Override
	public String getIngredients(){
		return "Coffee";
	}
}

//Abstract decorator class - it implements Coffee interface
public abstract class CoffeeDecrator implements Coffee{
	//protected for the usage in the subclasses
	protected final Coffee decoratedCoffee;
	public CoffeeDecorator(Coffee c){
		this.decoratedCoffee = c;
	}
	
	public double getCost(){
		return decoraredCoffee.getCost();
	}
	
	public String getIngredients(){
		return decoratredCoffee.getIngredients();
	}
}

//new class extents CoffeeDecorator
public class withMilk extends CoffeeDecorator{
	public withMilk(Coffee c){
		//super: can visit line 22-24 without definition
		super(c);
	}
	
	public double getCost(){ // override the methods defined in the abstract superclass
		return super.getCost() + 0.5;
	}
	
	public String getIngredients(){
		return super.getIngredients() + ", Milk";
	}
}

public class withSprinkles extends CoffeeDecorator{
	public withSprinkles(Coffee c){
		//super: can visit line 22-24 without definition
		super(c);
	}
	
	public double getCost(){ // override the methods defined in the abstract superclass
		return super.getCost() + 0.5;
	}
	
	public String getIngredients(){
		return super.getIngredients() + ", sprinkles";
	}
}
