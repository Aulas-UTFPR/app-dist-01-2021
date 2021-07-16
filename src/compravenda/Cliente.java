package compravenda;

public class Cliente extends Thread{
	
	Loja loja;
	int numero;
	
	Cliente(Loja l, int n) {
		loja = l;
		numero = n;
	}
	
	public void run() {
		loja.get(numero);
	}

}
