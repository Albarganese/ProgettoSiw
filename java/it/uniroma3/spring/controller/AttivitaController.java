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

import it.uniroma3.spring.model.Allievo;
import it.uniroma3.spring.model.Attivita;
import it.uniroma3.spring.model.Centro;
import it.uniroma3.spring.service.AllievoService;
import it.uniroma3.spring.service.AttivitaService;
import it.uniroma3.spring.service.CentroService;

@Controller
public class AttivitaController  {
	@Autowired
	private CentroService centroService;
	@Autowired
	private AllievoService allievoService;
	@Autowired
	private AttivitaService attivitaService; 



	@GetMapping("/attivitas")
	public String showAutori(Model model){
		List<Attivita> attivitas = (List<Attivita>) attivitaService.findAll();
		model.addAttribute("attivitas", attivitas);
		return "attivita/attivitas";
	}
	
	@GetMapping("/attivitasAdmin")
	public String showAttivitasAdmin(Model model){
		List<Attivita> attivitas = (List<Attivita>) attivitaService.findAll();
		model.addAttribute("attivitas", attivitas);
		return "attivita/attivitasAdmin";
	}

	@GetMapping("attivita/cancella")
	public ModelAndView deleteAllievo(@RequestParam("id")long id, Model model){
		attivitaService.delete(id);
		return new ModelAndView("redirect:/attivitasAdmin");
	}
	
	@GetMapping("/attivita/resultsAttivita")
	public String showAllievo(@RequestParam("id")long id, Model model){
		Attivita a = attivitaService.findbyId(id);
		model.addAttribute("attivita", a); 
		return "attivita/resultsAttivita";
	}

	@GetMapping("/attivita")
	public String showForm(Model model, Attivita attivita){
		List<Allievo> allievi = (List<Allievo>) allievoService.findAll();
		List<Centro> centri= (List<Centro>) centroService.findAll();
		model.addAttribute("allievi", allievi);
		model.addAttribute("centri",centri);
		return "attivita/formAttivita";
	}

	@PostMapping("/attivita")
	public String checkCustomerInfo(@Valid @ModelAttribute Attivita attivita, 
			BindingResult bindingResult, Model model) {
		List<Allievo> allievi = (List<Allievo>) allievoService.findAll();
		List<Centro> centri = (List<Centro>) centroService.findAll();
		model.addAttribute("allievi", allievi);
		model.addAttribute("centri", centri);
		if (bindingResult.hasErrors()) {
			return "attivita/formAttivita";
		}
		else {

			model.addAttribute(attivita);
			attivitaService.add(attivita); 
		}
		return "attivita/resultsAttivita";
	}
	
	@GetMapping("/attivita/modificaAttivita")
	public String modificaAttivita2(Model model,@RequestParam("id")Long id) {
		List<Allievo> allievi = (List<Allievo>) allievoService.findAll();
		List<Centro> centri = (List<Centro>) centroService.findAll();
		model.addAttribute("allievi", allievi);
		model.addAttribute("centri",centri);
		Attivita attivita=attivitaService.findbyId(id);
		model.addAttribute("attivita",attivita);
		return "attivita/modificaAttivita";
	}

	@PostMapping("/attivita/modificaAttivita")
	public String checkCustomer(@Valid @ModelAttribute Attivita attivita, 
			BindingResult bindingResult, Model model ){
		List<Allievo> allievi = (List<Allievo>) allievoService.findAll();
		List<Centro> centri = (List<Centro>) centroService.findAll();
		model.addAttribute("allievi", allievi);
		model.addAttribute("centri",centri);
		if (bindingResult.hasErrors()) {
			return "attivita/modificaAttivita";
		}
		else {
			model.addAttribute(attivita);
			try{
				attivitaService.add(attivita);
			}catch(Exception e){
				return"attivita/resultsAttivita";

			}
		}
		return "attivita/resultsAttivita";
	}
}




