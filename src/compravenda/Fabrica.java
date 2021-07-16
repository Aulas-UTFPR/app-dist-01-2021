package compravenda;

public class Fabrica extends Thread {
	
	Loja loja;
	int numero;
	
	Fabrica(Loja l, int n) {
		loja = l;
		numero = n;
	}
	
	public void run() {
		loja.put(numero);
	}

}
