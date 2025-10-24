package ej2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class lsSalida {

	public static void main(String[] args) {
		
		//Ejecuta ls -l, lee stdout del proceso y muéstralo por consola Java.
		
		//Process p = new ProcessBuilder("bash","-lc","ls -l").start();
		//Lee p.getInputStream() con BufferedReader
		
		try {
			
			Process proceso = new ProcessBuilder("ls", "-l").start();
            
			proceso.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			
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
