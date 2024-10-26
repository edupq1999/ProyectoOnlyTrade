package com.onlytrade.service;

import java.util.List;

import com.onlytrade.model.Categoria;
import com.onlytrade.model.Producto;

public interface ProductoService {
	List<Producto>listarProductoPorCategoria(Categoria categoria);
	List<Producto>BuscarNombreProducto(String NombreProducto);
	Producto buscarProductoPorId(Integer idProducto);
	
}
