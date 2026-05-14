package algoritmos;

public class Algoritmos {	
	/**
	 * Genera un número entero aleatorio en un rango, entre <em>m</em> y <em>n</em> (<em>m</em> &lt; <em>n</em>).
	 * @param m Valor inicial del rango
	 * @param n Valor final del rango
	 * @return Número entero aleatorio en el rango dado
	 */
	public static int aleatorio(int m, int n) {
		return (int)redondearDecimales(Math.random()*(n-m)+m, 0);
	}
	
	/**
	 * Genera un número real aleatorio en un rango, entre <em>m</em> y <em>n</em> (<em>m</em> &lt; <em>n</em>) con un n�mero de decimales dado.
	 * @param m Valor inicial del rango
	 * @param n Valor final del rango
	 * @param numeroDecimales Número de decimales que se requieren en el número generado
	 * @return Número real aleatorio en el rango y con n�mero de decimales dados
	 */
	public static double aleatorio(int m, int n, int numeroDecimales) {
		return redondearDecimales(Math.random()*(n-m)+m, numeroDecimales);
	}
	
	/**
	 * Redondea un número real <em>valor</em> al n�mero de decimales <em>numeroDecimales</em> dado.
	 * @param valor Número real a redondear
	 * @param numeroDecimales Número de decimales que se requieren
	 * @return Número real redondeado al número de decimales dado
	 */
	public static double redondearDecimales(double valor, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valor;
		parteEntera = Math.floor(resultado);
		resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
		resultado=Math.round(resultado);
		resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
		return resultado;
	}
	
	/**
	 * Genera el dígito verificador que valida una cédula. 
	 * Solo se requieren los primeros 9 dígitos de la cédula. 
	 * @param cedula9 Los primeros 9 dígitos de una cédula
	 * @return Dígito verificador que es el décimo dígito de la cédula
	 */
	public static int generarVerificadorDeCedula(String cedula9) {
		int verificador, tercerDigito;
		int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
		int suma, digito;
		
		try {

			if (cedula9.length() == 9) // Solo 9 d�gitos el d�cimo es el verificador
			{
				tercerDigito = Integer.parseInt(cedula9.substring(2, 3));
				if (tercerDigito < 6) {
					// Coeficientes de validaci�n c�dula
					// El d�cimo d�gito se lo considera d�gito verificador
					suma = 0;
					digito = 0;
					for (int i = 0; i < cedula9.length(); i++) {
						digito = Integer.parseInt(cedula9.substring(i, i + 1))* coefValCedula[i];
						suma += ((digito % 10) + (digito / 10));
					}
					if (suma % 10 == 0) {
						verificador = suma % 10;
					}
					else{
						verificador = 10 - (suma % 10);
					} 
				}else {
					verificador = -1;
				}
			}else {
				verificador = -1;
			}
		} catch (NumberFormatException nfe) {
			verificador = -1;
		} catch (Exception err) {
			System.out.println("Una excepcion ocurrió en el proceso de generación");
			verificador = -1;
		}
		return verificador;
	}
	
	/**
	 * Genera un número de cédula por provincia (código de 2 caracteres)
	 * @param provincia Código de provincia. Para El Oro es 07
	 * @return Un número de cédula aleatorio de la provincia
	 */
	public static String cedulaAleatorio(String provincia) {
		StringBuffer cedula9 = new StringBuffer();
		int decimoDigito;

		do {
			cedula9.delete(0, cedula9.length()); //vacía el StringBuffer
			for(int i=3; i<=9; ++i) { //genera 9 dígitos
				cedula9.append((int)aleatorio(0,9,0)); //del 0 al 9
			}
			cedula9.insert(0, provincia);
			decimoDigito = generarVerificadorDeCedula(cedula9.toString());
		}while(decimoDigito < 0);
		return cedula9.toString() + decimoDigito;
	}
	
	/**
	 * Genera un número de cédula aleatorio de acuerdo a las 24 provincias.
	 * Utiliza una clase Enum Provincia con el código de cada una.
	 * @return Un número de cédula aleatorio de una de las 24 provincias
	 */
	public static String cedulaAleatorio() {
		int provincia;
		
		provincia = aleatorio(1, Provincia.values().length);
		if(provincia < 10)
			return cedulaAleatorio("0" + String.valueOf(provincia));
		else
			return cedulaAleatorio(String.valueOf(provincia));			
	}
	
	/**
	 * M�todo para verificar si una cédula es válida.
	 * @param cedula Cédula a verificar su validez.
	 * @return true si la cédula es válida y false si la cédula no es válida.
	 */
	public static boolean verificaCedula(String cedula) {
		int digitoVerificador = generarVerificadorDeCedula(cedula.substring(0, cedula.length()-1));
		int decimoDigito = Character.getNumericValue(cedula.charAt(9));
		return digitoVerificador==decimoDigito;
	}
	
	/**
	 * Genera de manera aleatoria una letra mayúscula entre A y Z
	 * @return Letra mayúscula aleatoria
	 */
	public static char letraMayAleatoria() {
		return (char)aleatorio(65, 90);
	}
	
	/**
	 * Genera de manera aleatoria una letra minúscula entre a y z
	 * @return Letra minúscula aleatoria
	 */
	public static char letraMinAleatoria() {
		return (char)aleatorio(97, 122);
	}
	
	/**
	 * Genera un n�mero de placa de vehículo aleatoria
	 * @return Número de placa de la forma AAA-0000
	 */
	public static String generarPlacaAleatoria() {
		StringBuffer placa = new StringBuffer();
		for(int i=1; i<=3; ++i)
			placa.append(Provincia.values()[aleatorio(0, 23)].getCodigo());
		placa.append('-');
		for(int i=1; i<=4; ++i)
			placa.append(aleatorio(0, 9));
		return placa.toString();
	}
	
	/**
	 * Genera un número de placa de vehículo aleatoria,
	 * de acuerdo al código de provincia dado. El Oro es 7 por ejemplo.
	 * @param provincia Código de la provincia
	 * @return Número de placa de la forma AAA-0000 o null si el código dado no es válido.
	 */
	public static String generarPlacaAleatoria(int provincia) {
		if(provincia>=1 && provincia<=24) {
			StringBuffer placa = new StringBuffer();
			placa.append(Provincia.values()[provincia-1].getCodigo());
			for(int i=1; i<=2; ++i)
				placa.append(Provincia.values()[aleatorio(0, 23)].getCodigo());
			placa.append('-');
			for(int i=1; i<=4; ++i)
				placa.append(aleatorio(0, 9));
			return placa.toString();
		}
		else
			return null;
	}
}
