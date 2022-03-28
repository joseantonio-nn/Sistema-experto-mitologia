package mito_perseo;

public class Capacidad {

	private Ser ser;
	private Poder poder;
	
	public Capacidad(Ser ser, Poder poder) {
		super();
		this.ser = ser;
		this.poder = poder;
	}

	public Ser getSer() {
		return ser;
	}

	public void setSer(Ser ser) {
		this.ser = ser;
	}

	public Poder getPoder() {
		return poder;
	}

	public void setPoder(Poder poder) {
		this.poder = poder;
	}
}
