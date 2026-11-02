package ejercicio7;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ejercicios {
	
	public static List<Integer> CalcularSucesion(int n) {
		
		List<Integer> lista = new ArrayList<>();
		lista.add(n);
		
		if (n != 1) {
			if (n % 2 == 2)
				lista.addAll(CalcularSucesion(n/2));
			else
				lista.addAll(CalcularSucesion(n*3 + 1));
		}
		
		return lista;
		
	}
	
	public void IvertirArrayList (ArrayList<Integer> lista) {
		invertir(lista,0,lista.size()-1);
	}
	
	private void invertir (ArrayList<Integer> lista, int i, int j) {
		if (i < j) {
			int aux = lista.get(i);
			lista.set(i,lista.get(j));
			lista.set(j,aux);
			invertir(lista,i+1,j-1);
		}
	}
	
	public static int sumarLinkedList (LinkedList<Integer> lista) {
		return suma(0,lista);
	}
	
	private static int suma(int i,LinkedList<Integer> lista) {
		if (i < lista.size())
			return lista.get(i) + suma(i+1,lista);
		else
			return 0;
	}
	
	public static ArrayList<Integer> combinarOrdenado (ArrayList<Integer> lista1,ArrayList<Integer> lista2) {
		ArrayList<Integer>  res = new ArrayList<>();
		
		int i = 0, j = 0;
		
		while ((i < lista1.size()) && (j < lista2.size())) {
			if (lista1.get(i) <= lista2.get(j)) {
				res.add(lista1.get(i));
				i++;
			}
			else {
				res.add(lista2.get(j));
				j++;
			}
		}
		
		while (i < lista1.size()) {
			res.add(lista1.get(i));
			i++;
		}
		
		while (j < lista2.size()) {
			res.add(lista2.get(j));
			j++;
		}
		
		return res;
	}

}
