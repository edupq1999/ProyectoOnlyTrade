package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Persona;

public interface PersonaService {
	List<Persona>listarPersona();
	void crearPersona(Persona newPersona);
	void eliminarPersona(Integer usuarioId);
	
}
