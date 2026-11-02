package ejercicio3;

public class Profesor extends Persona {
	private int catedra;
	private String facultad;
	
	public Profesor(String nombre, String apellido, String mail, int catedra, String facultad) {
		super(nombre, apellido, mail);
		this.catedra = catedra;
		this.facultad = facultad;
	}

	public int getCatedra() {
		return catedra;
	}

    public void setCatedra(int catedra) {
		this.catedra = catedra;
	}

    public String getFacultad() {
		return facultad;
	}

    public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

    public String tusDatos() {
		String aux = "Profesor: " + super.tusDatos();
		aux += " | Catedra: " + this.getCatedra() + " | Facultad: " + this.getFacultad();
		return aux;
	}
}
