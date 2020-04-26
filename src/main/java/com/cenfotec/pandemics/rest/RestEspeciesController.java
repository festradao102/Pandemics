package com.cenfotec.pandemics.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cenfotec.pandemics.model.Especie;
import com.cenfotec.pandemics.service.EspecieService;


@RestController  //get, post(insert), put(update), delete, etc
@RequestMapping({"/especies"})
public class RestEspeciesController {	

	@Autowired
	private EspecieService especieService;
	
	@RequestMapping("/getEspecies")	//change route
	public List<Especie> listar(){
		return especieService.listarEspecies();
	}	
	
	 @GetMapping(path = {"/getByGuid/{guid}"})
	 public Optional<Especie> findByBodega(@PathVariable int guid){
		 return especieService.findEspecieByGuid(guid);
	 } 

	  @PostMapping("/createEspecie")
	  public String createEspecie(@Valid @RequestBody Especie especie) {
	    especieService.guardarEspecie(especie);
	    return "especie registrada!";
	  }
	  
	  @PutMapping(value="/updateEspecie/{guid}")
		public String actualizarEspecie(@Valid @RequestBody Especie pespecie,@PathVariable int guid) {
		    Especie especie = new Especie();
		    especie = especieService.listarEspecieByGuid(guid);
		    especie.setNombre(pespecie.getNombre());
		    especie.setDescubierto(pespecie.getDescubierto());
		    especie.setTipo(pespecie.getTipo());
		    
			especieService.actualizarEspecie(especie);
			return "especie actualizada!";		
		}
	  

		@DeleteMapping(value="/deleteEspecie/{guid}")
		public String eliminarEspecie(@Valid Especie especie,BindingResult bindingResult) {	
			especieService.EliminarEspecie(especie);
			return "especie eliminada!";		
		}
	 
}
