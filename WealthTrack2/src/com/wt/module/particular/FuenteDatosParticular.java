package com.wt.module.particular;

import java.util.ArrayList;

import com.wt.module.particular.Particular;

public class FuenteDatosParticular {
	private ArrayList<Particular> listaUsuarios;

	public FuenteDatosParticular() {
		this.listaUsuarios = new ArrayList<Particular>();
	}

	public void addUsuario(Particular p) {
		listaUsuarios.add(p);
	}

	public ArrayList<Particular> getListaParticular() {
		return listaUsuarios;
	}
}
