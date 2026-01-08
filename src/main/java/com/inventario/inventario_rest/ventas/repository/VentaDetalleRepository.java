package com.inventario.inventario_rest.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.inventario_rest.ventas.entity.VentaDetalle;
import com.inventario.inventario_rest.ventas.dto.VentaDetalleViewDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface VentaDetalleRepository extends JpaRepository<VentaDetalle, Long> {
    @Query("""
        SELECT new com.inventario.inventario_rest.ventas.dto.VentaDetalleViewDTO(
            d.id,
            p.sku,
            p.nombre,
            d.cantidad,
            d.precio,
            d.subtotal
        )
        FROM VentaDetalle d
        JOIN Producto p ON d.productoId = p.id
        WHERE d.ventaId = :ventaId
        ORDER BY d.id ASC
    """)
    List<VentaDetalleViewDTO> findDetalleByVentaId(@Param("ventaId") Long ventaId);
}
