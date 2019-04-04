package APP;

import DB.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Metodoak m = new Metodoak();

		m.fitxeroaIdatzi();
		m.FitxeroaIrakurri();



		


		m.FitxeroaIrakurri();
		

		String basedatos = "ethazi4";
		Konexioa con1 = new Konexioa(basedatos);
		con1.getConexion();
		
		System.out.println();
		Kontsultak.hotelInformazioaPantailaratu("aeiou");

//		VISTA.Lehioa1 ejecutar = new VISTA.Lehioa1();
//		ejecutar.setVisible(true);



		
	}

}
