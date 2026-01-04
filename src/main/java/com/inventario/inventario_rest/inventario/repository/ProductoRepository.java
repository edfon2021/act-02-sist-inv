package com.inventario.inventario_rest.inventario.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.inventario.inventario_rest.inventario.entity.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
