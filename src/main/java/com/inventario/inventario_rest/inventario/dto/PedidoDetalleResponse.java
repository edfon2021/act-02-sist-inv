package com.inventario.inventario_rest.inventario.dto;

import java.math.BigDecimal;

public class PedidoDetalleResponse {
    private Long pedidoId;
    private String producto;
    private String proveedor;
    private Integer cantidad;
    private BigDecimal precioCompra;

    public PedidoDetalleResponse(Long pedidoId, String producto, String proveedor, Integer cantidad, BigDecimal precioCompra) {
        this.pedidoId = pedidoId;
        this.producto = producto;
        this.proveedor = proveedor;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
    }

    public Long getPedidoId() { return pedidoId; }
    public String getProducto() { return producto; }
    public String getProveedor() { return proveedor; }
    public Integer getCantidad() { return cantidad; }
    public BigDecimal getPrecioCompra() { return precioCompra; }
}
