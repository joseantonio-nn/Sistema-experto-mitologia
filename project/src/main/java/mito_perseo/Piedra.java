package mito_perseo;

public class Piedra extends Poder {

	public Piedra(Objeto objeto) {
		super(objeto);
		this.nombre = this.getClass().getSimpleName();
	}

}
