package command;

public class Invoker {
	private ITask task;
	
	public Invoker(ITask task) {
		this.task = task;
	}
	
	public void invoke() {
		this.task.execute();
	}
}
