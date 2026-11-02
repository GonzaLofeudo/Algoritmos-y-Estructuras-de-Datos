package ejercicio7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
	
	public static void Prueba(Scanner sc) {
		List<Estudiante> l1 = new ArrayList<>();
		List<Estudiante> l2 = new ArrayList<>();
		
		String nombre;
		int legajo;
		double promedio;
		Estudiante e;
		
		for (int i = 0; i < 3; i++) {
			System.out.println("Ingrese nombre, legajo y promedio del alumno:");
			nombre = sc.next();
			legajo = sc.nextInt();
			promedio = sc.nextDouble();
			e = new Estudiante(nombre,legajo,promedio);
			l1.add(e);
		}
		
		for (int i = 0; i < 3; i++) {
			e = l1.get(i);
			l2.add(e);
		}
		
		System.out.println("Lista original:");
		l1.forEach(System.out::println);
		System.out.println("\nLista copia:");
		l2.forEach(System.out::println);
		
		l1.get(0).setPromedio(4.0);
		l2.get(1).setNombre("Mario");
		
		System.out.println("\nLista original:");
		l1.forEach(System.out::println);
		System.out.println("\nLista copia:");
		l2.forEach(System.out::println);
		
		nombre = sc.next();
		boolean esta = false;
		int i = 0;
		
		while ((i < 3) && !esta) {
			if (l1.get(i).getNombre().equals(nombre))
				esta = true;
			i++;
		}
		
		if (!esta) {
			legajo = sc.nextInt();
		    promedio = sc.nextDouble();
		    e = new Estudiante(nombre,legajo,promedio);
		    l1.add(e);
		}
	}
	
	public boolean esCapicua(ArrayList<Integer> lista) {
		int i = 0;
		int j = lista.size()-1;
		
		while (i < j) {
			if (!lista.get(i).equals(lista.get(j)))
				return false;
			i++;
			j--;
		}
		
		return true;
	}

}
