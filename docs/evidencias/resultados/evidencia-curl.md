# Evidencia de prueba REST con curl

Se verificó el funcionamiento del backend REST de cobros mediante terminal utilizando curl.

## POST de prueba

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

## GET de verificación

```bash
curl http://localhost:8080/api/cobros
```

## Resultado

El endpoint POST registra un nuevo cobro y el endpoint GET retorna la lista actualizada de cobros.

## Observación

La API REST quedó operativa en entorno local. La integración desde Flowable mediante HTTP Task fue configurada, pero no se logró completar la comunicación con el backend local por conectividad entre entornos.
