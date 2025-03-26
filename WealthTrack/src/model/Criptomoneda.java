package model;

public class Criptomoneda {
    private int criptoId;
    private int usuarioId;
    private String tipoCriptomoneda; // "Nueva" o "Existente"
    private double cantidad;

    // Constructor
    public Criptomoneda(int criptoId, int usuarioId, String tipoCriptomoneda, double cantidad) {
        this.criptoId = criptoId;
        this.usuarioId = usuarioId;
        this.tipoCriptomoneda = tipoCriptomoneda;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getCriptoId() {
        return criptoId;
    }

    public void setCriptoId(int criptoId) {
        this.criptoId = criptoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getTipoCriptomoneda() {
        return tipoCriptomoneda;
    }

    public void setTipoCriptomoneda(String tipoCriptomoneda) {
        this.tipoCriptomoneda = tipoCriptomoneda;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Criptomoneda{" +
                "criptoId=" + criptoId +
                ", usuarioId=" + usuarioId +
                ", tipoCriptomoneda='" + tipoCriptomoneda + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }
}