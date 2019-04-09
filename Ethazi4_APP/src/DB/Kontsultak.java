package DB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Kontsultak {
	
	public static ArrayList hotelIzenaPantailaratu(String hiria) {
		String izena = null;//hotelen izenak gordetzen dira
		String katea;//izena
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
			for(String k:hotelak) {
				System.out.println(k);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hotelak;
	}
	
	public static String hotelInformazioaPantailaratu(String hotelIzena) {
		String informazioa = null;//hotelen informazioa gordetzeko
		Connection conexion = null;
		Statement s = null;
		

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT INFORMAZIOA FROM HOTELAK WHERE IZENA LIKE '"+hotelIzena+"'");
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
			for(String k:hiriak) {
				System.out.println(k);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hiriak;
	}
	
	
	//HOTELEN SERBITZUAK ATERA
	public String serbitzuakAtera() {
		String serbitzua = "";
		
		Connection conexion = null;
		Statement s = null;
		
		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT SERBITZUAK FROM HOTELAK");
				while (rs.next()) {
					serbitzua = rs.getString("serbitzuak");
				}
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
		return serbitzua; //itzultzen du ze zerbitzu daukagun
			
		
	}

}

