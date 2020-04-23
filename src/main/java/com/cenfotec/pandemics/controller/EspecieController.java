package com.cenfotec.pandemics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cenfotec.pandemics.model.Especie;
import com.cenfotec.pandemics.service.EspecieService;


@Controller
public class EspecieController {
	
	@Autowired
	private EspecieService especieService; 
	
	////////// mostrar especies.html
	@RequestMapping(value="especies", method=RequestMethod.GET)
	public String read(Model model) {
		return "especies";
	}

}
