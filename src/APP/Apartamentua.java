package APP;

public class Apartamentua extends Ostatua{
	
	private int id;
	private String izena;
	
	public Apartamentua(int id, String hiria, int id2, String izena) {
		super(id, hiria);
		id = id2;
		this.izena = izena;
	}

}