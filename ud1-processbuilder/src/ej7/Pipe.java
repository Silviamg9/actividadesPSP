package ej7;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class Pipe {

	public static void main(String[] args) {
		//Crea dos procesos y conecta la salida del primero con la entrada del segundo desde Java.
		//Lanza p1 = new ProcessBuilder("bash","-lc","echo 'hola mundo'").start() y p2 = new ProcessBuilder("bash","-lc","wc -w").start().
		//Pasa bytes de p1.getInputStream() a p2.getOutputStream() con un buffer y cierra out de p2.
		
		try {
			
			File tmp = File.createTempFile("pipe", ".txt");
			
			Process pb1 = new ProcessBuilder("bash", "-lc", "echo", "hola mundo").redirectOutput(tmp).start();
			int codigoP1 = pb1.waitFor();
			
			Process pb2 = new ProcessBuilder("bash", "-lc", "wc", "-w").redirectInput(tmp).start();
			String salida = new String(pb2.getInputStream().readAllBytes(), "UTF-8");
			int codigoP2 = pb2.waitFor();

			System.out.println(salida);
			
		} catch (Exception ex) {
			System.err.print(ex);
		}

	}

}
