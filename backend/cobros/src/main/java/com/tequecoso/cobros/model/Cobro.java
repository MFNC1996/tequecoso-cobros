package com.tequecoso.cobros.model;

public class Cobro {

    private String cliente;
    private double monto;
    private String fechaVencimiento;
    private String estado;

    public Cobro() {
    }

    public Cobro(String cliente, double monto, String fechaVencimiento, String estado) {
        this.cliente = cliente;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
