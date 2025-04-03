package main.java.model.ej7;

public class Caja {
	private int numPersonas;
	private boolean abierta;
	
	public Caja(int numPersonas, boolean abierta) {
		super();
		this.numPersonas = numPersonas;
		this.abierta = abierta;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}
}
