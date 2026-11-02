package ejercicio8;

import java.util.List;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class RedNeuronal {

	public int neuronasActivadas(Graph<String> grafo, String inicio, int impulso) {
		if (grafo == null || inicio == null || impulso <= 0) {
			return 0;
		}

		Vertex<String> origen = grafo.search(inicio);
		if (origen == null) {
			return 0;
		}

		boolean[] visitados = new boolean[grafo.getSize()];
		return this.contarActivadas(grafo, origen, impulso, visitados);
	}

	private int contarActivadas(Graph<String> grafo, Vertex<String> actual, int impulso, boolean[] visitados) {
		int activadas = 0;
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion]) {
			visitados[posicion] = true;
			activadas = 1;

			List<Edge<String>> adyacentes = grafo.getEdges(actual);
			for (int i = 0; i < adyacentes.size(); i++) {
				Edge<String> sinapsis = adyacentes.get(i);
				Vertex<String> siguiente = sinapsis.getTarget();
				if (siguiente != null) {
					int nuevoImpulso = impulso - (impulso / 10);
					if (impulso > sinapsis.getWeight() && nuevoImpulso > 0) {
						activadas += this.contarActivadas(grafo, siguiente, nuevoImpulso, visitados);
					}
				}
			}
		}
		return activadas;
	}
}
