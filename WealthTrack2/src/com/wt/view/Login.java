package com.wt.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import com.wt.control.ControlLogin;
import com.wt.module.particular.Particular;
import com.wt.module.particular.Usuario;

public class Login extends JFrame {
	
    public static final int ANCHO = 850;
    public static final int ALTO = 650;
    private static final int ALTO_PNL_BTN = 37;
	private static final int ALTO_PNL_LOGO = 90;
	public static final int ALTO_PNL_CONTENIDO = ALTO - ALTO_PNL_LOGO - ALTO_PNL_BTN - 35;
    public static final String ACT_COM_BTN_PARTICULAR = "Particular";
    public static final String ACT_COM_BTN_EMPRESA = "Empresa";
	

    private JButton btnParticular;
    private JButton btnEmpresa;
    private JLabel lblImagen;
    private JLabel lblFondo;
	private JScrollPane scrContenido;
	private JPanel pnlFondo;
	private JLabel lblFondo2;
	private JPanel pnlLogo;
	private JPanel pnlBotones;
	private JLabel lblFondo3;
	
	

    public Login() {
        super("Wealhtrack");
        initComponents();
    }

    private void initComponents() {
        getContentPane().setLayout(new BorderLayout(0, 0));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(ANCHO, ALTO);

        // Centrar la ventana
        Dimension dimPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimVentana = new Dimension(ANCHO, ALTO);
        setLocation((dimPantalla.width - dimVentana.width) / 2, (dimPantalla.height - dimVentana.height) / 2);

        pnlLogo = new JPanel();
        //pnlLogo.setBounds(0, 0, ANCHO, ALTO_PNL_LOGO);
        pnlLogo.setPreferredSize(new Dimension(ANCHO, ALTO_PNL_LOGO));
        pnlLogo.setLayout(null);
        //pnlLogo.setSize(ANCHO, ALTO_PNL_LOGO);
        //panelCabecera.add(pnlLogo, BorderLayout.NORTH);
        getContentPane().add(pnlLogo, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("WealthTrack");
        lblNewLabel.setBounds(287, 24, 179, 40);
        pnlLogo.add(lblNewLabel);
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setFont(new Font("Palatino Linotype", Font.PLAIN, 29));

        lblImagen = new JLabel("");
        lblImagen.setBounds(461, 0, 97, 90);
        pnlLogo.add(lblImagen);
        lblImagen.setIcon(new ImageIcon(new ImageIcon(Login.class.getResource("/img/logo.png")).getImage()
                .getScaledInstance(83, 68, Image.SCALE_SMOOTH)));

        JLabel lblNewLabel_1 = new JLabel("Tu socio Financiero en un Click");
        lblNewLabel_1.setBounds(287, 50, 345, 14);
        pnlLogo.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(0, 0, 139));

        lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon(Login.class.getResource("/img/fondo.png")));
        lblFondo.setBounds(0, 0, ANCHO, ALTO_PNL_LOGO);
        pnlLogo.add(lblFondo);
        
        // Crear un panel para los componentes
        /*JPanel panelContenido = new JPanel();
        panelContenido.setLayout(null);
        panelContenido.setPreferredSize(new Dimension(ANCHO, ALTO - 30)); // Ajustar tamaño del contenido
*/
        pnlBotones = new JPanel();
        pnlBotones.setLayout(null);
        //pnlBotones.setOpaque(false);
        pnlBotones.setPreferredSize(new Dimension(ANCHO, ALTO_PNL_BTN));
        getContentPane().add(pnlBotones, BorderLayout.CENTER);
        
        // Crear y añadir componentes al panel
        btnParticular = new JButton(ACT_COM_BTN_PARTICULAR);
        /*btnParticular.setForeground(Color.BLACK);
        btnParticular.setBackground(new Color(255, 255, 255));*/
        btnParticular.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnParticular.setBounds(299, 0, 114, 37);
        pnlBotones.add(btnParticular);

        btnEmpresa = new JButton(ACT_COM_BTN_EMPRESA);
        /*btnEmpresa.setBackground(Color.WHITE);
        btnEmpresa.setForeground(Color.BLACK);*/
        btnEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnEmpresa.setBounds(413, 0, 114, 37);
        pnlBotones.add(btnEmpresa);
        
        lblFondo2 = new JLabel("");
        lblFondo2.setIcon(new ImageIcon(Login.class.getResource("/img/fondo.png")));
        lblFondo2.setBounds(0, 0, ANCHO, ALTO_PNL_BTN);
        pnlBotones.add(lblFondo2);
        
        scrContenido = new JScrollPane();
        //scrContenido.setOpaque(false);
        getContentPane().add(scrContenido, BorderLayout.SOUTH);
        
        pnlFondo = new JPanel();
        pnlFondo.setPreferredSize(new Dimension(ANCHO, ALTO_PNL_CONTENIDO));
        pnlFondo.setLayout(null);
        
        lblFondo3 = new JLabel("");
        lblFondo3.setIcon(new ImageIcon(Login.class.getResource("/img/fondo.png")));
        lblFondo3.setBounds(0, 0, ANCHO, ALTO_PNL_CONTENIDO);
        pnlFondo.add(lblFondo3);
        
        cargarPanel(pnlFondo);
       
    }

    public void setControlador(ControlLogin cl) {
        btnParticular.addActionListener(cl);
        btnEmpresa.addActionListener(cl);
        
    }
    
    public void cargarPanel(JPanel panel) {
    	scrContenido.setViewportView(panel);
    	
    }

	
}