package com.onlytrade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlytrade.model.Categoria;
import com.onlytrade.repository.CategoriaRepository;
import com.onlytrade.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> listarCategoria() {
		// TODO Auto-generated method stub
		return categoriaRepository.findAll();
	}

	@Override
	public Categoria buscarCategoriaPorId(Integer categoriaId) {
		// TODO Auto-generated method stub
		return categoriaRepository.findById(categoriaId).orElse(null);
	}

}
