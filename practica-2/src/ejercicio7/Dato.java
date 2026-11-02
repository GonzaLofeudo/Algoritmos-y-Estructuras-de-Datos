package ejercicio7;

public class Dato {
	private int suma;
    private int diferencia;

	public Dato(int suma, int diferencia) {
	    this.suma = suma;
	    this.diferencia = diferencia;
	}

	@Override
    public String toString() {
	    return "(" + suma + ", " + diferencia + ")";
	}
}
