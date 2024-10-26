package com.onlytrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/home/buscarPorNombre")
	public String listarProductoPorNombre(Model model, @RequestParam String cadena) {
		List<Producto> listaProducto = productoService.BuscarNombreProducto(cadena);
		System.out.println(cadena);
		model.addAttribute("lstProductos", listaProducto);
		return "lista_producto";
	}

	// Listar productos por categoria
	@GetMapping("/home/buscarPorCategoria/{categoriaId}")
	public String listarPorCategoria(Model model, @ModelAttribute("categoriaId") Integer categoriaId) {
		Categoria categoria = categoriaService.buscarCategoriaPorId(categoriaId);
		List<Producto> listaProducto = productoService.listarProductoPorCategoria(categoria);
		model.addAttribute("lstProductos", listaProducto);
		return "lista_producto";
	}

	// Listar categorias
	@GetMapping("/home")
	public String listarCategorias(Model model) {
		List<Categoria> listaCategorias = categoriaService.listarCategoria();
		model.addAttribute("lstCategorias", listaCategorias);
		return "home";
	}

	@GetMapping("/producto/{id}")
	public String detalleProducto(Model model, @PathVariable Integer id) {
		System.out.println("ID recibido: " + id); // Agrega esta línea para depurar
		Producto producto = productoService.buscarProductoPorId(id);
		model.addAttribute("producto", producto);
		return "/producto";
	}
}
