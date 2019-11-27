package adapter;

public class Adapter implements ITarget {
	private IAdaptee adaptee;
	
	public Adapter(IAdaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public void targetAction() {
		System.out.println("try to adapter Adaptee...");
		adaptee.action();
		
	}

}
