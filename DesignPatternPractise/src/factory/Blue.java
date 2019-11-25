package factory;

public class Blue implements Color {

	@Override
	public void taint() {
		System.out.println("print blue...");
	}

}
