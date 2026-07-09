# Backend - Tequecoso Cobros

Esta carpeta contiene el backend desarrollado en Java con Spring Boot para soportar la solución del proyecto.

## Descripción
El backend implementa servicios web básicos relacionados con la gestión de clientes, proveedores, cobros y pagos a proveedores.

Su propósito es complementar la solución modelada en Flowable, sirviendo como capa de soporte para manejar información del negocio mediante servicios REST.

## Tecnologías utilizadas
- Java 17
- Spring Boot
- Maven

## Estructura actual del proyecto

```text
backend/
└── cobros/
    ├── src/
    │   ├── main/
    │   │   ├── java/com/tequecoso/cobros/
    │   │   │   ├── controller/
    │   │   │   │   ├── ClienteController.java
    │   │   │   │   ├── CobroController.java
    │   │   │   │   ├── PagoProveedorController.java
    │   │   │   │   └── ProveedorController.java
    │   │   │   ├── model/
    │   │   │   │   ├── Cliente.java
    │   │   │   │   ├── Cobro.java
    │   │   │   │   ├── PagoProveedor.java
    │   │   │   │   └── Proveedor.java
    │   │   │   └── CobrosApplication.java
    │   │   └── resources/
    │   │       └── application.properties
    │   └── test/
    └── pom.xml
```

## Componentes principales

### Clase principal
- `CobrosApplication.java`: clase principal de arranque del proyecto Spring Boot.

### Controladores
- `ClienteController.java`: gestiona las operaciones relacionadas con clientes.
- `CobroController.java`: gestiona las operaciones relacionadas con cobros.
- `ProveedorController.java`: gestiona las operaciones relacionadas con proveedores.
- `PagoProveedorController.java`: gestiona las operaciones relacionadas con pagos a proveedores.

### Modelos
- `Cliente.java`: representa la información de un cliente.
- `Cobro.java`: representa la información de un cobro.
- `Proveedor.java`: representa la información de un proveedor.
- `PagoProveedor.java`: representa la información de un pago a proveedor.

## Funcionalidad general
El backend permite estructurar operaciones básicas del negocio a través de servicios REST. Estas operaciones están orientadas a apoyar los procesos implementados en Flowable para:

- Registro de clientes
- Registro de proveedores
- Cobro a clientes
- Pago a proveedores

## Ejecución local
Para ejecutar el proyecto en local:

1. Tener instalado Java 17.
2. Tener instalado Maven.
3. Abrir la carpeta `backend/cobros`.
4. Ejecutar el siguiente comando:

```bash
mvn spring-boot:run
```

## Configuración
El archivo `application.properties` contiene la configuración básica del proyecto.

## Relación con el proyecto
Este backend forma parte de la arquitectura general de la solución y sirve como capa de soporte para los procesos BPMN y formularios implementados en Flowable.

En conjunto, Flowable, los formularios y el backend permiten representar una propuesta integrada para la gestión de operaciones del negocio.
