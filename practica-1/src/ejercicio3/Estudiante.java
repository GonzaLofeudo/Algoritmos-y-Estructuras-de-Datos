package ejercicio3;

public class Estudiante extends Persona {
	private int comision;
	private String direccion;
	
	public Estudiante(String nombre, String apellido, String mail, int comision, String direccion) {
		super(nombre, apellido, mail);
		this.comision = comision;
		this.direccion = direccion;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String tusDatos() {
		String aux = "Estudiante: " + super.tusDatos();
		aux += " | Comisión: " + this.getComision() + " | Dirección: " + this.getDireccion();
		return aux;
	}
}
