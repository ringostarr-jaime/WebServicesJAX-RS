package com.servicio.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriInfo;

import com.service.dao.Ipersona;
import com.servicio.bean.Persona;
import com.servicio.bean.Profesion;
import com.servicio.impl.PersonaImpl;

@Path("/GetApi")
public class GetApi {
	Ipersona personaDao = new PersonaImpl();

	// --puerto por defecto 8080

	// ----Devolver datos en JSON
	// http://localhost:8060/WebServiceJersey/GetApi/json
	@GET
	@Path("/json")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public List<Persona> Json() {
		return personaDao.listarPersona();
	}

	// ----Devolver datos en JSON
	// http://localhost:8060/WebServiceJersey/GetApi/getByIdJson/1
	@GET
	@Path("/getByIdJson/{id}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Persona getByIdJson(@PathParam("id") int id) {
		// Logica a procesar
		return personaDao.getById(id);
	}

	// EJEMPLO para multiples
	// @Path("{year}/{month}/{day}")
	// @PathParam("year") int year, @PathParam("month") int month, @PathParam("day")
	// int day)
	// ----Devolver datos en xml
	// http://localhost:8060/WebServiceJersey/GetApi/getByIdXml/1
	@GET
	@Path("/getByIdXml/{id}")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
	public Persona getByIdXml(@PathParam("id") int id) {
		// Logica a procesar
		return personaDao.getById(id);
	}
	
	
	//http://localhost:8060/WebServiceJersey/GetApi/agregar?name=jaime&age=31&title=Licenciado&desc=Analista
	@POST
	@Path("/agregar")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response agregarUsuario(@FormParam("name") String name, @FormParam("surname") String surname, 
			@FormParam("age") int age,@FormParam("title") String title,@FormParam("desc") String desc) {
		Persona obj = new Persona();
		Profesion profesion = new Profesion();
		
		obj.setNombre(name);
		obj.setApellido(surname);		
		obj.setEdad((Integer.valueOf(age)));
		obj.setId(6);		
		profesion.setTitulo(title);
		profesion.setDescripcion(desc);
		obj.setProfesion(profesion);
		
		System.out.println("Programador agregadp , Nombre : " + obj.getNombre() +" Apellido" +obj.getApellido()+", Edad : " + obj.getEdad()+ "Titulo : " + profesion.getTitulo() + ", Descripcion : " + profesion.getDescripcion());
		
		//return Response.status(200).build();
		return Response.status(200).entity("Programador agregadp , Nombre : " + obj.getNombre() +" Apellido" +obj.getApellido()+", Edad : " + obj.getEdad()+ "Titulo : " + profesion.getTitulo() + ", Descripcion : " + profesion.getDescripcion()).build();
		//return Response.status(200).build();

	}


	// ----Devolver datos en xml
	// http://localhost:8060/WebServiceJersey/GetApi/xml
	@GET
	@Path("/xml")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
	public List<Persona> xml() {
		return personaDao.listarPersona();
	}

	// ---Obtener data en modo QUERY
	// http://localhost:8060/WebServiceJersey/GetApi/queryXMl?from=1&to=2
	@GET
	@Path("/queryXMl")
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_XML)
	public List<Persona> xml(@Context UriInfo info) {
		String from = info.getQueryParameters().getFirst("from");
		String to = info.getQueryParameters().getFirst("to");

		int desde = Integer.valueOf(from);
		int hasta = Integer.valueOf(to);

		return personaDao.listarQuery(desde, hasta);
	}

	// --Bajar una imagen del servidor
	// http://localhost:8060/WebServiceJersey/GetApi/get
	@GET
	@Path("/get")
	@Produces("image/png")
	public Response getFile() {
		// String ruta = System.getProperty("user.dir")+"\\imagen1.jpg";
		String FILE_PATH = "C:\\Users\\Jymmy\\Documents\\Eclipse-Workspace\\WebServiceJersey\\imagen1.jpg";

		System.out.println("===RUTA " + FILE_PATH);
		File file = new File(FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=image_from_server.png");
		return response.build();

	}
	
	
	//---------Consumiendo un FORM--------
	/*<h1>Jersey implementacion @FormParam POST</h1>
	//<!-- DESPLEGAR EN EL MISMO SERVIDOR -->
	//<!-- CREAR UN CLIENTE CON ESTOS DATOS PARA CONSUMIR EL WEBSERVICE -->
	<form action="GetApi/add" method="post">
		<p>
			Nombre : <input type="text" name="name" />
		</p>
		<p>
			Edad : <input type="text" name="age" />
		</p>
		<p>
			Titulo : <input type="text" name="title" />
		</p>
		<p>
			Descripcion : <input type="text" name="desc" />
		</p>		
		<input type="submit" value="Agregar" />
	</form>*/
	@POST
	@Path("/add")
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addUser(@FormParam("name") String name, 
			@FormParam("age") int age,@FormParam("title") String title,@FormParam("desc") String desc) {

		return Response.status(200).entity("Programador agregado , Nombre : " + name + ", Edad : " + age+ "Titulo : " + title + ", Descripcion : " + desc).build();

	}

}
