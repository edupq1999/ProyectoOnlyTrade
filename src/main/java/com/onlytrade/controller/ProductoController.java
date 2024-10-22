package com.onlytrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlytrade.model.Categoria;
import com.onlytrade.model.Producto;
import com.onlytrade.service.CategoriaService;
import com.onlytrade.service.ProductoService;
@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
    private ProductoService productoService;
	@Autowired
    private CategoriaService categoriaService;
	
	//LISTAR PRODUCTO///
	
		@GetMapping("/Producto")
		public String listarProducto(Model model) {
			List<Producto>listaProducto = productoService.listarProducto();
			model.addAttribute("listpro", listaProducto);
			return "lista_producto";
		}
		
					//REGISTRAR PRODUCTO//
		
		@GetMapping("/registrar_producto")
		public String mostrarRegistrarProducto(Model model) {
			List<Categoria>listaCategoria= categoriaService.listarCategoria();
			model.addAttribute("categorias",listaCategoria);
			model.addAttribute("producto", new Producto());
		return "registrar_producto";
		}
		
		@PostMapping("/registrar_producto")
		public String registrarProducto(@ModelAttribute("producto") Producto pro
				, Model model) {
			
			productoService.registrarProducto(pro);
			return "redirect:/producto/";
			
		}
	
						//LISTAR POR CATEGORIA///
		
		@GetMapping("/categoria_producto/{idCategoria}")
		public String verDetalleCategoria(Model model, @PathVariable("idCategoria") Integer idCategoria) {
			List<Producto>listaProductoCat = productoService.listarProductoPorCategoria(idCategoria);
			model.addAttribute("listaProductoCat", listaProductoCat);
		return "categoria_producto";
		}
		
		
		
		
		
		
		
		
		




}
