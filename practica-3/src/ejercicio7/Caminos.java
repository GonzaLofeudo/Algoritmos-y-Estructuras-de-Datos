package ejercicio7;

import java.util.List;
import java.util.LinkedList;

import ejercicio1.GeneralTree;

public class Caminos {
	private GeneralTree<Integer> arbol;
	
	public List<Integer> caminoAHojaMasLejana() {
		List<Integer> lista = new LinkedList<Integer>();
		if (this.arbol != null && !this.arbol.isEmpty())
			buscarCamino(this.arbol, lista, new LinkedList<Integer>(), 0);
		return lista;
	}
	
	private int buscarCamino(GeneralTree<Integer> arbol, List<Integer> resultado, List<Integer> caminoActual, int largoMaximo) {
		caminoActual.add(arbol.getData());
		if (arbol.isLeaf()) {
			if (caminoActual.size() > largoMaximo) {
				largoMaximo = caminoActual.size();
				resultado.clear();
				resultado.addAll(caminoActual);
			}
		}
		else
			for (GeneralTree<Integer> hijo : arbol.getChildren())
				largoMaximo = buscarCamino(hijo,resultado,caminoActual,largoMaximo);
		caminoActual.remove(caminoActual.size()-1);
		return largoMaximo;
	}

}
