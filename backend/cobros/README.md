# Backend Cobros

Proyecto base de Web Service en Java con Spring Boot para el control de cobros a clientes.

## Endpoints implementados

### GET /api/cobros
Retorna la lista de cobros registrados.

### POST /api/cobros
Registra un nuevo cobro.

Ejemplo de JSON:
```json
{
  "cliente": "Juan Perez",
  "monto": 15000,
  "estado": "pendiente"
}
```

## Estructura básica
- controller/CobroController.java
- model/Cobro.java

## Ejecución esperada
El proyecto puede ejecutarse con Spring Boot usando Maven.

Comandos comunes:
- `mvn spring-boot:run`
- en Windows también puede usarse `mvnw.cmd spring-boot:run`

## Objetivo
Este backend corresponde al avance mínimo de Web Services para la Entrega 1 del proyecto Tequecoso Cobros.
