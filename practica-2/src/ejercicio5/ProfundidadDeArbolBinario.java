package ejercicio5;

import ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int sumaElementosProfundidad(int p) {
		return calcular(p,arbol,0);
	}
	
	private int calcular(int p, BinaryTree<Integer> nodo, int prof) {
		if (nodo == null || nodo.isEmpty())
			return 0;
		if (prof == p)
			return nodo.getData();
		int suma = 0;
		if (nodo.hasLeftChild())
			suma += calcular(p,nodo.getLeftChild(),prof+1);
		if (nodo.hasRightChild())
			suma += calcular(p,nodo.getRightChild(),prof+1);
		return suma;
	}
}
