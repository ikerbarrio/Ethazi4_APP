package APP;

import DB.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] proba = null;
		
		Metodoak m = new Metodoak();



		String basedatos = "ethazi4";
		Konexioa con1 = new Konexioa(basedatos);
		con1.getConexion();
<<<<<<< HEAD

		
=======
		
		System.out.println("penepene");
>>>>>>> be30c95cae6fed8b00e4e2d0c5e367b74dae704a

		VISTA.OngiEtorri ejecutar = new VISTA.OngiEtorri();
		ejecutar.setVisible(true);


	}

}
