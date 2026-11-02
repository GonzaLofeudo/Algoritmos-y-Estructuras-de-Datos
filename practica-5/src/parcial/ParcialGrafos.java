package parcial;

import java.util.List;
import java.util.ArrayList;
import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class ParcialGrafos {

	public List<String> rutaOptimaDistribucion(Graph<String> reino, String castillo, String aldea, int maxPociones) {
		List<String> resultado = new ArrayList<>();
		if (reino != null && castillo != null && aldea != null && maxPociones >= 0) {
			Vertex<String> origen = reino.search(castillo);
			Vertex<String> destino = reino.search(aldea);
			if (origen != null && destino != null) {
				if (origen == destino) {
					resultado.add(origen.getData());
				} else {
					boolean[] visitados = new boolean[reino.getSize()];
					this.buscarCaminoOptimo(reino, origen, destino, visitados, new ArrayList<String>(), resultado, 0,maxPociones);
				}
			}
		}
		return resultado;
	}
	
	private void buscarCaminoOptimo(Graph<String> reino,Vertex<String> actual,Vertex<String> destino,boolean[] visitados,
									List<String> caminoActual,List<String> resultado,int pocionesActuales,int maxPociones) {
		int posicion = actual.getPosition();
		if (posicion >= 0 && posicion < visitados.length && !visitados[posicion] && pocionesActuales <= maxPociones) {
			visitados[posicion] = true;
			caminoActual.add(actual.getData());
			if (actual == destino) {
				if (caminoActual.size() > resultado.size()) {
					resultado.clear();
					resultado.addAll(caminoActual);
				}
			}
			else {
				List<Edge<String>> adyacentes = reino.getEdges(actual);
				for (int i = 0; i < adyacentes.size(); i++) {
					Edge<String> edge = adyacentes.get(i);
					Vertex<String> siguiente = edge.getTarget();
					if (siguiente != null) {
						int nuevasPociones = pocionesActuales + edge.getWeight();
						if (nuevasPociones <= maxPociones) {
							this.buscarCaminoOptimo(reino, siguiente, destino, visitados, caminoActual, resultado, nuevasPociones, maxPociones);
						}
					}
				}
			}
			caminoActual.remove(caminoActual.size() - 1);
			visitados[posicion] = false;
		}
	}
}
