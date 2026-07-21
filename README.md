# Tequecoso Cobros

Proyecto académico (Evaluación 3) de modelamiento de procesos de negocio en Flowable, con backend REST en Spring Boot, para la gestión de clientes, cobros, proveedores y pagos a proveedores.

## Estructura del repositorio

- `BPMN/`: los 4 procesos de negocio modelados en Flowable (ver `BPMN/README.md` para el detalle de cada uno).
- `backend/`: backend REST desarrollado con Spring Boot.
- `frontend/`: interfaz web conectada al backend y a los procesos de Flowable.
- `docs/`: evidencias, pruebas y documentación.
- `forms/`: formularios y capturas relacionadas con Flowable.
- `media/`: material multimedia del proyecto.

## Procesos de negocio cubiertos

El proyecto automatiza 4 procesos completos del negocio, cada uno modelado en BPMN y ejecutándose de extremo a extremo en Flowable (evento de inicio → tarea HTTP → evento de fin), sin intervención manual:

1. **Registro de clientes**
2. **Cobro a clientes**
3. **Registrar proveedor**
4. **Pago a proveedor**

Cada proceso recibe datos (desde el frontend o desde una llamada directa a la API de Flowable), y su tarea HTTP llama automáticamente al backend correspondiente para persistir la información.

## Backend REST

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

Los endpoints `/iniciar-proceso` reciben los datos del formulario, inician el proceso BPMN correspondiente en Flowable (con las variables del formulario) y devuelven la respuesta del motor — el backend actúa como intermediario entre el frontend y Flowable. Los endpoints `GET`/`POST` simples permiten además probar el backend de forma directa.

CORS está habilitado (`@CrossOrigin(origins = "*")`) en los 4 controladores para el consumo desde el frontend.

## Frontend

Interfaz web (`frontend/index.html`) con formularios para las 4 entidades del negocio. Cada formulario dispara el proceso BPMN correspondiente en Flowable, y cada sección muestra el listado actualizado de los registros existentes.

## Ejecución local

### 1. Backend
```
cd backend/cobros
mvn spring-boot:run
```
Queda disponible en `http://localhost:8080`.

### 2. Flowable Open Source (vía Docker)
```
docker run -d -p 8090:8080 --name flowable flowable/all-in-one
```
Queda disponible en `http://localhost:8090` (usuario `admin`, contraseña `test`). Los procesos de `BPMN/` se importan en el Modeler, se agrupan en una App y se publican desde ahí — más detalle en `BPMN/README.md`.

### 3. Frontend
Abrir `frontend/index.html` con un servidor estático (ej. Live Server) mientras el backend y Flowable están corriendo.

## Prueba por terminal (sin frontend)

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

```
curl http://localhost:8080/api/cobros
```

## Tecnologías utilizadas

- Flowable Open Source (Docker)
- Java
- Spring Boot
- Maven
- REST API
- HTML / CSS / JavaScript (frontend)
- GitHub
