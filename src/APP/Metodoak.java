
package APP;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import DB.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Metodoak {

	public static double kontTotala = 0;
	DB.Kontsultak k = new DB.Kontsultak();

	/*
	 * @author grupo1
	 * @deprecated  diruaren buieltak kalkulatu
	 * @return zenbat buelta diren
	 */
	public static String[] diruarenBueltak(String emaitza, String ordainketa) {// emaitza balioa main-etik hartu
		double DoubleTextDiruTot = Double.parseDouble(emaitza);
		DoubleTextDiruTot = DoubleTextDiruTot * 100;
		DoubleTextDiruTot = Math.round(DoubleTextDiruTot);

		double DoubleTextOrdainketa = Double.parseDouble(ordainketa);
		DoubleTextOrdainketa = DoubleTextOrdainketa * 100;
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
		bueltak = bueltak / 100;

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
				if (bueltak < 1)
					bueltak = 0;
			} while (bueltak != 0);// errepikatu prozesu hau bueltak 0 izan harte

		}

		return arrayBueltak;// main-era bidali buelten zerrenda
	}/* metodo bueltak */

	
	/*
	 * @author grupo1
	 * @deprecated  diruaren kenketa
	 * @return emaitza
	 */
	public static String kenketa(String diruTot, String ordainketa) {

		double doubleDiruTot = Double.parseDouble(diruTot);
		doubleDiruTot = doubleDiruTot * 100;
		doubleDiruTot = Math.round(doubleDiruTot);

		double doubleOrdainketa = Double.parseDouble(ordainketa);
		doubleOrdainketa = doubleOrdainketa * 100;
		doubleOrdainketa = Math.round(doubleOrdainketa);

		double emaitza = doubleDiruTot - doubleOrdainketa;
		emaitza = emaitza / 100;
		String stringEmaitza = Double.toString(emaitza);
		return stringEmaitza;
	}

	/*
	 * @author grupo1
	 * @deprecated  fitxeroaren datuak irakurtzen diutu
	 * @return 
	 */
	
	// METODO DE LECTURA DEL FICHERO LEER LAS RESERVAS

	public void FitxeroaIrakurri() {
		File Reserba = new File("..\\Ethazi4_APP\\src\\APP\\Reserba");

		Scanner s = null;

		try {
			// Leemos el contenido del fichero
			// System.out.println("... Leemos el contenido del fichero ...");
			s = new Scanner(Reserba);

			// Leemos linea a linea el fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine(); // Guardamos la linea en un String
				System.out.println(linea); // Imprimimos la linea
			}

		} catch (Exception e) {
			System.out.println("Mezua: " + e.getMessage());

			/*
			 * reserba.close();
			 * 
			 * }catch(Exception e) { System.out.println("Mesua: " + e.getMessage());
			 */
		}
	}

	/*
	 * @author grupo1
	 * @deprecated  NAN letra komprobatu
	 * @return ondo a la txarto dagoen NAN
	 */
	public static boolean nanKomprobaketa(String DNI) {

		ArrayList<Erabiltzailea> datuErabiltzaile = new ArrayList<Erabiltzailea>();
		datuErabiltzaile = Kontsultak.gordeErabiltzailea(); // array bueltatzen duen metodoa deitzen dut eta bere datuak
															// datosClienten gordetzen ditut

		boolean konprobatu = false;

		for (Erabiltzailea c : datuErabiltzaile) { // for each array zeharkatzeko

			System.out.println("inicio"); // comprobar si entra en el metodo

			if (konprobatu == false) {

				if (c.getDni().equals(DNI)) { // komparatzen dut sartzen duten DNI datu basean dagoenarekin
					// System.out.println("Correcto");
					konprobatu = true;

				} else {
					// System.out.println("falso");
				}
			}
		}

		System.out.println("Fin del metodo");// comprobar el metodo
		return konprobatu;
	}
	
	
	/*
	 * @author grupo1
	 * @deprecated  pasahitza ondo dagoen komprobatze du 
	 * @return pasahitza ondo dagoen ala ez
	 */

	public static boolean pasahitzaKomprobaketa(String pasahitza) {

		int i = 0;
		ArrayList<Erabiltzailea> datuErabiltzaile = new ArrayList<Erabiltzailea>();
		datuErabiltzaile = Kontsultak.gordeErabiltzailea(); // array bueltatzen duen metodoa deitzen dut eta bere datuak
															// datosClienten gordetzen ditut
		boolean konprobatu = false;

		for (Erabiltzailea c : datuErabiltzaile) { // for each array zeharkatzeko

			if (konprobatu == false) {

				if (c.getContraseña().equals(pasahitza)) { // komparatzen dut sartzen duten DNI datu basean dagoenarekin
					System.out.println("Correcto");
					konprobatu = true;

				} else {
					System.out.println("falso");
				}
			}
		}

		System.out.println("Fin del metodo");// comprobar el metodo
		return konprobatu;
	}
	
	
	/*
	 * @author grupo1
	 * @deprecated  pasatzen saion datua enkriptatzen du
	 * @return datua enkriptatuta
	 */

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
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	// ESCRIBIR LAS RESERVAS EN EL FITXERO
	/*
	 * @author grupo1
	 * @deprecated  fitxeroan datuak idatzi
	 * @return 
	 */

	public void fitxeroaIdatzi(String hotelIzena, double prezioFinala, String logelamota, String eguna, int gauKop) {

		System.out.println("ENTRA EN EL METODO");

		// zerbitzua = k.zerbitzuakAtera(hotelIzena);
		FileWriter reserba = null;

		try {
			reserba = new FileWriter("..\\Ethazi4_APP\\src\\APP\\Reserba");

			reserba.write("Zure reserba " + hotelIzena + " hotelean egin da. " + " \n Bere prezioa " + prezioFinala
					+ "€-koa izan da.  " + "\n Aukeratutako logela :" + logelamota + "\n Hotelaren erreserba " + eguna
					+ "-tik aurrera " + gauKop + " gauko estantzia."); // Fitxategian datuak gorde egiten ditu
			// (Izena Hotela)

			reserba.close();

		} catch (Exception e) {
			System.out.println("Mesua: " + e.getMessage());
		}
	}
	
	// KALKULATU ZENBAT LOGELA GERATZEN DIREN
	/*
	 * @author grupo1
	 * @deprecated  KALKULATU ZENBAT LOGELA GERATZEN DIREN
	 * @return logelen kantitatea
	 */
	public static int hotelLogelakKalkulatu(int logelakopurua, String hotelIzena, String gelaMota) {

		int hotelLogelaKopurua = (int) DB.Kontsultak.logelaKopuruaLortu(hotelIzena, gelaMota);

		hotelLogelaKopurua = hotelLogelaKopurua - logelakopurua;

		System.out.println("geratzen diren logelak " + hotelLogelaKopurua);

		return hotelLogelaKopurua;
	}

	public static ArrayList hiriakPantailaratu() {
		return Kontsultak.hiriakPantailaratu();
	}

	public static ArrayList hotelIzenaPantailaratu(String hiria) {
		return Kontsultak.hotelIzenaPantailaratu(hiria);
	}

	public static String informazioaPantailaratu(String hotelIzena, String tabla) {
		return Kontsultak.informazioaPantailaratu(hotelIzena,tabla);
	}

	public static void sartuErabiltzailea(String DNI, String izena, String abizena, String jaiotze_data, String sexua,
			String pasahitza) {
		Kontsultak.sartuErabiltzailea(DNI, izena, abizena, jaiotze_data, sexua, pasahitza);
	}

	
	/*
	 * @author grupo1
	 * @deprecated  // NAN-aren letra balidatzeko
	 * @return letra ondo dagoen ala ez
	 */
	// NAN-aren letra balidatzeko
	public static boolean NANbalidatu(String NAN) {
		boolean ondo = false;
		String zenbakia;// NAN-aren 8 zenbakiak gordetzen ditu
		int zenbakia_;// NAN-aren 8 zenbakiak int moduan gordetzen du
		String letra;// NAN-aren azken letra gordetzen du
		String letra_ = "TRWAGMYFPDXBNJZSQVHLCKET";// NAN-aren letrarekin konparatzeko

		zenbakia = NAN.substring(0, NAN.length() - 1);
		zenbakia_ = Integer.parseInt(zenbakia);
		letra = Character.toString(NAN.charAt(NAN.length() - 1));
		zenbakia_ = zenbakia_ % 23;
		letra_ = letra_.substring(zenbakia_, zenbakia_ + 1);

		if (!letra_.equals(letra.toUpperCase())) {
			System.out.println("NAN txarto dago, letra: " + letra_);
		} else {
			ondo = true;
		}
		return ondo;
	}

	public static int selectCod_logela(String hotelIzena, String mota) {
		return Kontsultak.selectCod_logelaHotel(hotelIzena, mota);
	}

	public static void logelaKopAldatu(int cod_logela, String mota, int kop) {
		Kontsultak.logelaKopAldatu(cod_logela, mota, kop);
	}
	
	
	
	public static boolean dataKalkulatu(String hasieraData) {
		boolean balidatu = false;
		ArrayList<String> datak = new ArrayList<String>();
		datak = Kontsultak.selectAmaieraDatak();
		String urteaAmaieraData;
		int intUrteaAmaieraData;
		String urteaHasieraData;
		int inturteaHasieraData;

		urteaHasieraData = hasieraData.substring(6, 7);
		inturteaHasieraData = Integer.parseInt(urteaHasieraData);

		for (int i = 0; i < datak.size(); i++) {
			urteaAmaieraData = datak.get(i).substring(6, 7);
			intUrteaAmaieraData = Integer.parseInt(urteaAmaieraData);
			if (intUrteaAmaieraData < inturteaHasieraData) {

			}

		}

		return balidatu;
	}
	
	
		

	// DATEN ARTEKO KENKETA
	/*
	 * @author grupo1
	 * @deprecated bi daten arteko denbora kalkulatu
	 * @return aukeratutako egunak
	 */
	public int datenKenketa(String fechaInicio, String fechaActual) {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< RESTA FECHAS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");


        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //creo las variables en date 
        java.util.Date fechaDate = null;
        java.util.Date fechaDate2 = null;
     
       // paso a date el string de la fecha
        try {
            fechaDate =   formato.parse(fechaInicio);
        } 
        catch (ParseException ex) 
        {
        	 System.out.println(ex+ " falla aqui");
        }
        
        // paso a date el string de la fecha
        try {   
         fechaDate2 =  formato.parse(fechaActual);    
       	} 
       catch (ParseException ex) 
       {
           System.out.println(ex + "falla aqui");
        }

//la resta maravillosa
	int dias =	(int)((  fechaDate2.getTime() -  fechaDate.getTime())/ 86400000);
	
	System.out.println("DIAS : "+ dias);
	return dias;
		
		
	}
	/*
	 * @author grupo1
	 * @deprecated hotelaren reserba data kalkulatu
	 * @return reserba egin al den ala ez
	 */
	public boolean reserbaFechaKalkulatuHotel(String fechaInicio, String fechaFinal, int logelaKop, String hotelIzena,
			String gelaMota) {

		boolean ondo = true;
		ArrayList<String> datak_DB = new ArrayList();
		datak_DB = Kontsultak.selectAmaieraDatak();
		ArrayList<Integer> arrayLogelaKop_DB = new ArrayList();
		arrayLogelaKop_DB = Kontsultak.selectLogelaKop();
		String fechaInicio_DB;
		int okupatutak = 0;
		int emaitza = 0;// resta entre el maximo de habitaciones permitidas y ocupadas
		int cod_logela = 0;
		int maximoLogelaKop = 0;// maximo de habitaciones de un tipo de cod_logela
		int maximoLogelaKopHotel = 50;// maximo de habitaciones permitidas en el hotel
		int logelaKop_DB = 0;// numero de habitaciones de un tipo de cod_logela en la tabla de reserba
		int logelaKopHotel = 0;

		String[] aFechaIng = fechaInicio.split("/");
		Integer diaInicio = Integer.parseInt(aFechaIng[0]);
		Integer mesInicio = Integer.parseInt(aFechaIng[1]);
		Integer anioInicio = Integer.parseInt(aFechaIng[2]);

		String[] aFecha;
		int diaFinal;
		int mesFinal;
		int anioFinal;

		cod_logela = Kontsultak.selectCod_logelaHotel(hotelIzena, gelaMota);
		maximoLogelaKop = Kontsultak.selectMaximoLogelaKop(cod_logela);

	        for(int i=0;i<datak_DB.size();i++) {
	        	aFechaIng = fechaInicio.split("/");
	        	diaInicio = Integer.parseInt(aFechaIng[0]);
		        mesInicio = Integer.parseInt(aFechaIng[1]);
		        anioInicio = Integer.parseInt(aFechaIng[2]);
	        	aFecha = datak_DB.get(i).split("/");
	        	diaFinal = Integer.parseInt(aFecha[0]);
	        	mesFinal = Integer.parseInt(aFecha[1]);
	        	anioFinal = Integer.parseInt(aFecha[2]);
	        	if(anioFinal==anioInicio) {
	        		if(mesFinal==mesInicio) {
	        			if(diaFinal>=diaInicio) {
	        				fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
	        				aFechaIng = fechaInicio_DB.split("/");
	        				diaInicio = Integer.parseInt(aFechaIng[0]);
	        				aFecha = fechaFinal.split("/");
	        				diaFinal = Integer.parseInt(aFecha[0]);
	        				if(diaInicio<=diaFinal) {
	        					okupatutak += arrayLogelaKop_DB.get(i);
	        					//okupatutak += Metodoak.logelaKopKalkulatu(datak_DB.get(i));
	        					logelaKop_DB = Kontsultak.selectLogelaKopEspecifico(cod_logela);
	        					System.out.println("Okupatuta: "+okupatutak);
	        					
	        					logelaKopHotel = Kontsultak.selectSumaLogelaKopPorHotel(Kontsultak.selectIDHotel(cod_logela),datak_DB.get(i));
	        			        System.out.println("LogelaKopHotel: "+logelaKopHotel);
	        			        logelaKopHotel += logelaKop;
	        			        if(maximoLogelaKopHotel<logelaKopHotel) {
	        			        	ondo = false;
	        			        }
	        				}
	        					
	        			}
	        		}else if(mesFinal>mesInicio) {
	        			fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
        				aFechaIng = fechaInicio_DB.split("/");
        				mesInicio = Integer.parseInt(aFechaIng[1]);
        				aFecha = fechaFinal.split("/");
        				mesFinal = Integer.parseInt(aFecha[1]);
        				if(mesInicio<=mesFinal) {
        					okupatutak += arrayLogelaKop_DB.get(i);
        					//okupatutak += Metodoak.logelaKopKalkulatu(datak_DB.get(i));
        					logelaKop_DB = Kontsultak.selectLogelaKopEspecifico(cod_logela);
        					System.out.println("Okupatuta: "+okupatutak);
        					
        					logelaKopHotel = Kontsultak.selectSumaLogelaKopPorHotel(Kontsultak.selectIDHotel(cod_logela),datak_DB.get(i));
        			        System.out.println("LogelaKopHotel: "+logelaKopHotel);
        			        logelaKopHotel += logelaKop;
        			        if(maximoLogelaKopHotel<logelaKopHotel) {
        			        	ondo = false;
        			        }
        				}
	        			
	        		}
	        	}else if(anioFinal>anioInicio) {
	        		fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
    				aFechaIng = fechaInicio_DB.split("/");
    				anioInicio = Integer.parseInt(aFechaIng[2]);
    				aFecha = fechaFinal.split("/");
    				anioFinal = Integer.parseInt(aFecha[2]);    				
    				if(anioInicio<=anioFinal) {
    					okupatutak += arrayLogelaKop_DB.get(i);
    					//okupatutak += Metodoak.logelaKopKalkulatu(datak_DB.get(i));
    					logelaKop_DB = Kontsultak.selectLogelaKopEspecifico(cod_logela);
    					System.out.println("Okupatuta: "+okupatutak);
    					
    					logelaKopHotel = Kontsultak.selectSumaLogelaKopPorHotel(Kontsultak.selectIDHotel(cod_logela),datak_DB.get(i));
    			        System.out.println("LogelaKopHotel: "+logelaKopHotel);
    			        logelaKopHotel += logelaKop;
    			        if(maximoLogelaKopHotel<logelaKopHotel) {
    			        	ondo = false;
    			        }
    				}
	        	}
	        }
	        
	       
	        logelaKop_DB += logelaKop;
	        
	        emaitza = maximoLogelaKopHotel - okupatutak;
	        
	        if(maximoLogelaKop<logelaKop_DB) {
	        	ondo = false;
	        	logelaKop_DB -= logelaKop;
	        }
	        
	        System.out.println("Numero de habitaciones elegidas: "+logelaKop);
	        System.out.println("Numero de habitaciones en la BD de cod_logela "+cod_logela+": "+logelaKop_DB);
	        System.out.println("Logela okupatutak: "+okupatutak);
	        System.out.println("Maximologelakop de cod_logela "+cod_logela+": "+maximoLogelaKop);
	        System.out.println("Maximo general del hotel: "+maximoLogelaKopHotel);
	        
	        

//	        if(emaitza<logelaKop) {
//	        	ondo = false;
//	        }else {
//	        	emaitza-=logelaKop;
//	        }
		System.out.println("Habitaciones restantes en el hotel: " + emaitza);

		return ondo;

	    }
	
	/*
	 * @author grupo1
	 * @deprecated apartamentu reserba data kalkulatu
	 * @return reserba egin al den ala ez
	 */
	
	public boolean reserbaFechaKalkulatuApartamentu(String fechaInicio,String fechaFinal, int idA, int pisua) {
        
        boolean ondo = true;
        ArrayList<String> datak_DB = new ArrayList();
        datak_DB = Kontsultak.selectAmaieraDatakApartamentu(idA);
        String fechaInicio_DB;
        ArrayList<Integer> arrayPisuak = new ArrayList();

        String[] aFechaIng = fechaInicio.split("/");
        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

        String[] aFecha;
        int diaFinal;
        int mesFinal;
        int anioFinal;
        

        for(int i=0;i<datak_DB.size();i++) {
        	aFechaIng = fechaInicio.split("/");
        	diaInicio = Integer.parseInt(aFechaIng[0]);
	        mesInicio = Integer.parseInt(aFechaIng[1]);
	        anioInicio = Integer.parseInt(aFechaIng[2]);
        	aFecha = datak_DB.get(i).split("/");
        	diaFinal = Integer.parseInt(aFecha[0]);
        	mesFinal = Integer.parseInt(aFecha[1]);
        	anioFinal = Integer.parseInt(aFecha[2]);
        	if(anioFinal==anioInicio) {
        		if(mesFinal==mesInicio) {
        			if(diaFinal>=diaInicio) {//si el dia de inicio de la reserba es mas pequeño que el dia final de la bd
        				fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
        				aFechaIng = fechaInicio_DB.split("/");
        				diaInicio = Integer.parseInt(aFechaIng[0]);
        				aFecha = fechaFinal.split("/");
        				diaFinal = Integer.parseInt(aFecha[0]);
        				if(diaInicio<=diaFinal) {//si dia final de la reserba es mas grande que el dia inicio de la bd
        					arrayPisuak=Kontsultak.selectPisuak(idA);
        					if(arrayPisuak.get(i)==pisua) {
        						ondo=false;
        					}
        				}
        					
        			}
        		}else if(mesFinal>mesInicio) {
        			fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
    				aFechaIng = fechaInicio_DB.split("/");
    				mesInicio = Integer.parseInt(aFechaIng[1]);
    				aFecha = fechaFinal.split("/");
    				mesFinal = Integer.parseInt(aFecha[1]);
    				if(mesInicio<=mesFinal) {
    					arrayPisuak=Kontsultak.selectPisuak(idA);
    					if(arrayPisuak.get(i)==pisua) {
    						ondo=false;
    					}
    				}
        			
        		}
        	}else if(anioFinal>anioInicio) {
        		fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
				aFechaIng = fechaInicio_DB.split("/");
				anioInicio = Integer.parseInt(aFechaIng[2]);
				aFecha = fechaFinal.split("/");
				anioFinal = Integer.parseInt(aFecha[2]);    				
				if(anioInicio<=anioFinal) {
					arrayPisuak=Kontsultak.selectPisuak(idA);
					if(arrayPisuak.get(i)==pisua) {
						ondo=false;
					}
				}
        	}
        }
        
		return ondo;

    }
	
	
	
	/*
	 * @author grupo1
	 * @deprecated etxearen reserba data kalkulatu
	 * @return reserba egin al den ala ez
	 */
	public boolean reserbaFechaKalkulatuEtxea(String fechaInicio,String fechaFinal, int idE) {
        
        boolean ondo = true;
        ArrayList<String> datak_DB = new ArrayList();
        datak_DB = Kontsultak.selectAmaieraDatakEtxea(idE);
        String fechaInicio_DB;
        ArrayList<Integer> arrayIDEtxea = new ArrayList();
        

        String[] aFechaIng = fechaInicio.split("/");
        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

        String[] aFecha;
        int diaFinal;
        int mesFinal;
        int anioFinal;
        
       
        

        for(int i=0;i<datak_DB.size();i++) {
        	aFechaIng = fechaInicio.split("/");
        	diaInicio = Integer.parseInt(aFechaIng[0]);
	        mesInicio = Integer.parseInt(aFechaIng[1]);
	        anioInicio = Integer.parseInt(aFechaIng[2]);
        	aFecha = datak_DB.get(i).split("/");
        	diaFinal = Integer.parseInt(aFecha[0]);
        	mesFinal = Integer.parseInt(aFecha[1]);
        	anioFinal = Integer.parseInt(aFecha[2]);
        	if(anioFinal==anioInicio) {
        		if(mesFinal==mesInicio) {
        			if(diaFinal>=diaInicio) {//si el dia de inicio de la reserba es mas pequeño que el dia final de la bd
        				fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
        				aFechaIng = fechaInicio_DB.split("/");
        				diaInicio = Integer.parseInt(aFechaIng[0]);
        				aFecha = fechaFinal.split("/");
        				diaFinal = Integer.parseInt(aFecha[0]);
        				if(diaInicio<=diaFinal) {//si dia final de la reserba es mas grande que el dia inicio de la bd
        					arrayIDEtxea=Kontsultak.selectIDEtxeaArray();
        					if(arrayIDEtxea.get(i)==idE) {
        						ondo=false;
        					}
        				}
        					
        			}
        		}else if(mesFinal>mesInicio) {
        			fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
    				aFechaIng = fechaInicio_DB.split("/");
    				mesInicio = Integer.parseInt(aFechaIng[1]);
    				aFecha = fechaFinal.split("/");
    				mesFinal = Integer.parseInt(aFecha[1]);
    				if(mesInicio<=mesFinal) {
    					arrayIDEtxea=Kontsultak.selectIDEtxeaArray();
    					if(arrayIDEtxea.get(i)==idE) {
    						ondo=false;
    					}
    				}
        			
        		}
        	}else if(anioFinal>anioInicio) {
        		fechaInicio_DB = Kontsultak.selectHasieraData(datak_DB.get(i));
				aFechaIng = fechaInicio_DB.split("/");
				anioInicio = Integer.parseInt(aFechaIng[2]);
				aFecha = fechaFinal.split("/");
				anioFinal = Integer.parseInt(aFecha[2]);    				
				if(anioInicio<=anioFinal) {
					arrayIDEtxea=Kontsultak.selectIDEtxeaArray();
					if(arrayIDEtxea.get(i)==idE) {
						ondo=false;
					}
				}
        	}
        }
        
		return ondo;

    }
	


	    
