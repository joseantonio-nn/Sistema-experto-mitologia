package mito_perseo;

public abstract class Estado {
	
	private Ser ser;

	public Estado(Ser ser) {
		super();
		this.ser = ser;
	}

	public Ser getSer() {
		return ser;
	}

	public void setSer(Ser ser) {
		this.ser = ser;
	}
	
}
