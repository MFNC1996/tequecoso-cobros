package com.tequecoso.cobros.model;

public class PagoProveedor {

    private String proveedor;
    private String fecha;
    private double monto;
    private String metodoPago;
    private String observacion;

    public PagoProveedor() {
    }

    public PagoProveedor(String proveedor, String fecha, double monto, String metodoPago, String observacion) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.observacion = observacion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
