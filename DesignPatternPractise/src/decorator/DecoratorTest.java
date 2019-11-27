package decorator;

/**
 * 装饰器模式
 * @author shen_k
 *
 */
public class DecoratorTest {

	public static void main(String[] args) {
		IPancake cake = new Pancake();
		IPancake eggCake = new EggPancakeDecorator(cake);
		eggCake.cook();

	}

}
