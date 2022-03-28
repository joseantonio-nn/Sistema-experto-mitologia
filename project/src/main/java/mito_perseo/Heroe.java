package mito_perseo;

public class Heroe extends Mortal {

	private int fuerza;
	
	public Heroe(String nombre, int fuerza) {
		super(nombre);
		this.fuerza = fuerza;
	}

	public int getFuerza() {
		return fuerza;
	}
}
