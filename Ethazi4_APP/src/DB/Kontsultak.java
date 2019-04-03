package DB;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Kontsultak {
	
	public static void hotelPantailaratu() {
		String izena = null;//hotelen izenak gordetzen dira
		Connection conexion = null;
		Statement s = null;
		

		try {
			// Cargar el driver
			Class.forName("com.mysql.jdbc.Driver");
			conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ethazi4", "root", "");
			s = (Statement) conexion.createStatement();

			// Se realiza la consulta. Los resultados se guardan en el ResultSet rs

			ResultSet rs = ((java.sql.Statement) s).executeQuery("SELECT IZENA FROM HOTELAK");
			while (rs.next()) {

				izena = rs.getString("izena");
				System.out.println(izena);
				
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}

