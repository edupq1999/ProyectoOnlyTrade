package com.onlytrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlytrade.model.Categoria;
import com.onlytrade.model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	List<Producto> findByNombreContaining(String nombreProducto);
	List<Producto>findByCategoria(Categoria categoria);
}
