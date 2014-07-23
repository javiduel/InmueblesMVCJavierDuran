package com.javier.inmuebles.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javier.inmuebles.modelos.Inmueble;
import com.javier.inmuebles.repositorios.RepositorioInmuebles;


@Controller
public class InmueblesController {
	@Autowired //conectado automaticamente y vamos al xml y busca repositorio empleados y esta indicado que es el daoempleado
	RepositorioInmuebles daoInmueble;
	
	@RequestMapping(value="/listado.html")
     public String Listado(Model modelo){
    	
		List<Inmueble> l=daoInmueble.get(Inmueble.class);//vas a crear una lista utiliando los datos del get
		modelo.addAttribute("inmuebles", l);//objeto del spring para mantener los datos en la memoria coje datos desde la vista al controlador y del controlador a la vista
		
		return "listado";
     }
}



