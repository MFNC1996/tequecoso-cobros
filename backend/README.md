# Tequecoso Cobros

Proyecto académico para modelar procesos en Flowable e implementar un backend REST en Spring Boot para la gestión de clientes, cobros, proveedores y pagos a proveedores.

## Estructura del repositorio

- `BPMN/`: procesos BPMN del proyecto.
- `backend/`: backend REST desarrollado con Spring Boot.
- `frontend/`: interfaz web (HTML/JS) conectada al backend y a los procesos de Flowable.
- `docs/`: evidencias, pruebas y documentación.
- `forms/`: formularios y capturas relacionadas con Flowable.
- `media/`: material multimedia del proyecto.

## Procesos incorporados

El proyecto incluye 4 procesos BPMN, modelados y desplegados en Flowable, cada uno con una tarea HTTP que se conecta automáticamente al backend:

- `cobroAClientes.bpmn` — Cobro a clientes
- `registroDeClientes.bpmn` — Registro de clientes
- `registrarProveedor.bpmn` — Registrar proveedor
- `cobroProveedor.bpmn` — Pago a proveedor

Los 4 procesos ejecutan de extremo a extremo (evento de inicio → tarea HTTP → evento de fin) sin intervención manual, llamando al backend con los datos recibidos desde el frontend o desde una llamada directa a la API de Flowable.

## Backend REST

El backend implementa los siguientes endpoints:

| Recurso | Endpoint | Métodos |
|---|---|---|
| Clientes | `/api/clientes` | `GET`, `POST` |
| Clientes (vía proceso) | `/api/clientes/iniciar-proceso` | `POST` |
| Cobros | `/api/cobros` | `GET`, `POST` |
| Cobros (vía proceso) | `/api/cobros/iniciar-proceso` | `POST` |
| Proveedores | `/api/proveedores` | `GET`, `POST` |
| Proveedores (vía proceso) | `/api/proveedores/iniciar-proceso` | `POST` |
| Pagos a proveedores | `/api/pagos-proveedor` | `GET`, `POST` |
| Pagos a proveedores (vía proceso) | `/api/pagos-proveedor/iniciar-proceso` | `POST` |

Los endpoints `/iniciar-proceso` reciben los datos del formulario, inician el proceso BPMN correspondiente en Flowable (pasándole las variables) y devuelven la respuesta del motor. El backend actúa como intermediario entre el frontend y Flowable, evitando restricciones de CORS del navegador. Los endpoints `GET`/`POST` simples siguen disponibles para pruebas directas.

CORS está habilitado (`@CrossOrigin(origins = "*")`) en los 4 controladores para permitir el consumo desde el frontend.

## Frontend

Interfaz web simple (`frontend/index.html`, sin frameworks) con formularios para las 4 entidades del negocio (clientes, cobros, proveedores, pagos a proveedores). Cada formulario envía los datos al backend, que a su vez dispara el proceso BPMN correspondiente en Flowable. Cada sección también muestra el listado actualizado de registros existentes, consumiendo los endpoints `GET`.

## Ejecución local

### 1. Backend

```
cd backend/cobros
mvn spring-boot:run
```

El backend queda disponible en `http://localhost:8080`.

### 2. Flowable (Open Source, vía Docker)

```
docker run -d -p 8090:8080 --name flowable flowable/all-in-one
```

Flowable queda disponible en `http://localhost:8090` (usuario `admin`, contraseña `test`). Los procesos BPMN se importan desde `BPMN/` en el Modeler (`http://localhost:8090/flowable-modeler`), se agrupan en una App y se publican desde ahí.

Cada tarea HTTP de los procesos apunta a `http://host.docker.internal:8080/...` (dirección especial de Docker para llegar al backend que corre en el mismo computador, fuera del contenedor).

### 3. Frontend

Abrir `frontend/index.html` con Live Server (o cualquier servidor estático) mientras el backend y Flowable están corriendo.

## Prueba por terminal (sin frontend)

Iniciar un proceso directamente vía API de Flowable, por ejemplo "Cobro a clientes":

```
curl -u admin:test -X POST -H "Content-Type: application/json" \
  -d '{"processDefinitionKey":"cobroAClientes","variables":[
    {"name":"cliente","value":"Maria Gonzalez","type":"string"},
    {"name":"monto","value":22000,"type":"double"},
    {"name":"fechaVencimiento","value":"2026-08-15","type":"string"},
    {"name":"estado","value":"pendiente","type":"string"}
  ]}' \
  http://localhost:8090/flowable-task/process-api/runtime/process-instances
```

Consultar el listado resultante en el backend:

```
curl http://localhost:8080/api/cobros
```

## Estado de integración con Flowable

La integración entre Flowable y el backend está **completamente funcional**. Se migró de la versión cloud de Flowable (con período de prueba limitado) a **Flowable Open Source ejecutándose localmente vía Docker**, tal como se recomendó como versión final del proyecto.

Los 4 procesos BPMN fueron modelados, desplegados y probados de extremo a extremo: cada uno recibe variables (desde el frontend o desde una llamada directa a la API), ejecuta su tarea HTTP, y el dato queda registrado en el backend. Se validó con pruebas tanto por consola (`curl`) como desde la interfaz web.

## Tecnologías utilizadas

- Flowable Open Source (Docker)
- Java
- Spring Boot
- Maven
- REST API
- HTML / CSS / JavaScript (frontend)
- GitHub