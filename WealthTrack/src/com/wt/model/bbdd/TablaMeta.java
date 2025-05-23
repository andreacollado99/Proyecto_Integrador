package com.wt.model.bbdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.wt.module.Meta;
import com.wt.module.particular.Particular;

public class TablaMeta {


	static final String NOM_TABLA = "Meta";
	static final String NOM_COL_META_ID = "MetaID";
	static final String NOM_COL_ID_USUARIO = "IdUsuario";
	static final String NOM_COL_CANTIDAD_OBJETIVO = "Cantidad Objetivo";
	static final String NOM_COL_DESCRIPCION = "Descripcion";
	static final String NOM_COL_PROGRESO_ACTUAL = "Progreso Actual";

    
	private ConexionBBDD conBBDD;
	 
	public TablaMeta( ) {
		conBBDD = new ConexionBBDD();
	}
	
	public int registrarMeta(Meta metaReg) {
		int resultado = 0;

        String query = "INSERT INTO " + NOM_TABLA + "(" + NOM_COL_META_ID
                + "," + NOM_COL_DESCRIPCION
                + "," + NOM_COL_CANTIDAD_OBJETIVO + ") VALUES (?, ?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = conBBDD.getConexion();
            pstmt = con.prepareStatement(query);
            
            pstmt.setInt(1, metaReg.getMetaId());
            pstmt.setString(2, metaReg.getDescripcion());
            pstmt.setDouble(3, metaReg.getCantidadObjetivo());

            resultado = pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resultado;
    }
	
	public ArrayList<String> consultarMetas() {
		
		ArrayList<String> listaMetas = new ArrayList<String>();
		
		String query = "SELECT DISTINCT " + NOM_COL_DESCRIPCION + " FROM " + NOM_TABLA;
		
		Connection con = null;
		Statement stmt = null; // la sentencia esta completa
		ResultSet rslt = null;
		
		try {
			con = conBBDD.getConexion();
			
			stmt = con.createStatement();
			
			rslt = stmt.executeQuery(query);
			
			while (rslt.next()) {
				listaMetas.add(rslt.getString(1));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				
				if (stmt != null) {
					stmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaMetas;
		
	}

}
