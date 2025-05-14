package com.wt.module.empresa;

import java.util.ArrayList;

import com.wt.module.empresa.Empresa;

public class FuenteDatosEmpresa {
	private ArrayList<Empresa> listaEmpresa;

	public FuenteDatosEmpresa() {
		this.listaEmpresa = new ArrayList<Empresa>();
	}

	public void addEmpresa(Empresa e) {
		listaEmpresa.add(e);
	}

	public ArrayList<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}
}
