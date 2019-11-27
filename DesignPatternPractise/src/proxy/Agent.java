package proxy;

public class Agent implements IActor {
	private IActor realActor = null;
	
	
	@Override
	public void movie() {
		System.out.println("actor agent is preparing...");
		if(realActor == null) {
			realActor = new Star();
			realActor.movie();
		}

	}

}
