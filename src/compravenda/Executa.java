package compravenda;

public class Executa {

	public static void main(String args[]) {
		Loja novaloja = new Loja();
		Thread c1 = new Cliente(novaloja, 1);
		Thread c2 = new Cliente(novaloja, 2);
		Thread f1 = new Fabrica(novaloja, 1);
		Thread f2 = new Fabrica(novaloja, 2);
		//for (int i=0; i<10; i++) {
			c1.start();
			c2.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f1.start();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f2.start();
		//}
	}
}
