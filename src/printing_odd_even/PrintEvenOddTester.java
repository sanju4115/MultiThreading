package printing_odd_even;

public class PrintEvenOddTester {

	public static void main(String[] args) {
		Printer print = new Printer();
        Thread t1 = new Thread(new Print(false,print,10));
        Thread t2 = new Thread(new Print(true,print, 10));
        t1.start();
        t2.start();
	}

}
