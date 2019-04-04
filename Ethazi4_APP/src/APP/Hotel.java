package APP;

public class Hotel extends Ostatua{
	
	private int id;
	private String izena;
	private String informazioa;
	
	public Hotel(int id, String hiria, int id2, String izena, String informazioa) {
		super(id, hiria);
		id = id2;
		this.izena = izena;
		this.informazioa = informazioa;
	}
	
	

}
