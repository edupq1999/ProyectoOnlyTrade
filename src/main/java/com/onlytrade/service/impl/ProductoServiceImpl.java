package com.onlytrade.service.impl;


import java.util.List;

import com.onlytrade.model.Producto;
import com.onlytrade.repository.ProductoRepository;
import com.onlytrade.service.ProductoService;

public class ProductoServiceImpl implements ProductoService{
		ProductoRepository productoRepository;
	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> BuscarNombreProducto(String NombreProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findByBuscarNombreProducto(NombreProducto);
	}
	
}
