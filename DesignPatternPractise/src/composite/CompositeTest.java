package composite;

/**
 * 组合模式：处理树形结构，客户端只需调用顶层节点；符合开关原则
 * 分类：安全组合模式 （叶子节点与非叶子节点定义不同接口，但违法依赖倒置原则）/ 透明组合模式（叶子节点与非叶子节点接口统一）
 * Spring Security应用：logoutHandler
 * @author shen_k
 *
 */
public class CompositeTest {

	public static void main(String[] args) {
		Component root = new Folder("root");
		Component dev1 = new Folder("dev1");
		root.add(dev1);
		root.add(new File("a.txt"));
		dev1.add(new File("b.txt"));
		
		root.print();
	}

}
