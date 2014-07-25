package com.javier.inmuebles.controladores;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javier.inmuebles.modelos.Propietario;
import com.javier.inmuebles.repositorios.RepositorioPropietarios;

@Controller
@RequestMapping(value="/propietario")
public class PropietariosRestController {

	@Autowired
	RepositorioPropietarios daoPropietario;
    @RequestMapping	(method=RequestMethod.GET,value="/{id}")
	 public @ResponseBody Propietario propietario(@PathVariable int id){
	  Propietario p=daoPropietario.get(Propietario.class, id);
	return p;  	

	      }
    @RequestMapping(method=RequestMethod.GET, value="/buscar/{texto}")
	public @ResponseBody List<Propietario>buscar(@PathVariable String texto){

		if(texto.equals("NoBuscoNada"))
			texto="";

		Map<String, Object> params=new HashMap();
		params.put("texto", "%"+texto+"%");
		List<Propietario> l=daoPropietario.find("Propietario.buscador", params);
		return l;


	}
    
    @RequestMapping(method=RequestMethod.DELETE)
	public @ResponseBody String borrar(@RequestBody Propietario propietario){

		daoPropietario.delete(propietario);

		return "borrado";
	}



}







