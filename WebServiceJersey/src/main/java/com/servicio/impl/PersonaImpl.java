package com.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import com.service.dao.Ipersona;
import com.servicio.bean.Persona;
import com.servicio.bean.Profesion;

public class PersonaImpl implements Ipersona{

	public List<Persona> listarPersona() {		
		
		return llenarDatosDummy();
	}

	public Persona getById(int id) {
		Persona obj = new Persona();
		Profesion profesion = new Profesion();
		List<Persona> listar = new ArrayList<Persona>();
		listar=llenarDatosDummy();
		for(int i=0;i<listar.size();i++)
		{
			if(id==listar.get(i).getId())
			{
				obj.setId(listar.get(i).getId());
				obj.setNombre(listar.get(i).getNombre());
				obj.setApellido(listar.get(i).getApellido());
				obj.setEdad(listar.get(i).getEdad());
				profesion.setTitulo(listar.get(i).getProfesion().getTitulo());
				profesion.setDescripcion(listar.get(i).getProfesion().getDescripcion());
				obj.setProfesion(profesion);
			}
			
		}
		if(obj.getId()==0)
		{
			obj=listVacio().get(0);
		}
		return obj;
	}
	
	public List<Persona> listarQuery(int from, int to) {
		Persona obj = new Persona();
		Profesion profesion = new Profesion();
		List<Persona> listar = new ArrayList<Persona>();
		List<Persona> listar2 = new ArrayList<Persona>();
		listar=llenarDatosDummy();
		int desde=(from-1);
		try {
			for(int i=desde;i<to;i++)
			{
				listar2.add(listar.get(i));
			}
			
		} catch (Exception e) {
			
		}
		
		if(listar2.size()==0)
		{
			listar2.add(listVacio().get(0));
		}
	
		return listar2;
	}
	
	
	public  List<Persona> listVacio()
	{
		List<Persona> listar = new ArrayList<Persona>();
		Persona obj = new Persona();
		Profesion profesion = new Profesion();
		obj.setId(0);
		obj.setNombre("No encontrado");
		obj.setApellido("No encontrado");
		obj.setEdad(0);
		profesion.setTitulo("No encontrado");
		profesion.setDescripcion("No encontrado");
		obj.setProfesion(profesion);
		listar.add(obj);
		return listar;
	}
	
	public List<Persona> llenarDatosDummy()
	{
		//-------------DATOS DUMMY----------------
		List<Persona> listar = new ArrayList<Persona>();
		Persona obj = new Persona();
		Profesion profesion = new Profesion();
		//----1
		obj.setId(1);
		obj.setNombre("Jaime Ernesto");
		obj.setApellido("Rodas Martinez");
		obj.setEdad(30);
		profesion.setTitulo("Licenciado en informatica");
		profesion.setDescripcion("Analista Programador");
		obj.setProfesion(profesion);
		listar.add(obj);
		//----2
		obj = new Persona();
		profesion = new Profesion();
		obj.setId(2);
		obj.setNombre("Bjarne ");
		obj.setApellido("Stroustrup");
		obj.setEdad(70);
		profesion.setTitulo("Cientifico de la programacion");
		profesion.setDescripcion("padre del lenguaje de programacion C++");	
		obj.setProfesion(profesion);
		listar.add(obj);		
		//----3
		obj = new Persona();
		profesion = new Profesion();
		obj.setId(3);
		obj.setNombre("James Arthur");
		obj.setApellido("Gosling");
		obj.setEdad(66);
		profesion.setTitulo("Cientifico de la programacion");
		profesion.setDescripcion("padre del lenguaje de programacion Java");	
		obj.setProfesion(profesion);		
		listar.add(obj);
		//----4
		obj = new Persona();
		profesion = new Profesion();
		obj.setId(4);
		obj.setNombre("Anders");
		obj.setApellido("Hejlsberg");
		obj.setEdad(66);
		profesion.setTitulo("Ingeniero de software");
		profesion.setDescripcion("Diseñó varios lenguajes de programación e instrumentos de desarrollo populares (Borland, C#, .Net), jefe del lenguaje de programación TypeScript");	
		obj.setProfesion(profesion);		
		listar.add(obj);
		//----5
		obj = new Persona();
		profesion = new Profesion();
		obj.setId(5);
		obj.setNombre("Timothy 'Tim' John");
		obj.setApellido("Berners-Lee");
		obj.setEdad(66);
		profesion.setTitulo("Ingeniero de software");
		profesion.setDescripcion("conocido por ser el padre de la World Wide Web");	
		obj.setProfesion(profesion);
		listar.add(obj);
		return listar;
	}

	

}
