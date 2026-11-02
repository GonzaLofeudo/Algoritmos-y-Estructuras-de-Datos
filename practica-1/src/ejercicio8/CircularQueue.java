package ejercicio8;

public class CircularQueue<T> extends Queue<T> {
	
	public T shift() {
		T elem = data.remove(0);
		data.add(elem);
		return elem;
	}

}
