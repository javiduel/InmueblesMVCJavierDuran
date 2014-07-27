package com.javier.inmuebles.controladores;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javier.inmuebles.modelos.Inquilino;
import com.javier.inmuebles.modelos.InquilinoViewForm;
import com.javier.inmuebles.repositorios.RepositorioInquilinos;




@Controller
@RequestMapping(value="altaInquilino.html")
public class InquilinosAltaController {
	@Autowired
	RepositorioInquilinos daoInquilino;
	@RequestMapping(method=RequestMethod.GET)
	public String alta(ModelMap modelo){

		InquilinoViewForm inquilino=new InquilinoViewForm();
		modelo.addAttribute("inquilino", inquilino);

		return "altaInquilino";

	}
	@RequestMapping(method=RequestMethod.POST)
	public String doAlta(@ModelAttribute("inquilino") InquilinoViewForm inquilino,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			
			return "altaInquilino";

		}
		Inquilino inqui=inquilino.getInquilino();
		daoInquilino.add(inqui);

		return "redirect:/listadoInquilino.html";
	}

}
 










