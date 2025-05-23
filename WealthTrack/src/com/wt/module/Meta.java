package com.wt.module;

public class Meta {
	
	private int metaId;
	private int usuarioId;
	private double cantidadObjetivo;
	private double progresoActual;
	private String descripcion;
	
	public Meta(int metaId, int usuarioId, double cantidadObjetivo, double progresoActual, String descripcion) {
		this.metaId = metaId;
		this.usuarioId = usuarioId;
		this.cantidadObjetivo = cantidadObjetivo;
		this.progresoActual = progresoActual;
		this.descripcion = descripcion;
	}

	public int getMetaId() {
		return metaId;
	}

	public void setMetaId(int metaId) {
		this.metaId = metaId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public double getCantidadObjetivo() {
		return cantidadObjetivo;
	}

	public void setCantidadObjetivo(double cantidadObjetivo) {
		this.cantidadObjetivo = cantidadObjetivo;
	}

	public double getProgresoActual() {
		return progresoActual;
	}

	public void setProgresoActual(double progresoActual) {
		this.progresoActual = progresoActual;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Meta [metaId=" + metaId + ", usuarioId=" + usuarioId + ", cantidadObjetivo=" + cantidadObjetivo
				+ ", progresoActual=" + progresoActual + ", descripcion=" + descripcion + "]";
	}
	
	
	
}
