//basic code
//Singleton design pattern: only one instance in one class
public class ParkingLot{
	private static ParkingLot _instance = null; //private, only accessed by this class
	private List<Level> levels;
	private ParkingLot(){ //private
		levels = new ArrayList<>();
	}
	
	public static synchronized ParkingLot getInstance(){ //public access, check whether _instance is null, if not return the original _instance, to realize the featrue of only one instantce
	//static: getInstance()function is only related to the class ParkingLot
	//to call this function: ParkingLot.getInstance()
	//synchronized: to avoid multi-threading visits
		if(_instance == null){
			_instance = new ParkingLot();
		}
		return _instance;
	}
}

//Singleton静态内部类式
public class ParkingLot{
	private ParkingLot(){
	}
	
	private static class LazyParkingLot{
		static final ParkingLot _instance = new ParkingLot();
	}
	
	public static ParkingLot getInstance(){
		return LazyParkingLot._instance;
	}
}