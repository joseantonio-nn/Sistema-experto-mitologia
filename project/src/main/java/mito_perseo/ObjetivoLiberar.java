package mito_perseo;

public class ObjetivoLiberar extends Objetivo{
	
	private Ser liberado;
	
	public ObjetivoLiberar(Ser liberado, Ser sujeto) {
		super(sujeto);
		this.liberado = liberado;
	}

	public Ser getLiberado() {
		return liberado;
	}

	public void setLiberado(Ser liberado) {
		this.liberado = liberado;
	}
}
