# Procesos BPMN

Esta carpeta contiene los 4 procesos de negocio modelados en Flowable para el proyecto Tequecoso Cobros. Todos fueron probados de extremo a extremo (evento de inicio → tarea HTTP → evento de fin) contra el backend en `backend/cobros`.

## Procesos incluidos

### `cobroAClientes.bpmn` — Cobro a clientes
Registra un cobro pendiente asociado a un cliente. Variables: `cliente`, `monto`, `fechaVencimiento`, `estado`.
Llama a `POST /api/cobros` en el backend.

### `registroDeClientes.bpmn` — Registro de clientes
Registra un nuevo cliente del negocio. Variables: `nombre`, `telefono`, `direccion`, `observacion`.
Llama a `POST /api/clientes` en el backend.

### `registrarProveedor.bpmn` — Registrar proveedor
Registra un nuevo proveedor. Variables: `nombre`, `telefono`, `direccion`, `observacion`.
Llama a `POST /api/proveedores` en el backend.

### `cobroProveedor.bpmn` — Pago a proveedor
Registra un pago realizado a un proveedor. Variables: `proveedor`, `fecha`, `monto`, `metodoPago`, `observacion`.
Llama a `POST /api/pagos-proveedor` en el backend.

## Cómo se ejecutan

Cada proceso tiene una única tarea de tipo **HTTP Task** que llama directo al backend, sin intervención manual. La URL de cada tarea HTTP apunta a:

```
http://host.docker.internal:8080/api/<recurso>
```

(`host.docker.internal` es la dirección especial que usa Docker para que Flowable, corriendo en un contenedor, pueda llegar al backend que corre en el mismo computador, fuera del contenedor.)

Los headers de cada tarea HTTP son:
```
Content-Type: application/json
Accept: application/json
```

El body de cada tarea usa variables del proceso con la sintaxis `${nombreVariable}` (los campos numéricos, como `monto`, van sin comillas; el resto van entre comillas).

## Cómo desplegarlos

1. Levantar Flowable Open Source local:
   ```
   docker run -d -p 8090:8080 --name flowable flowable/all-in-one
   ```
2. Entrar al Modeler (`http://localhost:8090/flowable-modeler`, usuario `admin`, contraseña `test`) e importar cada archivo `.bpmn` de esta carpeta.
3. Agregar los 4 procesos a una App (Apps → crear/editar app → agregar modelos BPMN).
4. Publicar la App.

## Cómo probarlos por consola

Ejemplo con "Cobro a clientes":
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

Los otros 3 procesos se prueban igual, cambiando `processDefinitionKey` (`registroDeClientes`, `registrarProveedor`, `cobroProveedor`) y las variables correspondientes.
