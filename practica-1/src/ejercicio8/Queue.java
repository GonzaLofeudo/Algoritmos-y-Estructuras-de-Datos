package ejercicio8;

import java.util.List;
import java.util.ArrayList;

public class Queue<T> extends Sequence{
	List<T> data;

	public Queue() {
		this.data = new ArrayList<>();
	}
	
	public void enqueue(T dato) {
		data.add(dato);
	}
	
	public T dequeue() {
		return data.remove(0);
	}
	
	public T head() {
		return data.get(0);
	}
	
	@Override
	public int size() {
		return data.size();
	}
	
	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	@Override
	public String toString() {
		return data.toString();
	}

}
