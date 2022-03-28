package mito_perseo;

public abstract class Acción {
	
	private Ser sujeto;

	public Acción(Ser sujeto) {
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
