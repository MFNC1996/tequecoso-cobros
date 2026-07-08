# Backend Cobros - Tequecoso

Backend desarrollado con Spring Boot para gestionar clientes, cobros, proveedores y pagos a proveedores. El proyecto expone endpoints REST y fue probado localmente usando Maven y curl desde terminal.

## Estructura del proyecto

La aplicación utiliza una clase principal `CobrosApplication`, un archivo `application.properties`, modelos Java y controladores REST separados por carpetas.

```text
backend/cobros/
├── pom.xml
├── src/main/java/com/tequecoso/cobros/
│   ├── CobrosApplication.java
│   ├── controller/
│   └── model/
└── src/main/resources/application.properties
```

## Tecnologías usadas

- Java 17
- Spring Boot
- Maven
- API REST con controladores anotados con `@RestController`

## Endpoints disponibles

| Recurso | Método | Ruta | Descripción |
|---|---|---|---|
| Clientes | GET | `/api/clientes` | Lista los clientes registrados. |
| Clientes | POST | `/api/clientes` | Registra un nuevo cliente. |
| Cobros | GET | `/api/cobros` | Lista los cobros registrados. |
| Cobros | POST | `/api/cobros` | Registra un nuevo cobro. |
| Proveedores | GET | `/api/proveedores` | Lista los proveedores registrados. |
| Proveedores | POST | `/api/proveedores` | Registra un nuevo proveedor. |
| Pagos a proveedor | GET | `/api/pagos-proveedor` | Lista los pagos registrados. |
| Pagos a proveedor | POST | `/api/pagos-proveedor` | Registra un nuevo pago a proveedor. |

## Ejecución local

Para ejecutar el proyecto localmente:

```bash
cd backend/cobros
mvn spring-boot:run
```

En Windows también puede usarse:

```bash
mvnw.cmd spring-boot:run
```

Si la aplicación inicia correctamente, queda disponible en:

```bash
http://localhost:8080
```

## Ejemplos de prueba

### Crear cliente

```bash
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan Perez","telefono":"0412-1234567","direccion":"Maracay","observacion":"Cliente nuevo"}'
```

### Consultar clientes

```bash
curl http://localhost:8080/api/clientes
```

### Crear cobro

```bash
curl -X POST http://localhost:8080/api/cobros \
  -H "Content-Type: application/json" \
  -d '{"cliente":"Juan Perez","monto":15000,"estado":"pendiente"}'
```

### Consultar cobros

```bash
curl http://localhost:8080/api/cobros
```

### Crear proveedor

```bash
curl -X POST http://localhost:8080/api/proveedores \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Distribuidora ABC","telefono":"0412-0000000","direccion":"Maracay","observacion":"Entrega semanal"}'
```

### Consultar proveedores

```bash
curl http://localhost:8080/api/proveedores
```

### Crear pago a proveedor

```bash
curl -X POST http://localhost:8080/api/pagos-proveedor \
  -H "Content-Type: application/json" \
  -d '{"proveedor":"Distribuidora ABC","fecha":"2026-07-08","monto":150.0,"metodoPago":"Transferencia","observacion":"Pago parcial"}'
```

### Consultar pagos a proveedor

```bash
curl http://localhost:8080/api/pagos-proveedor
```

## Observación actual

La implementación actual utiliza almacenamiento en memoria mediante listas, por lo que los datos se pierden al reiniciar la aplicación. Esta versión corresponde a un MVP funcional para la entrega académica.
