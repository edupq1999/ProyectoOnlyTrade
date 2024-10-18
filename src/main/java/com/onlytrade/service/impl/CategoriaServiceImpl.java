package com.onlytrade.service.impl;


import java.util.List;

import com.onlytrade.model.Categoria;
import com.onlytrade.repository.CategoriaRepository;
import com.onlytrade.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService{
	
		private CategoriaRepository categoriaRepository;
	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

}
