package mito_perseo;

public class Vuelo extends Poder {

	public Vuelo(Objeto objeto) {
		super(objeto);
		this.nombre = this.getClass().getSimpleName();
	}

}