//	public static int logelaKopKalkulatu(String data) {
//		int okupatutak=0;
//		
//		okupatutak = Kontsultak.selectLogelaKop(data);
//		
//		return okupatutak;
//	}

	public static ArrayList apartamentuIzenaPantailaratu(String hiria) {
		return Kontsultak.apartamentuIzenaPantailaratu(hiria);
	}

	public static ArrayList etxeIzenaPantailaratu(String hiria) {
		return Kontsultak.etxeIzenaPantailaratu(hiria);
	}
	
	
	//PREZIOA CALCULATU METODOA
//	public static int prezioKalk(int logelaKop, String mota) {
//		
//		int prezioFinala =0;
//		
//		if(mota.equalsIgnoreCase("Banakakoa")) {
//			
//			prezioFinala = logelaKop * 20;
//			
//		}else if (mota.equalsIgnoreCase("Bikoitza")) {
//			
//			prezioFinala = logelaKop * 40;
//			System.out.println(logelaKop+ " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
//			
//		}else if (mota.equalsIgnoreCase("Umeentzat")) {
//			
//			prezioFinala = logelaKop * 10;
//		
//		}
//		
//		return prezioFinala;
//	}
	
	/*
	 * @author grupo1
	 * @deprecated prezioa kalkulatu logela motaren artabera
	 * @return logelaren prezioa
	 */
	// PREZIOA CALCULATU METODOA
	public static int prezioKalk(int logelaKop, String mota) {

		int prezioFinala = 0;

		if (mota.equalsIgnoreCase("Banakakoa")) {

			prezioFinala = logelaKop * 20;

		} else if (mota.equalsIgnoreCase("Bikoitza")) {

			prezioFinala = logelaKop * 40;
			System.out.println(logelaKop + " <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		} else if (mota.equalsIgnoreCase("Umeentzat")) {

			prezioFinala = logelaKop * 10;

		}

		return prezioFinala;
	}

	/*
	 * @author grupo1
	 * @deprecated aukeratutako egunak ia denboraldi altua ala baxua den
	 * @return denboralñdi altua a la baxua den
	 */
	public static String kalkulatuDenboraldia(String fechaInicio, String fechaFinal) {
		String temporada = null;
		String[] aFechaIng = new String[3];
		String[] aFechaSal = new String[3];
		int diaInicio;
		int mesInicio;
		int anioInicio;
		int diaFinal;
		int mesFinal;
		int anioFinal;

		aFechaIng = fechaInicio.split("/");
		diaInicio = Integer.parseInt(aFechaIng[0]);
		mesInicio = Integer.parseInt(aFechaIng[1]);
		anioInicio = Integer.parseInt(aFechaIng[2]);

		aFechaSal = fechaInicio.split("/");
		diaFinal = Integer.parseInt(aFechaIng[0]);
		mesFinal = Integer.parseInt(aFechaIng[1]);
		anioFinal = Integer.parseInt(aFechaIng[2]);

		if (mesInicio == 11 || mesInicio == 12 || mesInicio == 1 || mesInicio == 2 || mesInicio == 3
				|| (diaInicio > 21 && mesInicio == 6) || mesInicio == 7 || mesInicio == 8 || mesFinal == 11
				|| mesFinal == 12 || mesFinal == 1 || mesFinal == 2 || mesFinal == 3 || (diaFinal > 21 && mesFinal == 6)
				|| mesFinal == 7 || mesFinal == 8) {
			temporada = "alta";
		} else if (mesInicio == 4 || mesInicio == 5 || (mesInicio == 6 && diaInicio < 22) || mesInicio == 9
				|| mesInicio == 10 || mesFinal == 4 || mesFinal == 5 || (mesFinal == 6 && diaFinal < 22)
				|| mesFinal == 9 || mesFinal == 10) {
			temporada = "baja";
		}
		return temporada;
	}
	
	public static void bostSegundo() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}

}
