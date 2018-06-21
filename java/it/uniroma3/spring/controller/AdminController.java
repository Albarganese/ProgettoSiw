package it.uniroma3.spring.controller;





import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.spring.model.Admin;
import it.uniroma3.spring.model.Ruolo;
import it.uniroma3.spring.service.AdminService;
import it.uniroma3.spring.service.RuoloService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RuoloService ruoloService;
	
	@GetMapping("/admin/registraAdmin")
	public String showForm(Admin admin){
		return "registraAdmin";
	}
	
	@PostMapping("/admin/registraAdmin")
	public String signUp(@Valid @ModelAttribute Admin admin, 
			BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()) {
			return "registraAdmin";
		}else {
			model.addAttribute(admin);
			try{
				Ruolo ruolo = new Ruolo(admin.getUsername());
				admin.setEnabled(true);
				adminService.add(admin); 
				ruoloService.add(ruolo);
				
			}catch(Exception e){
				return "registraAdmin";
			}
		}
		return "datiAdmin";
	}
	
}