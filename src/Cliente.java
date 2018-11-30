import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	private String host;
	private String nome;
	private int porta;
	private String string = null;

	public Cliente(String nome, String host, int porta) {
		this.host = host;
		this.porta = porta;
		this.nome = nome;
	}
	public String getNome() {
		return this.nome;
	}

	public void executa() throws UnknownHostException, IOException {
		
		Socket cliente = new Socket(this.host, this.porta);
			PrintStream saida = new PrintStream(cliente.getOutputStream());
			
			System.out.println("O cliente se conectou ao servidor!");
			Scanner teclado = new Scanner(System.in); 
	
			ServidorMensagens s = new ServidorMensagens(cliente.getInputStream());
			if(teclado.hasNext()) { string = teclado.next();}
			new Thread(s).start();
			//System.out.println(teclado.hasNext());
			if(string!=null) {
				while (!string.equals("sair")) {
					string = this.nome+" diz: "+teclado.next();
					saida.println(string);
				}
			}
			teclado.close();
		
	}
}