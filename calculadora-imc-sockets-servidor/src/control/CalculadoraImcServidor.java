package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraImcServidor {
	
	private ServerSocket sckServidor;
	
	public CalculadoraImcServidor() throws IOException {
		this.sckServidor = new ServerSocket(4000);
		
		for(;;) {
			Socket sck;
			InputStream cEntrada;
			OutputStream cSaida;
			BufferedReader entrada;
			PrintWriter saida;
			
			sck = this.sckServidor.accept();
			
			CalcLogica retorno = new CalcLogica();
			
			cEntrada = sck.getInputStream();
			cSaida = sck.getOutputStream();
			entrada = new BufferedReader(new InputStreamReader(cEntrada));
			saida = new PrintWriter(cSaida, true);
			
			while (true) {
				
				String ped = entrada.readLine();
				
				if (ped == null || ped.length() == 0) break;
				
				String mensagemCli = ped;
				
				try {
					String retornoStatus = retorno.separa_val(mensagemCli);
					saida.println("Resultado: "+ retornoStatus);
				}
				catch(Exception e) {
					saida.println("Algo deu errado!");
				}
				
			}
			sck.close();
		}
	}
}
