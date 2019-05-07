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

import DB.*;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Metodoak {

	public static double kontTotala = 0;
	DB.Kontsultak k = new DB.Kontsultak();

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
	//añadir  mas datos al fitxero 

	public void fitxeroaIdatzi(String hotelIzena, double prezioFinala, String logelamota, String eguna, int gauKop) {
		
		System.out.println("ENTRA EN EL METODO");

		 //zerbitzua = k.zerbitzuakAtera(hotelIzena);
		FileWriter reserba = null;

		try {
			reserba = new FileWriter("..\\Ethazi4_APP\\src\\APP\\Reserba");

			reserba.write("Zure reserba " + hotelIzena + " hotelean egin da. " + " \n Bere prezioa " + prezioFinala
					+ "€-koa izan da.  " + "\n Aukeratutako logela :" + logelamota + "\n Hotelaren erreserba " + eguna + "-tik aurrera " + gauKop + " gauko estantzia."); // Fitxategian datuak gorde egiten ditu
																					// (Izena Hotela)

			reserba.close();

		} catch (Exception e) {
			System.out.println("Mesua: " + e.getMessage());
		}
	}
	// KALKULATU ZENBAT LOGELA GERATZEN DIREN

	/* LogelaKopurua pasar el dato del spinner */
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

	public static String hotelInformazioaPantailaratu(String hotelIzena) {
		return Kontsultak.hotelInformazioaPantailaratu(hotelIzena);
	}

	public static void sartuErabiltzailea(String DNI, String izena, String abizena, String jaiotze_data, String sexua,
			String pasahitza) {
		Kontsultak.sartuErabiltzailea(DNI, izena, abizena, jaiotze_data, sexua, pasahitza);
	}

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
		return Kontsultak.selectCod_logela(hotelIzena, mota);
	}
	
	public static void logelaKopAldatu(int cod_logela, String mota, int kop) {
		Kontsultak.logelaKopAldatu(cod_logela, mota, kop);
	}
	
	
	
	
	//DATEN ARTEKO KENKETA
	public int datenKenketa(String fechaInicio, String fechaActual) {
		
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< RESTA FECHAS <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

//		
//		    fechaInicio = "22/04/1988";
//	         fechaActual = "09/04/2015";

	        
	        Date date = new Date(0);
	        
	        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
	
	        String[] aFechaIng = fechaInicio.split("/");
	        Integer diaInicio = Integer.parseInt(aFechaIng[0]);
	        Integer mesInicio = Integer.parseInt(aFechaIng[1]);
	        Integer anioInicio = Integer.parseInt(aFechaIng[2]);

	        String[] aFecha = fechaActual.split("/");
	        Integer diaFinal = Integer.parseInt(aFecha[0]);
	        Integer mesFinal = Integer.parseInt(aFecha[1]);
	        Integer anioFinal = Integer.parseInt(aFecha[2]);
	        
	        
	        int dias = diaFinal - diaInicio;
	        
	    System.out.println( "mes inicio "+mesInicio + " y el mes final" + mesFinal);
	    
	    
	    
	    
	    if (mesFinal > mesInicio) {
	    	   System.out.println(" PROBANDO SI FUNCIONA  EL IF");
	    int sumaPorMes=	mesFinal -mesInicio;
	    sumaPorMes = sumaPorMes *30;
	    dias = dias + sumaPorMes;
	    
	    System.out.println(" aplicando la diferencia del mes " + dias);
	    	
	 
	    }
/*
	        System.out.println(diaActual);
	        System.out.println(mesActual);
	        System.out.println(anioActual);
	        int b = 0;
	        int dias = 0;
	        int mes = 0;
	        int anios = 0;
	        int meses = 0;
	        mes = mesInicio - 1;
	        if (mes == 2) {
	            if ((anioActual % 4 == 0) && ((anioActual % 100 != 0) || (anioActual % 400 == 0))) {
	                b = 29;
	            } else {
	                b = 28;
	            }
	        } else if (mes <= 7) {
	            if (mes == 0) {
	                b = 31;
	            } else if (mes % 2 == 0) {
	                b = 30;
	            } else {
	                b = 31;
	            }
	        } else if (mes > 7) {
	            if (mes % 2 == 0) {
	                b = 31;
	            } else {
	                b = 30;
	            }
	        }
	        
	        if ((anioInicio > anioActual) || (anioInicio == anioActual && mesInicio > mesActual)
	                || (anioInicio == anioActual && mesInicio == mesActual && diaInicio > diaActual)) {
	        	
	            System.out.println("La fecha de inicio debe ser anterior a la fecha Actual");
	            
	        } else {
	            if (mesInicio <= mesActual) {
	                anios = anioActual - anioInicio;
	                if (diaInicio <= diaActual) {
	                    meses = mesActual - mesInicio;
	                    dias = b - (diaInicio - diaActual);
	                } else {
	                    if (mesActual == mesInicio) {
	                        anios = anios - 1;
	                    }
	                    meses = (mesActual - mesInicio - 1 + 12) % 12;
	                    dias = b - (diaInicio - diaActual);
	                }
	            } else {
	                anios = anioActual - anioInicio - 1;
	                System.out.println(anios);
	                if (diaInicio > diaActual) {
	                    meses = mesActual - mesInicio - 1 + 12;
	                    dias = b - (diaInicio - diaActual);
	                } else {
	                    meses = mesActual - mesInicio + 12;
	                    dias = diaActual - diaInicio;
	                }
	            }
	        }
	       


	        System.out.println("Años: " + anios);
	        System.out.println("Meses: " + meses);
	        */
	        

//	        System.out.println("Años: " + anios);
//	        System.out.println("Meses: " + meses);

	        System.out.println("Días: " + dias);
	        
			return dias;

	    }



}
