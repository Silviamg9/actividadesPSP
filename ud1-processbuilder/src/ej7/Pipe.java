package ej7;

import java.io.InputStream;
import java.io.OutputStream;

public class Pipe {

	public static void main(String[] args) {
		//Crea dos procesos y conecta la salida del primero con la entrada del segundo desde Java.
		//Lanza p1 = new ProcessBuilder("bash","-lc","echo 'hola mundo'").start() y p2 = new ProcessBuilder("bash","-lc","wc -w").start().
		//Pasa bytes de p1.getInputStream() a p2.getOutputStream() con un buffer y cierra out de p2.
		
		try {
			Process p1 = new ProcessBuilder("echo", "hola mundo").start();
			Process p2 = new ProcessBuilder("wc", "-w").start();

			InputStream p1Salida = p1.getInputStream();
			OutputStream p2Entrada = p2.getOutputStream();
			
			p1Salida.transferTo(p2Entrada);
			p2Entrada.close();
			
			int codigo1 = p1.waitFor();
			int codigo2 = p2.waitFor();
			if (codigo1 == 0 && codigo2 == 0) {
				System.out.println("Todo correcto");
			} else {
				System.out.println("Error");
			}

		} catch (Exception ex) {
			System.err.print(ex);
		}

	}

}
