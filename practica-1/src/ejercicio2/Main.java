package ejercicio2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Ingrese un número para crear el vector: ");
		int n = s.nextInt();
		int[] v = Generador.PrimerosMultiplos(n);
		for (int i = 0; i < n; i++) {
			System.out.println(v[i]);
		}
	}
}