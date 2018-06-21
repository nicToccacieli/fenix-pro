package it.uniroma3.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.controller.validator.DocenteValidator;
import it.uniroma3.model.Docente;
import it.uniroma3.service.DocenteService;

@Controller
public class DocenteController {
	
	@Autowired
    private DocenteService docenteService;

    @Autowired
    private DocenteValidator validator;
    
    @RequestMapping("/docenti")
    public String docenti(Model model) {
        model.addAttribute("docenti", this.docenteService.findAll());
        return "docenteList";
    }

    @RequestMapping("/addDocente")
    public String addDocente(Model model) {
        model.addAttribute("docente", new Docente());
        return "docenteForm";
    }

    @RequestMapping(value = "/docente/{id}", method = RequestMethod.GET)
    public String getDocente(@PathVariable("id") Long id, Model model) {
        model.addAttribute("docente", this.docenteService.findById(id));
    	return "showDocente";
    }

    /**
     * @param docente
     * @param model
     * @param bindingResult
     * @return
     */
    @RequestMapping(value = "/docente", method = RequestMethod.POST)
    public String newDocente(@Valid @ModelAttribute("docente") Docente docente, 
    									Model model, BindingResult bindingResult) {
        this.validator.validate(docente, bindingResult);
        
        if (this.docenteService.alreadyExists(docente)) {
            model.addAttribute("exists", "Docente already exists");
            return "docenteForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.docenteService.save(docente);
                model.addAttribute("docenti", this.docenteService.findAll());
                return "docenteList";
            }
        }
        return "docenteForm";
    }

}
