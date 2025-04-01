package main.java.model.ej4;

import java.time.LocalDate;

public class Busqueda {
	private String url;
	private LocalDate fechaHora;
	
	public Busqueda(String url, LocalDate fechaHora) {
		super();
		this.url = url;
		this.fechaHora = fechaHora;
	}
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public LocalDate getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}
}
