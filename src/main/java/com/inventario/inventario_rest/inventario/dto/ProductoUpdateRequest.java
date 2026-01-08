package com.inventario.inventario_rest.inventario.dto;

import java.math.BigDecimal;

public class ProductoUpdateRequest {
    private BigDecimal precioCompra;
    private BigDecimal precioVenta;
    private Integer cantidad;

    public ProductoUpdateRequest() {}

    public BigDecimal getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(BigDecimal precioCompra) { this.precioCompra = precioCompra; }

    public BigDecimal getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(BigDecimal precioVenta) { this.precioVenta = precioVenta; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
}
