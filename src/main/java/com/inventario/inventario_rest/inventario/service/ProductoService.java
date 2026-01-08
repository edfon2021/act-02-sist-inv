package com.inventario.inventario_rest.inventario.service;

import com.inventario.inventario_rest.inventario.dto.ProductoCreateRequest;
import com.inventario.inventario_rest.inventario.dto.ProductoUpdateRequest;
import com.inventario.inventario_rest.inventario.entity.Producto;
import com.inventario.inventario_rest.inventario.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Producto crear(ProductoCreateRequest req) {
        // Validaciones mínimas (podés endurecerlas)
        if (req.getSku() == null || req.getSku().trim().isEmpty()) {
            throw new IllegalArgumentException("El SKU es obligatorio");
        }
        if (req.getNombre() == null || req.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }

        Producto p = new Producto();
        p.setSku(req.getSku());
        p.setNombre(req.getNombre());
        p.setCategoria(req.getCategoria());
        p.setSubcategoria(req.getSubcategoria());
        p.setPrecioCompra(req.getPrecioCompra());
        p.setPrecioVenta(req.getPrecioVenta());
        p.setCantidad(req.getCantidad());
        p.setColor(req.getColor());
        p.setMarca(req.getMarca());
        p.setDescripcion(req.getDescripcion());

        return productoRepository.save(p);
    }

    // Equivalente al PUT de Node (solo 3 campos)
    @Transactional
    public Producto actualizarCamposInventario(Long id, ProductoUpdateRequest req) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado: " + id));

        // Si querés comportamiento EXACTO a Node, asumí que vienen los 3 siempre:
        p.setPrecioCompra(req.getPrecioCompra());
        p.setPrecioVenta(req.getPrecioVenta());
        p.setCantidad(req.getCantidad());

        return productoRepository.save(p);
    }

    /**
     * Devuelve 1 si eliminó, 0 si no existía (para imitar SQLite changes).
     */
    @Transactional
    public int eliminarPorIdContando(Long id) {
        if (!productoRepository.existsById(id)) {
            return 0;
        }
        productoRepository.deleteById(id);
        return 1;
    }
}
