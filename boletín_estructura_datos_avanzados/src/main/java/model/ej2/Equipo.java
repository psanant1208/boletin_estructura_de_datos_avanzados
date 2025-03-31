package main.java.model.ej2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

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

	public Equipo interseccionDeEquipos(Equipo equipoAUnir) {
		Equipo equipoInter = new Equipo(this.getNombre() + equipoAUnir.getNombre());
		
		for(Alumno alumno : this.alumnos) {
			if(equipoAUnir.alumnos.contains(alumno)) {
				equipoInter.alumnos.add(alumno);
			}
		}
		
		return equipoInter;
	}
	
	public List<Alumno> listarJugadoresMasculinos(){
		List<Alumno> listaMasculinos = new ArrayList<Alumno>();
		
		for(Alumno alumno : this.alumnos) {
			if(alumno.getSexo() == 'H' && alumno.getEdad() >= 18) {
				listaMasculinos.add(alumno);
			}
		}
		
		listaMasculinos.sort(Comparator.comparingInt(Alumno::getEdad));
		
		return listaMasculinos;
	}
	
	public boolean esEquipoFemenino() {
		boolean resultado = true;
		
		for(Alumno alumno : this.alumnos) {
			if(alumno.getSexo() == 'H') {
				resultado = false;
			}
		}
		
		return resultado;
	}
	
	public int contarJugadoresMayoresDeEdad() {
		int cont = 0;
		
		for(Alumno alumno : this.alumnos) {
			if(alumno.getEdad() >= 18) {
				cont++;
			}
		}
		
		//return (int) this.alumnos.stream().filter(alumno -> alumno.getEdad() >= 18).count();
		
		return cont;
	}
	
	public OptionalInt menorEdadJugadoraMayorDeEdad() {
		return this.alumnos.stream()
		.filter(alumno -> alumno.getEdad() >= 18)
		.filter(alumno -> alumno.getSexo() == 'M')
        .mapToInt(Alumno::getEdad)
        .min();
	}
	
	public Set<String> dniMasculinosMenores() {
		Set<String> dnis = new HashSet<String>();
		
		for(Alumno alumno : this.alumnos) {
			if(alumno.getSexo() == 'H' && alumno.getEdad() < 18) {
				dnis.add(alumno.getDni());
			}
		}
		
	    /*return this.alumnos.stream()
	            .filter(alumno -> alumno.getSexo() == 'H' && alumno.getEdad() < 18)
	            .map(Alumno::getDni)
	            .collect(Collectors.toSet());*/
		
		return dnis;
	}
	
	public List<String> nombresJugadorasAlfabeticamente() {
		return this.alumnos.stream()
				.filter(alumno -> alumno.getSexo() == 'M')
				.map(Alumno::getNombre)
				.sorted()
				.collect(Collectors.toList());
	}
	
	public boolean hayJugadoraMayor() {
		boolean resultado = false;
		
		for(Alumno alumno : this.alumnos) {
			if(alumno.getSexo() == 'M' && alumno.getEdad() >= 18) {
				resultado = true;
			}
		}
		
		return resultado;
	}
	
	public int contarCiudadesDiferntes() {
		List<String> ciudades = new ArrayList<String>();
		//Set<String> ciudades = new HashSet<>();
		
		for(Alumno alumno : this.alumnos) {
			if(!ciudades.contains(alumno.getCiudad())) {
				ciudades.add(alumno.getCiudad());
			}
		}
	    /*for (Alumno alumno : this.alumnos) {
	        ciudades.add(alumno.getCiudad());
	    }*/
		
		return ciudades.size();
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
