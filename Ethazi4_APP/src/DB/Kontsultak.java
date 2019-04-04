package DB;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Kontsultak {
	
	public static ArrayList hotelPantailaratu() {
		String izena = null;//hotelen izenak gordetzen dira
		String helbidea;
		String informazioa = null;
		String katea;//izena+helbidea+informazioa
		Connection conexion = null;
		Statement s = null;
		ArrayList<String> hotelak = new ArrayList(); 
		

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IZENA,INFORMAZIOA FROM HOTELAK");
			while (rs.next()) {

				izena = rs.getString(1);
				informazioa = rs.getString(2);
				katea="Hotel: "+izena+", Informazioa: "+informazioa;
				hotelak.add(katea);
				
			}
			for(String k:hotelak) {
				System.out.println(k);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return hotelak;
	}

}

