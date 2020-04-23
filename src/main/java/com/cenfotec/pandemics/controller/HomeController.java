package com.cenfotec.pandemics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
	
	////////// mostrar index
	@RequestMapping(value="home", method=RequestMethod.GET)
	public String read(Model model) {
		return "home";
	}

}
