package mito_perseo;

public class Preso extends Vivo {

	private Ser apresador;
	
	public Preso(Ser ser, Ser apresador) {
		super(ser);
		this.setApresador(apresador);
	}

	public Ser getApresador() {
		return apresador;
	}

	public void setApresador(Ser apresador) {
		this.apresador = apresador;
	}

}
