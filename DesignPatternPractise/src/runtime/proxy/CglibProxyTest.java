package runtime.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * cglib��̬����
 * ԭ������ASM
 * �ŵ㣺����Ҫ���ڽӿ�
 * ȱ�㣺���ܲ�
 * 
 * ʵ�ַ�����ʵ�ִ������࣬ʵ��MethodInterceptor�ӿ�
 * @author shen_k
 *
 */

class Person {
	public void say(String word) {
		System.out.println(word);
	}
}

class PersonCglibProxyCreator implements MethodInterceptor {
	private Person person;
	
	public PersonCglibProxyCreator(Person person) {
		this.person = person;
	}

	public Object createProxyClassInstance() {
		return Enhancer.create(person.getClass(), this);
	}
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("before logic");
		arg3.invokeSuper(arg0, arg2);
		System.out.println("after logic");
		return null;
	}
	
	
}


public class CglibProxyTest {

	public static void main(String[] args) {
		Person person = new Person();
		PersonCglibProxyCreator creator = new PersonCglibProxyCreator(person);
		Person proxyInstance = (Person)creator.createProxyClassInstance();
		
		System.out.println(proxyInstance.getClass());
		proxyInstance.say("Hello!");
	}

}
