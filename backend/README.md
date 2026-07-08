# Backend Cobros - Tequecoso

Backend desarrollado con Spring Boot para gestionar clientes, cobros, proveedores y pagos a proveedores. El proyecto ya expone endpoints REST y fue probado localmente con ejecución por terminal usando Maven.[1][2]

## Estructura del proyecto

La aplicación usa una clase principal `CobrosApplication`, un archivo `application.properties`, modelos Java y controladores REST separados por carpetas. La estructura base observada incluye `controller`, `model`, `pom.xml` y recursos de Spring Boot.[3][4][1]

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

- Java 17 configurado en `pom.xml`.[1]
- Spring Boot 4.1.0 como base del proyecto.[1]
- Maven para compilación y ejecución.[2][1]
- API REST con controladores anotados con `@RestController`.[5][6]

## Endpoints disponibles

| Recurso | Método | Ruta | Descripción |
|---|---|---|---|
| Clientes | GET | `/api/clientes` | Lista los clientes registrados.[5] |
| Clientes | POST | `/api/clientes` | Registra un nuevo cliente.[5] |
| Cobros | GET | `/api/cobros` | Lista los cobros registrados.[6] |
| Cobros | POST | `/api/cobros` | Registra un nuevo cobro.[6][2] |
| Proveedores | GET | `/api/proveedores` | Lista los proveedores registrados.[7] |
| Proveedores | POST | `/api/proveedores` | Registra un nuevo proveedor.[7] |
| Pagos a proveedor | GET | `/api/pagos-proveedor` | Lista los pagos registrados.[7] |
| Pagos a proveedor | POST | `/api/pagos-proveedor` | Registra un nuevo pago a proveedor.[7] |

## Ejecución local

Para ejecutar el proyecto localmente se usa Maven desde la carpeta `backend/cobros`. El `README` original del proyecto ya contemplaba el uso de `mvn spring-boot:run`.[2]

```bash
cd backend/cobros
mvn spring-boot:run
```

Si la aplicación inicia correctamente, queda disponible en `http://localhost:8080` y Spring Boot usa el nombre de aplicación `cobros` definido en `application.properties`.[4]

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

## Observación actual

Los controladores vistos almacenan información en listas en memoria, por lo que los datos se pierden al reiniciar la aplicación. Esto es consistente con la implementación actual basada en `ArrayList` dentro de los controladores mostrados.[5][6]
