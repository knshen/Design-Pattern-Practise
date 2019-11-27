package decorator;

public class EggPancakeDecorator extends AbstractPancakeDecorator {

	public EggPancakeDecorator(IPancake cake) {
		super(cake);
	}
	
	 public void cook() {
		 System.out.println("add an egg...");
		 super.cook();
	 }

}
