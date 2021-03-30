package org.springframework.springpetclinic.controllers;

import org.springframework.springpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

	private OwnerService OwnerService;
	
	public OwnerController(OwnerService ownerService) {
		OwnerService = ownerService;
	}

	@RequestMapping({"","/","/index","/index.html"})
	public String listVets(Model model) {	
		model.addAttribute("owners", OwnerService.findAll());
		return "owners/index";
	}
	
	@RequestMapping("/find")
	public String findOwners() {
		
		return "notimplemented";
	}
}
