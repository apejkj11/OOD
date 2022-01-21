//basic code
//StrategyDesignPattern 
//encapsulate multiple algorithms or strategies
//Example: Elevator system
class MyJavaApplication{
	ElevatorSystem system = new ElevatorSystem();
	system.setStrategy(new RandomHandleRequestStrategy());
	ExternalRequest request = new ExternalRequest(Direction.up, 3);
	system.handleRequest(request);
}

class ElevatorSystem{
	private HandleRequestStrategy strategy = new HandleRequestStrategy();
	private List<ELevator> elevators = new ArrayList<>();
	public void setStrategy(HandleRequestStrategy strategy){
		this.strategy = strategy;
	}
	public void handleRequest(ExternalRequest request){
		strategy.handleRequest(request, elevators);
	}
}

interface HandleRequestStrategy{
	public void handleRequest(ExternalRequest request, List<Elevator> elevators);
}

class RandomHandleRequestStrategy implements HandleRequestStrategy{
	public void handleRequest(ExternalRequest request, List<Elevator> elevators){
		Random rand = new Random();
		int n = rand.nextInt(elevators.size());
		elevators.get(n).handleExternalRequest(request);
	}
}

class AlwaysOneElevatorHandleRequestStrategy implements HandleRequestStrategy{
	public void handleRequest(ExternalRequest request, List<ELevator> elevators){
		elevators.get(0).handleExternalRequest(request);
	}
}