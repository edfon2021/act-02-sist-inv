package com.inventario.inventario_rest.ventas.dto;

import java.math.BigDecimal;
import java.util.List;

public class VentaRequest {
    private String fecha;              // ISO string opcional
    private ClienteDTO cliente;        // NO es tabla, solo JSON
    private List<VentaDetalleDTO> detalles;
    private BigDecimal total;

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public ClienteDTO getCliente() { return cliente; }
    public void setCliente(ClienteDTO cliente) { this.cliente = cliente; }

    public List<VentaDetalleDTO> getDetalles() { return detalles; }
    public void setDetalles(List<VentaDetalleDTO> detalles) { this.detalles = detalles; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
