package DB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import APP.*;

public class Kontsultak {

	public static ArrayList hotelIzenaPantailaratu(String hiria) {
		String izena = null;// hotelen izenak gordetzen dira
		String katea;// izena
		Connection conexion = null;
		Statement s = null;
		ArrayList<String> hotelak = new ArrayList();

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery(
					"SELECT IZENA FROM HOTELAK WHERE cod_postal = (SELECT cod_postal FROM HIRIAK WHERE IZENA LIKE '"+ hiria + "')");
			while (rs.next()) {

				izena = rs.getString(1);
				hotelak.add(izena);

			}
			for (String k : hotelak) {
				System.out.println(k);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hotelak;
	}

	public static String informazioaPantailaratu(String hotelIzena, String tabla) {
		String informazioa = null;// hotelen informazioa gordetzeko
		Connection conexion = null;
		Statement s = null;

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s)
					.executeQuery("SELECT INFORMAZIOA FROM "+ tabla +" WHERE IZENA LIKE '" + hotelIzena + "'");
			while (rs.next()) {

				informazioa = rs.getString(1);
				System.out.println(informazioa);

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return informazioa;
	}

	public static ArrayList hiriakPantailaratu() {
		String izena = null;
		Connection conexion = null;
		Statement s = null;
		ArrayList<String> hiriak = new ArrayList();

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IZENA FROM HIRIAK");
			while (rs.next()) {

				izena = rs.getString(1);
				hiriak.add(izena);

			}
			for (String k : hiriak) {
				System.out.println(k);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hiriak;
	}

	// HOTELEN ZERBITZUAK ATERA
	
	
	public  String zerbitzuakAtera(String hotelIzena) {
		String zerbitzua = "";

		Connection conexion = null;
		Statement s = null;

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s)
					.executeQuery("SELECT ZERBITZUAK FROM HOTELAK WHERE IZENA LIKE '" + hotelIzena + "'");
			while (rs.next()) {
				zerbitzua = rs.getString("zerbitzuak");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return zerbitzua; // itzultzen du ze zerbitzu daukagun

	}
	
	
	

	public static ArrayList<Erabiltzailea> gordeErabiltzailea() { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		ArrayList<Erabiltzailea> inicioSes = new ArrayList<Erabiltzailea>();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT * FROM ERABILTZAILEAK");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				String dni_;
				dni_ = rs.getString("DNI");

				String nombre_;
				nombre_ = rs.getString("izena");

				String apellido_;
				apellido_ = rs.getString("abizena");

				String sexo_;
				sexo_ = rs.getString("sexua");

				String contraseña_;
				contraseña_ = rs.getString("pasahitza");

				String fecha_nac_;
				fecha_nac_ = rs.getString("jaiotze_data");

				Erabiltzailea c1 = new Erabiltzailea(dni_, nombre_, apellido_, fecha_nac_, sexo_, contraseña_);
				inicioSes.add(0, c1);
//				for (int n = 0; n < inicioSes.size(); n++) {
//					System.out.println(inicioSes.get(n));
//				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return inicioSes; // gero erabili ahal izateko array nankomprobaketa metodoan
	}

	public static void sartuErabiltzailea(String DNI, String izena, String abizena, String jaiotze_data, String sexua,
			String pasahitza) {

		Connection conexion = null;
		Statement s = null;

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			String query = "INSERT INTO ERABILTZAILEAK(DNI,izena,abizena,jaiotze_data,sexua,pasahitza)"
					+ " VALUES(?,?,?,?,?,?)";

			PreparedStatement preparedStmt = (PreparedStatement) conexion.prepareStatement(query);
			preparedStmt.setString(1, DNI);
			preparedStmt.setString(2, izena);
			preparedStmt.setString(3, abizena);
			preparedStmt.setString(4, jaiotze_data);
			preparedStmt.setString(5, sexua);
			preparedStmt.setString(6, pasahitza);

			preparedStmt.execute();

			System.out.println("Sartuta");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	

	public static int logelaKopuruaLortu(String hotelIzena, String gelaMota) {
		int logelaKop = 0;
		Connection conexion = null;
		Statement s = null;

		try {
			System.out.println(hotelIzena);
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			String kontsulta = "SELECT logelakop from logelamota WHERE  mota like '" +  gelaMota + "' AND id = (SELECT id FROM hotelak WHERE IZENA like " + "'" + hotelIzena + "')";
			
			System.out.println(kontsulta);
			
			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT logelakop from logelamota WHERE  mota like '" +  gelaMota + "' AND id = (SELECT id FROM hotelak WHERE IZENA like " + "'" + hotelIzena + "')");
			

			while (rs.next()) {
				logelaKop = rs.getInt("logelaKop");
				System.out.println(logelaKop);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return logelaKop;

	}
	
	public static void logelaKopAldatu(int cod_logela, String mota, int kop) {

		Connection conexion = null;
		Statement s = null;
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Preparamos la consulta y la ejecutamos
			// NumReg-> Para saber cuantos registros se han modificado
			 int numReg = s.executeUpdate( "UPDATE logelamota SET logelakop = logelakop - "+kop+" WHERE cod_logela= "+cod_logela+" AND mota LIKE '"+mota+"'" );
			 // Informamos del número de registros borrados
			 System.out.println ("\nAldatuta\n");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	//hotelaren cod_ logela lortu
	
	public static int selectCod_logelaHotel(String izena, String mota) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int cod_logela=0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT COD_LOGELA FROM LOGELAMOTA WHERE ID=(SELECT ID FROM HOTELAK WHERE IZENA LIKE '"+izena+"') AND mota like '"+mota+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				cod_logela = rs.getInt(1);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cod_logela; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	public static int selectCod_logelaApartamentu(String izena, String mota) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int cod_logela=0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT COD_LOGELA FROM LOGELAMOTA WHERE IDA=(SELECT IDA FROM APARTAMENTUA WHERE IZENA LIKE '"+izena+"') AND mota like '"+mota+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				cod_logela = rs.getInt(1);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cod_logela; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	public static int selectCod_logelaEtxe(String izena, String mota) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int cod_logela=0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT COD_LOGELA FROM LOGELAMOTA WHERE IDE=(SELECT IDE FROM ETXEA WHERE IZENA LIKE '"+izena+"') AND mota like '"+mota+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				cod_logela = rs.getInt(1);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cod_logela; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	
	public static ArrayList selectDNI() { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		String DNI;
		ArrayList<String> arrayDNI = new ArrayList();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT DNI FROM ERABILTZAILEAK");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				DNI = rs.getString(1);
				arrayDNI.add(DNI);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayDNI; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	
	
	
	//INSERTAR DATOS EN LA TABLA DE RESERBAS
	
	
	public static void ReserbaDatuakGorde(String hotela, int id, double prezioa, String logelaMota, int codLogela, String hasieraData, String amaieraData,int logeolaKop, String localDate) {

		Connection conexion = null;
		Statement s = null;

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			String query = "INSERT INTO reserba (hotelIzena,id,prezioa,logelaMota,codLogela,hasieraData, amaieraData, logelakop,fecha_tc)"
					+ " VALUES(?,?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStmt = (PreparedStatement) conexion.prepareStatement(query);
			preparedStmt.setString(1, hotela);
			preparedStmt.setInt(2, id);
			preparedStmt.setDouble(3, prezioa);
			preparedStmt.setString(4, logelaMota);
			preparedStmt.setInt(5, codLogela);
			preparedStmt.setString(6, hasieraData);
			preparedStmt.setString(7, amaieraData);
			preparedStmt.setInt(8, logeolaKop);
			preparedStmt.setString(9, localDate);
			

			preparedStmt.execute();

			System.out.println("Sartuta");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static int hotelIdLortu(String hotela) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		String DNI;
		ArrayList<String> arrayDNI = new ArrayList();
		int id =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT id FROM hotelak WHERE  izena LIKE '" +hotela +"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				id = rs.getInt("id");
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
	public static int selectPrezioa(int cod_logela) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int prezioa=0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT PREZIOA FROM LOGELAMOTA WHERE COD_LOGELA="+cod_logela);

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				prezioa = rs.getInt(1);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return prezioa; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	public static ArrayList selectAmaieraDatak() { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		String data;
		ArrayList<String> datak = new ArrayList();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT AMAIERADATA FROM RESERBA");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				data = rs.getString(1);
				datak.add(data);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datak; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	public static String selectHasieraData(String fechaFinal) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		String data="";
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT HASIERADATA FROM RESERBA WHERE AMAIERADATA LIKE '"+fechaFinal+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				data = rs.getString(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return data; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	public static ArrayList apartamentuIzenaPantailaratu(String hiria) {
		String izena = null;// hotelen izenak gordetzen dira
		String katea;// izena
		Connection conexion = null;
		Statement s = null;
		ArrayList<String> apartamentuak = new ArrayList();

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IZENA FROM APARTAMENTUA WHERE cod_postal = (SELECT cod_postal FROM HIRIAK WHERE IZENA LIKE '"+ hiria + "')");
			while (rs.next()) {

				izena = rs.getString(1);
				apartamentuak.add(izena);

			}
			for (String k : apartamentuak) {
				System.out.println(k);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return apartamentuak;
	}
	
	public static ArrayList etxeIzenaPantailaratu(String hiria) {
		String izena = null;// hotelen izenak gordetzen dira
		String katea;// izena
		Connection conexion = null;
		Statement s = null;
		ArrayList<String> etxeak = new ArrayList();

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery(
					"SELECT IZENA FROM ETXEA WHERE cod_postal = (SELECT cod_postal FROM HIRIAK WHERE IZENA LIKE '"
							+ hiria + "')");
			while (rs.next()) {

				izena = rs.getString(1);
				etxeak.add(izena);

			}
			for (String k : etxeak) {
				System.out.println(k);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return etxeak;
	}
	
	public static int selectLogelaKop(String data) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int kop =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT LOGELAKOP FROM RESERBA WHERE AMAIERADATA LIKE '" +data +"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				kop = rs.getInt(1);
				
 
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kop;
		
	}
	
	public static int selectMaximoLogelaKop(int cod_logela) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int kop =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT LOGELAKOP FROM LOGELAMOTA WHERE COD_LOGELA = "+cod_logela);

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				kop = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kop;
		
	}
	
	public static int selectLogelaKopEspecifico(int cod_logela) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int kop =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT SUM(LOGELAKOP) FROM RESERBA WHERE CODLOGELA = " +cod_logela);

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				kop = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kop;
		
	}

	
	
	//etxeko logela motak lortu
	public static int logelaKopuruaLortuEtxea(String hotelIzena, String gelaMota) {
		int logelaKop = 0;
		Connection conexion = null;
		Statement s = null;

		try {
			System.out.println(hotelIzena);
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			String kontsulta = "SELECT logelakop from logelamota WHERE  mota like '" +  gelaMota + "' AND idE = (SELECT idE FROM etxea WHERE IZENA like " + "'" + hotelIzena + "')";
			
			System.out.println(kontsulta);
			
			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT logelakop from logelamota WHERE  mota like '" +  gelaMota + "' AND idE = (SELECT idE FROM etxea WHERE IZENA like " + "'" + hotelIzena + "')");

		


			while (rs.next()) {
				logelaKop = rs.getInt(1);
				System.out.println(logelaKop);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return logelaKop;

	}
	
	
	//apartamentu logela motak lortu
	
	public static int logelaKopuruaLortuApartamentu(String apartamentuIzena, String gelaMota) {
		int logelaKop = 0;
		Connection conexion = null;
		Statement s = null;

		try {
			System.out.println(apartamentuIzena);
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			String kontsulta = "SELECT logelakop from logelamota WHERE  mota like '" +  gelaMota + "' AND idA = (SELECT idA FROM apartamentua WHERE IZENA like '" + apartamentuIzena + "')";
			
			System.out.println(kontsulta);
			
			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT logelakop from logelamota WHERE  mota like '" +  gelaMota + "' AND idA = (SELECT idA FROM apartamentua WHERE IZENA like '" + apartamentuIzena + "')");
			

			while (rs.next()) {
				logelaKop = rs.getInt(1);
				System.out.println(logelaKop);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return logelaKop;

	}	
	
	
	//apartamentu id lortu
	
	public static int apartamentuIdLortu(String apartamentuIzena) { 
		Connection conexion = null;
		Statement s = null;
	
		int id =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idA FROM apartamentua WHERE  izena LIKE '" +apartamentuIzena +"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				id = rs.getInt("idA");
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
	
	//GUARDAR DATOS DE LOS APARTAMENTU
	
	public static void ReserbaDatuakGordeApartamentua(String izena, double prezioa, String hasieraData, String amaieraData, int idA, int pisua) {

		Connection conexion = null;
		Statement s = null;

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			String query = "INSERT INTO reserba (hotelIzena,prezioa,hasieraData, amaieraData, idA, pisua)"
					+ " VALUES(?,?,?,?,?,?)";

			PreparedStatement preparedStmt = (PreparedStatement) conexion.prepareStatement(query);
			preparedStmt.setString(1, izena);
			preparedStmt.setDouble(2, prezioa);
			preparedStmt.setString(3, hasieraData);
			preparedStmt.setString(4, amaieraData);
			preparedStmt.setInt(5, idA);
			preparedStmt.setInt(6, pisua);
			preparedStmt.execute();

			System.out.println("Sartuta");

		} catch (Exception e) {
			System.out.println("fallo");
			System.out.println(e.getMessage());
		}

	}
	
	// conseguir el idE de etxea
	public static int etxeIdLortu(String etxeIzena) { 
		Connection conexion = null;
		Statement s = null;
	
		int id =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT idE FROM etxea WHERE  izena LIKE '" +etxeIzena +"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				id = rs.getInt("idE");
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	//GUARDAR DATOS DE ETXEAK
	
	public static void ReserbaDatuakGordeEtxeak(String izena, double prezioa, String hasieraData, String amaieraData,int idE) {

		Connection conexion = null;
		Statement s = null;

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			String query = "INSERT INTO reserba (hotelIzena,prezioa,hasieraData, amaieraData, idE)"
					+ " VALUES(?,?,?,?,?)";

			PreparedStatement preparedStmt = (PreparedStatement) conexion.prepareStatement(query);
			preparedStmt.setString(1, izena);
			preparedStmt.setDouble(2, prezioa);
			preparedStmt.setString(3, hasieraData);
			preparedStmt.setString(4, amaieraData);
			preparedStmt.setInt(5, idE);

			preparedStmt.execute();

			System.out.println("Sartuta");

		} catch (Exception e) {
			System.out.println("fallo");
			System.out.println(e.getMessage());
		}

	}
	   
	
	//ETXEEN COD_ LOGELA LORTU
	
	public static int selectCodLogelaEtxea(String izena, String mota) { 
		Connection conexion = null;
		Statement s = null;
		int cod_logela=0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT cod_logela FROM logelamota WHERE idE=(SELECT idE FROM etxea WHERE izena  LIKE '"+izena+"') AND mota like '"+mota+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				cod_logela = rs.getInt("cod_logela");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cod_logela; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	
	//APARTAMENTUAREN CODLOGELA LORTU
	public static int selectCodLogelaApartamentu(String izena, String mota) { 
		Connection conexion = null;
		Statement s = null;
		int cod_logela=0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT cod_logela FROM logelamota WHERE idA=(SELECT idA FROM apartamentua WHERE izena  LIKE '"+izena+"') AND mota like '"+mota+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				cod_logela = rs.getInt("cod_logela");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return cod_logela; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	

	
	

	public static ArrayList selectLogelaKop() { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int kop;
		ArrayList<Integer> logelaKop = new ArrayList();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT LOGELAKOP FROM RESERBA");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				kop = rs.getInt(1);
				logelaKop.add(kop);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return logelaKop; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	public static int selectSumaLogelaKopPorHotel(int id, String data) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int kop =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT SUM(LOGELAKOP) FROM RESERBA WHERE ID = " +id+" AND AMAIERADATA LIKE '"+data+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				kop = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kop;
		
	}
	
	public static int selectSumaLogelaKopPorApartamentu(int id, String data) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int kop =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT SUM(LOGELAKOP) FROM RESERBA WHERE IDA = " +id+" AND AMAIERADATA LIKE '"+data+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				kop = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kop;
		
	}
	
	public static int selectSumaLogelaKopPorEtxe(int id, String data) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int kop =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT SUM(LOGELAKOP) FROM RESERBA WHERE IDE = " +id+" AND AMAIERADATA LIKE '"+data+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				kop = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return kop;
		
	}
	
	public static int selectIDHotel(int cod_logela) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int id =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT ID FROM LOGELAMOTA WHERE COD_LOGELA = " +cod_logela);

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				id = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
	public static int selectIDApartamentu(String izena) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int id =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IDA FROM APARTAMENTUA WHERE IZENA LIKE '" +izena+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				id = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
	public static ArrayList selectIDEtxeaArray() { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int idE =0;
		ArrayList<Integer> arrayidE = new ArrayList();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IDE FROM RESERBA WHERE IDE IS NOT NULL");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				idE = rs.getInt(1);
				arrayidE.add(idE);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return arrayidE;
		
	}
	
	public static int selectIDEtxea(String izena) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int idE =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IDE FROM ETXEA WHERE IZENA LIKE '"+izena+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				idE = rs.getInt(1);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return idE;
		
	}
	
	public static int selectPrezioEtxe(String izena) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int id =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT PREZIOA FROM ETXEA WHERE IZENA = '" +izena+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				id = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
	public static int selectPrezioApartamentu(String izena) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int id =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT PREZIOA FROM APARTAMENTUA WHERE IZENA = '" +izena+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				id = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return id;
		
	}
	
	public static int selectPisuaMaximoa(String izena) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int pisua =0;
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT SOLAIRUA FROM APARTAMENTUA WHERE IZENA = '" +izena+"'");

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE
				pisua = rs.getInt(1);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pisua;
		
	}
	
	public static ArrayList selectPisuak(int idA) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		int pisua = 0;
		ArrayList<Integer> pisuak = new ArrayList();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT PISUA FROM RESERBA WHERE IDA = " +idA);

			while (rs.next()) {

				
				pisua = rs.getInt(1);
				pisuak.add(pisua);
				

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pisuak;
		
	}
	
	public static ArrayList selectAmaieraDatakApartamentu(int idA) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		String data;
		ArrayList<String> datak = new ArrayList();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT AMAIERADATA FROM RESERBA WHERE IDA ="+idA);

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				data = rs.getString(1);
				datak.add(data);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datak; // gero erabili ahal izateko array nankomprobaketa metodoan
	}
	
	public static ArrayList selectAmaieraDatakEtxea(int idE) { // arraylist bueltatu behar du
		Connection conexion = null;
		Statement s = null;
		String data;
		ArrayList<String> datak = new ArrayList();
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT AMAIERADATA FROM RESERBA WHERE IDE ="+idE);

			while (rs.next()) {

				// SELECTAREN DATUAK GORDE

				
				data = rs.getString(1);
				datak.add(data);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return datak; // gero erabili ahal izateko array nankomprobaketa metodoan
	}

	
}