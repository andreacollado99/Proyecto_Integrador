package com.wt.module;

public class Cripto {
	
	private int idCripto;
	private String nombreCripto;
	private double importeEnCripto;
	private double importeEnEuro;
	
	public Cripto(int idCripto, String nombreCripto, double importeEnCripto, double importeEnEuro) {
		this.idCripto = idCripto;
		this.nombreCripto = nombreCripto;
		this.importeEnCripto = importeEnCripto;
		this.importeEnEuro = importeEnEuro;
	}

	public int getIdCripto() {
		return idCripto;
	}

	public void setIdCripto(int idCripto) {
		this.idCripto = idCripto;
	}

	public String getNombreCripto() {
		return nombreCripto;
	}

	public void setNombreCripto(String nombreCripto) {
		this.nombreCripto = nombreCripto;
	}

	public double getImporteEnCripto() {
		return importeEnCripto;
	}

	public void setImporteEnCripto(double importeEnCripto) {
		this.importeEnCripto = importeEnCripto;
	}

	public double getImporteEnEuro() {
		return importeEnEuro;
	}

	public void setImporteEnEuro(double importeEnEuro) {
		this.importeEnEuro = importeEnEuro;
	}
	
	

	
	
	
	
	

}
