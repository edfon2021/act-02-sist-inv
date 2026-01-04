package com.inventario.inventario_rest.inventario.dto;

public class PedidoRequest {
    private String fecha;
    private Double precioCompra;
    private Double precioVenta;
    private Long productoId;
    private Long proveedorId;
    private Integer cantidad;

    public PedidoRequest(){
        //Constructor vacio
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
