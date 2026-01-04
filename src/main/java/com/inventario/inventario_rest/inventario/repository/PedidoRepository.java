package com.inventario.inventario_rest.inventario.repository;

import com.inventario.inventario_rest.inventario.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    interface PedidoDetalleProjection {
        Long getPedidoId();
        String getProducto();
        String getProveedor();
        Integer getCantidad();
        BigDecimal getPrecioCompra();
    }

    @Query(value = """
        SELECT
          p.id          AS pedidoId,
          prod.nombre   AS producto,
          prov.nombre   AS proveedor,
          p.cantidad    AS cantidad,
          p.preciocompra AS precioCompra
        FROM pedidos p
        JOIN productos prod ON p.productoid = prod.id
        JOIN proveedores prov ON p.proveedorid = prov.id
        ORDER BY p.id DESC
        """, nativeQuery = true)
    List<PedidoDetalleProjection> findPedidosDetalle();
}
