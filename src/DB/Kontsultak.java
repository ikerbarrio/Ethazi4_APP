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
			
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IZENA FROM HOTELAK WHERE cod_postal = (SELECT cod_postal FROM HIRIAK WHERE IZENA LIKE '"+hiria+"')");
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

	public static String hotelInformazioaPantailaratu(String hotelIzena) {
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
					.executeQuery("SELECT INFORMAZIOA FROM HOTELAK WHERE IZENA LIKE '" + hotelIzena + "'");
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
	public String zerbitzuakAtera(String hotelIzena) {
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
				inicioSes.add(0,c1);
//				for (int n = 0; n < inicioSes.size(); n++) {
//					System.out.println(inicioSes.get(n));
//				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return inicioSes; // gero erabili ahal izateko array nankomprobaketa metodoan
	}

	
	public static void sartuErabiltzailea(String DNI, String izena, String abizena, String jaiotze_data, String sexua, String pasahitza) {

		Connection conexion = null;
		Statement s = null;
		
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
		
			String query = "INSERT INTO ERABILTZAILEAK(DNI,izena,abizena,jaiotze_data,sexua,pasahitza)"+" VALUES(?,?,?,?,?,?)";
			
			PreparedStatement preparedStmt = (PreparedStatement) conexion.prepareStatement(query);
		      preparedStmt.setString (1, DNI);
		      preparedStmt.setString (2, izena);
		      preparedStmt.setString (3, abizena);
		      preparedStmt.setString (4, jaiotze_data);
		      preparedStmt.setString (5, sexua);
		      preparedStmt.setString (6, pasahitza);
		      
		      preparedStmt.execute();
		      
		      System.out.println("Sartuta");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public int logelaKopuruaLortu(String hotelIzena) {
		int logelaKop =0;		
		Connection conexion = null;
		Statement s = null;
		
		try {
	
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs
			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT logelaKop FROM hotelak WHERE IZENA ="  + "'" +hotelIzena  + "'");

				while (rs.next()) {
					 logelaKop = rs.getInt("logelaKop");
	
				}
		
			
		}catch(Exception e ) {
			
		}
		return logelaKop;
		
	}
}
