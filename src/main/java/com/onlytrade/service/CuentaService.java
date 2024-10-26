package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Cuenta;

public interface CuentaService {
	List<Cuenta>listarCuenta();
	void crearCuenta(Cuenta newCuenta);
	Cuenta buscarPorCorreo(String correo);
	void actualizarCuenta(Cuenta updatedCuenta);
	void eliminarCuenta(String cuentaId);
	String iniciarSesion(String correo, String password);
}
