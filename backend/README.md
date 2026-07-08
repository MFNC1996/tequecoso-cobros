# Backend - Tequecoso Cobros

Esta carpeta contiene el backend del proyecto **Tequecoso Cobros**, desarrollado con Java y Spring Boot. Su propósito es exponer servicios web básicos para apoyar el control de cobros del sistema. [file:1]

## Objetivo

Proveer una base de Web Services funcional para registrar y consultar cobros, como parte del avance técnico del proyecto. [file:1]

## Estructura general

La estructura principal del backend considera componentes como:

- `controller/`
- `model/`
- `pom.xml`

Ejemplo de archivos usados en este avance:

- `controller/CobroController.java`
- `model/Cobro.java` [conversation_history]

## Endpoints implementados

### GET /api/cobros
Retorna la lista de cobros registrados. [conversation_history]

### POST /api/cobros
Registra un nuevo cobro. [conversation_history]

Ejemplo de solicitud:

```json
{
  "cliente": "Juan Perez",
  "monto": 15000,
  "estado": "pendiente"
}
```

## Ejecución

Para ejecutar el proyecto:

```bash
mvn spring-boot:run
```

En Windows:

```bash
mvnw.cmd spring-boot:run
```

## Estado actual

Este backend corresponde al avance mínimo funcional de Web Services para el proyecto. Actualmente está orientado al módulo de cobros y puede ampliarse con integración futura para clientes, proveedores y pagos. [file:1]

## Relación con Flowable

Los procesos modelados en Flowable representan la lógica del negocio, mientras que este backend constituye la base técnica de servicios web para futuras integraciones. [file:1]
