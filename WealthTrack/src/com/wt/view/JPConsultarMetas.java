package com.wt.view;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import com.wt.module.Meta;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JPConsultarMetas extends JPanel {
	
	public static final int ANCHO_PNL = 640;
	public static final int ALTO_PNL = 275;
	private JTable tblMetas;
	private DefaultTableModel dtmTablaMetas;
	private JScrollPane scrollPane;
	
	public JPConsultarMetas() {
		initComponents();
	}

	private void initComponents() {
		setSize(640, 240);
		
		setBackground(new Color(175, 238, 238));
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 29, 574, 181);
		add(scrollPane);
		
		tblMetas = new JTable();
		scrollPane.setViewportView(tblMetas);
		
		configurarTabla();

	}

	private void configurarTabla() {
		// creación del TableModel
		dtmTablaMetas = new DefaultTableModel() {
					
			// así indicamos que ninguna columna es editable
			public boolean isCellEditable(int row, int column) {
				return false;
				}
			};
			
			// especificamos el nombre de las columnas	
			dtmTablaMetas.addColumn("ID");
			dtmTablaMetas.addColumn("DESCRIPCIÓN");
			dtmTablaMetas.addColumn("CANTIDAD IMPORTE");
			
			// asignar el tablemodel a la tabla
			tblMetas.setModel(dtmTablaMetas);
	}
	
	public void rellenarTabla(ArrayList<Meta> listaMetas) {
		dtmTablaMetas.setRowCount(0); // limpia la tabla, vacia lo que tenga
		Object[] fila = new Object[5];
		
		for (Meta rest : listaMetas) {
			fila[0] = rest.getMetaId();
			fila[1] = rest.getDescripcion();
			fila[2] = rest.getCantidadObjetivo();			
			dtmTablaMetas.addRow(fila);
			
		}
	}
	
	public void mostrarMensajeError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error de datos", JOptionPane.ERROR_MESSAGE);
    }

	public void mostrarMensaje(String mensaje) {
		 JOptionPane.showMessageDialog(this, mensaje, "Resultado", JOptionPane.INFORMATION_MESSAGE);
		
	}

	public void ocultarTabla(boolean ocultar) {
		scrollPane.setVisible(ocultar);
	}
}

