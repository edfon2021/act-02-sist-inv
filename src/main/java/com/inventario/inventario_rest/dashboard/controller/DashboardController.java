package com.inventario.inventario_rest.dashboard.controller;

import com.inventario.inventario_rest.dashboard.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/dashboard-subcategorias")
    public ResponseEntity<?> dashboardSubcategorias() {
        try {
            return ResponseEntity.ok(dashboardService.dashboardSubcategorias());
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(Map.of("error", "Error generando datos del dashboard"));
        }
    }
}

