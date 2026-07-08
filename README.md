# Tequecoso Cobros

Proyecto académico para apoyar a Tequecoso, una microempresa que actualmente registra su información de forma manual y necesita una solución digital básica para gestionar clientes, proveedores, cobros y pagos. El objetivo del proyecto es construir una solución funcional usando BPMN, Flowable y Web Services en Java.

## Objetivo

Este proyecto busca:

- Gestionar clientes y proveedores.
- Controlar cobros a clientes.
- Controlar pagos a proveedores.
- Mantener una solución simple, funcional y ejecutable como MVP.

## Tecnologías utilizadas

- BPMN para modelado de procesos.
- Flowable para automatización y formularios.
- Java con Spring Boot para Web Services.
- GitHub para control de versiones y evidencia del trabajo.

## Procesos implementados en Flowable

Actualmente el proyecto incluye los siguientes procesos ejecutables:

- Registro de clientes.
- Registro de proveedores.
- Cobro a clientes.
- Pago a proveedores.

## Estructura del repositorio

```text
tequecoso-cobros/
├── README.md
├── backend/
├── flowable/
└── docs/
```

### backend/

Contiene el proyecto Spring Boot con los servicios web del sistema.

### flowable/

Contiene los modelos BPMN, formularios y evidencia relacionada con Flowable.

### docs/

Contiene actas, decisiones, evidencia y documentación del proyecto.

## Backend implementado

El backend desarrollado en Spring Boot incluye endpoints REST básicos para gestionar clientes, cobros, proveedores y pagos a proveedores.

### Endpoints disponibles

#### Clientes
- `GET /api/clientes` para listar clientes.
- `POST /api/clientes` para registrar un cliente.

#### Cobros
- `GET /api/cobros` para listar cobros.
- `POST /api/cobros` para registrar un cobro.

#### Proveedores
- `GET /api/proveedores` para listar proveedores.
- `POST /api/proveedores` para registrar un proveedor.

#### Pagos a proveedores
- `GET /api/pagos-proveedor` para listar pagos a proveedores.
- `POST /api/pagos-proveedor` para registrar un pago a proveedor.

## Ejemplos de JSON

### Registrar cliente

```json
{
  "nombre": "Juan Perez",
  "telefono": "0412-1234567",
  "direccion": "Maracay",
  "observacion": "Cliente nuevo"
}
```

### Registrar cobro

```json
{
  "cliente": "Juan Perez",
  "monto": 15000,
  "estado": "pendiente"
}
```

### Registrar proveedor

```json
{
  "nombre": "Distribuidora ABC",
  "telefono": "0412-0000000",
  "direccion": "Maracay",
  "observacion": "Entrega semanal"
}
```

### Registrar pago a proveedor

```json
{
  "proveedor": "Distribuidora ABC",
  "fecha": "2026-07-08",
  "monto": 150.0,
  "metodoPago": "Transferencia",
  "observacion": "Pago parcial"
}
```

## Cómo ejecutar el backend

Desde la carpeta del proyecto backend:

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

## Cómo probar los endpoints

Los endpoints pueden probarse desde navegador para solicitudes `GET` y desde terminal usando `curl` para solicitudes `POST`.

Ejemplo para registrar un cliente:

```bash
curl -X POST http://localhost:8080/api/clientes \
  -H "Content-Type: application/json" \
  -d '{"nombre":"Juan Perez","telefono":"0412-1234567","direccion":"Maracay","observacion":"Cliente nuevo"}'
```

Ejemplo para consultar clientes:

```bash
curl http://localhost:8080/api/clientes
```

Se agregó una guía más detallada en:

```text
docs/README-pruebas-endpoints.md
```

## Estado actual del proyecto

- Procesos BPMN simplificados para asegurar ejecución correcta en Flowable.
- Formularios asociados a cada proceso.
- Backend funcional para clientes, cobros, proveedores y pagos a proveedores.
- Endpoints probados localmente con ejecución real en Spring Boot.
- Repositorio reorganizado para mantener evidencia clara del avance.

## Enfoque del proyecto

Este proyecto se trabaja como un MVP, priorizando que los procesos sean funcionales antes que complejos. La pauta del curso indica explícitamente que no se espera un sistema perfecto, sino una solución funcional que resuelva el problema principal.

## Observación actual

La implementación actual del backend utiliza almacenamiento en memoria mediante listas, por lo que los datos registrados se pierden al reiniciar la aplicación. Esta versión corresponde a un avance funcional base para la entrega académica.
