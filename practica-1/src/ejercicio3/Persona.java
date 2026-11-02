package ejercicio3;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private String mail;
	
	public Persona(String nombre, String apellido, String mail) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String tusDatos() {
		String aux = "";
		aux += "Nombre: " + this.getNombre() + " | Apellido: " + this.getApellido() + " | Mail: " + this.getMail();
		return aux;
	}
}
