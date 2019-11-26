package reponse.chain;

public class FirstHandler implements IHandler {
	private IHandler next;
	@Override
	public void setNextHandler(IHandler handler) {
		this.next = handler;
	}

	@Override
	public void handle() {
		System.out.println("first handler...");
		if(next != null) {
			next.handle();
		}
	}

}
