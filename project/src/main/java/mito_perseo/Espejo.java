package mito_perseo;

public class Espejo extends Poder {

	public Espejo(Objeto objeto) {
		super(objeto);
		this.nombre = this.getClass().getSimpleName();
	}

}
