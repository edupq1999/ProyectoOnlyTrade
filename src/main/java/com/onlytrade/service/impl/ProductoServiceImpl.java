package com.onlytrade.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlytrade.model.Producto;
import com.onlytrade.repository.ProductoRepository;
import com.onlytrade.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService {
	ProductoRepository productoRepository;

	@Override
	public List<Producto> listarProducto() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> BuscarNombreProducto(String NombreProducto) {
		// TODO Auto-generated method stub
		return productoRepository.findByNombre(NombreProducto);
	}

	@Override
	public List<Producto> listarProductoPorCategoria(Integer idCategoria) {
		List<Producto> lstPorCategorias = productoRepository.findByCategoriaId(idCategoria);
		return lstPorCategorias;
	}

	@Override
	public void registrarProducto(Producto producto) {
		productoRepository.save(producto);
		
	}

}
