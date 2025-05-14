package com.wt.module.empresa;

import java.util.ArrayList;

import com.wt.module.Cripto;
import com.wt.module.Meta;
import com.wt.module.Movimiento;
import com.wt.module.Transaccion;

public class Empresa {
	private String nombre;
	private String apellido;
	private String nif;
	private String email;
	private String contrasenia;
	private String fechaNacimiento;
	private String telefono;
	
	private ArrayList<Movimiento> movimientos;
	private ArrayList<Meta> metas;
	private ArrayList<Transaccion> transacciones;

	public Empresa(String nombre, String apellido, String nif, String email, String contrasenia, String fechaNacimiento,
			String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nif = nif;
		this.email = email;
		this.contrasenia = contrasenia;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		movimientos = new ArrayList<Movimiento>();
		metas = new ArrayList<Meta>();
		transacciones = new ArrayList<Transaccion>();
	}

	public Empresa(String nif, String email, String contrasenia) {

		this.nif = nif;
		this.email = email;
		this.contrasenia = contrasenia;
		fechaNacimiento = "";
		telefono = "";
		nombre = "";
		apellido = "";
		movimientos = new ArrayList<Movimiento>();
		metas = new ArrayList<Meta>();
		transacciones = new ArrayList<Transaccion>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getnif() {
		return nif;
	}

	public String getEmail() {
		return email;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}

	public void addMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}

	public ArrayList<Meta> getMetas() {
		return metas;
	}

	public void addMeta(Meta meta) {
		metas.add(meta);
	}

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void addTransaccion(Transaccion transaccion) {
		transacciones.add(transaccion);
	}

}