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

import com.javier.inmuebles.modelos.Inquilino;
import com.javier.inmuebles.modelos.InquilinoViewForm;
import com.javier.inmuebles.repositorios.RepositorioInquilinos;



@Controller
@RequestMapping(value="modificarInquilino.html")
public class ModificarInquilinoController {
	@Autowired
	RepositorioInquilinos daoInquilino;
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String modificar(ModelMap modelo,@PathVariable int id){
		Inquilino inqui=daoInquilino.get(Inquilino.class, id);
		InquilinoViewForm inquilino=new InquilinoViewForm();
		inquilino.fromInquilino(inqui);
		modelo.addAttribute("inquilino", inquilino);

		return "modificarInquilino";

	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String doModificar(@ModelAttribute("inquilino") InquilinoViewForm inquilino,
				BindingResult resultado,
				HttpServletRequest request){

		if(resultado.hasErrors()){
			
			return "modificarInquilino";

		}
		Inquilino inqui=inquilino.getInquilino();
		daoInquilino.update(inqui);

		return "redirect:/listadoInquilino.html";
	}

}
 

