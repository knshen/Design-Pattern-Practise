package command;

/**
 * 命令模式：调用者-命令-执行者，通过中间人命令解耦调用者和执行者
 * 调用者不必知道是哪个接收者负责执行
 * @author shen_k
 *
 */
public class CommandTest {

	public static void main(String[] args) {
		IReceiver recv = new ReceiverImpl("A");
		ITask task = new TaskImpl(recv);
		Invoker invoker = new Invoker(task);
		
		invoker.invoke();

	}

}
