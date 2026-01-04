package com.inventario.inventario_rest.inventario.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.math.BigDecimal;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // timestamptz
    @Column(name = "fecha")
    private OffsetDateTime fecha;

    // numeric(12,2)
    @Column(name = "preciocompra")
    private BigDecimal precioCompra;

    // numeric(12,2)
    @Column(name = "precioventa")
    private BigDecimal precioVenta;

    @Column(name = "productoid", nullable = false)
    private Long productoId;

    @Column(name = "proveedorid", nullable = false)
    private Long proveedorId;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    public Pedido() {}

    public Long getId() { return id; }

    public OffsetDateTime getFecha() { return fecha; }
    public void setFecha(OffsetDateTime fecha) { this.fecha = fecha; }

    public BigDecimal getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(BigDecimal precioCompra) { this.precioCompra = precioCompra; }

    public BigDecimal getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(BigDecimal precioVenta) { this.precioVenta = precioVenta; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}
