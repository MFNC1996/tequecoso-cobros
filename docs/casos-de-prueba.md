# Casos de prueba

Este documento describe los escenarios principales probados en la solución implementada con Flowable y backend de soporte.

## Objetivo
Verificar que los procesos principales del negocio funcionan correctamente, que los formularios capturan la información esperada y que la solución responde de forma adecuada en los escenarios principales.

## Caso de prueba 1: Registro de cliente

### Descripción
Se prueba el proceso de registro de cliente mediante el formulario asociado en Flowable.

### Pasos
1. Iniciar el proceso de registro de cliente.
2. Completar el formulario con los datos solicitados.
3. Enviar la información.
4. Verificar que el proceso finaliza correctamente.

### Resultado esperado
El formulario se completa sin errores y el proceso de registro de cliente termina correctamente.

### Resultado obtenido
El proceso se ejecutó correctamente y permitió registrar la información del cliente.

---

## Caso de prueba 2: Registro de proveedor

### Descripción
Se prueba el proceso de registro de proveedor utilizando el formulario correspondiente en Flowable.

### Pasos
1. Iniciar el proceso de registro de proveedor.
2. Completar el formulario con los datos requeridos.
3. Enviar la información.
4. Verificar el cierre correcto del proceso.

### Resultado esperado
El formulario de proveedor se procesa correctamente y el flujo finaliza sin errores.

### Resultado obtenido
El proceso de registro de proveedor funcionó correctamente y permitió completar la actividad esperada.

---

## Caso de prueba 3: Cobro a clientes

### Descripción
Se prueba el proceso de cobro a clientes mediante el formulario de operación definido para este flujo.

### Pasos
1. Iniciar el proceso de cobro a clientes.
2. Completar el formulario con los datos del cobro.
3. Enviar la información del proceso.
4. Verificar que el flujo se ejecuta correctamente.

### Resultado esperado
El proceso de cobro recibe la información, ejecuta el flujo definido y finaliza de manera correcta.

### Resultado obtenido
El proceso de cobro a clientes se ejecutó correctamente en el escenario probado.

---

## Caso de prueba 4: Pago a proveedores

### Descripción
Se prueba el proceso de pago a proveedores utilizando el formulario definido para esta operación.

### Pasos
1. Iniciar el proceso de pago a proveedores.
2. Completar el formulario con los datos requeridos.
3. Enviar la información.
4. Verificar la finalización del flujo.

### Resultado esperado
El proceso recibe la información del pago y completa correctamente la secuencia definida.

### Resultado obtenido
El proceso de pago a proveedores funcionó correctamente en la prueba realizada.

## Evidencia
Las capturas de pantalla y demás evidencias relacionadas con estas pruebas se encuentran almacenadas en la carpeta `docs/evidencias/`.
