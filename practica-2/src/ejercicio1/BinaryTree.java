package ejercicio1;

import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());
	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		if (this.isEmpty())
			return 0;
		if (this.isLeaf())
			return 1;
		int aux = 0;
		if (this.hasLeftChild())
			aux += this.getLeftChild().contarHojas();
		if (this.hasRightChild())
			aux += this.getRightChild().contarHojas();
		return aux;
	}

    public BinaryTree<T> espejo(){
    	if (this.isEmpty())
    		return new BinaryTree<T>();
    	BinaryTree<T> nuevo = new BinaryTree<T>();
    	if (this.hasLeftChild())
    		nuevo.addRightChild(this.getLeftChild().espejo());
    	if (this.hasRightChild())
    		nuevo.addLeftChild(this.getRightChild().espejo());
    	return nuevo;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (this.isEmpty())
			return;
		Queue<BinaryTree<T>> cola = new LinkedList<>();
		Queue<Integer> niveles = new LinkedList<>();
		cola.add(this);
		niveles.add(0);
		while (!cola.isEmpty()) {
	        BinaryTree<T> nodo = cola.remove();
	        int nivel = niveles.remove();
	        if (nivel >= n && nivel <= m)
	            System.out.println(nodo.getData());
	        if (nivel < m) { 
	            if (nodo.hasLeftChild()) {
	                cola.add(nodo.getLeftChild());
	                niveles.add(nivel + 1);
	            }
	            if (nodo.hasRightChild()) {
	                cola.add(nodo.getRightChild());
	                niveles.add(nivel + 1);
	            }
	        }
	    }
   }
}
