package reponse.chain;

/**
 * 责任链模式：
 * 好处：符合开关原则
 * 缺点：可能有性能问题
 * @author shen_k
 *
 */
public class ResponseChainTest {

	public static void main(String[] args) {
		IHandler first = new FirstHandler();
		IHandler second = new SecondHandler();
		IHandler third = new ThirdHandler();
		first.setNextHandler(second);
		second.setNextHandler(third);
		
		first.handle();
	}

}
