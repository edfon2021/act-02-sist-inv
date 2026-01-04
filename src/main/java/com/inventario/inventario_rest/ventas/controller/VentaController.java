package com.inventario.inventario_rest.ventas.controller;

import com.inventario.inventario_rest.ventas.dto.VentaRequest;
import com.inventario.inventario_rest.ventas.service.VentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody VentaRequest request) {
        try {
            Long ventaId = ventaService.registrarVenta(request);
            return ResponseEntity.ok(Map.of("mensaje", "Venta registrada", "ventaId", ventaId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        } catch (Exception e) {
            System.err.println("Error al registrar venta: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno al registrar venta"));
        }
    }

    @GetMapping
    public ResponseEntity<?> listarVentas() {
       try {
            return ResponseEntity.ok(ventaService.listarVentas());
         } catch (Exception e) {
             return ResponseEntity.status(500)
                .body(Map.of("error", "Error al obtener ventas"));
         }
     }
}
