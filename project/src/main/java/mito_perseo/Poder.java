package mito_perseo;

public abstract class Poder {
	
	private Objeto objeto;
	protected String nombre;

	public Poder(Objeto objeto) {
		super();
		this.objeto = objeto;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
	
	public String getNombre() {
		return nombre;
	}

}
