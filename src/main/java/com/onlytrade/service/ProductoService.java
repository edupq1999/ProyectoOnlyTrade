package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Producto;

public interface ProductoService {
	List<Producto>listarProducto();
	List<Producto>BuscarNombreProducto(String NombreProducto);
	
}
