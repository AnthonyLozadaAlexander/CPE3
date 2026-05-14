package principal;

import tadPila.TadPila;
import algoritmos.Algoritmos;
import tadCola.ColaVacia;
import tadCola.TadCola;

public class Principal {
	public static void main(String[] args) {
		Long start = System.nanoTime();
		Persona[] personas;
		TadPila<Persona> pilaAtendidos = new TadPila<>("atendidos");
		TadCola<Persona> colaNormal = new TadCola<>("normal");
		TadCola<Persona> colaTerceraEdad = new TadCola<>("tercera edad");
		int countTerceraEdad = 0;
		int countNormal = 0;
		int n = 100;
		personas = generarPersonas(n);

		// las 10 primeras personas que entran al centro
		for (int i = 0; i < 10; i++) {
			if (personas[i].getEdad() >= 65) {
				colaTerceraEdad.encolar(personas[i]);
			} else if (personas[i].getEdad() < 65) {
				colaNormal.encolar(personas[i]);
			}
		}

		// se atiende a las personas en la cola por cada 2 que ingresan
		for (int i = 10; i < 100; i += 2) {
			Persona atendido;
			if (personas[i].getEdad() >= 65) {
				colaTerceraEdad.encolar(personas[i]);
			} else {
				colaNormal.encolar(personas[i]);

			}

			if (personas[i + 1].getEdad() >= 65) {
				colaTerceraEdad.encolar(personas[i + 1]);
			} else {
				colaNormal.encolar(personas[i + 1]);
			}

			// se atiende a una persona de la colaTerceraEdad Primero, si no hay se atiende
			// a la colaNormal
			try { // hay que incluir el try catch para capturar excepcion de desencolar
				if (!colaTerceraEdad.colaVacia()) { // si no esta vacia la cola de tercera edad se atiende
													// primordialmente a la tercera edad
					atendido = colaTerceraEdad.desencolar();
					countTerceraEdad++;
					pilaAtendidos.apilar(atendido);
				} else { // si esta vacia la cola de tercera edad se atiende a la cola normal
					if (!colaNormal.colaVacia()) { // si la cola normal no esta vacia
						atendido = colaNormal.desencolar(); // se atiende a la persona de la cola normal
						countNormal++;
						pilaAtendidos.apilar(atendido); // se agrega a la pila de atendidos
					}
				}

			} catch (ColaVacia e) {
				System.err.println(e.getMessage());
			}
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("Se Ingresaron " + n + " Personas al centro de ayuda ");
		System.out.println("Se Atendieron a " + pilaAtendidos.numElemPila() + " Personas en  el centro de ayuda");
		if (countTerceraEdad > countNormal) {
			System.out.println("Se atendieron a " + countTerceraEdad + " personas de la tercera Edad " + " y "
					+ countNormal + " personas de la edad normal");
		} else {
			System.out.println("Se atendieron a " + countNormal + " personas de la edad normal " + " y "
					+ countTerceraEdad + " personas de la tercera edad");
		}

		System.out.println("----------------------------------------------------------------------------------");
		pilaAtendidos.imprimirPila();

		System.out.println("Quedan Por Atender " + colaTerceraEdad.numElemCola() + " personas de la tercera edad");
		colaTerceraEdad.imprimirCola();

		System.out.println("Quedan Por Atender " + colaNormal.numElemCola() + " personas de la edad normal");
		colaNormal.imprimirCola();
		
		System.out.println("----------------------------------------------------------------------------------");
		
		Long end = System.nanoTime();
		System.out.println("Tiempo De Ejecucion Total: " + (end - start) + " nanosegundos");
	}
	
	public static Persona[] generarPersonas(int n) {
		Persona[] personas = new Persona[n];
		for(int i = 0; i < n; i++) {
			personas[i] = new Persona(Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 90));
		}
		
		return personas;
	}
}
