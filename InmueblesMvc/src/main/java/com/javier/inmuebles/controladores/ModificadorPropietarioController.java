package com.javier.inmuebles.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.inmuebles.modelos.Propietario;
import com.javier.inmuebles.modelos.PropietarioViewForm;
import com.javier.inmuebles.repositorios.RepositorioPropietarios;

@Controller
@RequestMapping(value="modificarPropietario.html")
public class ModificadorPropietarioController {
	@Autowired
	RepositorioPropietarios daoPropietario;
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap modelo,@PathVariable int id){
		Propietario propi=daoPropietario.get(Propietario.class, id);
		PropietarioViewForm propietario=new PropietarioViewForm();
		propietario.fromPropietario(propi);
		modelo.addAttribute("propietario", propietario);

		return "modificarPropietario";

	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("propietario") PropietarioViewForm propietario,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			
			return "modificarPropietario";

		}
		Propietario propi=propietario.getPropietario();
		daoPropietario.update(propi);

		return "redirect:/listadoPropietario.html";
	}

}
 

