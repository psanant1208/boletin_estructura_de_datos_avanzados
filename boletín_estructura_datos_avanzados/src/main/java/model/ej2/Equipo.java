package main.java.model.ej2;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	private String nombre;
	private List<Alumno> alumnos;
	
	public Equipo(String nombre) {
		super();
		this.nombre = nombre;
		this.alumnos = new ArrayList<Alumno>();
	}
	
	public void aniadirAlumno(Alumno nuevoAlumno) throws EquipoException {
		if(this.alumnos.contains(nuevoAlumno)) {
			throw new EquipoException("Este alumno ya está en el equipo");
		}
		
		this.alumnos.add(nuevoAlumno);
	}
	
	public void borrarAlumno(Alumno nuevoAlumno) throws EquipoException {
		if(!this.alumnos.contains(nuevoAlumno)) {
			throw new EquipoException("Este alumno no está en el equipo");
		}
		
		this.alumnos.remove(nuevoAlumno);
	}
	
	public Alumno alumnoPertemeceAEquipo(Alumno alumnoBuscado) {
		//Hecho con ternaria (En teoría):
		//return this.alumnos.contains(alumnoBuscado)? alumnoBuscado : null;
		
		Alumno alumnoEncontrado = null;
		
		if(this.alumnos.contains(alumnoBuscado)) {
			alumnoEncontrado = alumnoBuscado;
		}
		
		return alumnoEncontrado;
	}
	
	public String mostrarListaAlumnos() {
		return this.alumnos.toString();
	}
	
	public Equipo unionDeEquipos(Equipo equipoAUnir) {
		Equipo equipoUnido = new Equipo(this.getNombre() + equipoAUnir.getNombre());
		
		equipoUnido.alumnos.addAll(this.alumnos);
		equipoUnido.alumnos.addAll(equipoAUnir.alumnos);
		
		return equipoUnido;
	}

	public Equipo interseccionDeEquipos() {
		
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
