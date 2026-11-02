package ejercicio7;

public class Estudiante {
	private String nombre;
	private int legajo;
	private double promedio;
	
	public Estudiante(String nombre, int legajo, double promedio) {
		this.nombre = nombre;
		this.legajo = legajo;
		this.promedio = promedio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public double getPromedio() {
		return promedio;
	}

	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}

	@Override
	public String toString() {
		return "Estudiante: Nombre: " + nombre + " | Legajo: " + legajo + " | Promedio: " + promedio;
	}
}
