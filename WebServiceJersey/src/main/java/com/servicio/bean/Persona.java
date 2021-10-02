package com.servicio.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Persona implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8284522182314283584L;
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private Profesion profesion;
	
		
	public Persona() {
		super();
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Persona(int id, String nombre, String apellido, int edad, Profesion profesion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.profesion = profesion;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [id=");
		builder.append(id);
		builder.append(", nombre=");
		builder.append(nombre);
		builder.append(", apellido=");
		builder.append(apellido);
		builder.append(", edad=");
		builder.append(edad);
		builder.append(", profesion=");
		builder.append(profesion);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
	
}
