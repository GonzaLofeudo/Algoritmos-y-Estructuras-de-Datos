package ejercicio5;

public class Main {

	public static void main(String[] args) {
		int[] v = new int[6];
		v[0] = 4;
		v[1] = 1;
		v[2] = 2;
		v[3] = 10;
		v[4] = 7;
		v[5] = 2;
		
		double[] vR = new double[3];
		
		vR = Calcular.Tradicional(v);
		
		System.out.println("Máximo: " + vR[0] + " | Mínimo: " + vR[1] + " | Promedio: " + vR[2]);
		
		Resultado r = new Resultado();
		
		Calcular.ConClase(v, r);
		
		System.out.println("Máximo: " + r.getMax() + " | Mínimo: " + r.getMin() + " | Promedio: " + r.getPromedio());
		
		Calcular.SinRetorno(v);
		
		System.out.println("Máximo: " + Calcular.getMax() + " | Mínimo: " + Calcular.getMin() + " | Promedio: " + Calcular.getProme());
	}

}
