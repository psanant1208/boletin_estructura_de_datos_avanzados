package main.java.model.ej7;

import java.util.HashMap;
import java.util.Map;

public class Almacen {
	public Map<Integer, Caja> cajas;

	public Almacen() {
		super();
		this.cajas = new HashMap<Integer, Caja>();
	}
	
	public void abrirCaja(int numCaja) {
		if(this.cajas.get(numCaja).isAbierta()) {
			
		}
		
		this.cajas.get(numCaja).setAbierta(true);
	}
}
