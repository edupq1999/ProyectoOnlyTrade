package com.onlytrade.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tb_venta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ventaId;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "montoTotal", nullable = false)
    private Double montoTotal;

    @Column(name = "fVenta", nullable = false)
    private Date fVenta;

    @ManyToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "usuarioId", nullable = false)
    private Persona persona;

    @ManyToMany
    @JoinTable(
        name = "tb_venta_producto",
        joinColumns = @JoinColumn(name = "venta_id"),
        inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    private List<Producto> productos;
}
