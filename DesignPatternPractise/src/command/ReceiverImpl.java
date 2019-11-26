package command;

public class ReceiverImpl implements IReceiver {
	private String id;
	
	public ReceiverImpl(String id) {
		this.id = id;
	}
	
	@Override
	public void action() {
		System.out.println("receiver " + id + ": is executing...");

	}

}
