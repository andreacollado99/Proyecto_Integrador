package model;

public class UsuarioEmpresa extends Usuario {
    private String nif;
    private String nombreEmpresa;

    // Constructor
    public UsuarioEmpresa(int usuarioId, String nombre, String apellido, String email, String telefono, String contrasena, String nif, String nombreEmpresa) {
        super(usuarioId, nombre, apellido, email, telefono, contrasena);
        this.nif = nif;
        this.nombreEmpresa = nombreEmpresa;
    }

    // Getters y Setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    @Override
    public String toString() {
        return "UsuarioEmpresa{" +
                "nif='" + nif + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", " + super.toString() +
                '}';
    }
}