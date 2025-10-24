package ej4;

public class InheritIO {

	public static void main(String[] args) {
		//Ejecuta top -b -n1 heredando la salida directamente a tu terminal.
		//new ProcessBuilder("bash","-lc","top -b -n1").inheritIO().start().waitFor();
		
		try {
			
			Process proceso = new ProcessBuilder("top", "-b", "-n1").inheritIO().start();
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
