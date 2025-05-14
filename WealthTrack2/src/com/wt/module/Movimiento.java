package com.wt.module;

public class Movimiento {
	public static String[] TIPOS = {"Ingreso","Gasto"};
	
	private int idMovimiento;
	private String tipo;
	private String nombreMovimiento;
	private double importe;
	
	public Movimiento(String tipo, String nombreMovimiento, int importe) {
		this.tipo = tipo;
		this.nombreMovimiento = nombreMovimiento;
		this.importe = importe;
	}

	public String getNombreMovimiento() {
		return nombreMovimiento;
	}

	public void setNombreMovimiento(String nombreMovimiento) {
		this.nombreMovimiento = nombreMovimiento;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public String getTipo() {
		return tipo;
	}
	
	

}
