package producer.and.consumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LockGood implements Good {
	private LinkedList<String> goods = new LinkedList<>();
	
	private static final int MAX = 2;
	
	private Lock lock = new ReentrantLock();
	private Condition full = lock.newCondition(); 
	private Condition empty = lock.newCondition();
	
	@Override
	public void putOne(String name) {
		String th = Thread.currentThread().getName();
		try {
			lock.lock();
			while(goods.size() >= MAX) {
				System.out.println(th + ": queue size is MAX...");
				full.await();
				System.out.println(th + ": is notified, try to put again...");
			}
			
			goods.addLast(name);
			System.out.println(th + ": produce a good " + name);
			empty.signal();
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	@Override
	public void takeOne() {
		String th = Thread.currentThread().getName();
		try {
			lock.lock();
			while(goods.size() == 0) {
				System.out.println(th + ": queue size is ZERO...");
				empty.await();
				System.out.println(th + ": is notified, try to take again...");
			}
			
			String consumed = goods.removeFirst();
			System.out.println(th + ": take the good " + consumed + "...");
			full.signal();
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
}

public class LockProducerConsumerTest {

	public static void main(String[] args) {
		Good good = new LockGood();
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
