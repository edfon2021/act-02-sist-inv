package com.inventario.inventario_rest.inventario.controller;

import com.inventario.inventario_rest.inventario.dto.PedidoRequest;
import com.inventario.inventario_rest.inventario.entity.Pedido;
import com.inventario.inventario_rest.inventario.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    // POST /api/pedidos
    @PostMapping
    public ResponseEntity<?> registrarPedido(@RequestBody PedidoRequest request) {
        try {
            Pedido pedidoGuardado = pedidoService.registrarPedido(request);
            return ResponseEntity.ok(
                    Map.of("success", true, "id", pedidoGuardado.getId())
            );

        } catch (IllegalArgumentException e) {
            // Equivalente a tu res.status(400).json({ error: ... })
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));

        } catch (Exception e) {
            // Equivalente a tu res.status(500).json({ error: ... })
            System.err.println("Error al registrar pedido: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno al registrar pedido"));
        }
    }


    @GetMapping("/detalle")
     public ResponseEntity<?> obtenerPedidosDetalle() {
         try {
             return ResponseEntity.ok(pedidoService.listarPedidosDetalle());
             } catch (Exception e) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body(Map.of("error", "Error interno al obtener pedidos"));
              }
      }
}
