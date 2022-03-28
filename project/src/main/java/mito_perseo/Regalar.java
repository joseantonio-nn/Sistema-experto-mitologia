package mito_perseo;

public class Regalar extends Obtener {
	
	private Ser serReceptorRegalo;

	public Regalar(Objeto objetoReceptor, Ser sujeto, Ser serReceptorRegalo) {
		super(objetoReceptor, sujeto);
		this.serReceptorRegalo = serReceptorRegalo;
	}

	public Ser getSerReceptorRegalo() {
		return serReceptorRegalo;
	}

	public void setSerReceptorRegalo(Ser serReceptorRegalo) {
		this.serReceptorRegalo = serReceptorRegalo;
	}

}
