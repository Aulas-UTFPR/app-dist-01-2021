package sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

public class Cliente {
	
	public static void main(String args[]) {
		try {
			Socket servidor = new Socket("127.0.0.1", 8000);
		    ObjectInputStream entrada = new ObjectInputStream(servidor.getInputStream());
		    Date data_atual;
			try {
				data_atual = (Date)entrada.readObject();
			    JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    entrada.close();
		    System.out.println("Conexão encerrada");
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
