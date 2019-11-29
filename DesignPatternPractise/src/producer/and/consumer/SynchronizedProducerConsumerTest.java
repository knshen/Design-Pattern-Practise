package producer.and.consumer;

import java.util.LinkedList;

class WaitNotifyGood implements Good {
	private LinkedList<String> goods = new LinkedList<>();
	
	private static final int MAX = 2;
	
	public synchronized void putOne(String name) {
		String cur = Thread.currentThread().getName();
		try {
			while(goods.size() >= MAX) {
				System.out.println(cur + ": queue size is MAX...");
				wait();
				System.out.println(cur + ": is notified, try to put again...");
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		goods.addLast(name);
		System.out.println(cur + ": add the good " + name + "to queue...");

		notify(); // notify consumer threads
	}
	
	public synchronized void takeOne() {
		String cur = Thread.currentThread().getName();
		
		try {
			while(goods.size() <= 0) {
				System.out.println(cur + ": queue size is ZERO...");
				wait();
				System.out.println(cur + ": is notified, try to take again...");
			}
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		String consumed = goods.removeFirst();
		System.out.println(cur + ": take the good " + consumed + "...");
		notify();
	}
}





/**
 * 生产者消费者模式中的三个实体：
 * 1. 物品：是一个阻塞队列
 * 2. 生产者：负责向阻塞队列添加，是一个Runnable对象
 * 3. 消费者：负责向阻塞队列消费，是一个Runnable对象
 * @author shen_k
 *
 */
public class SynchronizedProducerConsumerTest {

	public static void main(String[] args) {
		Good good = new WaitNotifyGood();
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
