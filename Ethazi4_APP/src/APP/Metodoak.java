package APP;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodoak {
	
	public static double kontTotala = 0;
	
	public static String[] diruarenBueltak(String emaitza, String ordainketa) {// emaitza balioa main-etik hartu
		double DoubleTextDiruTot = Double.parseDouble(emaitza);
		DoubleTextDiruTot = DoubleTextDiruTot*100;
		DoubleTextDiruTot = Math.round(DoubleTextDiruTot);
		
		double DoubleTextOrdainketa = Double.parseDouble(ordainketa);
		DoubleTextOrdainketa = DoubleTextOrdainketa*100;
		DoubleTextOrdainketa = Math.round(DoubleTextOrdainketa);
		

		double[] array = new double[14];
		// Dena zentimoetan jarri
		array[0] = 1;
		array[1] = 2;
		array[2] = 5;
		array[3] = 10;
		array[4] = 20;
		array[5] = 50;
		array[6] = 100;
		array[7] = 200;
		array[8] = 500;
		array[9] = 1000;
		array[10] = 2000;
		array[11] = 5000;
		array[12] = 10000;
		array[13] = 20000;
		double bueltak;
		String[] arrayBueltak = new String[10];
		double buelta;
		String bueltaString;
		int j = 0;
		

		// double ordainketa;

		// System.out.println("Sartu dirua: ");
		// ordainketa = sc.nextDouble();

		do {
			if (DoubleTextOrdainketa < 0) {
				System.out.println("Sartu zenbaki positibo bat:");

			}
		} while (DoubleTextOrdainketa < 0);

		bueltak = DoubleTextOrdainketa - DoubleTextDiruTot;
		bueltak = bueltak/100;

		// Begiratu ea diru nahiko sartu duen edo bueltak eman behar diogun

		if (bueltak < 0) {
			arrayBueltak[0] = "";
			/*
			 * do { bueltak=-bueltak;
			 * System.out.println("Falta zaizkizu: "+bueltak+" euro");
			 * System.out.println("Sartu falta den dirua:"); emaitza=bueltak;
			 * 
			 * do { if (ordainketa<0) { System.out.println("Sartu zenbaki positibo bat:");
			 * 
			 * } }while (ordainketa<0); bueltak=ordainketa-emaitza; }while (bueltak!=0 &&
			 * bueltak < 0);//errepikatu 0 baino handiagoa edo berdina den zenbaki bat sartu
			 * harte
			 */
		}
		// galdetu bueltak dauden ala ez
		if (bueltak == 0) {
			System.out.println("Ez daude bueltak");
			arrayBueltak[0] = "0";
		} else
			System.out.println("Bueltak:");
		// Bueltak eman

		if (bueltak > 0) {
			bueltak = bueltak * 100;// bueltak zentimoetan jarri
			do {
				// begiratu noiz bueltak handiagoak diren, horrela bueltei zenbaki hurbilena
				// pantailaratuko du
				for (int i = 13; i >= 0; i--) {

					if (bueltak >= array[i]) {
						bueltak = bueltak - array[i];// bueltei kendu pantailaratuko den balioa
						buelta = array[i] / 100;
						bueltaString = Double.toString(buelta);
						arrayBueltak[j] = bueltaString;
						System.out.println(arrayBueltak[j]);
						j++;
						break;
					}
				}
				if (bueltak<1)
					bueltak=0;
			} while (bueltak != 0);// errepikatu prozesu hau bueltak 0 izan harte

		}
		

		return arrayBueltak;// main-era bidali buelten zerrenda
	}/* metodo bueltak */
	
	public static String kenketa(String diruTot, String ordainketa) {

		double doubleDiruTot = Double.parseDouble(diruTot);
		doubleDiruTot = doubleDiruTot*100;
		doubleDiruTot = Math.round(doubleDiruTot);
		
		double doubleOrdainketa = Double.parseDouble(ordainketa);
		doubleOrdainketa = doubleOrdainketa*100;
		doubleOrdainketa = Math.round(doubleOrdainketa);
		
		double emaitza = doubleDiruTot - doubleOrdainketa;
		emaitza = emaitza/100;
		String stringEmaitza = Double.toString(emaitza);
		return stringEmaitza;
	}
	
	
	//METODO DE LECTURA DEL FICHERO  LEER LAS RESERVAS

		public void FitxeroaIrakurri() {
			File Reserba = new File("..\\Ethazi4_APP\\src\\APP\\Reserba");

			Scanner s = null;

			try {
				// Leemos el contenido del fichero
				//System.out.println("... Leemos el contenido del fichero ...");
				s = new Scanner(Reserba);
				
				// Leemos linea a linea el fichero
							while (s.hasNextLine()) {
								String linea = s.nextLine(); 	// Guardamos la linea en un String
								System.out.println(linea);      // Imprimimos la linea
							}
				
			}catch(Exception e) {
				System.out.println("Mezua: " + e.getMessage());
				
			}
			
		}
		
		//ESCRIVIR LAS RESERVAS EN EL FITXERO
		
		
		public void fitxeroaIdatzi(String hotelIzena, double prezioFinala) {
			
			
			FileWriter  reserba = null; 
			
			try {
				reserba = new FileWriter("..\\Ethazi4_APP\\src\\APP\\Reserba");
			
			

					reserba.write("Zure reserba " +hotelIzena+ " hotelean egin da. " + prezioFinala);
			
				
				

				reserba.close();
				
			}catch(Exception e) {
				System.out.println("Mesua: " + e.getMessage());
			}
		}
		
		
		

}
