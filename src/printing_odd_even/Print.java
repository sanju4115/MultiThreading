package printing_odd_even;

public class Print implements Runnable {
	
	private boolean isEven;
	private Printer printer;
	private int range;
	
	public Print(boolean isEven, Printer printer, int range) {
		super();
		this.isEven = isEven;
		this.printer = printer;
		this.range = range;
	}

	@Override
	public void run() {
		int count = isEven ? 2 : 1 ;
		
		while(count<=range) {
			if(isEven) {
				printer.printEven(count);
			}else {
				printer.printOdd(count);
			}
			count = count+2;
		}
	}

}
