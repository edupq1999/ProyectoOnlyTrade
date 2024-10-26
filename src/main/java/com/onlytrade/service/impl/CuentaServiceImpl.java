package com.onlytrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Roles;
import com.onlytrade.repository.CuentaRepository;
import com.onlytrade.repository.RolesRepository;
import com.onlytrade.service.CuentaService;
import com.onlytrade.service.RolesService;
import com.onlytrade.utils.Utilitarios;
@Service
public class CuentaServiceImpl implements CuentaService, RolesService {
	
	@Autowired
	private CuentaRepository cuentaRepository;
	
	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public List<Cuenta> listarCuenta() {
		// TODO Auto-generated method stub
		return cuentaRepository.findAll();
	}

	@Override
	public void crearCuenta(Cuenta newCuenta) {
		// TODO Auto-generated method stub
		String passwordHash = Utilitarios.extraerHash(newCuenta.getPassword());
		newCuenta.setPassword(passwordHash);
		List<Roles> roles = listarRoles();
	    if (roles != null && roles.size() > 1) {
	        newCuenta.setRol(roles.get(1));
	    }
	    cuentaRepository.save(newCuenta);
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
	public List<Roles> listarRoles() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

}
