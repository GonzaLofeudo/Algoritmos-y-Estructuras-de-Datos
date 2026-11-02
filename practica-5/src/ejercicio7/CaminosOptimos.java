package ejercicio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class CaminosOptimos {

	private static final int INFINITO = Integer.MAX_VALUE / 4;
	private final Graph<String> grafo;

	public CaminosOptimos(Graph<String> grafo) {
		this.grafo = grafo;
	}

	public List<String> caminoMasCortoDijkstra(String ciudad1, String ciudad2) {
		List<String> resultado = new ArrayList<>();
		Vertex<String> origen = this.buscarCiudad(ciudad1);
		Vertex<String> destino = this.buscarCiudad(ciudad2);
		if (origen != null && destino != null) {
			DijkstraResultado dijkstra = this.ejecutarDijkstra(origen);
			resultado = this.reconstruirCamino(dijkstra.predecesores, origen, destino);
		}
		return resultado;
	}

	public List<String> caminoMasCortoFloyd(String ciudad1, String ciudad2) {
		List<String> resultado = new ArrayList<>();
		Vertex<String> origen = this.buscarCiudad(ciudad1);
		Vertex<String> destino = this.buscarCiudad(ciudad2);
		if (origen != null && destino != null) {
			FloydResultado floyd = this.ejecutarFloyd();
			int i = origen.getPosition();
			int j = destino.getPosition();
			if (i >= 0 && j >= 0 && i < floyd.next.length && j < floyd.next.length && floyd.next[i][j] != -1) {
				int actual = i;
				resultado.add(this.grafo.getVertex(actual).getData());
				while (actual != j) {
					actual = floyd.next[actual][j];
					if (actual == -1) {
						resultado.clear();
						break;
					}
					resultado.add(this.grafo.getVertex(actual).getData());
				}
			}
		}
		return resultado;
	}

	private Vertex<String> buscarCiudad(String ciudad) {
		if (this.grafo == null || ciudad == null) {
			return null;
		}
		return this.grafo.search(ciudad);
	}

	private DijkstraResultado ejecutarDijkstra(Vertex<String> origen) {
		int n = this.grafo.getSize();
		int[] distancias = new int[n];
		int[] predecesores = new int[n];
		boolean[] visitados = new boolean[n];
		Arrays.fill(distancias, INFINITO);
		Arrays.fill(predecesores, -1);
		distancias[origen.getPosition()] = 0;

		for (int iteracion = 0; iteracion < n; iteracion++) {
			int actual = this.elegirNoVisitadoMasCercano(distancias, visitados);
			if (actual == -1) {
				break;
			}
			visitados[actual] = true;
			Vertex<String> verticeActual = this.grafo.getVertex(actual);
			List<Edge<String>> adyacentes = this.grafo.getEdges(verticeActual);
			for (int i = 0; i < adyacentes.size(); i++) {
				Edge<String> edge = adyacentes.get(i);
				Vertex<String> vecino = edge.getTarget();
				if (vecino != null) {
					int posVecino = vecino.getPosition();
					if (posVecino >= 0 && posVecino < n && !visitados[posVecino]) {
						int nuevaDistancia = distancias[actual] + edge.getWeight();
						if (nuevaDistancia < distancias[posVecino]) {
							distancias[posVecino] = nuevaDistancia;
							predecesores[posVecino] = actual;
						}
					}
				}
			}
		}

		return new DijkstraResultado(distancias, predecesores);
	}

	private int elegirNoVisitadoMasCercano(int[] distancias, boolean[] visitados) {
		int mejorPosicion = -1;
		int mejorDistancia = INFINITO;
		for (int i = 0; i < distancias.length; i++) {
			if (!visitados[i] && distancias[i] < mejorDistancia) {
				mejorDistancia = distancias[i];
				mejorPosicion = i;
			}
		}
		return mejorPosicion;
	}

	private List<String> reconstruirCamino(int[] predecesores, Vertex<String> origen, Vertex<String> destino) {
		List<String> resultado = new ArrayList<>();
		int actual = destino.getPosition();
		int inicio = origen.getPosition();
		if (actual < 0 || inicio < 0 || actual >= predecesores.length || inicio >= predecesores.length) {
			return resultado;
		}

		List<String> inverso = new ArrayList<>();
		while (actual != -1) {
			Vertex<String> vertice = this.grafo.getVertex(actual);
			if (vertice == null) {
				inverso.clear();
				break;
			}
			inverso.add(vertice.getData());
			if (actual == inicio) {
				break;
			}
			actual = predecesores[actual];
		}

		if (!inverso.isEmpty() && inverso.get(inverso.size() - 1).equals(origen.getData())) {
			for (int i = inverso.size() - 1; i >= 0; i--) {
				resultado.add(inverso.get(i));
			}
		} else {
			resultado.clear();
		}
		return resultado;
	}

	private FloydResultado ejecutarFloyd() {
		int n = this.grafo.getSize();
		int[][] distancias = new int[n][n];
		int[][] next = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					distancias[i][j] = 0;
					next[i][j] = j;
				} else {
					distancias[i][j] = INFINITO;
					next[i][j] = -1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
				Vertex<String> vertice = this.grafo.getVertex(i);
				if (vertice != null) {
					List<Edge<String>> adyacentes = this.grafo.getEdges(vertice);
					for (int k = 0; k < adyacentes.size(); k++) {
						Edge<String> edge = adyacentes.get(k);
						Vertex<String> vecino = edge.getTarget();
						if (vecino != null) {
							int j = vecino.getPosition();
							if (j >= 0 && j < n && edge.getWeight() < distancias[i][j]) {
								distancias[i][j] = edge.getWeight();
								next[i][j] = j;
							}
						}
					}
				}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (distancias[i][k] < INFINITO && distancias[k][j] < INFINITO) {
						int nuevaDistancia = distancias[i][k] + distancias[k][j];
						if (nuevaDistancia < distancias[i][j]) {
							distancias[i][j] = nuevaDistancia;
							next[i][j] = next[i][k];
						}
					}
				}
			}
		}

		return new FloydResultado(distancias, next);
	}

	private static class DijkstraResultado {
		@SuppressWarnings("unused")
		private final int[] distancias;
		private final int[] predecesores;

		private DijkstraResultado(int[] distancias, int[] predecesores) {
			this.distancias = distancias;
			this.predecesores = predecesores;
		}
	}

	private static class FloydResultado {
		@SuppressWarnings("unused")
		private final int[][] distancias;
		private final int[][] next;

		private FloydResultado(int[][] distancias, int[][] next) {
			this.distancias = distancias;
			this.next = next;
		}
	}
}
