package ejercicio4;

import ejercicio1.GeneralTree;
import ejercicio8.Queue;

public class AnalizadorArbol {
	
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa> arbol) {
		if (arbol != null && !arbol.isEmpty())
			return buscarMaximoPromedio(arbol);
		return 0;
	}
	
	private double buscarMaximoPromedio (GeneralTree<AreaEmpresa> a) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(a);
		double maxPromedio = 0;
		
		while (!cola.isEmpty()) {
			int cantNivel = cola.size();
			int suma = 0;
			
			for (int i = 0; i < cantNivel; i++) {
				GeneralTree<AreaEmpresa> arbol = cola.dequeue();
				suma += arbol.getData().getTardanza();
				
				for (GeneralTree<AreaEmpresa> hijo : arbol.getChildren())
					cola.enqueue(hijo);
			}
			
			double promedio = (double) suma / cantNivel;
			if (promedio > maxPromedio)
				maxPromedio = promedio;
		}
		
		return maxPromedio;
	}

}
