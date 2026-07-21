package com.tequecoso.cobros.controller;

import com.tequecoso.cobros.model.PagoProveedor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pagos-proveedor")
public class PagoProveedorController {

    private List<PagoProveedor> pagosProveedor = new ArrayList<>();

    @GetMapping
    public List<PagoProveedor> listarPagosProveedor() {
        return pagosProveedor;
    }

    @PostMapping
    public PagoProveedor agregarPagoProveedor(@RequestBody PagoProveedor pagoProveedor) {
        pagosProveedor.add(pagoProveedor);
        return pagoProveedor;
    }

    @PostMapping("/iniciar-proceso")
    public ResponseEntity<String> iniciarProceso(@RequestBody PagoProveedor pagoProveedor) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/flowable-task/process-api/runtime/process-instances";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("admin", "test");

        Map<String, Object> body = new HashMap<>();
        body.put("processDefinitionKey", "cobroProveedor");

        List<Map<String, Object>> variables = new ArrayList<>();
        variables.add(Map.of("name", "proveedor", "value", pagoProveedor.getProveedor(), "type", "string"));
        variables.add(Map.of("name", "fecha", "value", pagoProveedor.getFecha(), "type", "string"));
        variables.add(Map.of("name", "monto", "value", pagoProveedor.getMonto(), "type", "double"));
        variables.add(Map.of("name", "metodoPago", "value", pagoProveedor.getMetodoPago(), "type", "string"));
        variables.add(Map.of("name", "observacion", "value",
                pagoProveedor.getObservacion() == null ? "" : pagoProveedor.getObservacion(), "type", "string"));
        body.put("variables", variables);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}