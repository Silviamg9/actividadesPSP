package ej1;

public class Echo {

	public static void main(String[] args){
		
		//Crea un programa que ejecute echo con un mensaje y verifica que el proceso termina con código 0.
		//Usa new ProcessBuilder("bash","-lc","echo 'Hola UD1'"), start() y waitFor().
		
		
		try {
			
			ProcessBuilder pb = new ProcessBuilder("echo", "Hola, mundo");
			Process proceso = pb.start();
			int codigo = proceso.waitFor();

			if (codigo == 0) {
				System.out.println("Todo correcto");
			}

		} catch (Exception ex) {
			System.err.print(ex);
		}
	}

}
