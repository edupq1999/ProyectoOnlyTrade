package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Cuenta;

public interface CuentaService {
	List<Cuenta>listarCuenta();
	void crearCuenta(Cuenta newCuenta);
	void actualizarCuenta(Cuenta updatedCuenta);
	void eliminarCuenta(Integer cuentaId);
}
