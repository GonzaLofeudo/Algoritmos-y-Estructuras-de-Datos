package ejercicio2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class Recorridos<T> {

	public List<T> dfs(Graph<T> grafo) {
		List<T> resultado = new ArrayList<>();
		if (grafo == null || grafo.isEmpty()) {
			return resultado;
		}

		boolean[] visitados = new boolean[grafo.getSize()];
		for (int i = 0; i < grafo.getSize(); i++) {
			Vertex<T> vertex = grafo.getVertex(i);
			if (vertex != null && !visitados[vertex.getPosition()]) {
				dfsDesde(grafo, vertex, visitados, resultado);
			}
		}
		return resultado;
	}

	private void dfsDesde(Graph<T> grafo, Vertex<T> vertex, boolean[] visitados, List<T> resultado) {
		int posicion = vertex.getPosition();
		if (posicion < 0 || posicion >= visitados.length || visitados[posicion]) {
			return;
		}

		visitados[posicion] = true;
		resultado.add(vertex.getData());

		for (Edge<T> edge : grafo.getEdges(vertex)) {
			Vertex<T> vecino = edge.getTarget();
			if (vecino != null) {
				dfsDesde(grafo, vecino, visitados, resultado);
			}
		}
	}

	public List<T> bfs(Graph<T> grafo) {
		List<T> resultado = new ArrayList<>();
		if (grafo == null || grafo.isEmpty()) {
			return resultado;
		}

		boolean[] visitados = new boolean[grafo.getSize()];
		Deque<Vertex<T>> cola = new ArrayDeque<>();

		for (int i = 0; i < grafo.getSize(); i++) {
			Vertex<T> inicio = grafo.getVertex(i);
			if (inicio != null) {
				int posicionInicio = inicio.getPosition();
				if (posicionInicio >= 0 && posicionInicio < visitados.length && !visitados[posicionInicio]) {
					visitados[posicionInicio] = true;
					cola.addLast(inicio);

					while (!cola.isEmpty()) {
						Vertex<T> actual = cola.removeFirst();
						resultado.add(actual.getData());

						for (Edge<T> edge : grafo.getEdges(actual)) {
							Vertex<T> vecino = edge.getTarget();
							if (vecino != null) {
								int posicionVecino = vecino.getPosition();
								if (posicionVecino >= 0 && posicionVecino < visitados.length && !visitados[posicionVecino]) {
									visitados[posicionVecino] = true;
									cola.addLast(vecino);
								}
							}
						}
					}
				}
			}
		}

		return resultado;
	}
}
