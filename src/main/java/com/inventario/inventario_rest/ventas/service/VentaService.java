package com.inventario.inventario_rest.ventas.service;

import com.inventario.inventario_rest.ventas.dto.VentaDetalleDTO;
import com.inventario.inventario_rest.ventas.dto.VentaRequest;
import com.inventario.inventario_rest.ventas.entity.Venta;
import com.inventario.inventario_rest.ventas.entity.VentaDetalle;
import com.inventario.inventario_rest.ventas.repository.VentaDetalleRepository;
import com.inventario.inventario_rest.ventas.repository.VentaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class VentaService {

    private final VentaRepository ventaRepository;
    private final VentaDetalleRepository ventaDetalleRepository;

    public VentaService(VentaRepository ventaRepository,
                        VentaDetalleRepository ventaDetalleRepository) {
        this.ventaRepository = ventaRepository;
        this.ventaDetalleRepository = ventaDetalleRepository;
    }

    @Transactional
    public Long registrarVenta(VentaRequest request) {

        if (request == null || request.getCliente() == null ||
            request.getDetalles() == null || request.getDetalles().isEmpty()) {
            throw new IllegalArgumentException("Datos incompletos");
        }

        if (request.getCliente().getNombre() == null || request.getCliente().getNombre().isBlank()) {
            throw new IllegalArgumentException("Nombre del cliente es obligatorio");
        }

        // 1) Insert en ventas
        Venta venta = new Venta();

        // fecha: si viene null, now()
        if (request.getFecha() != null && !request.getFecha().isBlank()) {
            venta.setFecha(OffsetDateTime.parse(request.getFecha()));
        } else {
            venta.setFecha(OffsetDateTime.now());
        }

        venta.setNombreCliente(request.getCliente().getNombre());
        venta.setApellidosCliente(request.getCliente().getApellidos());
        venta.setCedulaCliente(request.getCliente().getCedula());
        venta.setDireccionCliente(request.getCliente().getDireccion());
        venta.setTotal(request.getTotal());

        Venta guardada = ventaRepository.save(venta);
        Long ventaId = guardada.getId();

        // 2) Insert en ventas_detalles
        for (VentaDetalleDTO d : request.getDetalles()) {
            if (d.getProductoId() == null || d.getCantidad() == null || d.getCantidad() <= 0) {
                throw new IllegalArgumentException("Detalle inválido");
            }

            VentaDetalle det = new VentaDetalle();
            det.setVentaId(ventaId);
            det.setProductoId(d.getProductoId());
            det.setNombreProducto(d.getNombreProducto());
            det.setPrecio(d.getPrecio());
            det.setCantidad(d.getCantidad());
            det.setSubtotal(d.getSubtotal());

            ventaDetalleRepository.save(det);
        }

        return ventaId;
    }
}
