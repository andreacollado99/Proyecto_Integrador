package com.wt.module.particular;

import java.util.ArrayList;

import com.wt.module.Cripto;
import com.wt.module.Meta;
import com.wt.module.Movimiento;

public class Particular extends Usuario {
	
	/*private String nombre;
	private String apellido;
	private String email;
	private String contrasenia;
	private String fechaNacimiento;
	private String telefono;*/
	private String dni;
	

	private ArrayList<Movimiento> movimientos;
	private ArrayList<Meta> metas;
	private ArrayList<Cripto> criptos;

	/*public Particular(String nombre, String apellido, String dni, String email, String contrasenia,
			String fechaNacimiento, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.contrasenia = contrasenia;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		Movimientos = new ArrayList<Movimiento>();
		Metas = new ArrayList<Meta>();
		Criptos = new ArrayList<Cripto>();
	}*/
	
	

	public Particular(String email, String contrasenia) {
		super(email, contrasenia);
		
		movimientos = new ArrayList<Movimiento>();
		metas = new ArrayList<Meta>();
		criptos = new ArrayList<Cripto>();
	}

	public Particular(String nombre, String apellido, String dni, String email, String contrasenia,
			String fechaNacimiento, String telefono) {
		super(nombre, apellido, email, contrasenia, fechaNacimiento, telefono);
		this.dni = dni;
		
		movimientos = new ArrayList<Movimiento>();
		metas = new ArrayList<Meta>();
		criptos = new ArrayList<Cripto>();
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

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public ArrayList<Movimiento> getIdMovimientos() {
		return movimientos;
	}

	public void addMovimiento(Movimiento movimiento) {
		movimientos.add(movimiento);
	}

	public ArrayList<Meta> getIdMetas() {
		return metas;
	}

	public void addMeta(Meta meta) {
		metas.add(meta);
	}

	public ArrayList<Cripto> getIdCriptos() {
		return criptos;
	}

	public void addMeCripto(Cripto cripto) {
		criptos.add(cripto);
	}

}