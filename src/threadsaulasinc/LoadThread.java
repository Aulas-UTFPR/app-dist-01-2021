package threadsaulasinc;

public class LoadThread {

	static void calc(int milliseconds) {
		while(true) {
			long sleepTime = milliseconds*1000000L; // convert to nanoseconds
		    long startTime = System.nanoTime();
		    while ((System.nanoTime() - startTime) < sleepTime) {}
		}
	}
	
	public static void main(String args[]) {
		Thread ta = new Thread() {
			public void run() {
				calc(5000);
			}
		};
		
		Thread tb = new Thread() {
			public void run() {
				calc(5000);
			}
		};
		
		Thread tc = new Thread() {
			public void run() {
				calc(5000);
			}
		};
		
		Thread td = new Thread() {
			public void run() {
				calc(5000);
			}
		};
		
		ta.start();
		// tb.start();
		// tc.start();
		// td.start();
	}
	
}
