package main.java.model.ej2;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private String dni;
	private int edad;
	private char sexo;
	private String ciudad;
	
	public Alumno(String nombre, String dni, int edad, char sexo, String ciudad) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.sexo = sexo;
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre);
	}
}
