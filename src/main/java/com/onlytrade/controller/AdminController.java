package com.onlytrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlytrade.model.Cuenta;
import com.onlytrade.model.Venta;
import com.onlytrade.service.CuentaService;
import com.onlytrade.service.VentaService;

@Controller
public class AdminController {

    @Autowired
    private CuentaService cuentaService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/panel_admin")
    public String panelAdmin(Model model) {
        List<Venta> lstVentas = ventaService.listarVenta();
        List<Cuenta> lstCuentas = cuentaService.listarCuenta();

        model.addAttribute("lstVentas", lstVentas);
        model.addAttribute("lstCuentas", lstCuentas);
        return "panel_admin";
    }

}
