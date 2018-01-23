package printing_odd_even;

public class Printer {
	private boolean isOdd = false;
	
	public synchronized void printEven(int number) {
		while(!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Even : " + number);
		isOdd = false;
		notifyAll();
		
	}
	
	public synchronized void printOdd(int number) {
		while(isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Odd : " + number);
		isOdd = true;
		notifyAll();
		
	}

}
