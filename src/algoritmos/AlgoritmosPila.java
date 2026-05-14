package algoritmos;

import tadPila.Pila;
import tadPila.PilaVacia;

public class AlgoritmosPila {
	public static <T> void sumergir(Pila<T> pila, T dato) {		
		if(!pila.pilaVacia()) {
			T elem;
			try {
				elem = pila.desapilar();
				sumergir(pila, dato);
				pila.apilar(elem);
			} catch (PilaVacia e) {
				
			}			
		}
		else {
			pila.apilar(dato);
		}
	}
	
	
	public static <T> int contar(Pila<T> pila) {
		return 0;
	}
	
	public static <T> void invertirPila(Pila<T> pila) {
		
	}
	
}
