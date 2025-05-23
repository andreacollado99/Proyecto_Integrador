package com.wt.module;

public class SesionUsuario {
	
	public static SesionUsuario instancia;
	
	private String email;
	private String nombre;
	
	private SesionUsuario() {	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public static SesionUsuario getInstancia() {
		if (instancia == null) {
			instancia = new SesionUsuario();
		}
		return instancia;
	}
}
