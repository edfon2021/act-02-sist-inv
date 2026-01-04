package com.inventario.inventario_rest.inventario.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // opcional, pero claro
    private Long id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "subcategoria")
    private String subcategoria;

    // En tu BD: preciocompra (sin guion bajo)
    @Column(name = "preciocompra")
    private BigDecimal precioCompra;

    // En tu BD: precioventa (sin guion bajo)
    @Column(name = "precioventa")
    private BigDecimal precioVenta;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "color")
    private String color;

    @Column(name = "marca")
    private String marca;

    @Column(name = "descripcion")
    private String descripcion;

    public Producto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getSubcategoria() { return subcategoria; }
    public void setSubcategoria(String subcategoria) { this.subcategoria = subcategoria; }

    public BigDecimal getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(BigDecimal precioCompra) { this.precioCompra = precioCompra; }

    public BigDecimal getPrecioVenta() { return precioVenta; }
    public void setPrecioVenta(BigDecimal precioVenta) { this.precioVenta = precioVenta; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
