package com.inventario.inventario_rest.dashboard.dto;

import java.math.BigDecimal;

public class DashboardSubcategoriasRowDTO {
    private String producto;
    private Integer mesNum;
    private Integer anio;
    private Long ventasTotales;
    private BigDecimal precioPromedioVenta;
    private BigDecimal precioPromedioCompra;

    // Constructor compatible con tipos reales que devuelve Hibernate (AVG suele ser Double)
    public DashboardSubcategoriasRowDTO(
            String producto,
            Number mesNum,
            Number anio,
            Number ventasTotales,
            Number precioPromedioVenta,
            Number precioPromedioCompra
    ) {
        this.producto = producto;
        this.mesNum = (mesNum == null) ? null : mesNum.intValue();
        this.anio = (anio == null) ? null : anio.intValue();

        this.ventasTotales = (ventasTotales == null) ? null : ventasTotales.longValue();

        this.precioPromedioVenta = (precioPromedioVenta == null)
                ? null
                : new BigDecimal(precioPromedioVenta.toString());

        this.precioPromedioCompra = (precioPromedioCompra == null)
                ? null
                : new BigDecimal(precioPromedioCompra.toString());
    }

    public String getProducto() { return producto; }
    public Integer getMesNum() { return mesNum; }
    public Integer getAnio() { return anio; }
    public Long getVentasTotales() { return ventasTotales; }
    public BigDecimal getPrecioPromedioVenta() { return precioPromedioVenta; }
    public BigDecimal getPrecioPromedioCompra() { return precioPromedioCompra; }
}
