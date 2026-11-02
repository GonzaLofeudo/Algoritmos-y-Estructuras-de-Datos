package ejercicio5;

public class Calcular {
	private static int max;
	private static int min;
	private static double prome;
	
    private Calcular() {}
	
	public static double[] Tradicional(int[] v) {
		double[] resultado = new double[3];
		
		int suma =  0, max = v[0], min = v[0];
		
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max) max = v[i];
			if (v[i] < min) min = v[i];
			suma += v[i];
		}
		
		double prome = (double) suma / v.length;
		
		resultado[0] = max;
		resultado[1] = min;
		resultado[2] = prome;
		
		return resultado;
	}
	
	public static void ConClase(int[] v, Resultado r) {
        int suma =  0, max = v[0], min = v[0];
		
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max) max = v[i];
			if (v[i] < min) min = v[i];
			suma += v[i];
		}
		
		double prome = (double) suma / v.length;
		
		r.setMax(max);
		r.setMin(min);
		r.setPromedio(prome);
	}
	
	public static void SinRetorno(int[] v) {
		int suma = 0;
        max = v[0];
        min = v[0];
		
		for (int i = 0; i < v.length; i++) {
			if (v[i] > max) max = v[i];
			if (v[i] < min) min = v[i];
			suma += v[i];
		}
		
		prome = (double) suma / v.length;
	}
	
	public static int getMax() {
		return max;
	}

	public static int getMin() {
		return min;
	}

	public static double getProme() {
		return prome;
	}
}
