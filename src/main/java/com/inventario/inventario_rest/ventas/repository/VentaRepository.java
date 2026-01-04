package com.inventario.inventario_rest.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.inventario_rest.ventas.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}