package ejercicio9;

import java.util.List;
import java.util.LinkedList;
import ejercicio1.GeneralTree;
import ejercicio8.Queue;

public class ParcialArboles {
	
	public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
		boolean resultado = false;
		if (arbol != null && !arbol.isEmpty()) {
			resultado = busqueda(arbol);
		}
		return resultado;
	}
	
	private static boolean busqueda(GeneralTree<Integer> arbol) {
		boolean resultado = true;
		if (!arbol.isLeaf()) {
			int min = Integer.MAX_VALUE;
			for (GeneralTree<Integer> hijo : arbol.getChildren())
				min = Math.min(min,hijo.getData());
			if (min != arbol.getData())
				resultado = false;
		}
		List<GeneralTree<Integer>> hijo = arbol.getChildren();
		int i = 0;
		while (i < hijo.size() && resultado) {
			resultado = busqueda(hijo.get(i));
			i++;
		}
		return resultado;
	}
	
	public static List<Integer> resolver(GeneralTree<Integer> arbol) {
		List<Integer> lista = new LinkedList<Integer>();
		if (arbol != null && !arbol.isEmpty())
			recorrer(arbol,lista,new LinkedList<Integer>(),0,Integer.MIN_VALUE,0);
		return lista;
	}
	
	private static int recorrer(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> caminoActual,int sumaActual, int maximo, int nivel) {
		if (arbol.getData() == 1) {
			sumaActual += nivel;
			caminoActual.add(arbol.getData());
		}
		if (arbol.isLeaf()) {
			if (sumaActual > maximo) {
				maximo = sumaActual;
				resultado.clear();
				resultado.addAll(caminoActual);
			}
		}
		else
			for (GeneralTree<Integer> hijo : arbol.getChildren())
				maximo = recorrer(hijo,resultado,caminoActual,sumaActual,maximo,nivel+1);
		if (arbol.getData() == 1)
			caminoActual.remove(caminoActual.size()-1);
		return maximo;
	}
	
	public static boolean resuelve(GeneralTree<Integer> arbol ) {
		boolean resultado = false;
		if (arbol != null && !arbol.isEmpty())
			resultado = recorre(arbol);
		return resultado;
	}
	
	private static boolean recorre(GeneralTree<Integer> arbol) {
		boolean resultado = true;
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		int nivel = 0;
		while (!cola.isEmpty() && resultado) {
			List<GeneralTree<Integer>> nodos = new LinkedList<GeneralTree<Integer>>();
    		while (!cola.isEmpty())
	    		nodos.add(cola.dequeue());
		    if (nodos.size() == nivel + 1) {
		    	int i = 0;
		    	while (i < nodos.size()) {
		    		for (GeneralTree<Integer> hijos : nodos.get(i).getChildren())
		    			cola.enqueue(hijos);
		    		i++;
		    	}
		    	nivel++;
		    }
		    else
		    	resultado = false;
		}
		return resultado;
	}
}
