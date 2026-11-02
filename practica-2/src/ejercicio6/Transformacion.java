package ejercicio6;

import ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public Transformacion(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public BinaryTree<Integer> suma() {
		transformar(arbol);
		return arbol;
	}
	
	private int transformar(BinaryTree<Integer> nodo) {
		if (nodo == null || nodo.isEmpty())
			return 0;
		int sumaIzq = 0;
		int sumaDer = 0;
		if (nodo.hasLeftChild())
			sumaIzq += transformar(nodo.getLeftChild());
		if (nodo.hasRightChild())
			sumaDer += transformar(nodo.getRightChild());
		int val = nodo.getData();
		nodo.setData(sumaIzq + sumaDer);
		return sumaIzq + sumaDer + val;
	}

}
