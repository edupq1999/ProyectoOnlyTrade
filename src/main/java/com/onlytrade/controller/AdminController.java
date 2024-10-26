package com.onlytrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlytrade.service.CuentaService;
import com.onlytrade.service.VentaService;

public class AdminController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/admin")
    public String panelAdmin(Model model) {
        model.addAttribute("lstVentas", ventaService.listarVenta());
        model.addAttribute("lstCuentas", cuentaService.listarCuenta());
        return "admin";
    }

}
