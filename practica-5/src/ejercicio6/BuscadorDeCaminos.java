package ejercicio6;

import java.util.ArrayList;
import java.util.List;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class BuscadorDeCaminos {

	private Graph<String> bosque;

	public BuscadorDeCaminos(Graph<String> bosque) {
		this.bosque = bosque;
	}

	public List<List<String>> recorridosMasSeguro() {
		List<List<String>> resultado = new ArrayList<>();
		if (this.bosque != null) {
			Vertex<String> origen = this.bosque.search("Casa Caperucita");
			Vertex<String> destino = this.bosque.search("Casa Abuelita");
			if (origen != null && destino != null) {
				boolean[] visitados = new boolean[this.bosque.getSize()];
				this.buscarCaminos(origen, destino, visitados, new ArrayList<String>(), resultado);
			}
		}
		return resultado;
	}

	private void buscarCaminos(Vertex<String> actual, Vertex<String> destino, boolean[] visitados,
			List<String> caminoActual, List<List<String>> resultado) {
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion]) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				resultado.add(new ArrayList<>(caminoActual));
			} else {
				List<Edge<String>> adyacentes = this.bosque.getEdges(actual);
				for (int i = 0; i < adyacentes.size(); i++) {
					Edge<String> edge = adyacentes.get(i);
					Vertex<String> siguiente = edge.getTarget();
					if (siguiente != null && edge.getWeight() < 5) {
						this.buscarCaminos(siguiente, destino, visitados, caminoActual, resultado);
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
	}
}
