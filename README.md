# Tequecoso Cobros

Proyecto académico para modelar procesos en Flowable e implementar un backend REST en Spring Boot para la gestión de cobros a clientes.

## Estructura del repositorio

- `BPMN/`: procesos BPMN del proyecto.
- `backend/`: backend REST desarrollado con Spring Boot.
- `docs/`: evidencias, pruebas y documentación.
- `forms/`: formularios y capturas relacionadas con Flowable.
- `media/`: material multimedia del proyecto.

## Proceso incorporado

Se incluye el proceso `cobroAClientes.bpmn`, modelado en Flowable, con formulario de captura de datos y una configuración de integración mediante HTTP Task.

## Backend REST

El backend implementa los siguientes endpoints:

- `GET /api/cobros`: retorna la lista de cobros registrados.
- `POST /api/cobros`: registra un nuevo cobro.

Los datos del cobro consideran los campos:

- `cliente`
- `monto`
- `fechaVencimiento`
- `estado`

## Ejecución local

Entrar a la carpeta del backend:

```bash
cd backend/cobros
mvn spring-boot:run
```

O bien:

```bash
mvn clean package
java -jar target/cobros-0.0.1-SNAPSHOT.jar
```

## Prueba por terminal

Ejemplo de registro de cobro con `curl`:

```bash
curl -X POST http://localhost:8080/api/cobros \
  -H "Content-Type: application/json" \
  -d '{
    "cliente": "Maria Gonzalez",
    "monto": 22000,
    "fechaVencimiento": "2026-08-15",
    "estado": "pendiente"
  }'
```

Consulta del listado:

```bash
curl http://localhost:8080/api/cobros
```

## Estado de integración con Flowable

Se configuró el formulario del proceso y se diseñó la integración hacia el backend mediante HTTP Task con método `POST`, headers JSON y body alineado al modelo `Cobro`.

El backend REST quedó operativo y validado mediante pruebas por terminal.

La integración directa desde Flowable hacia el backend local no se logró completar en la ejecución final por un problema de conectividad entre el entorno de Flowable y el servicio local.

## Tecnologías utilizadas

- Flowable
- Java
- Spring Boot
- Maven
- REST API
- GitHub
