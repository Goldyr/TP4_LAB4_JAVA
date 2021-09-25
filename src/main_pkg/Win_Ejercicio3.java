package main_pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import utilities.FrameClass;

import java.awt.Choice;
import javax.swing.JList;
import java.awt.Scrollbar;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButtonMenuItem;


public class Win_Ejercicio3 implements Runnable{
	
	private FrameClass fClass;

	private final ButtonGroup btnGroup_SO = new ButtonGroup();
	private final ButtonGroup btnGroup_Esp = new ButtonGroup();
	private  JTextField txtHoras;
	private JButton btnNewButton;
	
	public Win_Ejercicio3() {

		fClass = new FrameClass("Ejercicio 70");
		fClass.getContentPane().setLayout(null);
		
		this.crearVisual();

		
		fClass.setVisible(true);
	}

	// Metodo para crear la parte visual de la ventana
	private void crearVisual() {
		
		//1. Panel general donde esta el label y los radio buttons
		// ==============
		JPanel pnl_seleccionarSO = new JPanel();
		pnl_seleccionarSO.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		fClass.getContentPane().add(pnl_seleccionarSO);
		pnl_seleccionarSO.setBounds(10, 26, 564, 93);
		fClass.getContentPane().add(pnl_seleccionarSO);
		pnl_seleccionarSO.setLayout(null);
		
		//1.1 Label para seleccionar los radio buttons
		// ===============
		JLabel lbl_seleccionarSO = new JLabel("Elije un sistema operativo");
		lbl_seleccionarSO.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl_seleccionarSO.setBounds(32, 39, 167, 14);
		pnl_seleccionarSO.add(lbl_seleccionarSO);
		
		// 1.2 Panel donde se encuentran los radio buttons
		// ==============
		JPanel pnl_elegir_cb = new JPanel();
		pnl_elegir_cb.setBounds(225, 24, 306, 47);
		pnl_seleccionarSO.add(pnl_elegir_cb);
		pnl_elegir_cb.setLayout(new GridLayout(1, 3, 0, 0));
		
		
		// 1.2.1 Checkboxlist para elegir el SO
		// =============
		JRadioButton rbWindows = new JRadioButton("Windows");
		rbWindows.setSelected(true);
		btnGroup_SO.add(rbWindows);
		pnl_elegir_cb.add(rbWindows);
		
		JRadioButton rbMac = new JRadioButton("Mac");
		btnGroup_SO.add(rbMac);
		pnl_elegir_cb.add(rbMac);
		
		JRadioButton rbLinux = new JRadioButton("Linux");
		btnGroup_SO.add(rbLinux);
		pnl_elegir_cb.add(rbLinux);
		
		// 2.1 Panel general donde estan las especialidades
		// ===========
		
		JPanel pnl_elegirEsp = new JPanel();
		pnl_elegirEsp.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl_elegirEsp.setBounds(10, 130, 564, 114);
		fClass.getContentPane().add(pnl_elegirEsp);
		pnl_elegirEsp.setLayout(null);
		
		// 2.2 Label de las especialidades
		// ============
		JLabel lblElijeUnaEspecialidad = new JLabel("Elije una especialidad");
		lblElijeUnaEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblElijeUnaEspecialidad.setBounds(30, 45, 148, 14);
		pnl_elegirEsp.add(lblElijeUnaEspecialidad);
		
	
		// 2.3 Panel donde están los checkboxes
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(214, 11, 317, 89);
		pnl_elegirEsp.add(panel_2);
		panel_2.setLayout(null);
		
		// 2.3.1 Checkboxes para elegir la especialidad
		// ===========
		JCheckBox cbProg = new JCheckBox("Programaci\u00F3n");
		cbProg.setSelected(true);
		btnGroup_Esp.add(cbProg);
		cbProg.setBounds(71, 7, 240, 23);
		panel_2.add(cbProg);
		
		JCheckBox cbDGrafico = new JCheckBox("Dise\u00F1o Gr\u00E1fico");
		btnGroup_Esp.add(cbDGrafico);
		cbDGrafico.setBounds(71, 59, 240, 23);
		panel_2.add(cbDGrafico);
		
		JCheckBox cbAdmin = new JCheckBox("Administraci\u00F3n");
		btnGroup_Esp.add(cbAdmin);
		cbAdmin.setBounds(71, 33, 240, 23);
		panel_2.add(cbAdmin);
		
		// 3.1 Panel para ingresar las horas
		// ===========
		
		JPanel pnl_ingresarHoras = new JPanel();
		pnl_ingresarHoras.setBounds(10, 255, 564, 43);
		fClass.getContentPane().add(pnl_ingresarHoras);
		pnl_ingresarHoras.setLayout(null);
		
		// 3.1.1 Label para ingresar horas
		// ==============
		JLabel lblHoras = new JLabel("Cantidad de horas en el computador: ");
		lblHoras.setBounds(32, 11, 253, 21);
		pnl_ingresarHoras.add(lblHoras);
		
		// 3.1.2 Textfield para ingresar horas
		// ============
		txtHoras = new JTextField();
		txtHoras.setBounds(289, 11, 108, 20);
		pnl_ingresarHoras.add(txtHoras);
		txtHoras.setColumns(10);
		
		// 4. Boton para aceptar
		btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(385, 309, 119, 23);
		fClass.getContentPane().add(btnNewButton);
	}

	
	private void crearLogica() {
		//TODO: FALTA CREAR LA NUEVA VENTANA CUANDO INGRESE LAS HORAS
	}
	
	//Uso hilos para correr el codigo de creacion del frame para que las ventanas puedan usarse al mismo tiempo
	@Override
	public void run() {

		try {

		
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
