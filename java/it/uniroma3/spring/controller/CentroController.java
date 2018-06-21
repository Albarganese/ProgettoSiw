package it.uniroma3.spring.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.service.CentroService;

@Controller
public class CentroController {
	
	@Autowired
	CentroService centroService;
	
	@GetMapping("/centri")
	public String showcentri(Model model){
		List<Centro> centri = (List<Centro>) centroService.findAll();
		model.addAttribute("centri", centri);
		return "centro/centri";
	}
	
	@GetMapping("/centriAdmin")
	public String showcentriadmin(Model model){
		List<Centro> centri = (List<Centro>) centroService.findAll();
		model.addAttribute("centri", centri);
		return "centro/centriAdmin";
	}
	
    @GetMapping("/centro")
    public String showForm(Centro centro) {
        return "centro/formCentro";
    }
    
    @GetMapping("/centro/resultsCentro")
	public String showCentro(@RequestParam("id")long id, Model model){
		Centro c = centroService.findbyId(id);
		model.addAttribute("centro", c);
		return "centro/resultsCentro";
	}
    @GetMapping("/centro/resultsCentroAdmin")
	public String showCentroAdmin(@RequestParam("id")long id, Model model){
		Centro c = centroService.findbyId(id);
		model.addAttribute("centro", c);
		return "centro/resultsCentroAdmin";
	}
    
    @GetMapping("centro/cancella")
	public ModelAndView deleteCentro(@RequestParam("id")long id, Model model){
		centroService.delete(id);
		return new ModelAndView("redirect:/centri");
	}
    
    
    
    @PostMapping("/centro")
    public String checkCustomerInfo(@Valid @ModelAttribute Centro centro, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "centro/formCentro";
        } else {
        	model.addAttribute(centro);
        	centroService.addCentro(centro); 
        }
        return "centro/resultsCentro";
    }
    
    @GetMapping("/centro/modificaCentro")
	public String modificaCentro(Model model,@RequestParam("id")Long id) {

		Centro centro=centroService.findbyId(id);
		model.addAttribute("centro",centro);
		return "centro/modificaCentro";
	}

	@PostMapping("/centro/modificaCentro")
	public String modificacentro(@Valid @ModelAttribute Centro centro, 
			BindingResult bindingResult, Model model ){
		if (bindingResult.hasErrors()) {
			return "centro/modificaCentro";
		}
		else {
			model.addAttribute(centro);
			try{
				centroService.addCentro(centro);
			}catch(Exception e){
				return"centro/resultsCentro";

			}
		}
		return "centro/resultsCentro";
	}
}
