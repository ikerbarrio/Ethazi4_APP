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

		

		VISTA.OngiEtorri ejecutar = new VISTA.OngiEtorri();
		ejecutar.setVisible(true);


	}

}
