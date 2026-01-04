package com.inventario.inventario_rest.inventario.service;

import com.inventario.inventario_rest.inventario.dto.PedidoRequest;
import com.inventario.inventario_rest.inventario.entity.Pedido;
import com.inventario.inventario_rest.inventario.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import com.inventario.inventario_rest.inventario.repository.PedidoRepository.PedidoDetalleProjection;
import java.util.List;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido registrarPedido(PedidoRequest request) {

        // Validaciones mínimas (igual a tu Node)
        if (request == null ||
            request.getProductoId() == null ||
            request.getProveedorId() == null ||
            request.getCantidad() == null ||
            request.getCantidad() <= 0) {
            throw new IllegalArgumentException("Datos incompletos para registrar pedido");
        }

        Pedido pedido = new Pedido();

        // fecha: si viene null, usar ahora
        pedido.setFecha(
                request.getFecha() != null && !request.getFecha().isBlank()
                        ? OffsetDateTime.parse(request.getFecha())
                        : OffsetDateTime.now()
        );

        // numeric(12,2) en PostgreSQL: usar BigDecimal
        // Si PedidoRequest usa Double, convertimos aquí.
        pedido.setPrecioCompra(
                request.getPrecioCompra() != null
                        ? BigDecimal.valueOf(request.getPrecioCompra())
                        : null
        );

        pedido.setPrecioVenta(
                request.getPrecioVenta() != null
                        ? BigDecimal.valueOf(request.getPrecioVenta())
                        : null
        );

        pedido.setProductoId(request.getProductoId());
        pedido.setProveedorId(request.getProveedorId());
        pedido.setCantidad(request.getCantidad());

        // Guardar (INSERT)
        return pedidoRepository.save(pedido);
    }

    public List<PedidoDetalleProjection> listarPedidosDetalle() {
        return pedidoRepository.findPedidosDetalle();
     }
}
