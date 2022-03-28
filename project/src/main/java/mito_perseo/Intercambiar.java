package mito_perseo;

public class Intercambiar extends Obtener {

	private Ser interesado;
	private Objeto objetoEntregado;
	
	public Intercambiar(Objeto objetoReceptor, Ser sujeto, Ser interesado, Objeto objetoEntregado) {
		super(objetoReceptor, sujeto);
		this.interesado = interesado;
		this.objetoEntregado = objetoEntregado;
	}

	public Ser getInteresado() {
		return interesado;
	}

	public void setInteresado(Ser interesado) {
		this.interesado = interesado;
	}

	public Objeto getObjetoEntregado() {
		return objetoEntregado;
	}

	public void setObjetoEntregado(Objeto objetoEntregado) {
		this.objetoEntregado = objetoEntregado;
	}

}
