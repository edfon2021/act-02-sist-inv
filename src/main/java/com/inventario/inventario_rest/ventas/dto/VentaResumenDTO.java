package com.inventario.inventario_rest.ventas.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class VentaResumenDTO {
    private Long ventaId;
    private String cliente;
    private BigDecimal total;
    private OffsetDateTime fecha;

    public VentaResumenDTO(Long ventaId, String cliente, BigDecimal total, OffsetDateTime fecha) {
        this.ventaId = ventaId;
        this.cliente = cliente;
        this.total = total;
        this.fecha = fecha;
    }

    public Long getVentaId() { return ventaId; }
    public String getCliente() { return cliente; }
    public BigDecimal getTotal() { return total; }
    public OffsetDateTime getFecha() { return fecha; }
}
