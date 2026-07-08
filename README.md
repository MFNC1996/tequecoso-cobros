# Tequecoso Cobros

Proyecto académico para apoyar a **Tequecoso**, una microempresa que actualmente registra su información de forma manual y necesita una solución digital básica para gestionar clientes, proveedores, cobros y pagos. El objetivo del proyecto es construir una solución funcional usando BPMN, Flowable y Web Services en Java. [file:1]

## Objetivo

Este proyecto busca:

- Gestionar clientes y proveedores. [file:1]
- Controlar cobros a clientes. [file:1]
- Controlar pagos a proveedores. [file:1]
- Mantener una solución simple, funcional y ejecutable como MVP. [file:1]

## Tecnologías utilizadas

- BPMN para modelado de procesos. [file:1]
- Flowable para automatización y formularios. [file:1]
- Java con Spring Boot para Web Services. [file:1]
- GitHub para control de versiones y evidencia del trabajo. [file:1]

## Procesos implementados en Flowable

Actualmente el proyecto incluye los siguientes procesos ejecutables:

- Registro de clientes.
- Registrar proveedor.
- Cobro a clientes.
- Pago a proveedor.

## Estructura del repositorio

```bash
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

## Backend disponible

El backend implementado incluye un módulo base de cobros con:

- `GET /api/cobros` para listar cobros.
- `POST /api/cobros` para registrar un cobro. [conversation_history]

Ejemplo de JSON para registrar un cobro:

```json
{
  "cliente": "Juan Perez",
  "monto": 15000,
  "estado": "pendiente"
}
```

## Cómo ejecutar el backend

Desde la carpeta del proyecto backend:

```bash
mvn spring-boot:run
```

En Windows también puede usarse:

```bash
mvnw.cmd spring-boot:run
```

## Estado actual del proyecto

- Procesos BPMN simplificados para asegurar ejecución correcta en Flowable.
- Formularios asociados a cada proceso.
- Backend base funcional para cobros.
- Repositorio reorganizado para mantener evidencia clara del avance. [file:1]

## Enfoque del proyecto

Este proyecto se trabaja como un MVP, priorizando que los procesos sean funcionales antes que complejos. La pauta del curso indica explícitamente que no se espera un sistema perfecto, sino una solución funcional que resuelva el problema principal. [file:1]
