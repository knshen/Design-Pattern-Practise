package proxy;

/**
 * 静态代理模式：使用代理类控制主类的行为
 * 场景：延迟初始化
 * 与装饰器模式区别：装饰器侧重对原有接口的功能增强；代理模式侧重对原有接口进行访问控制
 * @author shen_k
 *
 */
public class StaticProxyTest {

	public static void main(String[] args) {
		IActor agent = new Agent();
		agent.movie();

	}

}
