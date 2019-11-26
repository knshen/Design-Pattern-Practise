package command;

public class TaskImpl implements ITask {
	private IReceiver recv;
	
	public TaskImpl(IReceiver recv) {
		this.recv = recv;
	}
	
	@Override
	public void execute() {
		recv.action();
	}

}
