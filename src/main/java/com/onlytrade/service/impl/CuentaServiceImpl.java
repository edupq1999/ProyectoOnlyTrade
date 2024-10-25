package com.onlytrade.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Persona;
import com.onlytrade.repository.CuentaRepository;
import com.onlytrade.repository.PersonaRepository;
import com.onlytrade.repository.RolesRepository;
import com.onlytrade.service.CuentaService;
import com.onlytrade.service.PersonaService;
import com.onlytrade.utils.Utilitarios;
@Service
public class CuentaServiceImpl implements CuentaService, PersonaService {
	private CuentaRepository cuentaRepository;
	private RolesRepository rolesRepository;
	private PersonaRepository personaRepository;

	@Override
	public List<Cuenta> listarCuenta() {
		// TODO Auto-generated method stub
		return cuentaRepository.findAll();
	}

	@Override
	public void crearCuenta(Cuenta newCuenta, Persona newPersona) {
		// TODO Auto-generated method stub
		String passwordHash = Utilitarios.extraerHash(newCuenta.getPassword());
		newCuenta.setPassword(passwordHash);
		newCuenta.setRol(rolesRepository.findAll().get(0));
		cuentaRepository.save(newCuenta);
		crearPersona(newPersona);
	}

	@Override
	public Cuenta buscarPorCorreo(String correo) {
		Cuenta cuenta = cuentaRepository.findById(correo).orElse(null);
		return cuenta;
	}

	@Override
	public void actualizarCuenta(Cuenta updatedCuenta) {
		// TODO Auto-generated method stub
		Cuenta cuenta = buscarPorCorreo(updatedCuenta.getCorreo());
		cuenta.setRol(updatedCuenta.getRol());
		cuentaRepository.save(cuenta);
	}

	@Override
	public void eliminarCuenta(String correo) {
		Cuenta cuenta = buscarPorCorreo(correo);
		if (cuenta != null) {
			cuentaRepository.delete(cuenta);
		}
		Persona persona = buscarPorUsuarioCorreo(correo);
	    if (persona != null) {  
	        personaRepository.delete(persona);
	    }
	}

	@Override
	public String iniciarSesion(String correo, String password) {
		Cuenta cuenta = buscarPorCorreo(correo);
		if (cuenta == null) {
			return "El correo no existe";
		} else if (!Utilitarios.checkPassword(password, cuenta.getPassword())) {
			return "Contraseña incorrecta";
		} else {
			return "Exitoso";
		}
	}

	@Override
	public void crearPersona(Persona newPersona) {
		// TODO Auto-generated method stub
		personaRepository.save(newPersona);;
	}

	@Override
	public Persona buscarPorUsuarioCorreo(String correo) {
		// TODO Auto-generated method stub
		return personaRepository.findByCorreo(correo);
	}

	@Override
	public void eliminarPersona(String correo) {
		Persona persona = buscarPorUsuarioCorreo(correo);
	    if (persona != null) {  
	        personaRepository.delete(persona);
	    }
	}

}
