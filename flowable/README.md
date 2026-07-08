# Flowable - Tequecoso Cobros

Esta carpeta contiene los elementos relacionados con Flowable y su uso dentro del proyecto, especialmente la ejecución de procesos y su relación con los formularios y evidencias documentadas en otras carpetas del repositorio.

## Objetivo

Implementar procesos simples, funcionales y ejecutables en Flowable, alineados con el caso de estudio de Tequecoso.

## Relación con la estructura del repositorio

En este proyecto, los elementos relacionados con BPMN, formularios y evidencias no están todos dentro de una misma carpeta. La organización actual del repositorio es la siguiente:

```text
tequecoso-cobros/
├── BPMN/
├── backend/
├── docs/
├── flowable/
└── README.md
```

## Ubicación de los elementos relacionados con Flowable

### BPMN

Los modelos BPMN del proyecto se almacenan en la carpeta:

```text
BPMN/
```

### Formularios y capturas

Los formularios asociados a los procesos y las capturas de evidencia se encuentran organizados dentro de:

```text
docs/
```

## Procesos implementados

Actualmente el proyecto incluye los siguientes procesos ejecutables en Flowable:

- Registro de clientes
- Registrar proveedor
- Cobro a clientes
- Pago a proveedor

## Criterio de diseño

Los procesos fueron simplificados para asegurar que se ejecuten correctamente en Flowable Work. Se priorizó un enfoque MVP, con procesos claros, formularios funcionales y flujo básico estable.

## Estado actual

Los cuatro procesos se encuentran implementados en Flowable Work, con formularios asociados y evidencia visual del modelado y ejecución.

## Relación con el proyecto

Estos procesos permiten representar parte del funcionamiento esperado para Tequecoso, especialmente en la gestión básica de clientes, proveedores, cobros y pagos.
