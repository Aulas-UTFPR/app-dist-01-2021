package threadsaulasinc;

public class ExemploThreads {
	
	static void mostraA() {
		
	}
	
	static void mostraB() {
		
	}
	
	public static void main(String args[]) throws InterruptedException {
		Thread ta = new Thread() {
			public void run() {
				//for (int i=0; i<10; i++) {
				while(true) {
					System.out.println("AAAAAA");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		Thread tb = new Thread() {
			public void run() {
				//for (int i=0; i<15; i++) {
				while(true) {
					System.out.println("BBBBBB");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		ta.start();
		tb.start();
	}

}
