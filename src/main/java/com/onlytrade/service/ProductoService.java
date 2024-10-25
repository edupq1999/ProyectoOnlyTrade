package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Producto;

public interface ProductoService {
	List<Producto>listarProductoPorCategoria(Integer idCategoria);
	List<Producto>BuscarNombreProducto(String NombreProducto);
	Producto buscarProductoPorId(Integer idProducto);
	
}
