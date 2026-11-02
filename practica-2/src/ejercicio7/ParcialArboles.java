package ejercicio7;

import ejercicio1.BinaryTree;

public class ParcialArboles {
	private BinaryTree<Integer> arbol;
	
	public ParcialArboles(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}
	
	public boolean isLeftTree(int num) {
		boolean[] encontrado = new boolean[1];
		boolean[] resultado = new boolean[1];
		calcular(arbol,num,encontrado,resultado);
		if (!encontrado[0])
			return false;
		return resultado[0];
	}
	
	private int calcular(BinaryTree<Integer> nodo, int num, boolean[] encontrado, boolean[] resultado) {
		if (nodo == null || nodo.isEmpty())
			return 0;
		int izq = 0;
		int der = 0;
		if (nodo.hasLeftChild())
			calcular(nodo,num,encontrado,resultado);
		if (nodo.hasRightChild())
			calcular(nodo,num,encontrado,resultado);
		int cant = ((nodo.hasLeftChild() ^ nodo.hasRightChild()) ? 1 : 0);
		if (nodo.getData() == num) {
			encontrado[0] = true;
			int valorIzq = nodo.hasLeftChild() ? izq : -1;
			int valorDer = nodo.hasRightChild() ? der : -1;
			resultado[0] = (valorIzq > valorDer);
		}
		return izq + der + cant;
	}
	
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1 == null || arbol1.isEmpty())
			return true;
		if (arbol2 == null || arbol2.isEmpty())
			return false;
		if (!arbol1.getData().equals(arbol2.getData()))
			return false;
		boolean izq = esPrefijo(arbol1.hasLeftChild()?arbol1.getLeftChild():null,arbol2.hasLeftChild()?arbol2.getLeftChild():null);
		boolean der = esPrefijo(arbol1.hasRightChild()?arbol1.getRightChild():null,arbol2.hasRightChild()?arbol2.getRightChild():null);
        return izq && der;
	}
	
	public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol) {
		if (arbol == null || arbol.isEmpty())
			return new BinaryTree<Dato>();
		return calcula(arbol,0,0);
	}
	
	private BinaryTree<Dato> calcula(BinaryTree<Integer> nodo,int suma, int padre) {
		if (nodo == null || nodo.isEmpty())
			return new BinaryTree<Dato>();
		int nuevaSuma = suma + nodo.getData();
		int diferencia = nodo.getData() - padre;
		BinaryTree<Dato> nuevo = new BinaryTree<>(new Dato(nuevaSuma,diferencia));
		if (nodo.hasLeftChild())
			nuevo.addLeftChild(calcula(nodo.getLeftChild(),nuevaSuma,nodo.getData()));
		if (nodo.hasRightChild())
			nuevo.addRightChild(calcula(nodo.getRightChild(),nuevaSuma,nodo.getData()));
		return nuevo;
	}
}
