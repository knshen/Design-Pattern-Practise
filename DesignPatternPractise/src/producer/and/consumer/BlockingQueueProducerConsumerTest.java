package producer.and.consumer;

import java.util.concurrent.ArrayBlockingQueue;

class BlockingQueueGood implements Good {
	private ArrayBlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
	
	@Override
	public void putOne(String name) {
		String th = Thread.currentThread().getName();
		try {
			bq.put(name);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println(th + ": put the good " + name);
	}

	@Override
	public void takeOne() {
		String th = Thread.currentThread().getName();
		try {
			String name = bq.take();
			System.out.println(th + ": take the good " + name);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}

public class BlockingQueueProducerConsumerTest {

	public static void main(String[] args) {
		Good good = new BlockingQueueGood();
		Thread c1 = new Thread(new Consumer(good));
		Thread c2 = new Thread(new Consumer(good));
		Thread p1 = new Thread(new Producer(good));
		Thread p2 = new Thread(new Producer(good));
		Thread p3 = new Thread(new Producer(good));
		c1.setName("Consumer1");
		c2.setName("Consumer2");
		
		p1.setName("Producer1");
		p2.setName("Producer2");
		p3.setName("Producer3");
		
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();

	}

}
