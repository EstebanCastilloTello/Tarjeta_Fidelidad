package com.fidelidad;

import java.time.LocalDate;

public class Compra {
    private final String idCompra;
    private final String idCliente;
    private final double monto;
    private final LocalDate fecha;

    public Compra(String idCompra, String idCliente, double monto, LocalDate fecha) {
        this.idCompra = idCompra;
        this.idCliente = idCliente;
        this.monto = monto;
        this.fecha = fecha;
    }

    public String getIdCompra() { return idCompra; }
    public String getIdCliente() { return idCliente; }
    public double getMonto() { return monto; }
    public LocalDate getFecha() { return fecha; }
}
