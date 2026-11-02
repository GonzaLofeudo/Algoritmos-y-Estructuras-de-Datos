package ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        
        System.out.println("Ingrese numeros (0 para terminar):");
        int num = sc.nextInt();

        while (num != 0) {
            lista.add(num);
            num = sc.nextInt();
        }

        System.out.println("Contenido de la lista:");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
		Test.Prueba(sc);

        sc.close();
	}
}
