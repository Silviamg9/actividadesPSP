package ej5;

import java.io.File;

public class Directory {

	public static void main(String[] args) {
		//Ejecuta pwd desde un directorio distinto al actual (por ejemplo, /tmp).
		//new ProcessBuilder("bash","-lc","pwd").directory(new File("/tmp")).start();
		
		try {
			
			Process proceso = new ProcessBuilder("pwd").directory(new File("/tmp")).start();
			int codigo = proceso.waitFor();

			if (codigo == 0) {
				System.out.println("Todo correcto");
			} else {
				System.out.println("Error");
			}

		} catch (Exception ex) {
			System.err.print(ex);
		}

	}

}
