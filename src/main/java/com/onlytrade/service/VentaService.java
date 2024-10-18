package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Venta;

public interface VentaService {
	List<Venta>listarVenta();
	void crearVenta(Venta newVenta);
	void eliminarVenta(Integer ventaId);
}
