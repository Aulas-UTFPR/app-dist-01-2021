package sockets;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Server {
	
	public static void main(String args[]) {
		try {
			ServerSocket servidor = new ServerSocket(8000);
			System.out.println("Servidor na porta 8000...");
			while(true) {
		        Socket cliente = servidor.accept(); // Espera por uma conexao.
		        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
		        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
		        saida.flush();
		        saida.writeObject(new Date());
		        saida.close();
		        cliente.close();
		      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
