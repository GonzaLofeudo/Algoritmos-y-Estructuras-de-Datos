package ejercicio1;

public class Numerador {
	
	public static void NumerarFor(int a, int b) {
		if (a <= b)
			for (int i = a; i <= b; i++)
			  System.out.println(i);
		else
			for (int i = a; i >= b; i--)
				System.out.println(i);
	}
	
	public static void NumerarWhile(int a, int b) {
		int i = a;
		if (a <= b)
			while (i <= b) {
				System.out.println(i);
				i++;
			}
		else
			while (i >= b) {
			    System.out.println(i);
			    i--;
		    }
	}
	
	public static void NumerarRecursivo(int a, int b) {
		System.out.println(a);
		if (a < b)
			NumerarRecursivo(a+1,b);
		else
			if (a > b)
				NumerarRecursivo(a-1, b);
	}
}
