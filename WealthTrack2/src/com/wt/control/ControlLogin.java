package com.wt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.wt.model.bbdd.TablaParticular;
import com.wt.module.particular.Particular;
import com.wt.module.particular.Usuario;
import com.wt.view.Home;
import com.wt.view.JPLoginE;
import com.wt.view.JPLoginP;
import com.wt.view.JPMovimientos;
import com.wt.view.Login;
import com.wt.view.RegistroParticular;

public class ControlLogin implements ActionListener {
	
	private static final int NUM_INTENTOS = 3;
	
	private Login lg;
	private RegistroParticular rp;
	private Home hm;
	private TablaParticular datos;
	private JPMovimientos jpm;
	private JPLoginP jplp;
	private JPLoginE jple;
	
	private int contIntentos = 0;
	
	public ControlLogin(Login lg, RegistroParticular rp, Home hm, JPMovimientos jpm,
			JPLoginP jplp, JPLoginE jple) {
		this.lg = lg;
		this.rp = rp;
		this.hm = hm;
		this.jpm = jpm;
		this.jplp = jplp;
		this.jple = jple;
		this.datos = new TablaParticular();
		contIntentos = 0;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton ) {
			if (e.getActionCommand().equals(Login.ACT_COM_BTN_PARTICULAR)) {
		         
				lg.cargarPanel(jplp);
	
			}else if (e.getActionCommand().equals(Login.ACT_COM_BTN_EMPRESA)) {
				lg.cargarPanel(jple);
				
			} else if (e.getActionCommand().equals(jplp.ACT_COM_BTN_INGRESAR)) {
				Particular usuarioV = jplp.obtenerDatos();
			
				if (usuarioV != null) {
					// COMPROBARLOS CONTRA LA BBDD
					
					Usuario usuarioTabla = datos.comprobarExiste(usuarioV.getEmail());
					
					// si los datos son correctos accede, si no mostramos mensaje de error
					if (usuarioTabla != null) {
						contIntentos++;
						// comparamos las passwords
						if (usuarioTabla.getContrasenia().equals(usuarioV.getContrasenia())) {
							// accede
							lg.dispose(); // cierra la ventana
							hm.setVisible(true);
							
						} else {
							// CONTROLAR 3 INTENTOS
							if (contIntentos < NUM_INTENTOS) {
								jplp.mostrarMensajeError("La contraseña no es correcta. Te quedan " + (NUM_INTENTOS - contIntentos) + " intentos." );

							} else {
								jplp.mostrarMensajeError("La contraseña no es correcta. Se han agotado los intentos. "
										+ "Póngase en contacto con su administrador." );
								System.exit(0);
							}
						}
						
					} else {
						jplp.mostrarMensajeError("El usuario no está registrado");
					}
				}
				
			} else if (e.getActionCommand().equals(jplp.ACT_COM_BTN_CREAR_PAR)) {
				lg.dispose();
				rp.setVisible(true);
				
			} else if (e.getActionCommand().equals(rp.ACT_COM_BTN_TENGO_CUENTA)) {
				rp.dispose();
				lg.setVisible(true);
				
			} else if (e.getActionCommand().equals(rp.ACT_COM_BTN_REGISTRARME)) {
				Particular usuarioReg = rp.obtenerDatos();
				
				if(usuarioReg != null) {
					int numRegI = datos.registrarParticular(usuarioReg);
					
					if (numRegI == 1) {
						 rp.mostrarMensaje("Registrado con éxito");
						 rp.dispose();
						 lg.setVisible(true);
						 jplp.cargarUsuario(usuarioReg.getEmail());
						 lg.cargarPanel(jplp);
						 
						
					}
				}
			} else if (e.getActionCommand().equals(hm.ACT_COM_BTN_GESTIONES))	{
				
			} else if (e.getActionCommand().equals(hm.ACT_COM_BTN_MOVIMIENTOS))	{
				hm.cargarPanel(jpm);
			} else if (e.getActionCommand().equals(hm.ACT_COM_BTN_INVERSIONES))	{
				
			}
		} 		
	}
	
}
	/*
	 * if (e.getSource() instanceof JButton ) {
			if (e.getActionCommand().equals(lp.ACT_COM_BTN_INGRESAR)) {
				Particular usuarioV = lp.obtenerDatos();
			
				if (usuarioV != null) {
					// COMPROBARLOS CONTRA LA BBDD
					
					Usuario usuarioTabla = datos.comprobarExiste(usuarioV.getEmail());
					
					// si los datos son correctos accede, si no mostramos mensaje de error
					if (usuarioTabla != null) {
						contIntentos++;
						// comparamos las passwords
						if (usuarioTabla.getContrasenia().equals(usuarioV.getContrasenia())) {
							// accede
							lp.dispose(); // cierra la ventana
							hm.setVisible(true);
							
						} else {
							// CONTROLAR 3 INTENTOS
							if (contIntentos < NUM_INTENTOS) {
								lp.mostrarMensajeError("La contraseña no es correcta. Te quedan " + (NUM_INTENTOS - contIntentos) + " intentos." );

							} else {
								lp.mostrarMensajeError("La contraseña no es correcta. Se han agotado los intentos. "
										+ "Póngase en contacto con su administrador." );
								System.exit(0);
							}
						}
						
					} else {
						lp.mostrarMensajeError("El usuario no está registrado");
					}
				}
				
			} else if (e.getActionCommand().equals(lp.ACT_COM_BTN_CREAR_PAR)) {
				lp.dispose();
				rp.setVisible(true);
				
			} else if (e.getActionCommand().equals(rp.ACT_COM_BTN_TENGO_CUENTA)) {
				rp.dispose();
				lp.setVisible(true);
				
			} else if (e.getActionCommand().equals(LoginEmpresa.ACT_COM_BTN_PARTI)) {
		         
					lp.cargarPanel(lp.getMainPanel());

			}else if (e.getActionCommand().equals(LoginParticular.ACT_COM_BTN_EMPREA)) {
					lp.cargarPanel(le);
				
			} else if (e.getActionCommand().equals(rp.ACT_COM_BTN_REGISTRARME)) {
				Usuario usuarioReg = rp.obtenerDatos();
				
				if(usuarioReg != null) {
					 rp.mostrarMensaje("Registrado con éxito");
					 rp.dispose();
					 lp.setVisible(true);
					 lp.cargarUsuario(usuarioReg.getEmail());
				}
			} else if (e.getActionCommand().equals(hm.ACT_COM_BTN_GESTIONES))	{
				
			} else if (e.getActionCommand().equals(hm.ACT_COM_BTN_MOVIMIENTOS))	{
				hm.cargarPanel(jpm);
			} else if (e.getActionCommand().equals(hm.ACT_COM_BTN_INVERSIONES))	{
				
			}
		} 		
	}
	 */

			

