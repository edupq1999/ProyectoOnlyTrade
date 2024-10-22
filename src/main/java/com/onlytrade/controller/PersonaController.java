package com.onlytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlytrade.model.Persona;
import com.onlytrade.service.PersonaService;
@Controller
public class PersonaController {

	 @Autowired
	    private PersonaService personaService;
	
	 				// LISTAR PERSONAS
    @GetMapping("/listar_personas")
    public String listarPersonas(Model model) {
    	model.addAttribute("lstPersonas", personaService.listarPersona());
        return "listar_personas";
    }

    				// CREAR PERSONA
    @GetMapping("/crear_persona")
    public String mostrarPersona(Model model) {
    	model.addAttribute("persona", new Persona());
        return "crear_persona";
    }
    
    @PostMapping("/crear_persona")
	public String crearPersona(@ModelAttribute("persona") Persona newPersona,
			Model model) {
    	personaService.crearPersona(newPersona);
		return "listar_personas";
	}
    
    			// ELIMNAR PERSONA
    
    @PostMapping("/eliminarPersona/{usuarioId}")
    public String eliminarPerosna(@PathVariable Integer usuarioId) {
    	Persona persona = personaService.buscarPorUsuarioId(usuarioId);
    	if (persona == null) {
    		// Posible alerta
            return "La Persona no existe";
        }
    	personaService.eliminarPersona(usuarioId);
        return "listar_personas";
    }
    
    
    
}
