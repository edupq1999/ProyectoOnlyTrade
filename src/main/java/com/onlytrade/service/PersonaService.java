package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Persona;

public interface PersonaService {
	List<Persona>listarPersona();
	void crearPersona(Persona newPersona);
	Persona buscarPorUsuarioId(Integer usuarioId);
	void eliminarPersona(Integer usuarioId);
	
}
