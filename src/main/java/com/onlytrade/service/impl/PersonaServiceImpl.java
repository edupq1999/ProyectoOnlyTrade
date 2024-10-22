package com.onlytrade.service.impl;

import java.util.List;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Persona;
import com.onlytrade.repository.PersonaRepository;
import com.onlytrade.service.PersonaService;


public class PersonaServiceImpl implements PersonaService{
	private PersonaRepository personaRepository;
	@Override
	public List<Persona> listarPersona() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public void crearPersona(Persona newPersona) {
		// TODO Auto-generated method stub
		personaRepository.save(newPersona);
	}

	@Override
	public void eliminarPersona(Integer usuarioId) {
	    Persona persona = personaRepository.findById(usuarioId).get();
	    if (persona != null) {  
	        personaRepository.delete(persona);
	    }
	}

	@Override
	public Persona buscarPorUsuarioId(Integer usuarioId) {
		    return personaRepository.findById(usuarioId).orElse(null);
		}

	
}
