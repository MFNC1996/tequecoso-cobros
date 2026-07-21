# Acta de sesión de trabajo — S3

**Proyecto:** Tequecoso Cobros (Evaluación 3)
**Fecha:** 20 de julio de 2026
**Responsable:** Mauricio Fernando Núñez Caamaño
**Modalidad:** Trabajo individual

## Objetivo de la sesión

Resolver las observaciones de la Entrega 2 (BPMN demasiado simple, sin evidencia de ejecución en Flowable, interfaces solo prototipo, videos en formato incorrecto) y dejar el proyecto funcionando de extremo a extremo para la Entrega 3.

## Actividades realizadas

1. **Migración de Flowable cloud a Flowable Open Source local.** Se agotó el período de prueba de la versión cloud; se instaló Docker Desktop y se levantó Flowable Open Source en un contenedor local, tal como fue recomendado en la retroalimentación del profesor.
2. **Conectividad backend–Flowable.** Se resolvió la comunicación entre el motor de procesos (contenedor Docker) y el backend local, usando la dirección `host.docker.internal`.
3. **Modelado y ejecución de 4 procesos BPMN**, cubriendo el proceso de negocio completo:
   - Registro de clientes
   - Cobro a clientes
   - Registrar proveedor
   - Pago a proveedor

   Cada uno con una tarea HTTP conectada al backend, validado con ejecución de extremo a extremo (inicio → tarea HTTP → fin) sin intervención manual.
4. **Ampliación del backend.** Se agregaron endpoints `/iniciar-proceso` en los 4 controladores (`ClienteController`, `CobroController`, `ProveedorController`, `PagoProveedorController`), que permiten iniciar los procesos de Flowable desde el frontend, y se habilitó CORS para el consumo desde la interfaz web.
5. **Desarrollo del frontend.** Se construyó una interfaz web (`frontend/index.html`) con formularios y listados para las 4 entidades del negocio, conectada al backend y, a través de este, a los procesos de Flowable.
6. **Actualización de documentación.** Se actualizaron el `README.md` principal y se agregó `BPMN/README.md`, reflejando el estado real y funcional del proyecto.
7. **Control de versiones.** Se subieron todos los cambios a GitHub mediante commits, resolviendo un conflicto de merge en el proceso.

## Decisiones tomadas

- Usar Flowable Open Source en Docker como solución definitiva (en vez de la versión cloud), alineado con lo pedido por el profesor.
- Que el backend actúe como intermediario entre el frontend y Flowable (endpoints `/iniciar-proceso`), evitando restricciones de CORS del navegador al llamar directo a la API de Flowable.

## Pendientes para el cierre de la entrega

- Grabación de video para la emprendedora (visión de caja negra).
- Grabación de video para el profesor (visión de caja blanca / técnica).
