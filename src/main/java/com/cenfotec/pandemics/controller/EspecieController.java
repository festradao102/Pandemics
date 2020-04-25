package com.cenfotec.pandemics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.pandemics.model.Especie;
import com.cenfotec.pandemics.service.EspecieService;


@Controller
public class EspecieController {
	
	@Autowired
	private EspecieService especieService; 
	
	////////// mostrar index especies.html
	@RequestMapping(value="especies", method=RequestMethod.GET)
	public String homeIndex(Model model) {
		return "especies";
	}
	
	////////// mostrar busqueda especies por guid.html
	@ExceptionHandler
	@RequestMapping(value="especies/listarEspeciePorGuid", method=RequestMethod.GET)
	public String searchIndex(Model model) {
		return "listarEspeciePorGuid";
	}
	
	////////// mostrar formulario registrar
	@RequestMapping(value="especies/registrar", method=RequestMethod.GET)
	public String registrarEspecie(Model model) {
		model.addAttribute("especie",new Especie());
		return "registrar";
	}
	
	////////// registrar especies
	@RequestMapping(value="especies/especieRegistrada")
	public String guardarEspecie(@Valid Especie especie,BindingResult bindingResult) {
		especieService.guardarEspecie(especie);
		return "especieRegistrada";
	}
	
	/////////// listar especies
	@GetMapping(value="especies/listarEspecies")
	public String listarEspecies(Model model) {
		model.addAttribute("especie",new Especie());
		model.addAttribute("especies", especieService.listarEspecies()); 
		return "listarEspecies";
	}
	
	/////////// listar especie
	@GetMapping(value="especies/listarEspecie/{guid}")
	public String listarEspeciesGuid(Model model, @PathVariable int guid) {
		model.addAttribute("especie",new Especie());
		model.addAttribute("especie", especieService.listarEspecieByGuid(guid)); 
		return "listarEspecie";
	}
	
	////////// mostrar formulario actualizar
	@RequestMapping(value="especies/editar/{guid}", method=RequestMethod.GET)
	public String actualizarEspecie(Model model, @PathVariable int guid) {
		model.addAttribute("especie",new Especie());
		model.addAttribute("especie", especieService.listarEspecieByGuid(guid));
		return "editar";
	}
	
	/////////// actualizar especies
	@RequestMapping(value="especies/especieActualizada")
	public String actualizarEspecie(@Valid Especie especie,BindingResult bindingResult) {	
		especieService.actualizarEspecie(especie);
		return "especieActualizada";		
	}
	
	////////// mostrar formulario eliminar 
    @RequestMapping(value="especies/eliminar/{guid}", method=RequestMethod.GET)
    public String eliminarEspecie(Model model, @PathVariable int guid) {
    	model.addAttribute("especie",new Especie());
		model.addAttribute("especie", especieService.listarEspecieByGuid(guid));
    	return "eliminar";
    }    
    
	@RequestMapping(value="especies/especieEliminada")
	public String eliminarEspecie(@Valid Especie especie,BindingResult bindingResult) {	
		especieService.EliminarEspecie(especie);
		return "especieEliminada";		
	}
	
}
