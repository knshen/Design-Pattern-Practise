package factory;

/**
 * 简单工厂模式
 * 定义：根据参数创建相同接口的不同对象
 * @author shen_k
 *
 */
class ShapeFactory {
	public Shape createShape(String type) {
		// 可以为每个shape实现类增加support方法优化下面的if-else
		if(type.equals("circle")) {
			return new CircleShape();
		} else if(type.equals("rect")) {
			return new RectShape();
		} else if(type.equals("triangle")) {
			return new TriangleShape();
		}
		return null;
	}
}
public class SimpleFactoryTest {
	
	public static void main(String[] args) {
		ShapeFactory fact = new ShapeFactory();
		Shape trian = fact.createShape("triangle");
		Shape circle = fact.createShape("circle");
		Shape rect = fact.createShape("rect");
		
		trian.draw();
		circle.draw();
		rect.draw();
	}

}
