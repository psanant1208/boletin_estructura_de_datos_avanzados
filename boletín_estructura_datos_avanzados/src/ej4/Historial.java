package main.java.model.ej4;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

public class Historial {
	private List<Busqueda> busquedas;

	public Historial(List<Busqueda> busquedas) {
		super();
		this.busquedas = busquedas;
	}
	
	public void aniadirBusqueda(String url, LocalDate fechaHora) throws HistorialException{
	    if (!busquedas.isEmpty()) {
	        LocalDate ultimaFecha = busquedas.get(busquedas.size() - 1).getFechaHora();
	        
	        if (!fechaHora.isAfter(ultimaFecha)) {
	            throw new HistorialException("Fecha de la búsqueda no válida");
	        }
	    }
	    
	    busquedas.add(new Busqueda(url, fechaHora));
	}
	
	public String consultarHistorial() {
		String cadenaHistorial = "";
		
		for(Busqueda busqueda : this.busquedas) {
			cadenaHistorial+=busqueda.getUrl()+" "+busqueda.getFechaHora().toString()+" ";
		}
		
		return cadenaHistorial;
	}
	
	public String consultarHistorialDia(LocalDate dia) {
		String cadenaHistorial = "";
		
		for(Busqueda busqueda : this.busquedas) {
			if(busqueda.getFechaHora().getDayOfYear() == dia.getDayOfYear() && busqueda.getFechaHora().getYear() == dia.getYear()) {
				cadenaHistorial+=busqueda.getUrl()+" "+busqueda.getFechaHora().toString()+" ";
			}
		}
		
		return cadenaHistorial;
	}
	
	public void borrarHistorial() {
		this.busquedas.clear();
	}
	
	public void borrarBusquedasAUnaPagina(String url) {
		for(Busqueda busqueda : this.busquedas) {
			if(busqueda.getUrl() == url) {
				this.busquedas.remove(busqueda);
			}
		}
		
	    Iterator<Busqueda> iterator = this.busquedas.iterator();
	    
	    while (iterator.hasNext()) {
	        Busqueda busqueda = iterator.next();
	        
	        if (busqueda.getUrl().equals(url)) {
	            iterator.remove();  // Elimina de manera segura usando el iterador
	        }
	    }
	}
}














































