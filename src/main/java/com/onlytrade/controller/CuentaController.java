package com.onlytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Roles;
import com.onlytrade.service.CuentaService;
import com.onlytrade.service.RolesService;


@Controller
public class CuentaController {

    @Autowired
    private CuentaService cuentaService;
    
    @Autowired
    private RolesService rolesService;

    // Listar todas las cuentas
    @GetMapping("/listar_cuentas")
    public String listarCuentas(Model model) {
    	model.addAttribute("lstCuentas", cuentaService.listarCuenta());
        return "listar_cuentas";
    }

    // Crear una nueva cuenta
    @GetMapping("/registrar_cuenta")
    public String mostrarCuenta(Model model) {
    	model.addAttribute("cuenta", new Cuenta());
        return "registrar_cuenta";
    }
    
    @PostMapping("/registrar_cuenta")
	public String registrarCuenta(@ModelAttribute("cuenta") Cuenta newCuenta,
			Model model) {
    	cuentaService.crearCuenta(newCuenta);
		return "listar_cuentas";
	}

    // Actualizar cuenta a moderador
    @PostMapping("/actualizar/{correo}")
    public String actualizarAdminCuenta(@PathVariable String correo, Model model) {
    	Cuenta updatedCuenta = cuentaService.buscarPorCorreo(correo);
    	Roles admin = rolesService.listarRoles().get(1);
    	updatedCuenta.setRol(admin);
    	cuentaService.actualizarCuenta(updatedCuenta);
        return "listar_cuentas";
    }

    // Eliminar una cuenta
    @PostMapping("/eliminar/{correo}")
    public String eliminarCuenta(@PathVariable String correo) {
    	Cuenta cuenta = cuentaService.buscarPorCorreo(correo);
    	if (cuenta == null) {
    		// Posible alerta
            return "La cuenta no existe";
        }
    	cuentaService.eliminarCuenta(correo);
        return "listar_cuentas";
    }

    // Iniciar sesión
    @PostMapping("/login")
    public String iniciarSesion(@RequestParam String correo, @RequestParam String password, Model model) {
        String resultadoLogin = cuentaService.iniciarSesion(correo, password);
        if (!resultadoLogin.equals("Exitoso")) {
            model.addAttribute("error", resultadoLogin);
            return "login";
        }
        Cuenta cuenta = cuentaService.buscarPorCorreo(correo);
        Roles rol = rolesService.listarRoles().get(1);
        if(cuenta.getRol().equals(rol)) {
        	return "admin";
        }
        return "home";
    }
}
