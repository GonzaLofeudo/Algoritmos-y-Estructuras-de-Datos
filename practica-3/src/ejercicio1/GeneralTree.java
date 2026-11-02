package ejercicio1;

import java.util.LinkedList;
import java.util.List;
import ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		if (children != null)
			this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		int max = -1;
		for (GeneralTree<T> hijo : this.getChildren())
		    max = Math.max(max, hijo.altura());
		return max + 1;
	}
	
	public int nivel(T dato){
		if (this.getData() != null && this.getData().equals(dato))
		    return 0;
		for (GeneralTree<T> hijo : this.getChildren()) {
			int nivelHijo = hijo.nivel(dato);
			if (nivelHijo != -1)
				return nivelHijo + 1;
		}
		return -1;
	  }

	public int ancho(){
		if (this.isEmpty())
			return 0;
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		int max = 0;
		cola.enqueue(this);
		while (!cola.isEmpty()) {
			int cantNivel = cola.size();
			if (cantNivel > max)
				max = cantNivel;
			for (int i = 0; i < cantNivel; i++) {
				GeneralTree<T> arbol = cola.dequeue();
				for (GeneralTree<T> hijo : arbol.getChildren())
					cola.enqueue(hijo);
			}
		}
		return max;
	}
	
	public boolean esAncestro(T a, T b) {
		boolean ok = false;
		if (!this.isEmpty()) {
			if (this.getData() != null && this.getData().equals(a))
			    ok = busquedaB(b);
			else {
				int i = 0;
				while (i < this.getChildren().size() && !ok) {
					ok = this.getChildren().get(i).esAncestro(a,b);
					i++;
				}
			}
		}
		return ok;
	}
	
	private boolean busquedaB(T b) {
		boolean ok = false;
		if (this.getData() != null && this.getData().equals(b))
			ok = true;
		else {
			int i = 0;
			while (i < this.getChildren().size() && !ok) {
				ok = this.getChildren().get(i).busquedaB(b);
				i++;
			}
		}
		return ok;
	}
}
