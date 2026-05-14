package algoritmos;

public class Busqueda {
	public static int busquedaBinaria(int dato, int[] vector) {
		int centro, inf=0, sup=vector.length-1;
		int resul = -1;
		while(inf<=sup) {
			centro = (inf+sup)/2;
			if(vector[centro] == dato) {
				resul = centro;
				inf = sup+1; //salida lógica del lazo si ya lo encontró
			}
			else
				if(vector[centro] > dato)
					sup = centro - 1;
				else
					inf = centro + 1;
		}
		return resul;
	}
	
	public static int busquedaBinariaR(int dato, int[] vector) {
		return busquedaBinariaR(dato, vector, 0, vector.length-1);
	}
	
	private static int busquedaBinariaR(int dato, int[] vector, int inf, int sup) {
		int centro;
		int resul = -1;
		
		if(inf<=sup) {
			centro = (inf+sup)/2;
			if(vector[centro] == dato) {
				resul = centro;
				inf = sup+1; //salida lógica del lazo si ya lo encontró
			}
			else
				if(vector[centro] > dato)
					sup = centro - 1;
				else
					inf = centro + 1;
			resul = busquedaBinariaR(dato, vector, inf, sup);
		}
		return resul;
	}
	
	public static int busquedaSecuencial(int dato, int[] vector) {
		int pos = 0, resul = -1;
		while(pos<=vector.length-1) {
			if(vector[pos] == dato) {
				resul = pos;
				pos = vector.length; //salida l�gica del lazo
			}
			else
				++pos;
		}
		return resul;
	}	
	
	public static int busquedaSecuencialR(int dato, int[] vector) {
		return busquedaSecuencialR(dato, vector, 0);
	}
	
	private static int busquedaSecuencialR(int dato, int[] vector, int pos) {
		int resul = -1;
		if(pos<=vector.length-1) {
			if(vector[pos] == dato)
				resul = pos;
			else
				resul = busquedaSecuencialR(dato, vector, pos+1);
		}
		return resul;
	}	
}
