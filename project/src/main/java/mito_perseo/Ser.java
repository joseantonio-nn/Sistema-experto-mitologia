package mito_perseo;

public abstract class Ser {
	
	private String nombre;

	public Ser(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
