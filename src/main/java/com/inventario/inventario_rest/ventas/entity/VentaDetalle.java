package com.inventario.inventario_rest.ventas.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ventas_detalles")
public class VentaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // En tu BD: ventaid
    @Column(name = "ventaid", nullable = false)
    private Long ventaId;

    // En tu BD: productoid
    @Column(name = "productoid", nullable = false)
    private Long productoId;

    @Column(name = "nombreproducto")
    private String nombreProducto;

    @Column(name = "precio")
    private BigDecimal precio;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "subtotal")
    private BigDecimal subtotal;

    public VentaDetalle() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getVentaId() { return ventaId; }
    public void setVentaId(Long ventaId) { this.ventaId = ventaId; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}
