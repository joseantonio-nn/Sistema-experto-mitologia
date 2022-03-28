package mito_perseo;

public abstract class Objetivo {
	
	private Ser sujeto;

	public Objetivo(Ser sujeto) {
		super();
		this.sujeto = sujeto;
	}

	public Ser getSujeto() {
		return sujeto;
	}

	public void setSujeto(Ser sujeto) {
		this.sujeto = sujeto;
	}
	
}
