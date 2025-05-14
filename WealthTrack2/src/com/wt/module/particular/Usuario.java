package com.wt.module.particular;

public class Usuario {

	protected String nombre;
	protected String apellido;
	protected String email;
	protected String contrasenia;
	protected String fechaNacimiento;
	protected String telefono;
	
	/*
	private String dni;
	private String nif;*/
	
	public Usuario(String nombre, String apellido, String email, String contrasenia, String fechaNacimiento,
			String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasenia = contrasenia;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
	}

	public Usuario(String email, String contrasenia) {
		this.email = email;
		this.contrasenia = contrasenia;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}
	
}
