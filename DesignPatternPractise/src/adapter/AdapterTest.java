package adapter;

/**
 * 适配器模式
 * 使用场景：想要复用一个已经存在的类，但该类的接口不符合要求
 * @author shen_k
 *
 */
public class AdapterTest {

	public static void main(String[] args) {
		IAdaptee adaptee = new AdapteeImpl();
		ITarget adapter = new Adapter(adaptee);
		adapter.targetAction();

	}

}
