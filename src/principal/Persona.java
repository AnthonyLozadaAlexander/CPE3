package principal;

public class Persona implements Comparable<Persona> {
	
	private String cedula;
	private int edad;
	
	public Persona(String cedula, int edad) {
		super();
		this.cedula = cedula;
		this.edad = edad;
	}
	
	public String getCedula() {
		return cedula;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString() {
		return "Identificacion: " + cedula + " " + "Edad: " + edad; 
	           
	}

	// Metodo para comparar por edad, si son iguales se compara por cedula
	@Override
	public int compareTo(Persona p) {
		if(this.edad > p.edad) {
			return 1;
		}else {
			if(this.edad < p.edad) {
				return - 1;
			}else {
				return this.cedula.compareTo(p.getCedula());
			}
		}
	}

}
