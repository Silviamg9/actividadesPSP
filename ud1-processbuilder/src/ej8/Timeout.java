package ej8;

import java.util.concurrent.TimeUnit;

public class Timeout {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Ejecuta sleep 10 y finalízalo si tarda más de 2 segundos.
		// Usa p.waitFor(2, TimeUnit.SECONDS); si devuelve false, llama a p.destroy() o destroyForcibly().
		
		try {
			
			Process pb = new ProcessBuilder("sleep", "10").start();
			boolean fin = pb.waitFor(2, TimeUnit.SECONDS);
			
			if (!fin) {
				pb.destroyForcibly();
				System.out.println("Proceso terminado por timeout");
            } else {
                System.out.println("Proceso finalizado correctamente");
			}
			
		} catch (Exception ex) {
			System.err.print(ex);
		}
	}

}
