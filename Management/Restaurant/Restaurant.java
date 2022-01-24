//Exception
class NoTableException extends Exception{
	public NoTableException(Party p){
		super("No Table available for party size: " + p.getSize());
	}
}

class Meal{
	private float price;
	public Meal(float price){
		this.price = price;
	}
	publi float getPrice(){
		return this.price;
	}
}

class Order{
	private List<Meal> meals;
	public Order(){
		meals = new ArrayList<Meal>();
	}
	public List<Meal> getMeals(){
		return meals;
	}
	
	public void mergeOrder(Order order){
		if(order != null){
			for(Meal meal : order.getMeals()){
				meals.add(meal);
			}
		}
	}
	public float getBill(){
		int bill = 0;
		for(Meal meal : meals){
			bill += meal.getPrice();
		}
		return bill;
	}
}

class Party{
	private int size;
	public Party(int size){
		this.size = size;
	}
	
	public int getSize(){
		return this.size;
	}
}

class Table implements Comparable<Table>{
	private int capacity;
	private boolean available;
	private Order order;
	public Table(int capacity){
		this.capacity = capacity;
		available = true;
		order = null;
	}
	
	public int getCapacity(){
		return this.capacity;
	}
	
	public boolean isAvailable(){
		return this.available;
	}
	
	public void markAvailable(){
		this.available = true;
	}
	public void markUnavailable(){
		this.available = false;
	}
	public Order getCurrentOrder(){
		return this.order;
	}
	
	public void setOrder(Order o){
		if(order == null){
			this.order = o;
		}else{
			if(o != null){
				this.order.mergeOrder(o);
			}else{
				this.order = o;
			}
		}
	}
	
	@Override
	public int compareTo(Table compareTable){
		return this.capacity - compareTable.getCapacity();
	}
}

public class Restaurant{
	private List<Table> tables;
	private List<Meal> meals;
	public Restaurant(){
		tables = new ArrayList<Table>();
		meals = new ArrayList<Meal>();
	}
	
	public void findTable(Party p) throws NoTableException{
		int partySize = p.getSize();
		for(Table t :  tables){
			if(t.isAvailable()){
				if(t.getCapacity() >= partySize){
					t.markUnavailable();
					return;
				}
			}
		}
		throw new NoTableException(p);
	}
	
	public void takeOrder(Table t, Order o){
		t.setOrder(o);
	}
	
	public float checkout(Table t){
		float bill = 0;
		Order o = t.getCurrentOrder();
		if(o != null){
			bill = o.getBill();
		}
		t.markAvailable;
		t.setOrder(null);
		return bill;
	}
	public List<Meal> getMenu(){
		return menu;
	}
	
	public void addTable(Table t){
		tables.add(t);
		Collections.sort(tables);
	}
}