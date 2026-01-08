package com.inventario.inventario_rest.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.inventario.inventario_rest.ventas.dto.VentaResumenDTO;
import com.inventario.inventario_rest.ventas.entity.Venta;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta, Long> {
    @Query("""
        SELECT new com.inventario.inventario_rest.ventas.dto.VentaResumenDTO(
            v.id,
            CONCAT(v.nombreCliente, ' ', v.apellidosCliente),
            v.total,
            v.fecha
        )
        FROM Venta v
        ORDER BY v.id DESC
    """)
    List<VentaResumenDTO> findVentasResumen();
}