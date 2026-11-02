package ejercicio4;

import ejercicio1.BinaryTree;

public class RedBinariaLlena {
	private BinaryTree<Integer> arbol;
	
	public RedBinariaLlena(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public int retardoReenvio() {
		if (arbol == null || arbol.isEmpty())
			return 0;
		return calcularRetardo(arbol);
	}

	private int calcularRetardo(BinaryTree<Integer> nodo) {
		if (nodo.isLeaf())
			return nodo.getData();
		int maxIzq = 0;
		int maxDer = 0;
		if (nodo.hasLeftChild())
			maxIzq = calcularRetardo(nodo.getLeftChild());
		if (nodo.hasRightChild())
			maxDer = calcularRetardo(nodo.getRightChild());
		return nodo.getData() + Math.max(maxIzq,maxDer);
	}
}
