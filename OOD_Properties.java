//1. Encapsulation

//class/object
class Animal{}
Animal a = new Animal();

//2.Inheritance
//2.1 case1
class Animal{
	public void description(){
		System.out.println("This is a general animal object");
	}
	protected String name; //can only be accessed by self and children
	public int id; //can be accessed by everything
	private String privacy;//can not be inherited by child class
}

class Dog extends Animal{
	//inherit everything in parent class except for the private attributes/methods
}

Dog dog = new Dog();
dog.description(); //can use parent class' method

//2.2 case2
class Animal{
	public void description(){
		System.out.println("This is a general animal object");
	}
	protected String name; //can only be accessed by self and children
	public int id; //can be accessed by everything
	private String privacy;//can not be inherited by child class
}

class Dog extends Animal{
	@override //will not user parent's description method 复写？
	public void description(){
		System.out.println("This is a dog object");
		System.out.println("Name ->" + name);
		System.out.println("Id ->" +id);
		System.out.println("Privacy ->" + privacy); //This is wrong!!!!
	}
	
	@overload//重载？ call the function based on the input
	public void description(String type){
	}
}

Dog dog = new Dog();
dog.description(); //can use parent class' method

//2.3 super
class Animal{
	public void description(){
		System.out.println("This is a general animal object");
	}
	protected String name; //can only be accessed by self and children
	public int id; //can be accessed by everything
	private String privacy;//can not be inherited by child class
}

class Dog extends Animal{
	public void description(){
		super();//this will call base class's description
	}
}

Dog dog = new Dog();
dog.description();

//2.4 final
final class Animal{
}//this class cannot be inherited

//2.5 abstract 
//abstract class cannot be initialized

class Animal{
	public void description(){
		System.out.println("This is a general animal object");
	}
	protected String name; 
	public int id; 
	private String privacy;
}

class Dog extends Animal{
	public void description(){
		super();//this will call base class's description
	}
}

Animal animal = new Animal();//this is wrong!!!
Animal animal = new Dog();//this is right

//2.6 abstract function can be in abstract class

abstract class Animal{
	public void description(){
		System.out.println("This is a general animal object");
	}
	public abstract void makeSound();//abstract function
	
	protected String name; 
	public int id; 
	private String privacy;
}

class Dog extends Animal{
	public void makeSound(){ //must be implemented because this child class is not abstract class
		System.out.println("...");
	}
}

abstract class mamal extends Animal{//no need to implement makeSound function
}

//2.7 Interface
interface Service{
	//No constructor
	public void serve();
	public void retire();
}
interface Circus{
	public volid perform();
}
class Animal{
	public void description(){
		System.out.println("This is a general animal object");
	}
	protected String name; 
	public int id; 
	private String privacy;
}

class Dog extends Animal implements Service, Circus{//only one parent class can be multiple interfaces
	public void serve(){
		//...//each interface's method need to be implemented
	}
	public void retire(){
		//...
	}
	public void perform(){
		//...
	}
}

//3.polymorphism
