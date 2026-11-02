package ejercicio2;

import java.util.List;
import java.util.LinkedList;
import ejercicio1.GeneralTree;
import ejercicio8.Queue;

public class RecorridosAG {
	
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if (a != null && !a.isEmpty())
			imparesPreOrden(a,n,resultado);
		return resultado;
	}
	
	private void imparesPreOrden(GeneralTree<Integer> a, Integer n, List<Integer> l) {
		if (a.getData() > n && a.getData()%2 != 0)
			l.add(a.getData());
		if (a.hasChildren())
			for (GeneralTree<Integer> hijo: a.getChildren())
				imparesPreOrden(hijo,n,l);
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if (a != null && !a.isEmpty())
			imparesInOrden(a,n,resultado);
		return resultado;
	}
	
	private void imparesInOrden(GeneralTree<Integer> a, Integer n, List<Integer> l) {
		if (a.hasChildren())
			imparesInOrden(a.getChildren().get(0),n,l);
		if (a.getData() > n && a.getData()%2 != 0)
			l.add(a.getData());
		List<GeneralTree<Integer>> hijos = a.getChildren();
		for (int i = 1; i < hijos.size(); i++)
			imparesInOrden(hijos.get(i),n,l);
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if (a != null && !a.isEmpty())
			imparesPostOrden(a,n,resultado);
		return resultado;
	}
	
	private void imparesPostOrden(GeneralTree<Integer> a, Integer n, List<Integer> l) {
		if (a.hasChildren())
			for (GeneralTree<Integer> hijo: a.getChildren())
				imparesPostOrden(hijo,n,l);
		if (a.getData() > n && a.getData()%2 != 0)
			l.add(a.getData());
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles (GeneralTree<Integer> a, Integer n) {
		List<Integer> resultado = new LinkedList<Integer>();
		if (a != null && !a.isEmpty())
			imparesPorNiveles(a,n,resultado);
		return resultado;
	}
	
	private void imparesPorNiveles (GeneralTree<Integer> a, Integer n, List<Integer> l) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(a);
		while (!cola.isEmpty()) {
			GeneralTree<Integer> arbol = cola.dequeue();
			if (arbol.getData() > n && arbol.getData()%2 != 0)
				l.add(arbol.getData());
			for (GeneralTree<Integer> hijo : arbol.getChildren())
				cola.enqueue(hijo);
		}
	}
	
}
