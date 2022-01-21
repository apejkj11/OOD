class MyException extends Exception{
	public MyException(String s){
		super(s);
	}
}

public class Testing{
	public void test(){
		try{
			throw new MyException("My exception");
		}catch(MyException ex){
			System.out.println(ex.getMessages());
		}
	}
}