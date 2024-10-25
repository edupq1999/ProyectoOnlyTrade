package com.onlytrade.service;


import com.onlytrade.model.Persona;

public interface PersonaService {
	void crearPersona(Persona newPersona);
	Persona buscarPorUsuarioCorreo(String correo);
	void eliminarPersona(String correo);
	
}
