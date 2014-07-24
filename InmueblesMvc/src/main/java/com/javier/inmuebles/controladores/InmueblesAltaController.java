package com.javier.inmuebles.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.inmuebles.repositorios.RepositorioInmuebles;

public class InmueblesAltaController {
	@Autowired
	RepositorioInmuebles daoInmueble;
	@Autowired
	RepositorioPropietarios daoPropietario;
	@Autowired
	RepositorioDepartamento daoInquilino;
	


	@RequestMapping(method=RequestMethod.GET)
	public String alta(ModelMap modelo){

		InmuebleViewForm inmueble=new InmuebleViewForm();
		modelo.addAttribute("inmueble", inmueble);

		Map<Integer,String> lp=daoPropietario.getMapaOptions();
		Map<Integer,String> li=daoInquilino.getMapaOptions();

		modelo.addAttribute("propietario", lp);
		modelo.addAttribute("inquilino",li);
		return "alta";

	}
	@RequestMapping(method=RequestMethod.POST)
	public String 
		doAlta(@ModelAttribute("inmueble") InmuebleViewForm inmueble,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			Map<Integer,String> lp=daoPropietario.getMapaOptions();
			Map<Integer,String> li=daoInquilino.getMapaOptions();
			request.setAttribute("propietario", lp);
			request.setAttribute("inquilino",li);
			return "alta";

		}
		Inmueble inmu=inmueble.getInmueble();
		daoInmueble.add(inmu);

		return "redirect:/listado.html";
	}

}

