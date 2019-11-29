package producer.and.consumer;

public class Producer implements Runnable {
	private Good good;
	
	public Producer(Good good) {
		this.good = good;
	}
	
	@Override
	public void run() {
		good.putOne("knshen[" + System.currentTimeMillis() + "]");
	}
	
}
