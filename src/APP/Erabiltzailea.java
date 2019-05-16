package APP;

public class Erabiltzailea {
	
	private String Dni;
	private String Nombre;
	private String Apellido;
	private String fecha_nac;
	private String Sexo;
	private String Contraseña;
	
	public Erabiltzailea (String Dni, String Nombre, String Apellido, String fecha_nac, String Sexo, String Contraseña) {
		this.Apellido = Apellido;
		this.Contraseña = Contraseña;
		this.Dni = Dni;
		this.fecha_nac = fecha_nac;
		this.Nombre = Nombre;
		this.Sexo = Sexo;
	}

	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
}