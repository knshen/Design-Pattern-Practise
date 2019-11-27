package decorator;

public abstract class AbstractPancakeDecorator implements IPancake {
	private IPancake cake = null;
		
	public AbstractPancakeDecorator(IPancake cake) {
		this.cake = cake;
	}
	
	public void cook() {
		if(cake != null) {
			cake.cook();
		}
	}
}
