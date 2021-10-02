package com.service.dao;

import java.util.List;

import com.servicio.bean.Persona;

public interface Ipersona {

	public List<Persona> listarPersona();
	public Persona getById(int id);
	public List<Persona> listarQuery(int from, int to);
}
