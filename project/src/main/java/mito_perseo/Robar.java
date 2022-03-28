package mito_perseo;

public class Robar extends Obtener {
	
	private Ser serRobado;

	public Robar(Objeto objetoReceptor, Ser sujeto, Ser serRobado) {
		super(objetoReceptor, sujeto);
		this.serRobado = serRobado;
	}

	public Ser getSerRobado() {
		return serRobado;
	}

	public void setSerRobado(Ser serRobado) {
		this.serRobado = serRobado;
	}
	
}
