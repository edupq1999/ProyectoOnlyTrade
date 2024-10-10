package com.onlytrade.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer ventaId;

	@Column(name = "usuario", nullable = false)
	private String usuario;

	@Column(name = "producto", nullable = false)
	private Integer producto;

	@Column(name = "cantidad", nullable = false)
	private Double cantidad;

	@Column(name = "montoTotal", nullable = false)
	private String montoTotal;

	@Column(name = "fVenta", nullable = false)
	private Date fVenta;
}
