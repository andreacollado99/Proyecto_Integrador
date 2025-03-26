package model;

import java.util.Date;

public class Gasto {
    private int gastoId;
    private int usuarioId;
    private double cantidad;
    private Date fecha;
    private String tipo;

    // Constructor
    public Gasto(int gastoId, int usuarioId, double cantidad, Date fecha, String tipo) {
        this.gastoId = gastoId;
        this.usuarioId = usuarioId;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipo = tipo;
    }

    // Getters y Setters
    public int getGastoId() {
        return gastoId;
    }

    public void setGastoId(int gastoId) {
        this.gastoId = gastoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Gasto{" +
                "gastoId=" + gastoId +
                ", usuarioId=" + usuarioId +
                ", cantidad=" + cantidad +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}