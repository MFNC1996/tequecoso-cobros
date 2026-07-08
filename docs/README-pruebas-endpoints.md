# Guía de pruebas de endpoints

Esta guía resume cómo probar el backend del proyecto Tequecoso Cobros desde terminal usando `curl`, sin depender de extensiones de VS Code o herramientas externas.

## Requisito previo

Antes de probar cualquier endpoint, la aplicación debe estar ejecutándose localmente con Maven.

```bash
cd backend/cobros
mvn spring-boot:run
```

Si el backend inicia correctamente, queda disponible en:

```bash
http://localhost:8080
```

## Endpoints disponibles

| Recurso | Método | Ruta |
|---|---|---|
| Clientes | GET | `/api/clientes` |
| Clientes | POST | `/api/clientes` |
| Cobros | GET | `/api/cobros` |
| Cobros | POST | `/api/cobros` |
| Proveedores | GET | `/api/proveedores` |
| Proveedores | POST | `/api/proveedores` |
| Pagos a proveedor | GET | `/api/pagos-proveedor` |
| Pagos a proveedor | POST | `/api/pagos-proveedor` |

## Pruebas de clientes

### Registrar cliente

```bash
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan Perez","telefono":"0412-1234567","direccion":"Maracay","observacion":"Cliente nuevo"}'
```

### Consultar clientes

```bash
curl http://localhost:8080/api/clientes
```

## Pruebas de cobros

### Registrar cobro

```bash
curl -X POST http://localhost:8080/api/cobros \
  -H "Content-Type: application/json" \
  -d '{"cliente":"Juan Perez","monto":15000,"estado":"pendiente"}'
```

### Consultar cobros

```bash
curl http://localhost:8080/api/cobros
```

## Pruebas de proveedores

### Registrar proveedor

```bash
curl -X POST http://localhost:8080/api/proveedores \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Distribuidora ABC","telefono":"0412-0000000","direccion":"Maracay","observacion":"Entrega semanal"}'
```

### Consultar proveedores

```bash
curl http://localhost:8080/api/proveedores
```

## Pruebas de pagos a proveedor

### Registrar pago a proveedor

```bash
curl -X POST http://localhost:8080/api/pagos-proveedor \
  -H "Content-Type: application/json" \
  -d '{"proveedor":"Distribuidora ABC","fecha":"2026-07-08","monto":150.0,"metodoPago":"Transferencia","observacion":"Pago parcial"}'
```

### Consultar pagos a proveedor

```bash
curl http://localhost:8080/api/pagos-proveedor
```

## Resultado esperado

Si las pruebas se ejecutan correctamente, cada solicitud `POST` devuelve el objeto enviado y cada solicitud `GET` muestra una lista en formato JSON con los registros almacenados en memoria.

## Observación actual

La implementación actual funciona como un MVP académico. Los datos se almacenan temporalmente en memoria, por lo que se pierden al reiniciar la aplicación.
