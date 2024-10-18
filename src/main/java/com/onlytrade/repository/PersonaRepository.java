package com.onlytrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlytrade.model.Persona;
import com.onlytrade.model.Producto;


public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	List<Persona>listarPersona();
	List<Persona>findByBuscarNombrePersona(String NombrePersona);
}
