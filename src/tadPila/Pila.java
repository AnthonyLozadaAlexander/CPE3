package tadPila;
//Revisado 29/09/2010

public interface Pila<T> {
	boolean pilaVacia ();
	void eliminarPila ();
	T cima () throws PilaVacia;
	void apilar (T x);
	T desapilar () throws PilaVacia;
	void decapitar () throws PilaVacia;
	void imprimirPila ();
	//void leerPila () throws NumberFormatException, IOException;
	int numElemPila ();
	String getNombre();
}

