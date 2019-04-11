package APP;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import DB.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodoak {
	
	public static double kontTotala = 0;
	DB.Kontsultak k = new DB.Kontsultak ();
	
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
				

				/*reserba.close();
				
			}catch(Exception e) {
				System.out.println("Mesua: " + e.getMessage());*/
			}
		}
		
		public static boolean nanKomprobaketa(String DNI)  {

			ArrayList<Erabiltzailea> datuErabiltzaile = new ArrayList <Erabiltzailea> ();
			datuErabiltzaile = Kontsultak.gordeErabiltzailea(); // array bueltatzen duen metodoa deitzen dut eta bere datuak datosClienten gordetzen ditut
			
			
			boolean konprobatu = false;
		
			for (Erabiltzailea c: datuErabiltzaile) { // for each array zeharkatzeko


				System.out.println("inicio"); // comprobar si entra en el metodo

			if (konprobatu==false) {

				
				if (c.getDni().equals(DNI)) { // komparatzen dut sartzen duten DNI datu basean dagoenarekin
					//System.out.println("Correcto");
					konprobatu=true;

				} else {
					//System.out.println("falso");
				}
			}
			}
			
			System.out.println("Fin del metodo");// comprobar el metodo
			return konprobatu;
		}
		
		
		public static boolean pasahitzaKomprobaketa(String pasahitza) {

			int i=0;
			ArrayList<Erabiltzailea> datuErabiltzaile = new ArrayList<Erabiltzailea>();
			datuErabiltzaile =Kontsultak.gordeErabiltzailea(); // array bueltatzen duen metodoa deitzen dut eta bere datuak
																// datosClienten gordetzen ditut
			boolean konprobatu = false;
			
			for (Erabiltzailea c : datuErabiltzaile) { // for each array zeharkatzeko

			if (konprobatu==false) {
				
				if (c.getContraseña().equals(pasahitza)) { // komparatzen dut sartzen duten DNI datu basean dagoenarekin
					System.out.println("Correcto");
					konprobatu=true;

				} else {
					System.out.println("falso");
				}
			}
			}
			
			System.out.println("Fin del metodo");// comprobar el metodo
			return konprobatu;
		}
		
		
		public static String getMD5(String input) {
			 try {
			 MessageDigest md = MessageDigest.getInstance("MD5");
			 byte[] messageDigest = md.digest(input.getBytes());
			 BigInteger number = new BigInteger(1, messageDigest);
			 String hashtext = number.toString(16);

			 while (hashtext.length() < 32) {
			 hashtext = "0" + hashtext;
			 }
			 
			 return hashtext;
			 }
			 catch (NoSuchAlgorithmException e) {
			 throw new RuntimeException(e);
			 }
			 }


		
		//ESCRIBIR LAS RESERVAS EN EL FITXERO
		
		
		public void fitxeroaIdatzi(String hotelIzena, double prezioFinala) {
			
			String Zerbitzua = k.zerbitzuakAtera(hotelIzena);
			FileWriter  reserba = null; 
			
			try {
				reserba = new FileWriter("..\\Ethazi4_APP\\src\\APP\\Reserba");	


		
					reserba.write("Zure reserba " +hotelIzena+ " hotelean egin da. " + " Bere prezioa "+ prezioFinala + "€-koa izan da. Bere zerbitzuak hauek dira "+Zerbitzua); //Fitxategian datuak gorde egiten ditu (Izena Hotela)
			
				

				reserba.close();
				
			}catch(Exception e) {
				System.out.println("Mesua: " + e.getMessage());
			}
		}
		//KALKULATU ZENBAT LOGELA GERATZEN DIREN
		
		/*LogelaKopurua pasar el dato del spinner */
		public int hotelLogelakKalkulatu(int logelakopurua, String hotelIzena) {
			
			 int hotelLogelaKopurua = (int)k.logelaKopuruaLortu(hotelIzena);
			int geratzenDirenHotelak = 0;
			
	geratzenDirenHotelak =  hotelLogelaKopurua - logelakopurua;
	
	System.out.println("geratzen diren logelak " + geratzenDirenHotelak);
	
	return geratzenDirenHotelak;
}
		
		public static ArrayList hiriakPantailaratu() {
			return Kontsultak.hiriakPantailaratu();
		}

		public static ArrayList hotelIzenaPantailaratu(String hiria) {
			return Kontsultak.hotelIzenaPantailaratu(hiria);
		}
		
		public static String hotelInformazioaPantailaratu(String hotelIzena) {
			return Kontsultak.hotelInformazioaPantailaratu(hotelIzena);
		}
		
		public static void sartuErabiltzailea(String DNI, String izena, String abizena, String jaiotze_data, String sexua, String pasahitza) {
			Kontsultak.sartuErabiltzailea(DNI, izena, abizena, jaiotze_data, sexua, pasahitza);
		}
		
<<<<<<< HEAD
=======
		//NAN-aren letra balidatzeko
>>>>>>> defb4b9a7e4078a6aece03c165dc09f7ad70b262
		public static boolean NANbalidatu(String NAN) {
			boolean ondo = false;
			String zenbakia;
			int zenbakia_;
			String letra;
			String letra_ = "TRWAGMYFPDXBNJZSQVHLCKET";
			
			zenbakia = NAN.substring(0, NAN.length()-1);
			zenbakia_ = Integer.parseInt(zenbakia);
			letra = Character.toString(NAN.charAt(NAN.length()-1));
			zenbakia_ = zenbakia_ % 23;
			letra_=letra_.substring(zenbakia_,zenbakia_+1);
			
			if(!letra_.equals(letra.toUpperCase())) {
				System.out.println("NAN txarto dago, letra: "+letra_);
			}else {
				ondo = true;
			}
			return ondo;
		}

}
