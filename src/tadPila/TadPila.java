package tadPila;

public class TadPila<T> implements Pila<T> {
	NodoPila<T> pila;
	private String nombre;
	
	public TadPila () {
		pila = null;
		nombre = "";
	}

    public TadPila(String nombre) {
		super();
		pila = null;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean pilaVacia () {
      	return pila == null;
    }
        
    public void eliminarPila () {
      	pila = null;
    }

    public T cima () throws PilaVacia {
    	if (pilaVacia ())
       		throw new PilaVacia ("La pila está vacía");
    	else
    		return pila.dato;
    }
        
    public void apilar (T dato) {
        pila = new NodoPila<> (dato, pila);
    }

    public T desapilar () throws PilaVacia {
        T resultado;
        if (pilaVacia ()) {  
             throw new PilaVacia ("Desapilar: La pila está vacía");
        }
        else {
	        resultado = pila.dato;
	        pila = pila.siguiente;
	        return resultado;
        }
    }

    public void decapitar () throws PilaVacia {
        if (pilaVacia ()) {  
             throw new PilaVacia ("Decapitar: La pila está vacía");
        }
        else
        	pila = pila.siguiente;
    }

    public void imprimirPila () {
        NodoPila<T> aux;
        System.out.print ("Estado de la pila "+this.getNombre()+": ");
        aux = pila;
        while (aux != null) {
            System.out.print (aux.dato + " ");
            aux = aux.siguiente;
        }
        System.out.println ();
    }
        
    public int numElemPila () {
        NodoPila<T> aux;	
        int resul;
        
        aux = pila;
        resul = 0;
        while (aux != null) {
         	++resul;
        	aux = aux.siguiente;
        }
        return resul;
    }
}