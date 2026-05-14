package principal;

import tadPila.TadPila;
import algoritmos.Algoritmos;
import tadCola.TadCola;

public class Principal {
	public static void main(String[] args) {
		Persona[] personas; 
		TadPila<Persona> pilaAtentidos = new TadPila<>("atentidos");
		TadCola<Persona> colaNormal = new TadCola<>("normal");
		TadCola<Persona> colaTerceraEdad = new TadCola<>("tercera edad");		
		personas = generarPersonas(100);
		
		// las 10 primeras personas que entran al centro
		for(int i = 0; i < 10; i++) {
			if(personas[i].getEdad() >= 60) {
				colaTerceraEdad.encolar(personas[i]);
			}else if(personas[i].getEdad() < 60) {
				colaNormal.encolar(personas[i]);
			}
		}
		
		
	}
	
	public static Persona[] generarPersonas(int n) {
		Persona[] personas = new Persona[n];
		for(int i = 0; i < n; i++) {
			personas[i] = new Persona(Algoritmos.cedulaAleatorio("El Oro"), Algoritmos.aleatorio(18, 90));
		}
		
		return personas;
	}
}
