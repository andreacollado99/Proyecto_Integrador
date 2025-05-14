package com.wt.model.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wt.module.particular.Particular;
import com.wt.module.particular.Usuario;

public class TablaParticular {

	static final String NOM_TABLA = "Particular";
	static final String NOM_COL_NOM = "Nombre";
	static final String NOM_COL_APE = "Apellido";
	static final String NOM_COL_DNI = "DNI";
	static final String NOM_COL_EMAIL = "Email";
	static final String NOM_COL_FECHA_NAC = "FechaNac";
	static final String NOM_COL_CONTRA = "Contraseña";
	static final String NOM_COL_TEL = "Telefono";
	
	private ConexionBBDD conBBDD;

	public TablaParticular() {
		conBBDD = new ConexionBBDD();
	}
	
	public Usuario comprobarExiste(String email) {
		Usuario usuario = null;
		
		String query = "SELECT " + NOM_COL_CONTRA + " FROM " + NOM_TABLA 
				+ " WHERE " + NOM_COL_EMAIL + " = ?";
		
		Connection con = null; 
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = conBBDD.getConexion();
			
			System.out.println("## Conexión establecida");

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			
			System.out.println("## Statement preparado");
			
			rslt = pstmt.executeQuery();
			
			System.out.println("## Se ha ejecutado la sentencia");
			
			if (rslt.next()) {
				usuario = new Usuario(email, rslt.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();	
			
		} finally {
			try {
				
				if (rslt != null ) {
					rslt.close(); 
				}
				
				if (pstmt != null) {
					pstmt.close(); 
				}
				
				if (con != null) {
					con.close(); 
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		return usuario; 
	}

	public int registrarParticular(Particular usuarioReg) {
		// cuando implementemos un metodo que vaya a ejecutar un select 
		// nos va a interesar que retorne un entero que representa el numero 
		// de registros que se vean afectados por la sentencia
		
		int resultado = 0;
		
		String query = "INSERT INTO " + NOM_TABLA + "(" + NOM_COL_NOM 
				+ "," + NOM_COL_APE + "," + NOM_COL_DNI 
				+ "," + NOM_COL_FECHA_NAC + "," + NOM_COL_EMAIL 
				+ "," + NOM_COL_CONTRA + "," + NOM_COL_TEL + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		/*String query = "INSERT INTO " + NOM_TABLA + " VALUES (?, ?)";*/
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		// NO NECESITAMOS UN RESULTSET PORQUE NO ES TIPO SELECT
		
		try {
			con = conBBDD.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, usuarioReg.getNombre());
			pstmt.setString(2, usuarioReg.getApellido());
			pstmt.setString(3, usuarioReg.getDni());
			pstmt.setString(4, usuarioReg.getFechaNacimiento());
			pstmt.setString(5, usuarioReg.getEmail());
			pstmt.setString(6, usuarioReg.getContrasenia());
			pstmt.setString(7, usuarioReg.getTelefono());
			
			resultado = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		return resultado;
		
	}
}
