package ejercicio4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class VisitaOslo {

	public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo, List<String> lugaresRestringidos) {
		List<String> resultado = new ArrayList<>();
		if (lugares != null && destino != null && maxTiempo >= 0) {
			Vertex<String> origen = lugares.search("Ayuntamiento");
			Vertex<String> fin = lugares.search(destino);
			Set<String> restringidos = this.toSet(lugaresRestringidos);
			if (origen != null && fin != null && !restringidos.contains("Ayuntamiento") && !restringidos.contains(destino)) {
				boolean[] visitados = new boolean[lugares.getSize()];
				this.buscarCamino(origen, fin, lugares, restringidos, visitados, new ArrayList<String>(), resultado, 0, maxTiempo);
			}
		}
		return resultado;
	}

	private boolean buscarCamino(Vertex<String> actual, Vertex<String> destino, Graph<String> lugares,
			Set<String> restringidos, boolean[] visitados, List<String> caminoActual, List<String> resultado,
			int tiempoActual, int maxTiempo) {
		boolean encontrado = false;
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion]
				&& !restringidos.contains(actual.getData()) && tiempoActual <= maxTiempo) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				resultado.clear();
				resultado.addAll(caminoActual);
				encontrado = true;
			} else {
				List<Edge<String>> adyacentes = lugares.getEdges(actual);
				for (int i = 0; i < adyacentes.size() && !encontrado; i++) {
					Edge<String> edge = adyacentes.get(i);
					Vertex<String> siguiente = edge.getTarget();
					if (siguiente != null) {
						int nuevoTiempo = tiempoActual + edge.getWeight();
						if (nuevoTiempo <= maxTiempo) {
							encontrado = this.buscarCamino(siguiente, destino, lugares, restringidos, visitados,
									caminoActual, resultado, nuevoTiempo, maxTiempo);
						}
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
		return encontrado;
	}

	private Set<String> toSet(List<String> lugaresRestringidos) {
		Set<String> resultado = new HashSet<>();
		if (lugaresRestringidos != null) {
			resultado.addAll(lugaresRestringidos);
		}
		return resultado;
	}
}
