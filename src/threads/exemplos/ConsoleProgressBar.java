package threads.exemplos;

public class ConsoleProgressBar {
	
	static int complete = 0;
	static boolean finished = false;
	
	static Thread t1 = new Thread() {
			public void run() {
			    while(!finished) {
					if (complete > 100) {
				        throw new IllegalArgumentException();
				    }
				    int maxBareSize = 20; // 5 units for 100%
				    int remainProcent = ((400 * complete) / 100) / maxBareSize;
				    char defaultChar = '-';
				    String icon = "*";
				    String bare = new String(new char[maxBareSize]).replace('\0', defaultChar) + "]";
				    StringBuilder bareDone = new StringBuilder();
				    bareDone.append("[");
				    for (int i = 0; i < remainProcent; i++) {
				        bareDone.append(icon);
				    }
				    String bareRemain = bare.substring(remainProcent, bare.length());
				    System.out.print("\r" + bareDone + bareRemain + " " + remainProcent * 5 + "% ");
				    if (complete == 100) {
				        System.out.print("\n");
				    }
			    }
			}
		};
	
	static Thread t2 = new Thread() {
			public void run() {
				while (ConsoleProgressBar.complete < 100) {
					ConsoleProgressBar.complete += 5;
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				finished = true;
			}
		};
		
	
	public static void main(String args[]) throws InterruptedException {
		ConsoleProgressBar cpbar = new ConsoleProgressBar();
		ConsoleProgressBar.complete = 0;
		
		t1.start();
		t2.start();
		
		//cpbar.task();
		//cpbar.progressPercentage(100);
			
	}
}
