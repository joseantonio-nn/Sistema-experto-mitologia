package mito_perseo;

public abstract class SobreObjeto extends Acción {
	
	private Objeto objetoReceptor;

	public SobreObjeto(Objeto objetoReceptor, Ser sujeto) {
		super(sujeto);
		this.objetoReceptor = objetoReceptor;
	}

	public Objeto getObjetoReceptor() {
		return objetoReceptor;
	}

	public void setObjetoReceptor(Objeto objetoReceptor) {
		this.objetoReceptor = objetoReceptor;
	}
	
}
