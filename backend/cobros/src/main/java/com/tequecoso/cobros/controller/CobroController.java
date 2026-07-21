package com.tequecoso.cobros.controller;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.*;
import com.tequecoso.cobros.model.Cobro;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/cobros")
public class CobroController {

    private List<Cobro> cobros = new ArrayList<>();

    @GetMapping
    public List<Cobro> listarCobros() {
        return cobros;
    }

    @PostMapping
    public Cobro agregarCobro(@RequestBody Cobro cobro) {
        cobros.add(cobro);
        return cobro;
    }

    @PostMapping("/iniciar-proceso")
    public ResponseEntity<String> iniciarProceso(@RequestBody Cobro cobro) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/flowable-task/process-api/runtime/process-instances";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth("admin", "test");

        Map<String, Object> body = new HashMap<>();
        body.put("processDefinitionKey", "cobroAClientes");

        List<Map<String, Object>> variables = new ArrayList<>();
        variables.add(Map.of("name", "cliente", "value", cobro.getCliente(), "type", "string"));
        variables.add(Map.of("name", "monto", "value", cobro.getMonto(), "type", "double"));
        variables.add(Map.of("name", "fechaVencimiento", "value", cobro.getFechaVencimiento(), "type", "string"));
        variables.add(Map.of("name", "estado", "value", cobro.getEstado(), "type", "string"));
        body.put("variables", variables);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        return ResponseEntity.ok(response.getBody());
    }
}
