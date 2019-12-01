package runtime.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * 原理：java反射
 * 优点：性能好
 * 缺点：目标类必须实现接口，并且只能代理接口方法
 * 
 * 实现原理：基于被代理类的接口，创建代理类
 * 实现方法：实现一个创建类，实现InvocationHandler接口
 * @author shen_k
 *
 */
interface IPerson {
	void say();
}

class Programmer implements IPerson {

	@Override
	public void say() {
		System.out.println("Hello World!");
	}
	
}

class ProgrammerProxyCreator implements InvocationHandler  {
	private IPerson person;
	
	/**
	 * 运行时创建代理类对象
	 * @return
	 */
	public Object createRuntimeProxyInstance() {
		return Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), this);
	}
	
	public ProgrammerProxyCreator(IPerson per) {
		this.person = per;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before logic...");
		if(method.getName().equals("say")) {
			this.person.say();
		}
		System.out.println("after logic...");
		return null;
	}
	
}

public class JDKProxyTest {

	public static void main(String[] args) {
		IPerson pgm = new Programmer();
		ProgrammerProxyCreator creator = new ProgrammerProxyCreator(pgm);
		IPerson proxy = (IPerson)creator.createRuntimeProxyInstance();

		System.out.println(proxy.getClass());
		proxy.say();
	}

}
