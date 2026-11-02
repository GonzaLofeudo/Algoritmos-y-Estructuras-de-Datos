package ejercicio2;

public class Generador {

	private Generador() {}
	
	public static int[] PrimerosMultiplos (int n) {
		int[] vector = new int[n];
		for (int i = 0; i < n; i++) {
			vector[i] = n*(i+1);
		}
		return vector;
	}
}