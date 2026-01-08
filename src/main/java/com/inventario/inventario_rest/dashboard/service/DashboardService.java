package com.inventario.inventario_rest.dashboard.service;

import com.inventario.inventario_rest.dashboard.dto.DashboardSubcategoriasDTO;
import com.inventario.inventario_rest.dashboard.dto.DashboardSubcategoriasRowDTO;
import com.inventario.inventario_rest.dashboard.repository.DashboardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardService(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    private static final Map<String, String> MESES = new HashMap<>() {{
        put("01","Enero"); put("02","Febrero"); put("03","Marzo");
        put("04","Abril"); put("05","Mayo"); put("06","Junio");
        put("07","Julio"); put("08","Agosto"); put("09","Septiembre");
        put("10","Octubre"); put("11","Noviembre"); put("12","Diciembre");
    }};

    @Transactional(readOnly = true)
    public List<DashboardSubcategoriasDTO> dashboardSubcategorias() {
        List<DashboardSubcategoriasRowDTO> rows = dashboardRepository.dashboardSubcategoriasRows();

        return rows.stream().map(r -> {
            BigDecimal avgVenta = r.getPrecioPromedioVenta() == null ? BigDecimal.ZERO : r.getPrecioPromedioVenta();
            BigDecimal avgCompra = r.getPrecioPromedioCompra() == null ? BigDecimal.ZERO : r.getPrecioPromedioCompra();

            BigDecimal utilidadUnidad = avgVenta.subtract(avgCompra);
            BigDecimal ventasTotales = BigDecimal.valueOf(r.getVentasTotales() == null ? 0 : r.getVentasTotales());

            BigDecimal precio = avgVenta.setScale(2, RoundingMode.HALF_UP);
            BigDecimal ingresos = utilidadUnidad.multiply(ventasTotales).setScale(2, RoundingMode.HALF_UP);

            // Postgres: mesNum viene 1..12
            String mesNum2 = String.format("%02d", r.getMesNum() == null ? 0 : r.getMesNum());
            String mes = MESES.getOrDefault(mesNum2, mesNum2);

            return new DashboardSubcategoriasDTO(
                    r.getProducto(),
                    mes,
                    r.getVentasTotales(),
                    precio,
                    ingresos
            );
        }).collect(Collectors.toList());
    }
}

