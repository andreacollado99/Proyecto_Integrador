package com.wt.main;

import java.awt.EventQueue;

import com.wt.control.ControlLogin;
import com.wt.view.Home;
import com.wt.view.JPLoginE;
import com.wt.view.JPLoginP;
import com.wt.view.JPMovimientos;
import com.wt.view.Login;
import com.wt.view.RegistroParticular;

public class Inicio {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
	
				Login lg = new Login();
				RegistroParticular rp = new RegistroParticular();
				Home hm = new Home();
				JPMovimientos jpm = new JPMovimientos();
				JPLoginP jplp = new JPLoginP();
				JPLoginE jple = new JPLoginE();
				
				ControlLogin cl = new ControlLogin(lg, rp, hm, jpm, jplp, jple);
				
				lg.setControlador(cl);
				rp.setControlador(cl);
				hm.setcontrolador(cl);
				jpm.setControlador(cl);
				jplp.setControlador(cl);
				jple.setControlador(cl);
				
				
				lg.setVisible(true);
				
				
				
			}
		});
	}

}
