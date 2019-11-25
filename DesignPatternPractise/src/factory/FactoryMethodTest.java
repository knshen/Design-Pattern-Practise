package factory;

/**
 * 工厂方法模式
 * 定义：与简单工厂的区别是，工厂类也有多个，并于创建对象一一对应
 * @author shen_k
 *
 */

interface IShapeFactory {
	Shape createShape();
}

class CircleShapeFactory implements IShapeFactory {

	@Override
	public Shape createShape() {
		return new CircleShape();
	}
}

class RectShapeFactory implements IShapeFactory {

	@Override
	public Shape createShape() {
		return new RectShape();
	}
}

class TriangleShapeFactory implements IShapeFactory {

	@Override
	public Shape createShape() {
		return new TriangleShape();
	}
}
public class FactoryMethodTest {

	public static void main(String[] args) {
		IShapeFactory circleFact = new CircleShapeFactory();
		IShapeFactory rectFact = new RectShapeFactory();
		IShapeFactory triangleFact = new TriangleShapeFactory();

		circleFact.createShape().draw();
		rectFact.createShape().draw();
		triangleFact.createShape().draw();
	}

}
