package com.inventario.inventario_rest.dashboard.dto;

import java.math.BigDecimal;

public class DashboardSubcategoriasDTO {
    private String producto;
    private String mes;
    private Long ventas;
    private BigDecimal precio;
    private BigDecimal ingresos;

    public DashboardSubcategoriasDTO(String producto, String mes, Long ventas, BigDecimal precio, BigDecimal ingresos) {
        this.producto = producto;
        this.mes = mes;
        this.ventas = ventas;
        this.precio = precio;
        this.ingresos = ingresos;
    }

    public String getProducto() { return producto; }
    public String getMes() { return mes; }
    public Long getVentas() { return ventas; }
    public BigDecimal getPrecio() { return precio; }
    public BigDecimal getIngresos() { return ingresos; }
}

