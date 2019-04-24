package APP;

import DB.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] proba = null;
		 
		Metodoak m = new Metodoak();

System.out.println("sdsdsdsd");
		String basedatos = "ethazi4";
		Konexioa con1 = new Konexioa(basedatos);
		con1.getConexion();

System.out.println();

		VISTA.OngiEtorri ejecutar = new VISTA.OngiEtorri();
		ejecutar.setVisible(true);


	}

}
