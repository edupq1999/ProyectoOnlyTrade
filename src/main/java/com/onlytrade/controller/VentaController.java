package com.onlytrade.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Producto;
import com.onlytrade.model.Venta;
import com.onlytrade.service.CuentaService;
import com.onlytrade.service.ProductoService;
import com.onlytrade.service.VentaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class VentaController {

	@Autowired
	private VentaService ventaService;

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private CuentaService cuentaService;

	@PostMapping("/producto/{id}/venta")
	public String registrarVentaDesdeProducto(
			@PathVariable("id") Integer idProducto,
			@RequestParam("cantidad") Integer cantidad,
			HttpSession session,
			Model model) {

		Producto producto = productoService.buscarProductoPorId(idProducto);

		if (producto == null) {
			model.addAttribute("error", "Producto no encontrado");
			return "error";
		}

		Venta nuevaVenta = new Venta();
		nuevaVenta.setCantidad(cantidad);
		nuevaVenta.setMontoTotal(producto.getPrecio() * cantidad);
		nuevaVenta.setProductos(List.of(producto));

		String correoUsuario = (String) session.getAttribute("usuarioCorreo");
		Cuenta persona = cuentaService.buscarPorCorreo(correoUsuario);
		nuevaVenta.setPersona(persona);
		nuevaVenta.setfVenta(new Date());

		ventaService.crearVenta(nuevaVenta);

		return "redirect:/lista_Venta";
	}

	// Eliminar venta
	@GetMapping("/delete/{ventaId}")
	public String deleteVenta(Model model, @PathVariable("ventaId") Integer ventaId) {
		ventaService.eliminarVenta(ventaId);
		return "redirect:/lista_Venta";
	}

}
