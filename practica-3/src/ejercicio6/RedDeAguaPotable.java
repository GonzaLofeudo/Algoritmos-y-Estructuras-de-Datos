package ejercicio6;

import ejercicio1.GeneralTree;

public class RedDeAguaPotable {
	private GeneralTree<Character> red;
	
	public double minimoCaudal(double caudal) {
		double min = 0;
		if (this.red != null && !this.red.isEmpty())
			min = minimoCaudal(this.red, caudal);
		return min;
	}
	
	private double minimoCaudal(GeneralTree<Character> arbol, double caudal) {
		double min = caudal;
		if (!arbol.isLeaf()) {
			double caudalHijo = caudal / arbol.getChildren().size();
			min = Double.MAX_VALUE;
			for (GeneralTree<Character> hijo : arbol.getChildren())
				min = Math.min(min, minimoCaudal(hijo, caudalHijo));
		}
		return min;
	}
}
