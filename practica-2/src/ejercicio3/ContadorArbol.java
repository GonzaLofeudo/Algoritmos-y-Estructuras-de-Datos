package ejercicio3;

import java.util.List;
import java.util.ArrayList;

import ejercicio1.BinaryTree;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
        this.arbol = arbol;
    }
	
	public List<Integer> numerosParesIn() {
		List<Integer> lista = new ArrayList<Integer>();
		inOrden(arbol,lista);
		return lista;
	}
	
	private void inOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo == null || nodo.isEmpty())
			return;
		if (nodo.hasLeftChild())
			inOrden(nodo.getLeftChild(),lista);
		if (nodo.getData()%2 == 0)
			lista.add(nodo.getData());
		if (nodo.hasRightChild())
			inOrden(nodo.getRightChild(),lista);
	}
	
	public List<Integer> numerosParesPost() {
		List<Integer> lista = new ArrayList<Integer>();
		postOrden(arbol,lista);
		return lista;
	}
	
	private void postOrden(BinaryTree<Integer> nodo, List<Integer> lista) {
		if (nodo == null || nodo.isEmpty())
			return;
		if (nodo.hasLeftChild())
			inOrden(nodo.getLeftChild(),lista);
		if (nodo.hasRightChild())
			inOrden(nodo.getRightChild(),lista);
		if (nodo.getData()%2 == 0)
			lista.add(nodo.getData());
	}
}
