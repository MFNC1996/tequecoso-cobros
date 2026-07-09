# Integración Flowable - Backend Cobros

## Objetivo

Integrar el proceso de cobro a clientes modelado en Flowable con el backend REST de cobros desarrollado en Spring Boot.

## Diseño realizado

Se modeló un proceso BPMN con formulario de captura de datos y se configuró una HTTP Task para invocar el endpoint:

- POST /api/cobros

El body JSON fue alineado con el modelo Cobro del backend, considerando los campos:

- cliente
- monto
- fechaVencimiento
- estado

## Resultado obtenido

El backend REST fue validado exitosamente con pruebas locales mediante curl.
El proceso BPMN y el formulario quedaron configurados en Flowable.
La integración directa desde Flowable hacia el backend local no se logró completar en la ejecución final por un problema de conectividad entre el entorno de Flowable y el servicio local.

## Conclusión

Se deja implementado y probado:
- proceso BPMN,
- formulario de captura,
- backend REST,
- pruebas de endpoints con curl,
- diseño de integración mediante HTTP Task.
