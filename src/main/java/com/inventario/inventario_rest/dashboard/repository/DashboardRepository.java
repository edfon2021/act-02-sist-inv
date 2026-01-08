package com.inventario.inventario_rest.dashboard.repository;
import com.inventario.inventario_rest.dashboard.dto.DashboardSubcategoriasRowDTO;
import com.inventario.inventario_rest.ventas.entity.VentaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DashboardRepository extends JpaRepository<VentaDetalle, Long> {

    @Query(
        "SELECT new com.inventario.inventario_rest.dashboard.dto.DashboardSubcategoriasRowDTO(" +
        " p.subcategoria, " +
        " CAST(EXTRACT(MONTH FROM v.fecha) AS integer), " +
        " CAST(EXTRACT(YEAR FROM v.fecha) AS integer), " +
        " SUM(d.cantidad), " +
        " AVG(d.precio), " +
        " AVG(p.precioCompra) " +
        ") " +
        "FROM VentaDetalle d " +
        "JOIN Producto p ON d.productoId = p.id " +
        "JOIN Venta v ON d.ventaId = v.id " +
        "GROUP BY p.subcategoria, EXTRACT(MONTH FROM v.fecha), EXTRACT(YEAR FROM v.fecha) " +
        "ORDER BY EXTRACT(YEAR FROM v.fecha), EXTRACT(MONTH FROM v.fecha)"
    )
    List<DashboardSubcategoriasRowDTO> dashboardSubcategoriasRows();
}
