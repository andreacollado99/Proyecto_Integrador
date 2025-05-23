package com.wt.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.wt.control.ControlLogin;
import com.wt.module.Movimiento;

import javax.swing.JButton;
import javax.swing.JTable;

public class JPInversiones extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnAceptar;
	private JTable tblMovimientos;
	private JComboBox<String> cbmMovimientos;
	private DefaultTableModel dtmTablaMovimientos;
	
	
	
	public JPInversiones() {
		initComponents();
	}

	private void initComponents() {
		setLayout(null);
		
		setSize(Home.ANCHO - 60, Home.ALTO - 120);
		
		cbmMovimientos = new JComboBox<String>();
		cbmMovimientos.setModel(new DefaultComboBoxModel(new String[] {"Ingreso", "Gasto"}));
		cbmMovimientos.setFont(new Font("Tahoma", Font.BOLD, 13));
		cbmMovimientos.setBounds(106, 21, 101, 34);
		add(cbmMovimientos);
		
		textField = new JTextField();
		textField.setBounds(360, 70, 229, 34);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(360, 114, 229, 34);
		add(textField_1);
		
		JLabel lblNomMovi = new JLabel("Nombre del movimiento");
		lblNomMovi.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNomMovi.setBounds(177, 114, 173, 34);
		add(lblNomMovi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(87, 238, 613, 221);
		add(scrollPane);
		
		tblMovimientos = new JTable();
		scrollPane.setViewportView(tblMovimientos);
		
		JLabel lblImporte = new JLabel("Importe");
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblImporte.setBounds(177, 70, 173, 34);
		add(lblImporte);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAceptar.setBounds(360, 182, 93, 21);
		add(btnAceptar);
        
		configurarTabla();
		
	}

	private void configurarTabla() {
		// creación del TableModel
		dtmTablaMovimientos = new DefaultTableModel() {
			
			// así indicamos que ninguna columna es editable
			public boolean isCellEditable(int row, int column) {
				return false;
				}
			};
			
			// especificamos el nombre de las columnas	
			dtmTablaMovimientos.addColumn("ID");
			dtmTablaMovimientos.addColumn("TIPO");
			dtmTablaMovimientos.addColumn("NOMBRE");
			dtmTablaMovimientos.addColumn("IMPORTE");
			
			// asignar el tablemodel a la tabla
			tblMovimientos.setModel(dtmTablaMovimientos);
			
			// configurar el tamaño de las columnas
			//dtmTablaMovimientos.getColumn("DESCRIPCION").setPreferredWidth(100);
	}
	
	public void rellenarTabla(ArrayList<Movimiento> listaMovimientos) {
		dtmTablaMovimientos.setRowCount(0); // limpia la tabla, vacia lo que tenga
		Object[] fila = new Object[4];
		
		for (Movimiento mov : listaMovimientos) {
			fila[0] = mov.getIdMovimiento();
			fila[1] = mov.getTipo();
			fila[2] = mov.getNombreMovimiento();
			fila[3] = mov.getImporte();
			
			dtmTablaMovimientos.addRow(fila);
			
		}
	}

	public void setControlador(ControlLogin cl) {
		btnAceptar.addActionListener(cl);
		
	}
}

