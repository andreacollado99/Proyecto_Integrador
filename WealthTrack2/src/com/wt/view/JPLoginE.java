package com.wt.view;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

import com.wt.control.ControlLogin;
import com.wt.module.particular.Particular;

public class JPLoginE extends JPanel {

	public static final String ACT_COM_BTN_EMPRESA = "Empresa";
    public static final String ACT_COM_BTN_OLVIDE = "Olvidé mi contraseña";
    public static final String ACT_COM_BTN_INGRESAR = "Ingresar";
    public static final String ACT_COM_BTN_CREAR_PAR = "Crear cuenta particular";
	
    private JTextField textEmail;
	private JPasswordField passContrasenia;
	private JButton btnOlvideContrasenia;
	private JButton btnCrearCuentaPar;
	private JButton btnIngresar;
	private JLabel lblFondo;
	private JTextField textField;
	private JTextField textNif;

    public JPLoginE() {
        initComponents();
    }

    private void initComponents() {
    	setLayout(null);
		
		setSize(Login.ANCHO, Login.ALTO_PNL_CONTENIDO);

        // Crear un panel para los componentes
        /*JPanel panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setPreferredSize(new Dimension(Login.ANCHO, Login.ALTO));*/ // Ajustar tamaño del contenido

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEmail.setBounds(248, 20, 46, 25);
        add(lblEmail);

        textEmail = new JTextField();
        textEmail.setBounds(238, 73, 373, 31);
        add(textEmail);

        JLabel lblNif = new JLabel("NIF");
        lblNif.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNif.setBounds(248, 121, 46, 25);
        add(lblNif);
        
        textNif = new JTextField();
        textNif.setBounds(238, 174, 373, 31);
        add(textNif);
        
        JLabel lblContrasenia = new JLabel("Contraseña");
        lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblContrasenia.setBounds(248, 215, 90, 25);
        add(lblContrasenia);

        passContrasenia = new JPasswordField();
        passContrasenia.setBounds(238, 269, 373, 31);
        add(passContrasenia);

        btnOlvideContrasenia = new JButton(ACT_COM_BTN_OLVIDE);
        btnOlvideContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnOlvideContrasenia.setBounds(238, 311, 179, 21);
        btnOlvideContrasenia.setContentAreaFilled(false);
        btnOlvideContrasenia.setBorderPainted(false);
        add(btnOlvideContrasenia);

        btnCrearCuentaPar = new JButton(ACT_COM_BTN_CREAR_PAR);
        btnCrearCuentaPar.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCrearCuentaPar.setContentAreaFilled(false);
        btnCrearCuentaPar.setBorderPainted(false);
        btnCrearCuentaPar.setBounds(238, 342, 186, 21);
        add(btnCrearCuentaPar);
        
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setForeground(Color.BLACK);
        btnIngresar.setBounds(368, 405, 114, 37);
        btnIngresar.setBackground(Color.WHITE);
        add(btnIngresar);
        
        lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Login.class.getResource("/img/fondo.png")));
        lblFondo.setBounds(0, 0, Login.ANCHO, Login.ALTO_PNL_CONTENIDO);
        add(lblFondo);
        
        
       
    }

    public void setControlador(ControlLogin cl) {
        btnIngresar.addActionListener(cl);
        btnOlvideContrasenia.addActionListener(cl);
        btnCrearCuentaPar.addActionListener(cl);
    }

    public Particular obtenerDatos() {
        Particular usuario = null;

        String email = textEmail.getText().trim();
        String contrasenia = passContrasenia.getText().trim();
        if (email.isEmpty() || contrasenia.isEmpty()) {
            mostrarMensajeError("Todos los campos son obligatorios");
        }else {
        	 usuario = new Particular(email, contrasenia);
        }
        return usuario;
    }

	public void mostrarMensajeError(String error) {
		JOptionPane.showMessageDialog(this, error, "Error de datos", JOptionPane.ERROR_MESSAGE);
		
	}
	public void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public boolean comprobar(Particular usuario, ArrayList<Particular> lisUs) {
	    for (Particular u : lisUs) {
	        if (u.getEmail().equals(usuario.getEmail()) && u.getContrasenia().equals(usuario.getContrasenia())) {
	            return true;
	        }
	    }
	    return false;
	}

	public void cargarUsuario(String email) {
		
		textEmail.setText(email);
		
	}	
}