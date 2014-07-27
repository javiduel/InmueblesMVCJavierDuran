package com.javier.inmuebles.controladores;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.inmuebles.modelos.Inquilino;
import com.javier.inmuebles.repositorios.RepositorioInquilinos;



@Controller
public class InquilinosController {
	@Autowired 
	RepositorioInquilinos daoInquilino;

	@RequestMapping(value="/listadoInquilino.html")
     public String Listado(Model modelo){
    	
		List<Inquilino> l=daoInquilino.get(Inquilino.class);
		modelo.addAttribute("inquilinos", l);

		return "listadoInquilino";
     }
	@RequestMapping(value="detalleInquilino.html",method=RequestMethod.GET)
	public String detalle(Model modelo,HttpServletRequest request){

		int id=Integer.parseInt(request.getParameter("id"));

		Inquilino i=daoInquilino.get(Inquilino.class, id);



		modelo.addAttribute("inquilino", i);

		return "detalleInquilino";
	}






}



