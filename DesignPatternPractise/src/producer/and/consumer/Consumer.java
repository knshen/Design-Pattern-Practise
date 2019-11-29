package producer.and.consumer;

public class Consumer implements Runnable {
	private Good good;
	
	public Consumer(Good good) {
		this.good = good;
	}

	@Override
	public void run() {
		good.takeOne();
	}
}
