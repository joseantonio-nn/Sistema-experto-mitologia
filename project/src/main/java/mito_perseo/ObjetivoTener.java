package mito_perseo;

public class ObjetivoTener extends Objetivo{

	private Objeto objeto;
	
	public ObjetivoTener(Objeto objeto, Ser sujeto) {
		super(sujeto);
		this.objeto = objeto;
	}

	public Objeto getObjeto() {
		return objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}
	
}
