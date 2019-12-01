package runtime.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk��̬����
 * ԭ��java����
 * �ŵ㣺���ܺ�
 * ȱ�㣺Ŀ�������ʵ�ֽӿڣ�����ֻ�ܴ���ӿڷ���
 * 
 * ʵ��ԭ�����ڱ�������Ľӿڣ�����������
 * ʵ�ַ�����ʵ��һ�������࣬ʵ��InvocationHandler�ӿ�
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
	 * ����ʱ�������������
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
