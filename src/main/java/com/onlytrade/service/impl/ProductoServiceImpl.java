package com.onlytrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlytrade.model.Categoria;
import com.onlytrade.model.Producto;
import com.onlytrade.repository.ProductoRepository;
import com.onlytrade.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository productoRepository;

	@Override
	public List<Producto> BuscarNombreProducto(String NombreProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findByNombre(NombreProducto);
	}

	@Override
	public List<Producto> listarProductoPorCategoria(Categoria Categoria) {
		List<Producto> lstPorCategorias = productoRepository.findByCategoria(Categoria);
		return lstPorCategorias;
	}

	@Override
	public Producto buscarProductoPorId(Integer idProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findById(idProducto).get();
	}

}
