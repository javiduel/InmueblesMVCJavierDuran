package com.javier.inmuebles.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.inmuebles.modelos.Propietario;
import com.javier.inmuebles.repositorios.RepositorioPropietarios;

@Controller
public class PropietariosController {
	@Autowired //conectado automaticamente y vamos al xml y busca repositorio empleados y esta indicado que es el daoempleado
	RepositorioPropietarios daoPropietario;

	@RequestMapping(value="/listadoPropietario.html")
     public String Listado(Model modelo){
    	
		List<Propietario> l=daoPropietario.get(Propietario.class);//vas a crear una lista utiliando los datos del get
		modelo.addAttribute("propietarios", l);//objeto del spring para mantener los datos en la memoria coje datos desde la vista al controlador y del controlador a la vista

		return "listadoPropietario";
     }
	@RequestMapping(value="detallePropietario.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){

		int id=Integer.parseInt(request.getParameter("id"));

		Propietario p=daoPropietario.get(Propietario.class, id);



		modelo.addAttribute("propietario", p);

		return "detallePropietario";
	}






}



