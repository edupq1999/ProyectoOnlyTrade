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
@Table(name = "tb_persona")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usuarioId;
	
	@Column(name = "dni", nullable = false, unique = true)
	private String dni;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "apellido", nullable = false)
	private String apellido;
	
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;
	
	@Column(name = "rol", nullable = false)
	private String rol;
	
	@Column(name = "fNacimiento", nullable = false)
	private Date fNacimiento;
}
