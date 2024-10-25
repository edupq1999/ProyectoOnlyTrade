package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Persona;

public interface CuentaService {
	List<Cuenta>listarCuenta();
	void crearCuenta(Cuenta newCuenta, Persona newPersona);
	Cuenta buscarPorCorreo(String correo);
	void actualizarCuenta(Cuenta updatedCuenta);
	void eliminarCuenta(String cuentaId);
	String iniciarSesion(String correo, String password);
}
