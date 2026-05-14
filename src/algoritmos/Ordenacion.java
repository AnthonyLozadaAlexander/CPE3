package algoritmos;

public class Ordenacion {
	private static void intercambiar(int[] vector, int a, int b) {
		int aux;
		
		aux = vector[a];
		vector[a] = vector[b];
		vector[b] = aux;
	}
	
	public static void bubbleSort(int[] vector) {
		boolean ordenado;

		for(int i=0; i<vector.length; ++i) {
			ordenado = true;
			for(int j=0; j<vector.length-1-i; ++j) {
				if(vector[j] > vector[j+1]) {
					intercambiar(vector, j, j+1);;
					ordenado = false;
				}
			}
			if(ordenado)
				i = vector.length;//salir del bucle de pasadas
		}
	}
	
	public static void bubbleSortR(int[] vector) {
		bubbleSortR(vector, 0);
	}
	
	private static void bubbleSortR(int[] vector, int i) {
		boolean ordenado;
		int aux;
		if(i<vector.length) { //condición de parada de las pasadas recursivas
			ordenado = true;
			for(int j=0; j<vector.length-1-i; ++j) {
				if(vector[j] > vector[j+1]) {
					aux = vector[j];
					vector[j] = vector[j+1];
					vector[j+1] = aux;
					ordenado = false;
				}
			}
			if(!ordenado)
				bubbleSortR(vector, i+1); //seguir pasando si no está ordenado: llamada recursiva
		}
	}
	
	public static void seleccion(int[] vector) {
		int indiceMenor, i, j, n;
		n = vector.length;
		for (i = 0; i < n - 1; i++) { // comienzo de la exploraci�n en �ndice i
			indiceMenor = i; // j explora la sublista a[i+1]..a[n-1]
			for (j = i + 1; j < n; j++)
				if (vector[j] < vector[indiceMenor])
					indiceMenor = j; // sit�a el elemento mas peque�o en a[i]
			if (i != indiceMenor)
				intercambiar(vector, i, indiceMenor);
		}
	}
	
	public static void seleccionR(int[] vector) {
		seleccionR(vector, 0);
	}
	
	private static void seleccionR(int[] vector, int i) {
		int indiceMenor, j, n;
		n = vector.length;
		if(i < n - 1) { // comienzo de la exploración en índice i
			indiceMenor = i; // j explora la sublista a[i+1]..a[n-1]
			for (j = i + 1; j < n; j++)
				if (vector[j] < vector[indiceMenor])
					indiceMenor = j; // sitúa el elemento mas pequeño en a[i]
			if (i != indiceMenor)
				intercambiar(vector, i, indiceMenor);
			seleccionR(vector, i+1);
		}
	}
	
	public static void insercion(int[] vector) {
		int i, j;
		int aux;
		for (i = 1; i < vector.length; i++) {
			/*
			 * índice j es para explorar la sublista a[i-1]..a[0] buscando la posici�n
			 * correcta del elemento destino
			 */
			j = i;
			aux = vector[i];
			// se localiza el punto de inserci�n explorando hacia abajo
			while (j > 0 && aux < vector[j - 1]) {
				// desplazar elementos hacia arriba para hacer espacio
				vector[j] = vector[j - 1];
				j--;
			}
			vector[j] = aux;
		}
	}
	
	public static void insercionR(int[] vector) {
		insercionR(vector, 1);
	}
	
	private static void insercionR(int[] vector, int i) {
		int j;
		int aux;
		if(i < vector.length) {
			/*
			 * índice j es para explorar la sublista a[i-1]..a[0] buscando la posici�n
			 * correcta del elemento destino
			 */
			j = i;
			aux = vector[i];
			// se localiza el punto de inserci�n explorando hacia abajo
			while (j > 0 && aux < vector[j - 1]) {
				// desplazar elementos hacia arriba para hacer espacio
				vector[j] = vector[j - 1];
				j--;
			}
			vector[j] = aux;
			insercionR(vector, i+1);
		}
	}
	
	public static void quickSort(int vector[])
	{
		quickSort(vector, 0, vector.length-1);
	}
	
	private static void quickSort(int vector[], int primero, int ultimo) {
		int i, j, central;
		int pivote;
		central = (primero + ultimo) / 2;
		pivote = vector[central];
		i = primero;
		j = ultimo;
		do {
			while (vector[i] < pivote)
				i++;
			while (vector[j] > pivote)
				j--;
			if (i <= j) {
				intercambiar(vector, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j)
			quickSort(vector, primero, j); // mismo proceso con sublista izqda
		if (i < ultimo)
			quickSort(vector, i, ultimo); // mismo proceso con sublista drcha
	}
}
