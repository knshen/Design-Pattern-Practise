package reponse.chain;

public class SecondHandler implements IHandler {
	private IHandler next;
	
	@Override
	public void setNextHandler(IHandler handler) {
		this.next = handler;
	}

	@Override
	public void handle() {
		System.out.println("second handler...");
		if(next != null) {
			next.handle();
		}
	}

}
