import java.io.IOException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) 
			throws IOException {
		Scanner s = new Scanner(System.in);
		
		System.out.print("IP do servidor: ");
		String ip = s.next();
		System.out.print("Seu nome: ");
		String nome = s.next();
		
		new Cliente(nome,ip,1234).executa();
		
		/*
		System.out.print("Numero da porta: ");
		int porta = Integer.parseInt(s.next());
		new Servidor(porta).executa();
		*/
		s.close();
	}
}
