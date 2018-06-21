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
import it.uniroma3.spring.service.AllievoService;
import it.uniroma3.spring.service.AttivitaService;

@Controller
public class AllievoController {


	@Autowired
	AllievoService allievoService;
	AttivitaService attivitaService;
	
	@GetMapping("/allievi")
	public String showAllievi(Model model){
		List<Allievo> allievi = (List<Allievo>) allievoService.findAll();
		model.addAttribute("allievi", allievi);
		return "allievo/allievi";
	}
	
	@GetMapping("/allieviAdmin")
	public String showAllieviAdmin(Model model){
		List<Allievo> allievi = (List<Allievo>) allievoService.findAll();
		model.addAttribute("allievi", allievi);
		return "allievo/allieviAdmin";
	}

	@GetMapping("/allievo")
	public String showForm(Allievo allievo) {
		return "allievo/formAllievo";
	}
	@GetMapping("/allievo/resultsAllievo")
	public String showAllievo(@RequestParam("id")long id, Model model){
		Allievo a = allievoService.findbyId(id);
		model.addAttribute("allievo", a);
		return "allievo/resultsAllievo";
	}

	@GetMapping("/allievo/resultsAllievoUtente")
	public String showAllievoPerUtente(@RequestParam("id")long id, Model model){
		Allievo a = allievoService.findbyId(id);
		model.addAttribute("allievo", a);
		return "allievo/resultsAllievoUtente";
	}
	

	@GetMapping("allievo/cancella")
	public ModelAndView deleteAllievo(@RequestParam("id")long id, Model model){
		allievoService.delete(id);
		return new ModelAndView("redirect:/allievo");
	}
	

	@PostMapping("/allievo")
	public String checkCustomerInfo(@Valid @ModelAttribute Allievo allievo, 
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "allievo/formAllievo";
		} else {
			model.addAttribute(allievo);
			allievoService.addAllievo(allievo); 
		}
		return "allievo/resultsAllievo";
	}
	@GetMapping("/allievo/modificaAllievo")
	public String modificaAllievo(Model model,@RequestParam("id")Long id) {

		Allievo allievo=allievoService.findbyId(id);
		model.addAttribute("allievo",allievo);
		return "allievo/modificaAllievo";
	}

	@PostMapping("/allievo/modificaAllievo")
	public String modificaAllievo2(@Valid @ModelAttribute Allievo allievo, 
			BindingResult bindingResult, Model model ){
		if (bindingResult.hasErrors()) {
			return "allievo/modificaAllievo";
		}
		else {
			model.addAttribute(allievo);
			try{
				allievoService.addAllievo(allievo);
			}catch(Exception e){
				return"allievo/modificaAllievo";

			}
		}
		return "allievo/resultsAllievo";
	}
}
