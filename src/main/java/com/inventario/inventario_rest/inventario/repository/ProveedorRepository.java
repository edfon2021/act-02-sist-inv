package com.inventario.inventario_rest.inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.inventario_rest.inventario.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
