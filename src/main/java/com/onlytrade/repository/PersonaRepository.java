package com.onlytrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlytrade.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	List<Persona>findByBuscarNombrePersona(String NombrePersona);
}
