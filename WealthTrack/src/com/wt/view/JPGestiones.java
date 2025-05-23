package com.wt.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wt.control.ControlLogin;
import com.wt.module.Movimiento;
import com.wt.module.SesionUsuario;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPGestiones extends JPanel {
	public static final String ACT_COM_BTN_ANIADIR_META = "Añadir Meta";
	public static final String ACT_COM_BTN_CONSULTAR_META = "Consultar Meta";	
	private JButton btnAniadirMeta;
	private JButton btnConMeta;
	private JScrollPane contenedor;
		
	public JPGestiones() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		setBackground(new Color(175, 238, 238));
		
		setSize(Home.ANCHO - 60, Home.ALTO - 120);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Castellar", Font.PLAIN, 18));
		lblBienvenido.setBounds(10, 10, 165, 38);
		add(lblBienvenido);
        
		JLabel lblUsuario = new JLabel(SesionUsuario.getInstancia().getNombre());
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(48, 85, 122, 29);
		add(lblUsuario);
		
		JLabel lblPuntitos = new JLabel("...................................................................................");
		lblPuntitos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuntitos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuntitos.setBounds(184, 97, 397, 29);
		add(lblPuntitos);
		
		JLabel lblDinero = new JLabel("DINERO");
		lblDinero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDinero.setBounds(591, 85, 122, 29);
		add(lblDinero);
		
		btnAniadirMeta = new JButton(ACT_COM_BTN_ANIADIR_META);
		btnAniadirMeta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAniadirMeta.setBounds(167, 154, 157, 21);
		add(btnAniadirMeta);
		
		btnConMeta = new JButton(ACT_COM_BTN_CONSULTAR_META);
		btnConMeta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConMeta.setBounds(457, 154, 157, 21);
		add(btnConMeta);
		
		contenedor = new JScrollPane();
		contenedor.setVisible(false);
		contenedor.setBounds(77, 203, 640, 240);
		contenedor.setBorder(null);
		add(contenedor);
		
		
		
	}

	public void setControlador(ControlLogin cl) {
		btnAniadirMeta.addActionListener(cl);
		btnConMeta.addActionListener(cl);
	}
	
	public void cargarPanelMetas(JPanel panel) {
		contenedor.setViewportView(panel);
		contenedor.setVisible(true);
		
	}
}

