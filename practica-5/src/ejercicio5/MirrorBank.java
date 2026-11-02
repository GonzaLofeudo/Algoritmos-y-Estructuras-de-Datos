package ejercicio5;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ejercicio1.Edge;
import ejercicio1.Graph;
import ejercicio1.Vertex;

public class MirrorBank {

	public List<Persona> jubiladosCercanos(Graph<Persona> grafo, Persona empleado, int gradoSeparacion) {
		List<Persona> resultado = new ArrayList<>();
		if (grafo != null && empleado != null && empleado.isEmpleado() && gradoSeparacion >= 0) {
			Vertex<Persona> origen = grafo.search(empleado);
			if (origen != null) {
				boolean[] visitados = new boolean[grafo.getSize()];
				Deque<Nodo> cola = new ArrayDeque<>();
				Set<Persona> agregados = new HashSet<>();
				cola.addLast(new Nodo(origen, 0));
				visitados[origen.getPosition()] = true;

				while (!cola.isEmpty() && resultado.size() < 40) {
					Nodo actual = cola.removeFirst();
					Persona personaActual = actual.vertice.getData();

					if (actual.distancia > 0 && actual.distancia <= gradoSeparacion
							&& personaActual.isJubilado() && !personaActual.isCobroJubilacion()
							&& !agregados.contains(personaActual)) {
						resultado.add(personaActual);
						agregados.add(personaActual);
					}

					if (actual.distancia < gradoSeparacion) {
						List<Edge<Persona>> adyacentes = grafo.getEdges(actual.vertice);
						for (int i = 0; i < adyacentes.size(); i++) {
							Vertex<Persona> siguiente = adyacentes.get(i).getTarget();
							if (siguiente != null) {
								int posicion = siguiente.getPosition();
								if (posicion >= 0 && posicion < visitados.length && !visitados[posicion]) {
									visitados[posicion] = true;
									cola.addLast(new Nodo(siguiente, actual.distancia + 1));
								}
							}
						}
					}
				}
			}
		}
		return resultado;
	}

	private static class Nodo {
		private final Vertex<Persona> vertice;
		private final int distancia;

		private Nodo(Vertex<Persona> vertice, int distancia) {
			this.vertice = vertice;
			this.distancia = distancia;
		}
	}
}
