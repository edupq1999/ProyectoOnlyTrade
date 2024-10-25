package com.onlytrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.onlytrade.model.Categoria;
import com.onlytrade.model.Producto;
import com.onlytrade.service.CategoriaService;
import com.onlytrade.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	@Autowired
	private CategoriaService categoriaService;

	// Listar productos por nombre
	@PostMapping("/home/buscarPorNombre")
	public String listarProductoPorNombre(Model model, @ModelAttribute("input") String nombre) {
		List<Producto> listaProducto = productoService.BuscarNombreProducto(nombre);
		model.addAttribute("lstProductos", listaProducto);
		return "redirect:/lista_producto";
	}

	// Listar productos por categoria
	@PostMapping("/home/buscarPorCategoria")
	public String listarPorCategoria(Model model, @ModelAttribute("categoriaId") Integer categoriaId) {
		List<Producto> listaProducto = productoService.listarProductoPorCategoria(categoriaId);
		model.addAttribute("lstProductos", listaProducto);
		return "redirect:/lista_producto";
	}

	// Listar categorias
	@GetMapping("/home")
	public String listarCategorias(Model model) {
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		model.addAttribute("lstCategorias", listaCategorias);
		return "home";
	}

	@GetMapping("/producto/{id}")
	public String detalleProducto(Model model, @PathVariable Integer idProducto) {
		Producto producto = productoService.buscarProductoPorId(idProducto);
		model.addAttribute("producto", producto);
		return "/producto/{id}";
	}
}
