package strategy;

/**
 * 策略模式：符合开关原则
 * 上下文对象：屏蔽客户端对策略对象的直接调用；解耦客户端和策略
 * @author shen_k
 *
 */
public class StrategyTest {

	public static void main(String[] args) {
		SortInvoker invoker = new SortInvoker();
		Object a[] = new Object[]{1,2,3};
		Object b[] = new Object[]{"a", "b", "c"};
		Object c[] = new Object[]{4L, 5L, 6L};
		
		invoker.execSort(a);
		invoker.execSort(b);
		invoker.execSort(c);
	}

}
