package com.inventario.inventario_rest.inventario.controller;

import com.inventario.inventario_rest.inventario.dto.ProveedorRequest;
import com.inventario.inventario_rest.inventario.entity.Proveedor;
import com.inventario.inventario_rest.inventario.service.ProveedorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ProveedorController {

    private static final Logger logger = LoggerFactory.getLogger(ProveedorController.class);

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping("/proveedores")
    public ResponseEntity<?> crearProveedor(@RequestBody ProveedorRequest request) {
        try {
            Proveedor guardado = proveedorService.crearProveedor(request);
            return ResponseEntity.ok(Map.of("success", true, "id", guardado.getId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            logger.error("Error al agregar proveedor:", e);
            return ResponseEntity.status(500).body(Map.of("error", "Error interno del servidor"));
        }
    }

    @GetMapping("/proveedores")
    public ResponseEntity<?> listarProveedores() {
        try {
            List<Proveedor> proveedores = proveedorService.listarProveedores();
            proveedores.forEach(p -> logger.info("Proveedor id={} nombre={}", p.getId(), p.getNombre()));
            return ResponseEntity.ok(proveedores);
        } catch (Exception e) {
            logger.error("Error al obtener proveedores:", e);
            return ResponseEntity.status(500).body(Map.of("error", "Error interno al obtener proveedores"));
        }
    }

    @DeleteMapping("/proveedores/{id}")
    public ResponseEntity<?> eliminarProveedor(@PathVariable Long id) {
        try {
            proveedorService.eliminarProveedor(id);
            return ResponseEntity.ok(Map.of("success", true, "deleted", 1));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(404).body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            logger.error("Error eliminando proveedor:", e);
            return ResponseEntity.status(500).body(Map.of("error", "Error interno del servidor"));
        }
    }
}
