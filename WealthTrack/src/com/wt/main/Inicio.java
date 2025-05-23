package com.wt.main;

import java.awt.EventQueue;

import com.wt.control.ControlLogin;
import com.wt.view.Home;
import com.wt.view.JPAniadirMetas;
import com.wt.view.JPConsultarMetas;
import com.wt.view.JPGestiones;
import com.wt.view.JPMovimientos;
import com.wt.view.Login;
import com.wt.view.RegistroEmpresa;
import com.wt.view.RegistroParticular;

public class Inicio {

	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        @Override
	        public void run() {
	            Login lg = new Login();
	            RegistroParticular rp = new RegistroParticular();
	            RegistroEmpresa re = new RegistroEmpresa();
	            Home hm = new Home();
	            JPMovimientos jpm = new JPMovimientos();
	            JPGestiones jpg = new JPGestiones();
	            JPAniadirMetas jpa = new JPAniadirMetas();
	            JPConsultarMetas jpc = new JPConsultarMetas();
	            
	            ControlLogin cl = new ControlLogin(lg, rp, re, hm, jpm, jpg, jpa, jpc);

	            lg.setControlador(cl);
	            rp.setControlador(cl);
	            re.setControlador(cl);
	            hm.setControlador(cl);
	            jpm.setControlador(cl);
	            jpg.setControlador(cl);
	            jpa.setControlador(cl);

	            lg.setVisible(true);
	        }
	    });
	}

}
