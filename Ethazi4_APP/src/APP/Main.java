package APP;

import DB.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metodoak m = new Metodoak();
		m.FitxeroaIrakurri();
		System.out.println("bb");

		String basedatos = "ethazi4";
		Konexioa con1 = new Konexioa(basedatos);
		con1.getConexion();
		
		System.out.println();
		Kontsultak.hotelInformazioaPantailaratu("aeiou");

//		VISTA.Lehioa1 ejecutar = new VISTA.Lehioa1();
//		ejecutar.setVisible(true);


//		String basedatos = "ethazi4";
//		Konexioa con1 = new Konexioa(basedatos);
//		con1.getConexion();
//		
//		System.out.println();
//		Kontsultak.hotelPantailaratu();

		VISTA.Lehioa1 ejecutar = new VISTA.Lehioa1();
		ejecutar.setVisible(true);

		
	}

}
