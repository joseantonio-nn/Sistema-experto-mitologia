package mito_perseo;

public class ObjetivoCapacidad extends Objetivo{

	private Poder poder;
	
	public ObjetivoCapacidad(Poder poder, Ser sujeto) {
		super(sujeto);
		this.poder = poder;
	}

	public Poder getPoder() {
		return poder;
	}

	public void setPoder(Poder poder) {
		this.poder = poder;
	}
}
