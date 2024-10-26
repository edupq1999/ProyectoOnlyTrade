package com.onlytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Roles;
import com.onlytrade.service.CuentaService;
import com.onlytrade.service.RolesService;

import jakarta.servlet.http.HttpSession;

@SessionAttributes("cuenta")
@Controller
public class CuentaController {

	@Autowired
	private CuentaService cuentaService;

	@Autowired
	private RolesService rolesService;

	// Crear una nueva cuenta
	@GetMapping("/registrar_cuenta")
	public String mostrarFormularioRegistro(Model model) {
	    model.addAttribute("cuenta", new Cuenta());
	    return "registrar_cuenta";
	}

	@PostMapping("/registrar_cuenta")
	public String registrarCuenta(@ModelAttribute("cuenta") Cuenta cuenta, Model model) {
	    cuentaService.crearCuenta(cuenta);
	    return "redirect:/login";
	}


	// Actualizar cuenta a moderador
	@PostMapping("/actualizar/{correo}")
	public String actualizarAdminCuenta(@PathVariable String correo, Model model) {
		Cuenta updatedCuenta = cuentaService.buscarPorCorreo(correo);
		Roles admin = rolesService.listarRoles().get(1);
		updatedCuenta.setRol(admin);
		cuentaService.actualizarCuenta(updatedCuenta);
		return "redirect:/listar_cuentas";
	}

	// Eliminar una cuenta
	@GetMapping("/eliminar/{correo}")
	public String eliminarCuenta(@PathVariable String correo) {
		Cuenta cuenta = cuentaService.buscarPorCorreo(correo);
		if (cuenta == null) {
			return "La cuenta no existe";
		}
		cuentaService.eliminarCuenta(correo);
		return "redirect:/listar_cuentas";
	}

	// Iniciar sesión
	@GetMapping("/login")
	public String mostrarLogin(Model model) {
		return "login";
	}

	@PostMapping("/login")
	public String iniciarSesion(@RequestParam String correo, @RequestParam String password, Model model) {
		String resultadoLogin = cuentaService.iniciarSesion(correo, password);
		if (!resultadoLogin.equals("Exitoso")) {
			model.addAttribute("error", resultadoLogin);
			return "login";
		}
		Cuenta cuenta = cuentaService.buscarPorCorreo(correo);
		Roles rol = rolesService.listarRoles().get(0);
		if (cuenta.getRol().equals(rol)) {
			return "redirect:/admin";
		}
		model.addAttribute("cuenta", cuenta);
		return "redirect:/home";
	}
	
	// Cerrar sesión
	@GetMapping("/logout")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
