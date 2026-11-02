package ejercicio1;

public interface Edge<T> {
	
	/**
	 * Retorna el vértice destino de la arista.
	 * 
	 * @return
	 */
	public Vertex<T> getTarget();

	/**
	 * Alias de {@link #getTarget()} para mantener compatibilidad con la
	 * especificación textual del TP.
	 *
	 * @return vértice destino de la arista
	 */
	default Vertex<T> target() {
		return getTarget();
	}
	
	/**
	 * Retorna el peso de la arista
	 * 
	 * @return
	 */
	public int getWeight();

}
