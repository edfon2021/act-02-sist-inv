package com.inventario.inventario_rest.inventario.service;

import com.inventario.inventario_rest.inventario.dto.ProveedorRequest;
import com.inventario.inventario_rest.inventario.entity.Proveedor;
import com.inventario.inventario_rest.inventario.repository.ProveedorRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public Proveedor crearProveedor(ProveedorRequest request) {
        if (request == null || request.getNombre() == null || request.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del proveedor es obligatorio");
        }

        Proveedor proveedor = new Proveedor();
        proveedor.setNombre(request.getNombre().trim());
        proveedor.setTelefono(request.getTelefono());
        proveedor.setEmail(request.getEmail());

        return proveedorRepository.save(proveedor);
    }

    public List<Proveedor> listarProveedores() {
        // Similar al Node: SELECT * FROM proveedores (si querés ordenado por id desc, lo dejamos así)
        return proveedorRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public void eliminarProveedor(Long id) {
        if (id == null || !proveedorRepository.existsById(id)) {
            throw new IllegalArgumentException("Proveedor no encontrado");
        }
        proveedorRepository.deleteById(id);
    }
}
