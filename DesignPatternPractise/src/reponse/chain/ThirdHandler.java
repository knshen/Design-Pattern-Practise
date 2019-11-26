package reponse.chain;

public class ThirdHandler implements IHandler {
	private IHandler next;
	
	@Override
	public void setNextHandler(IHandler handler) {
		this.next = handler;
	}

	@Override
	public void handle() {
		System.out.println("third handler...");
		if(next != null) {
			next.handle();
		}
	}

}
