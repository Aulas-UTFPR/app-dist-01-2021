package compravenda;

public class Loja {
	
	int produtos = 0;
	
	public synchronized void get(int cliente) { // Vender ou tirar do estoque
		if (produtos<=0) {
			System.out.println("Cliente "+cliente+" entrou na fila...");
			while(produtos<=0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("1 produto vendido dos "+produtos+" em estoque para o cliente "+cliente+"!");
		produtos--;
	}
	
	public synchronized void put(int fabrica) { // Comprar ou inserir no estoque
		produtos++;
		System.out.println("1 produto comprado da fabrica "+fabrica+", totalizando "+produtos+" em estoque!");
		notifyAll();
	}
}
