package algoritmos;

import tadCola.Cola;
import tadCola.ColaVacia;

public class AlgoritmosCola {
	
	public static <T> void encolarPrimero(Cola<T> cola, T dato) {
		try {
			if(cola != null) {
				cola.invertirCola();
				encolarPrimeroR(cola, dato);
			}
			else
				System.err.println("No existe la cola");
		} catch (ColaVacia e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	private static <T> void encolarPrimeroR(Cola<T> cola, T dato) throws ColaVacia {
		if(!cola.colaVacia()) {
			T elem = cola.desencolar();
			encolarPrimeroR(cola, dato);
			cola.encolar(elem);
		}
		else
			cola.encolar(dato);
	}
	
	public static <T> int contar(Cola<T> cola) {
		return 0;
	}
	
	public static <T> void quitarUltimo(Cola<T> cola) {

		
	}

}
