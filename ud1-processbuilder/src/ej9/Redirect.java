package ej9;

import java.io.File;


public class Redirect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProcessBuilder pb = new ProcessBuilder("cat", "etc/passwd");
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("error.txt"));
		
		try {
			Process p = pb.start();
			p.waitFor();
			System.out.println("Finalizado");
					
		} catch (Exception ex) {
			System.err.print(ex);
		}
		

	}

}
