package com.wt.module.empresa;

public class Empresa {
    
    private String nombre;
    private String apellido;
    private String nif;
    private String email;
    private String fechaNacimiento;
    private String contrasenia;
    private String telefono;

    public Empresa(String nombre, String apellido, String nif, String email, String contrasenia, String fechaNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nif = nif;
        this.email = email;
        this.contrasenia = contrasenia;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
    public String getNif() {
        return nif;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }
}
