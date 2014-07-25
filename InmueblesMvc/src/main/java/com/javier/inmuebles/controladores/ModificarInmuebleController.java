package com.javier.inmuebles.controladores;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.inmuebles.modelos.Inmueble;
import com.javier.inmuebles.modelos.InmuebleViewForm;
import com.javier.inmuebles.repositorios.RepositorioInmuebles;
import com.javier.inmuebles.repositorios.RepositorioInquilinos;
import com.javier.inmuebles.repositorios.RepositorioPropietarios;

@Controller
@RequestMapping(value="modificarInmueble.html")
public class ModificarInmuebleController {
	@Autowired
	RepositorioInmuebles daoInmueble;
	@Autowired
	RepositorioPropietarios daoPropietario;
	@Autowired
	RepositorioInquilinos daoInquilino;
	


	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap modelo,@PathVariable int id){
        Inmueble inmu=daoInmueble.get(Inmueble.class, id);
		InmuebleViewForm inmueble=new InmuebleViewForm();
		inmueble.fromInmueble(inmu);
		modelo.addAttribute("inmueble", inmueble);

		Map<Integer,String> lp=daoPropietario.getMapaOptions();
		Map<Integer,String> li=daoInquilino.getMapaOptions();

		modelo.addAttribute("propietarios", lp);
		modelo.addAttribute("inquilinos",li);
		return "modificar";

	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("inmueble") InmuebleViewForm inmueble,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			Map<Integer,String> lp=daoPropietario.getMapaOptions();
			Map<Integer,String> li=daoInquilino.getMapaOptions();
			request.setAttribute("propietarios", lp);
			request.setAttribute("inquilinos",li);
			return "modificar";

		}
		Inmueble inmu=inmueble.getInmueble();
		daoInmueble.update(inmu);

		return "redirect:/listado.html";
	}

}



