package ejercicio5;

public class Persona {
	private final String nombre;
	private final String domicilio;
	private final boolean empleado;
	private final boolean jubilado;
	private final boolean cobroJubilacion;

	public Persona(String nombre, String domicilio, boolean empleado, boolean jubilado, boolean cobroJubilacion) {
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.empleado = empleado;
		this.jubilado = jubilado;
		this.cobroJubilacion = cobroJubilacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public boolean isEmpleado() {
		return empleado;
	}

	public boolean isJubilado() {
		return jubilado;
	}

	public boolean isCobroJubilacion() {
		return cobroJubilacion;
	}
}
