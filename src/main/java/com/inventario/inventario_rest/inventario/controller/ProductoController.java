package com.inventario.inventario_rest.inventario.controller;

import com.inventario.inventario_rest.inventario.dto.ProductoCreateRequest;
import com.inventario.inventario_rest.inventario.dto.ProductoUpdateRequest;
import com.inventario.inventario_rest.inventario.entity.Producto;
import com.inventario.inventario_rest.inventario.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // POST /api/productos  -> { success:true, id: ... }
    @PostMapping("/productos")
    public ResponseEntity<?> crearProducto(@RequestBody ProductoCreateRequest req) {
        try {
            Producto creado = productoService.crear(req);
            return ResponseEntity.ok(Map.of("success", true, "id", creado.getId()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("success", false, "error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "error", "Error creando producto"));
        }
    }

    // GET /api/productos -> lista
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> listarProductos() {
        return ResponseEntity.ok(productoService.listar());
    }

    // PUT /api/productos/:id -> { success:true } (actualiza solo precioCompra, precioVenta, cantidad)
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Long id, @RequestBody ProductoUpdateRequest req) {
        try {
            productoService.actualizarCamposInventario(id, req);
            return ResponseEntity.ok(Map.of("success", true));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("success", false, "error", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "error", "Error actualizando producto"));
        }
    }

    // DELETE /api/productos/:id -> { success:true, deleted: changes }
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id) {
        try {
            int deleted = productoService.eliminarPorIdContando(id);
            return ResponseEntity.ok(Map.of("success", true, "deleted", deleted));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("success", false, "error", "Error eliminando producto"));
        }
    }

    // GET /api/inventario -> igual que /api/productos
    @GetMapping("/inventario")
    public ResponseEntity<List<Producto>> listarInventario() {
        return ResponseEntity.ok(productoService.listar());
    }
}
