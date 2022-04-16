package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculadoraImcCliente {

	public static void main(String[] args) {
		
		Socket socket;
		InputStream canalEntrada;
		OutputStream canalSaida;
		BufferedReader entrada;
		PrintWriter saida;
		
		try {
			socket = new Socket("10.10.11.5", 4000); //local: 127.0.0.1
			
			canalEntrada = socket.getInputStream();
			canalSaida = socket.getOutputStream();
			
			entrada = new BufferedReader(new InputStreamReader(canalEntrada));
			saida = new PrintWriter(canalSaida, true);
			
			Scanner teclado = new Scanner(System.in);
			
			System.out.println("Informe o seu peso em KG:");
			String peso = teclado.nextLine();
			
			System.out.println("Informe a sua altura em metros:");
			String altura = teclado.nextLine();
			
			teclado.close();
			
			saida.println(peso + " " + altura);
			
			String resultado = entrada.readLine();
			System.out.println(resultado);
			
			socket.close();
			
		}	catch (IOException ioe) {
				ioe.printStackTrace();				
			
		}

	}

}
