package ejercicio3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class Caminos {

	private final Graph<String> grafo;

	public Caminos(Graph<String> grafo) {
		this.grafo = grafo;
	}

	public List<String> devolverCamino(String ciudad1, String ciudad2) {
		List<String> resultado = new ArrayList<>();
		Vertex<String> origen = this.buscarCiudad(ciudad1);
		Vertex<String> destino = this.buscarCiudad(ciudad2);
		if (origen != null && destino != null) {
			boolean[] visitados = new boolean[this.grafo.getSize()];
			this.buscarCamino(origen, destino, visitados, new ArrayList<String>(), resultado);
		}
		return resultado;
	}

	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades) {
		List<String> resultado = new ArrayList<>();
		Set<String> excluidas = this.toSet(ciudades);
		Vertex<String> origen = this.buscarCiudad(ciudad1);
		Vertex<String> destino = this.buscarCiudad(ciudad2);
		if (origen != null && destino != null && !excluidas.contains(ciudad1) && !excluidas.contains(ciudad2)) {
			boolean[] visitados = new boolean[this.grafo.getSize()];
			this.buscarCaminoExceptuando(origen, destino, visitados, new ArrayList<String>(), resultado, excluidas);
		}
		return resultado;
	}

	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		List<String> resultado = new ArrayList<>();
		Vertex<String> origen = this.buscarCiudad(ciudad1);
		Vertex<String> destino = this.buscarCiudad(ciudad2);
		if (origen != null && destino != null) {
			boolean[] visitados = new boolean[this.grafo.getSize()];
			this.buscarCaminoMasCorto(origen, destino, visitados, new ArrayList<String>(), resultado, 0, new int[] { Integer.MAX_VALUE });
		}
		return resultado;
	}

	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		List<String> resultado = new ArrayList<>();
		Vertex<String> origen = this.buscarCiudad(ciudad1);
		Vertex<String> destino = this.buscarCiudad(ciudad2);
		if (origen != null && destino != null && tanqueAuto > 0) {
			boolean[] visitados = new boolean[this.grafo.getSize()];
			this.buscarSinCargar(origen, destino, visitados, new ArrayList<String>(), resultado, 0, tanqueAuto);
		}
		return resultado;
	}

	public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
		List<String> resultado = new ArrayList<>();
		Vertex<String> origen = this.buscarCiudad(ciudad1);
		Vertex<String> destino = this.buscarCiudad(ciudad2);
		if (origen != null && destino != null && tanqueAuto > 0) {
			boolean[] visitados = new boolean[this.grafo.getSize()];
			this.buscarConMenorCarga(origen, destino, visitados, new ArrayList<String>(), resultado, tanqueAuto, tanqueAuto, 0, new int[] { Integer.MAX_VALUE });
		}
		return resultado;
	}

	private Vertex<String> buscarCiudad(String ciudad) {
		if (this.grafo == null || ciudad == null) {
			return null;
		}
		return this.grafo.search(ciudad);
	}

	private Set<String> toSet(List<String> ciudades) {
		Set<String> resultado = new HashSet<>();
		if (ciudades != null) {
			resultado.addAll(ciudades);
		}
		return resultado;
	}

	private boolean buscarCamino(Vertex<String> actual, Vertex<String> destino, boolean[] visitados,
			List<String> caminoActual, List<String> resultado) {
		boolean encontrado = false;
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion]) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				resultado.clear();
				resultado.addAll(caminoActual);
				encontrado = true;
			} else {
				List<Edge<String>> adyacentes = this.grafo.getEdges(actual);
				for (int i = 0; i < adyacentes.size() && !encontrado; i++) {
					Vertex<String> siguiente = adyacentes.get(i).getTarget();
					if (siguiente != null) {
						encontrado = this.buscarCamino(siguiente, destino, visitados, caminoActual, resultado);
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
		return encontrado;
	}

	private boolean buscarCaminoExceptuando(Vertex<String> actual, Vertex<String> destino, boolean[] visitados,
			List<String> caminoActual, List<String> resultado, Set<String> excluidas) {
		boolean encontrado = false;
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion] && !excluidas.contains(actual.getData())) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				resultado.clear();
				resultado.addAll(caminoActual);
				encontrado = true;
			} else {
				List<Edge<String>> adyacentes = this.grafo.getEdges(actual);
				for (int i = 0; i < adyacentes.size() && !encontrado; i++) {
					Vertex<String> siguiente = adyacentes.get(i).getTarget();
					if (siguiente != null) {
						encontrado = this.buscarCaminoExceptuando(siguiente, destino, visitados, caminoActual, resultado, excluidas);
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
		return encontrado;
	}

	private void buscarCaminoMasCorto(Vertex<String> actual, Vertex<String> destino, boolean[] visitados,
			List<String> caminoActual, List<String> resultado, int pesoActual, int[] menorPeso) {
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion] && pesoActual < menorPeso[0]) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				if (pesoActual < menorPeso[0]) {
					menorPeso[0] = pesoActual;
					resultado.clear();
					resultado.addAll(caminoActual);
				}
			} else {
				List<Edge<String>> adyacentes = this.grafo.getEdges(actual);
				for (int i = 0; i < adyacentes.size(); i++) {
					Edge<String> edge = adyacentes.get(i);
					Vertex<String> siguiente = edge.getTarget();
					if (siguiente != null) {
						this.buscarCaminoMasCorto(siguiente, destino, visitados, caminoActual, resultado,
								pesoActual + edge.getWeight(), menorPeso);
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
	}

	private void buscarSinCargar(Vertex<String> actual, Vertex<String> destino, boolean[] visitados,
			List<String> caminoActual, List<String> resultado, int distanciaActual, int tanqueAuto) {
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion] && distanciaActual <= tanqueAuto) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				resultado.clear();
				resultado.addAll(caminoActual);
			} else {
				List<Edge<String>> adyacentes = this.grafo.getEdges(actual);
				for (int i = 0; i < adyacentes.size(); i++) {
					Edge<String> edge = adyacentes.get(i);
					Vertex<String> siguiente = edge.getTarget();
					int nuevaDistancia = distanciaActual + edge.getWeight();
					if (siguiente != null && nuevaDistancia <= tanqueAuto) {
						this.buscarSinCargar(siguiente, destino, visitados, caminoActual, resultado, nuevaDistancia, tanqueAuto);
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
	}

	private void buscarConMenorCarga(Vertex<String> actual, Vertex<String> destino, boolean[] visitados,
			List<String> caminoActual, List<String> resultado, int tanqueActual, int tanqueMaximo, int cargasActuales,
			int[] mejorCarga) {
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion] && cargasActuales <= mejorCarga[0]) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				if (cargasActuales < mejorCarga[0]) {
					mejorCarga[0] = cargasActuales;
					resultado.clear();
					resultado.addAll(caminoActual);
				}
			} else {
				List<Edge<String>> adyacentes = this.grafo.getEdges(actual);
				for (int i = 0; i < adyacentes.size(); i++) {
					Edge<String> edge = adyacentes.get(i);
					Vertex<String> siguiente = edge.getTarget();
					int peso = edge.getWeight();
					if (siguiente != null && peso <= tanqueMaximo) {
						if (peso <= tanqueActual) {
							this.buscarConMenorCarga(siguiente, destino, visitados, caminoActual, resultado,
									tanqueActual - peso, tanqueMaximo, cargasActuales, mejorCarga);
						} else {
							this.buscarConMenorCarga(siguiente, destino, visitados, caminoActual, resultado,
									tanqueMaximo - peso, tanqueMaximo, cargasActuales + 1, mejorCarga);
						}
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
	}
}
