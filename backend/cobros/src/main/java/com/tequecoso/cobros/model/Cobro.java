package com.tequecoso.cobros.model;

public class Cobro {

    private String cliente;
    private double monto;
    private String estado;

    public Cobro() {
    }

    public Cobro(String cliente, double monto, String estado) {
        this.cliente = cliente;
        this.monto = monto;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
