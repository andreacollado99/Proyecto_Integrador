package com.wt.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import com.wt.model.bbdd.TablaEmpresa;
import com.wt.model.bbdd.TablaMeta;
import com.wt.model.bbdd.TablaParticular;
import com.wt.module.Meta;
import com.wt.module.empresa.Empresa;
import com.wt.module.particular.Particular;
import com.wt.view.Home;
import com.wt.view.JPAniadirMetas;
import com.wt.view.JPConsultarMetas;
import com.wt.view.JPGestiones;
import com.wt.view.JPMovimientos;
import com.wt.view.Login;
import com.wt.view.RegistroEmpresa;
import com.wt.view.RegistroParticular;

public class ControlLogin implements ActionListener {

    private static final int NUM_INTENTOS = 3;

    private Login lg;
    private RegistroParticular rp;
    private RegistroEmpresa re;
    private Home hm;
    private JPMovimientos jpm;
    private JPGestiones jpg;
    private JPAniadirMetas jpa;
    private JPConsultarMetas jpc;
    private TablaParticular datosParticular;
    private TablaEmpresa datosEmpresa;
    private TablaMeta datosMeta;

    private int contIntentos = 0;

    public ControlLogin(Login lg, RegistroParticular rp, RegistroEmpresa re, Home hm, 
    		JPMovimientos jpm, JPGestiones jpg, JPAniadirMetas jpa, JPConsultarMetas jpc) {
        this.lg = lg;
        this.rp = rp;
        this.re = re;
        this.hm = hm;
        this.jpm = jpm;
        this.jpg = jpg;
        this.jpa = jpa;
        this.jpc = jpc;
        this.datosParticular = new TablaParticular();
        this.datosEmpresa = new TablaEmpresa();
        this.datosMeta = new TablaMeta();
        contIntentos = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();

            if (btn.getText().equals(Login.ACT_COM_BTN_INGRESAR)) { // BOTON INGRESAR
                System.out.println("Botón Ingresar presionado");
                
                String email = lg.obtenerEmail();
                String contrasenia = lg.obtenerContrasenia();
                boolean esParticular = lg.esParticularSeleccionado();

                if (email != null && contrasenia != null) {
                    if (esParticular) {
                        Particular particular = datosParticular.comprobarExiste(email, contrasenia);
                        if (particular != null) {
                            lg.dispose();
                            hm.setVisible(true);
                        } else {
                            lg.mostrarMensajeError("El usuario no está registrado como particular");
                        }
                    } else {
                        Empresa empresa = datosEmpresa.comprobarExiste(email, contrasenia);
                        if (empresa != null) {
                            lg.dispose();
                            hm.setVisible(true);
                        } else {
                            lg.mostrarMensajeError("El usuario no está registrado como empresa");
                        }
                    }
                }
                
            } else if (btn.getText().equals(Login.ACT_COM_BTN_CREAR_PARTICULAR)) { // BOTON CREAR CUENTA PARTICULAR
                System.out.println("Botón Crear cuenta particular presionado");
                lg.dispose();
                rp.setVisible(true);
                
            } else if (btn.getText().equals(Login.ACT_COM_BTN_CREAR_EMPRESA)) { // BOTON CREAR CUENTA EMPRESA
                System.out.println("Botón Crear cuenta empresa presionado");
                lg.dispose();
                re.setVisible(true);
                
            } else if (btn.getText().equals(RegistroParticular.ACT_COM_BTN_TENGO_CUENTA)) { // BOTON YA TENGO CUENTA PARTICULAR
                System.out.println("Botón Ya tengo una cuenta (Particular) presionado");
                rp.dispose();
                lg.setVisible(true);
                
            } else if (btn.getText().equals(RegistroEmpresa.ACT_COM_BTN_TENGO_CUENTA)) { // BOTON YA TENGO CUENTA EMPRESA
                System.out.println("Botón Ya tengo una cuenta (Empresa) presionado");
                re.dispose();
                lg.setVisible(true);
                
            } else if (btn.getText().equals(RegistroParticular.ACT_COM_BTN_REGISTRARME)) { // BOTON PARA REGISTRARSE PARTICULAR
                System.out.println("Botón Registrarme (Particular) presionado");
                Particular usuarioReg = rp.obtenerDatos();
                
                if (usuarioReg != null) {
                    int numRegI = datosParticular.registrarParticular(usuarioReg);
                    if (numRegI == 1) {
                        rp.mostrarMensaje("Registrado con éxito");
                        rp.dispose();
                        lg.setVisible(true);
                    }
                }
                
            } else if (btn.getText().equals(RegistroEmpresa.ACT_COM_BTN_REGISTRARME)) { // BOTON PARA REGISTRARSE EMPRESA
                System.out.println("Botón Registrarme (Empresa) presionado");
                Empresa empresaReg = re.obtenerDatos();
                
                if (empresaReg != null) {
                    int numRegI = datosEmpresa.registrarEmpresa(empresaReg);
                    if (numRegI == 1) {
                        re.mostrarMensaje("Registrado con éxito");
                        re.dispose();
                        lg.setVisible(true);
                    }
                }
            } else if (btn.getText().equals(Home.ACT_COM_BTN_GESTIONES)) { // BOTON GESTIONES
                System.out.println("Botón Gestiones presionado");
                hm.cargarPanel(jpg);
                
            } else if (btn.getText().equals(Home.ACT_COM_BTN_MOVIMIENTOS)) { // BOTON MOVIMIENTOS
                System.out.println("Botón Movimientos presionado");
                hm.cargarPanel(jpm);
               
            } else if (btn.getText().equals(Home.ACT_COM_BTN_INVERSIONES)) { // BOTON INVERSIONES
                System.out.println("Botón Inversiones presionado");
            
            } else if (btn.getText().equals(JPGestiones.ACT_COM_BTN_ANIADIR_META)) { // BOTON AÑADIR META
                System.out.println("Botón añadir meta presionado");
                jpg.cargarPanelMetas(jpa);
            
            } else if (btn.getText().equals(JPAniadirMetas.ACT_COM_BTN_ANIADIR)) { // BOTON AÑADIR EN META
            	Meta aniadirMeta = jpa.obtenerDatos();
            	
            	if (aniadirMeta != null) {
            		int numRegM = datosMeta.registrarMeta(aniadirMeta);
                    
            		if (numRegM == 1) {
                        jpa.mostrarMensaje("Meta registrada con éxito");
            		}
            	}
            } else if (btn.getText().equals(JPGestiones.ACT_COM_BTN_CONSULTAR_META)) { // BOTON CONSULTAR META
            	// primero recupamos los datos del filtro
            	String descripcion = jpa.obtenerDescripcion();
            	String importe = jpa.obtenerImporte();
            	
            	// segundo analizamos la consulta con la bbdd
            	ArrayList<Meta> listaMetas = new ArrayList<Meta>();
            	
            	// analizar la lista
				if(listaMetas.isEmpty()) {
					JOptionPane.showMessageDialog(jpc, "No se han encontrado datos para el filtro introducido", 
							"Resultado de consulta", JOptionPane.INFORMATION_MESSAGE);
					
					jpc.ocultarTabla(false);
				} else {
					// mostrar el resultado de la consulta en la ventana
					jpc.rellenarTabla(listaMetas);
					
					jpc.ocultarTabla(true);
				}
            }
         }
    }

}
