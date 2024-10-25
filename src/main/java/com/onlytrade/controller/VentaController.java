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

import com.onlytrade.model.Persona;
import com.onlytrade.model.Producto;
import com.onlytrade.model.Venta;
import com.onlytrade.service.PersonaService;
import com.onlytrade.service.ProductoService;
import com.onlytrade.service.VentaService;
@Controller
public class VentaController {

	 @Autowired
	    private VentaService ventaService;
	    
	    @Autowired
	    private ProductoService productoService;
	    @Autowired
	    private PersonaService personaService;
	    
	    
        //LISTAR VENTA///
		
		@GetMapping("/lista_Venta")
		public String listarVentas(Model model) {
			List<Venta>listaVenta = ventaService.listarVenta();
			model.addAttribute("listaventa", listaVenta);
			return "lista_Venta";
		}
		
		//REGISTRAR VENTA//
		
		@GetMapping("/registrar_venta")
		public String mostrarRegistrarVenta(Model model) {
			List<Producto>listaProdu= productoService.listarProducto();
			List<Persona>listaPers= personaService.listarPersona();
			model.addAttribute("producto",listaProdu);
			model.addAttribute("persona",listaPers);
			model.addAttribute("venta", new Venta());
			return "registrar_venta";
		}
		
		
		@PostMapping("/registrar_venta")
		public String registrarventa(@ModelAttribute("venta") Venta vent
				, Model model) {
			
			ventaService.crearVenta(vent);
			return "redirect:/lista_Venta/";
			
		}
		
		//ELIMINAR VENTA//
		
		@GetMapping("/delete/{ventaId}")
		public String deleteVenta(Model model, @PathVariable("ventaId") Integer ventaId) {
			ventaService.eliminarVenta(ventaId);
			return "redirect:/lista_Venta";
		}
		
		
		
		
		
		
		
		
		
		
}
