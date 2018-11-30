import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class MensagensCliente implements Runnable {

	private Socket cliente;
	private Servidor servidor;

	public MensagensCliente(Socket cliente, Servidor servidor) {
		this.cliente = cliente;
		this.servidor = servidor;
	}

	public void run() {
		try(Scanner s = new Scanner(this.cliente.getInputStream())) {
			while (s.hasNextLine()) {
				servidor.distribuiMensagem(this.cliente, s.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}