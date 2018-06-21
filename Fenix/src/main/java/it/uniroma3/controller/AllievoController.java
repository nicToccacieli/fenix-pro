package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.controller.validator.AllievoValidator;
import it.uniroma3.model.Allievo;
import it.uniroma3.service.AllievoService;

@Controller
public class AllievoController {
	
	@Autowired
    private AllievoService allievoService;

	/*@Autowired
    private AttivitaService attivitaService;*/
	
    @Autowired
    private AllievoValidator validator;

    @RequestMapping("/index")
    public String index() {
    	return "index";
    }
    
    @RequestMapping("/registrazione")
    public String registraAllievo() {
    	return "registrazione";
    }
    
    @RequestMapping("/elenco")
    public String elencoAllievo() {
    	return "elenco";
    }
    
    @RequestMapping("/allievi")
    public String allievi(Model model) {
        model.addAttribute("allievi", this.allievoService.findAll());
        return "allievoList";
    }

    @RequestMapping("/addAllievo")
    public String addAllievo(Model model) {
        model.addAttribute("allievo", new Allievo());
        return "allievoForm";
    }
    
    @RequestMapping(value = "/allievo/{id}", method = RequestMethod.GET)
    public String getAllievo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("allievo", this.allievoService.findById(id));
    	return "showAllievo";
    }

    @RequestMapping(value = "/allievo", method = RequestMethod.POST)
    public String newAllievo(@Valid @ModelAttribute("allievo") Allievo allievo, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(allievo, bindingResult);
        
        if (this.allievoService.alreadyExists(allievo)) {
            model.addAttribute("exists", "Allievo already exists");
            return "allievoForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.allievoService.save(allievo);
                model.addAttribute("allievi", this.allievoService.findAll());
                return "allievoList";
            }
        }
        return "allievoForm";
    }
    
    @GetMapping("/attivita/{id}/allievi")
    public String allieviAttivita(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("allievi", this.allievoService.findAllByAttivitaId(id));
    	return "allievoList";
    }
    
    @GetMapping("/iscrivi")
    public String iscrivi() {
    	//a = this.allievoService.findById(id);
       // a.getAttivita().add(this.attivitaService.findById(id));
        return "successo";
    }

}
