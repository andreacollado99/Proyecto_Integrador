package com.wt.module.particular;

public class Particular {
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String fechaNacimiento;
    private String contrasenia;
    private String telefono;

    public Particular(String nombre, String apellido, String dni, String email, String contrasenia, String fechaNacimiento, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getDni() {
        return dni;
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
