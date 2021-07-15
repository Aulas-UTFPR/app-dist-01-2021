package threads.exemplos;

public class ConsoleProgressBarThread {
	
	static int complete = 0;
	static boolean finished = false;
	
	public static void progressPercentage(int total) {
		Thread t1 = new Thread() {
			public void run() {
			    while(!finished) {
					if (complete > total) {
				        throw new IllegalArgumentException();
				    }
				    int maxBareSize = 20; // 5 units for 100%
				    int remainProcent = ((400 * complete) / total) / maxBareSize;
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
				    if (complete == total) {
				        System.out.print("\n");
				    }
			    }
			}
		};
		t1.start();
	}
	
	public void task() { // Simulação de uma tarefa que leva um certo tempo para executar.
		Thread t2 = new Thread() {
			public void run() {
				while (ConsoleProgressBarThread.complete < 100) {
					ConsoleProgressBarThread.complete += 5;
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
		t2.start();
	}
	
	
	public static void main(String args[]) throws InterruptedException {
		ConsoleProgressBarThread cpbar = new ConsoleProgressBarThread();
		ConsoleProgressBarThread.complete = 0;
		
		cpbar.task();
		cpbar.progressPercentage(100);
			
	}
}
