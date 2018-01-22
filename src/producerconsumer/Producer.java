package producerconsumer;

import java.util.Queue;
import java.util.Random;

public class Producer implements Runnable {
	
	private Queue<Integer> sharedQueue;

	public Producer(Queue<Integer> sharedQueue) {
		super();
		this.sharedQueue = sharedQueue;
	}



	@Override
	public void run() {
		while(true) {
			synchronized (sharedQueue) {
				while(sharedQueue.size()==5) {
					try {
						sharedQueue.wait();
						System.out.println("Producer is waiting...");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				Random random = new Random();
				int data = random.nextInt(5);
				sharedQueue.add(data);
				System.out.println("Produced : "+data);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sharedQueue.notifyAll();
			}
		}
	}

}
