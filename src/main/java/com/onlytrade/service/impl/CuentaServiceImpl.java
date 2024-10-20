package com.onlytrade.service.impl;

import java.util.List;

import com.onlytrade.model.Cuenta;
import com.onlytrade.repository.CuentaRepository;
import com.onlytrade.service.CuentaService;


public class CuentaServiceImpl implements CuentaService{
		private CuentaRepository cuentaRepository;
	@Override
	public List<Cuenta> listarCuenta() {
		// TODO Auto-generated method stub
		return cuentaRepository.findAll();
	}

	@Override
	public void crearCuenta(Cuenta newCuenta) {
		// TODO Auto-generated method stub
		cuentaRepository.save(newCuenta);
	}

	@Override
	public void actualizarCuenta(Cuenta updatedCuenta) {
		// TODO Auto-generated method stub
		Cuenta cuenta = cuentaRepository.findByCorreo(updatedCuenta.getCorreo());
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
	public Cuenta buscarPorCorreo(String correo) {
		Cuenta cuenta = cuentaRepository.findById(correo).orElse(null);
		return cuenta;
	}

	
}
