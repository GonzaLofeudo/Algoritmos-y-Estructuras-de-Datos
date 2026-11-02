package ejercicio9;

import java.util.Stack;

public class TestBalanceo {
	
	public boolean estaBalanceado(String s) {
		Stack<Character> pila = new Stack<>();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if ((c == '(') || (c == '[') || (c == '{'))
				pila.push(c);
			else {
				if ((pila.isEmpty()) || (!coincide(pila.pop(),c)))
					return false;
			}
		}
		return pila.isEmpty();
	}
	
	private boolean coincide(char c, char v) {
		return ((c == '(') && (v == ')') || (c == '[') && (v == ']') || (c == '{') && (v == '}'));
	}

}
