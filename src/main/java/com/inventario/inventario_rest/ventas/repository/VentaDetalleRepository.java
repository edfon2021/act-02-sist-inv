package com.inventario.inventario_rest.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.inventario_rest.ventas.entity.VentaDetalle;

public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Long> {
}
