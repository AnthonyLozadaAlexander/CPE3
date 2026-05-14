package tadCola;

public class TadCola<T> implements Cola<T> {
	private NodoCola<T> principio;
	private NodoCola<T> fin;
	private String nombre;

	public TadCola() {
		principio = null;
		fin = null;
	}

	public TadCola(String nombre) {
		super();
		principio = null;
		fin = null;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean colaVacia() {
		return principio == null;
	}

	public void eliminarCola() {
		principio = null;
		fin = null;
	}

	public T primero() throws ColaVacia {
		if (colaVacia())
			throw new ColaVacia("La cola está vacía");
		else
			return principio.dato;
	}

	public void encolar(T x) {
		NodoCola<T> aux;
		aux = new NodoCola<>(x, null);
		if (principio == null) {
			principio = aux;
			fin = aux;
		} else {
			fin.siguiente = aux;
			fin = aux;
		}
	}

	public T desencolar() throws ColaVacia {
		if (colaVacia()) {
			throw new ColaVacia("Desencolar: La cola está vacía");
		} else {
			T resultado;
			resultado = principio.dato;
			principio = principio.siguiente;
			if (principio == null)
				fin = null;
			return resultado;
		}
	}

	public void quitarPrimero() throws ColaVacia {
		if (colaVacia()) {
			throw new ColaVacia("Quitar primero: La cola est� vac�a");
		} else {
			principio = principio.siguiente;
			if (principio == null)
				fin = null;
		}
	}

	public void mostrarEstadoCola() {
		System.out.println("Estado de la cola:");
		System.out.println("Número de elementos: " + this.numElemCola());
		if (!colaVacia()) {
			System.out.println("Primer elemento - Clave: " + principio.dato);
			System.out.println("Último elemento - Clave: " + fin.dato);
		}
	}

	public void imprimirCola() {
		NodoCola<T> aux;
		System.out.print("Estado de la cola " + this.getNombre() + ": ");
		aux = principio;
		while (aux != null) {
			System.out.print(aux.dato + " ");
			aux = aux.siguiente;
		}
		System.out.println();
	}

	public int numElemCola() {
		NodoCola<T> aux;
		int resul;

		aux = principio;
		resul = 0;
		while (aux != null) {
			++resul;
			aux = aux.siguiente;
		}
		return resul;
	}

	public void invertirCola() {
		T elem;
		if (!colaVacia()) {
			try {
				elem = desencolar();
				invertirCola();
				encolar(elem);
			} catch (ColaVacia e) {
				
			}
			
		}
	}
}
