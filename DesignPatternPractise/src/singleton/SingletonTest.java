package singleton;

import java.lang.reflect.Constructor;

/**
 * 饿汉式：类加载即初始化 线程安全
 * 
 * @author shen_k
 *
 */
class HungrySingletonBean {
	private static HungrySingletonBean bean = new HungrySingletonBean();

	private HungrySingletonBean() {
	}

	public static HungrySingletonBean createBean() {
		return bean;
	}
}

/**
 * 双重加锁懒汉式
 * 
 * @author shen_k
 *
 */
class LazyBean {
	private volatile static LazyBean bean = null; // volatile防止指令重排

	private LazyBean() {

	}

	public LazyBean createBean() {
		if (bean == null) {
			synchronized (LazyBean.class) {
				if (bean == null) {
					bean = new LazyBean();
				}
			}
		}

		return bean;
	}
}

/**
 * 静态内部类 优点：延迟加载（调用create方法时内部静态类才会被加载）；线程安全
 * 
 * @author shen_k
 *
 */
class StaticInnerBean {
	private StaticInnerBean() {

	}

	private static class BeanHolder {
		private static StaticInnerBean bean = new StaticInnerBean();
	}

	public StaticInnerBean createBean() {
		return BeanHolder.bean;
	}
}

/**
 * 枚举
 *  优点：防止反射漏洞攻击 
 *  缺点：无法懒加载
 * @author shen_k
 */
enum EnumBean {
	INSTANCE;
	public EnumBean createInstance() {
		return EnumBean.INSTANCE;
	}
	
	private EnumBean() {
		
	}
}

public class SingletonTest {

	public static void main(String[] args) throws Exception {
		// 演示反射漏洞
		Constructor con = StaticInnerBean.class.getDeclaredConstructor();
		con.setAccessible(true);
		StaticInnerBean obj1 = (StaticInnerBean) con.newInstance();
		StaticInnerBean obj2 = (StaticInnerBean) con.newInstance();
		System.out.println(obj1);
		System.out.println(obj2);
		
		// jvm禁止通过反射获取enum类型私有构造方法
		con = EnumBean.class.getDeclaredConstructor();
	}

}
