package producer.and.consumer;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

class SemaphoreGood implements Good {
	private LinkedList<String> goods = new LinkedList<>();
	
	private static final int MAX = 2;
	
	private Semaphore mutex = new Semaphore(1);
	
	private Semaphore produce = new Semaphore(MAX);
	
	private Semaphore consume = new Semaphore(0);
	
	@Override
	public void putOne(String name) {
		String cur = Thread.currentThread().getName();
		try {
			produce.acquire();
			mutex.acquire();
			goods.addLast(name);
			System.out.println(cur + ": add the good " + name + "to queue...");
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			mutex.release();
			consume.release();
		}
		
	}

	@Override
	public void takeOne() {
		String cur = Thread.currentThread().getName();
		try {
			consume.acquire();
			mutex.acquire();
			String consumed = goods.removeFirst();
			System.out.println(cur + ": take the good " + consumed + "...");
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			mutex.release();
			produce.release();
		}
		
	}
	
}

public class SemaphoreProducerConsumerTest {
	
	public static void main(String[] args) {
		Good good = new SemaphoreGood();
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
