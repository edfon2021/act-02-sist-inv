package com.inventario.inventario_rest.ventas.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Si en la BD es timestamp / timestamptz
    @Column(name = "fecha")
    private OffsetDateTime fecha;

    @Column(name = "nombrecliente")
    private String nombreCliente;

    @Column(name = "apellidoscliente")
    private String apellidosCliente;

    @Column(name = "cedulacliente")
    private String cedulaCliente;

    @Column(name = "direccioncliente")
    private String direccionCliente;

    @Column(name = "total")
    private BigDecimal total;

    public Venta() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public OffsetDateTime getFecha() { return fecha; }
    public void setFecha(OffsetDateTime fecha) { this.fecha = fecha; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getApellidosCliente() { return apellidosCliente; }
    public void setApellidosCliente(String apellidosCliente) { this.apellidosCliente = apellidosCliente; }

    public String getCedulaCliente() { return cedulaCliente; }
    public void setCedulaCliente(String cedulaCliente) { this.cedulaCliente = cedulaCliente; }

    public String getDireccionCliente() { return direccionCliente; }
    public void setDireccionCliente(String direccionCliente) { this.direccionCliente = direccionCliente; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}
