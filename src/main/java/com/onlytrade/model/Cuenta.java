package com.onlytrade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_cuenta")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cuenta {

    @Id
    @Column(name = "correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "fk_rol", referencedColumnName = "rolId", nullable = false)
    private Roles rol;

	public String getCorreo() {
		return correo;
	}

	public String getPassword() {
		return password;
	}

	public Roles getRol() {
		return rol;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRol(Roles rol) {
		this.rol = rol;
	}
    
    
}
