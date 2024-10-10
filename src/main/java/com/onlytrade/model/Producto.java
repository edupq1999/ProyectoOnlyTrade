package com.onlytrade.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_producto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productoId;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "stock", nullable = false)
	private Integer stock;
	
	@Column(name = "precio", nullable = false)
	private Double precio;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	@Column(name = "categoria", nullable = false)
	private String categoria;
	
	@Column(name = "fEntrada", nullable = false)
	private Date fEntrada;
}
