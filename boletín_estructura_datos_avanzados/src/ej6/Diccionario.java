package main.java.model.ej6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Diccionario {
	public Map<String, List<String>> palabras;

	public Diccionario(Map<String, List<String>> palabras) {
		super();
		this.palabras = palabras;
	}
	
	public void aniadirPalabra(String palabra, String significado) {
		if(this.palabras.containsKey(palabra)) {
			this.palabras.get(palabra).add(significado);
		}
		
		else {
			this.palabras.put(palabra, new ArrayList<>(Arrays.asList(significado)));
		}
	}
	
	public List<String> buscarPalabra(String palabra) throws DiccionarioException {
		if(!this.palabras.containsKey(palabra)) {
			throw new DiccionarioException("La palabra no se encuentra en el diccionario");
		}
		
		return this.palabras.get(palabra);
	}
	
	public void borrarPalabra(String palabra) {
		this.palabras.remove(palabra);
	}
	
	public List<String> listarPalabrasConComienzo(String comienzo) {
		List<String> palabrasComenzadas = new ArrayList<String>();
		
		for(String palabra : this.palabras.keySet()) {
			if(palabra.startsWith(comienzo)) {
				palabrasComenzadas.add(palabra);
			}
		}
		
		return palabrasComenzadas;
	}
}






















