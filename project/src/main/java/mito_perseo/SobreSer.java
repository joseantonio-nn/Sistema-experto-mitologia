package mito_perseo;

public abstract class SobreSer extends Acción {
	
	private Ser serReceptor;

	public SobreSer(Ser sujeto, Ser serReceptor) {
		super(sujeto);
		this.serReceptor = serReceptor;
	}

	public Ser getSerReceptor() {
		return serReceptor;
	}

	public void setSerReceptor(Ser serReceptor) {
		this.serReceptor = serReceptor;
	}
	
}
