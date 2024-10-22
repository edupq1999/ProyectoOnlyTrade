package com.onlytrade.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlytrade.model.Venta;
import com.onlytrade.repository.VentaRepository;
import com.onlytrade.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService{
		private VentaRepository ventaRepository;
	@Override
	public List<Venta> listarVenta() {
		// TODO Auto-generated method stub
		return ventaRepository.findAll();
	}

	@Override
	public void crearVenta(Venta newVenta) {
		// TODO Auto-generated method stub
		ventaRepository.save(newVenta);
	}

	@Override
	public void eliminarVenta(Integer ventaId) {
	    Venta venta = ventaRepository.findById(ventaId).orElse(null);
	    if (venta != null) {
	        ventaRepository.delete(venta);
	    }
	}
}


