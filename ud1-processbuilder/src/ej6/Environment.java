package ej6;

public class Environment {

	public static void main(String[] args) {
		//Define una variable de entorno (p. ej. MI_VAR=UD1) y verifica su valor con printenv.
		//ProcessBuilder pb = new ProcessBuilder("bash","-lc","printenv MI_VAR"); 
		//pb.environment().put("MI_VAR","UD1");
		
		try {
			
			ProcessBuilder pb = new ProcessBuilder("printenv", "MI_VAR").inheritIO();
			pb.environment().put("MI_VAR", "UD1");
			Process proceso = pb.start();
			
			proceso.waitFor();
			
		} catch (Exception ex) {
			System.err.print(ex);
		}

	}

}
