package com.onlytrade.service.impl;

import java.util.List;

import com.onlytrade.model.Cuenta;
import com.onlytrade.repository.CuentaRepository;
import com.onlytrade.service.CuentaService;

import jakarta.persistence.EntityNotFoundException;

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
		
	}

	@Override
	public void eliminarVenta(Integer ventaId) {
	    
	    Cuenta cuenta = cuentaRepository.findById(ventaId).orElse(null);
	    
	    if (cuenta != null) {
	       
	        cuentaRepository.delete(cuenta);
	    }
	   
	}

	
}
