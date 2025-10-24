package ej3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lsError {

	public static void main(String[] args) {
		
		//Lanza ls /ruta/que/no/existe y muestra el mensaje de error de stderr.
		//Usa p.getErrorStream(). No mezcles con redirectErrorStream(true) para verlos por separado.
		
		try {

			Process proceso = new ProcessBuilder("ls", "/ruta/que/no/existe").start();

			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getErrorStream()));

			String linea;
			while ((linea = br.readLine()) != null) {
				System.out.println(linea);
			}

			int codigo = proceso.waitFor();
			if (codigo == 0) {
				System.out.println("Todo correcto");
			} else {
				System.out.println("Error");
			}
			br.close();

		} catch (Exception ex) {
			System.err.print(ex);
		}

	}

}
