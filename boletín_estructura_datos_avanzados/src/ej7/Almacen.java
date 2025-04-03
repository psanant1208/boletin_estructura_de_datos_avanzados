package main.java.model.ej7;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Almacen {
	public Map<Integer, Caja> cajas;
	public Map<Integer, Cliente> clientes;
	public int contClientes;

	public Almacen() {
		super();
		this.cajas = new HashMap<Integer, Caja>();
		this.clientes = new HashMap<Integer, Cliente>();
		this.contClientes = 1;
	}
	
	public void abrirCaja(int numCaja) throws AlmacenException{
		if(this.cajas.get(numCaja).isAbierta()) {
			throw new AlmacenException("La caja ya se encuentra abierta");
		}
		
		this.cajas.get(numCaja).setAbierta(true);
	}
	
	public void cerrarCaja(int numCaja) throws AlmacenException{
		if(this.cajas.get(numCaja).getNumPersonas() > 0) {
			throw new AlmacenException("La caja no está vacia");
		}
		
		if(!this.cajas.get(numCaja).isAbierta()) {
			throw new AlmacenException("La caja ya se encuentra cerrada");
		}
		
		this.cajas.get(numCaja).setAbierta(false);
	}
	
	public String nuevoCliente(Cliente cliente) throws AlmacenException {
	    this.clientes.put(this.contClientes, cliente);

	    int cajaAsignada = this.cajas.entrySet().stream()
	        .filter(e -> e.getValue().isAbierta())
	        .min(Comparator.comparingInt(e -> e.getValue().getNumPersonas()))
	        .map(Map.Entry::getKey) 
	        .orElseThrow(() -> new AlmacenException("No hay cajas abiertas disponibles"));

	    this.cajas.get(cajaAsignada).setNumPersonas(this.cajas.get(cajaAsignada).getNumPersonas() + 1);

	    return "Es usted el cliente número " + (contClientes++) + ", pase a la caja " + cajaAsignada;
	}
	
	
	
}
