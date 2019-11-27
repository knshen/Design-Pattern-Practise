package proxy;

public class Star implements IActor {
	
	public Star() {
		System.out.println("initialize star...");
	}
	
	@Override
	public void movie() {
		System.out.println("play a movie...");

	}

}
