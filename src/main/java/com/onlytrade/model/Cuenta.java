package com.onlytrade.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_cuenta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cuenta {
	
	@Id
	@Column(name = "user")
	private Integer user;
	
	@Column(name = "password", nullable = false)
	private String password;
}
