package factory;

/**
 * 抽象工厂模式
 * 定义：在某个工厂类中可以创建多个不同类型的对象；不符合开闭原则
 * @author shen_k
 *
 */

interface CompositeFactory {
	Shape createShape();
	Color createColor();
}

class RedCircleFactoryImpl implements CompositeFactory {

	@Override
	public Shape createShape() {
		return new CircleShape();
	}

	@Override
	public Color createColor() {
		return new Red();
	}
	
}

class BlueRectFactoryImpl implements CompositeFactory {

	@Override
	public Shape createShape() {
		return new RectShape();
	}

	@Override
	public Color createColor() {
		return new Blue();
	}
	
}

class BlueTriangleImpl implements CompositeFactory {

	@Override
	public Shape createShape() {
		return new TriangleShape();
	}

	@Override
	public Color createColor() {
		return new Blue();
	}
	
}

public class AbstractFactoryTest {

	public static void main(String[] args) {
		CompositeFactory redCFact = new RedCircleFactoryImpl();
		CompositeFactory blueRFact = new BlueRectFactoryImpl();
		CompositeFactory blueTFact = new BlueTriangleImpl();
		
		redCFact.createShape().draw();
		redCFact.createColor().taint();
		
		blueRFact.createShape().draw();
		blueRFact.createColor().taint();
		
		blueTFact.createShape().draw();
		blueTFact.createColor().taint();
	}

}
