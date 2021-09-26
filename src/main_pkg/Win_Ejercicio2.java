package main_pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import utilities.FrameClass;

import javax.swing.Box;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Choice;
import java.awt.Container;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class Win_Ejercicio2  implements Runnable   {


	private FrameClass fClass;
	
	public static float promedio;
	
	public static ArrayList <JTextField> listTextField;
	private static ArrayList <JTextField> listNotasTxtField;
	
	private static JComboBox comboBox;
	
	public Win_Ejercicio2() {
		
		promedio = 0;
		fClass = new FrameClass("Ejercicio 2");
		fClass.getContentPane().setLayout(null);
		
		listTextField = new ArrayList<JTextField>(5);
		
		this.crearVisual();
		this.actualizarVentana();
		
		fClass.setVisible(true);
		
	}
	
	// Se crea la parte visual de la ventana
	private void crearVisual() {
		
		JLabel lblTitulo = new JLabel("Ejercicio 2");
		fClass.getContentPane().add(lblTitulo);
		
		Botones btn= new Botones(fClass.getContentPane());
		
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setBounds(24, 225, 291, 113);
			fClass.getContentPane().add(panel);
			panel.setLayout(null);
			
			//label de condicion
			JLabel lblNewLabel_2_2 = new JLabel("Condicion:");
			lblNewLabel_2_2.setBounds(26, 67, 81, 14);
			panel.add(lblNewLabel_2_2);
			
			JTextField tf_Condicion = new JTextField();
			tf_Condicion.setBounds(127, 61, 129, 26);
			panel.add(tf_Condicion);
			tf_Condicion.setColumns(10);
			tf_Condicion.setEditable(false);
			
			//label de promedio
			JLabel lblNewLabel_1_1 = new JLabel("Promedio:");
			lblNewLabel_1_1.setBounds(26, 30, 81, 14);
			panel.add(lblNewLabel_1_1);
			
			JTextField tf_Promedio = new JTextField();
			tf_Promedio.setBounds(127, 24, 129, 26);
			panel.add(tf_Promedio);
			tf_Promedio.setColumns(10);
			tf_Promedio.setEditable(false);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(24, 35, 291, 179);
			fClass.getContentPane().add(panel_1);
			panel_1.setLayout(null);
			
			//label de la nota 1
			JLabel lblNewLabel = new JLabel("Nota 1:");
			lblNewLabel.setBounds(22, 23, 46, 14);
			panel_1.add(lblNewLabel);
	
			JTextField tf_Nota1 = new JTextField();
			tf_Nota1.setBounds(126, 17, 129, 26);
			panel_1.add(tf_Nota1);
			tf_Nota1.setColumns(10);
			
			//label de la nota 2
			JLabel lblNota_1 = new JLabel("Nota 2:");
			lblNota_1.setBounds(22, 65, 46, 14);
			panel_1.add(lblNota_1);
			
			JTextField tf_Nota2 = new JTextField();
			tf_Nota2.setBounds(126, 59, 129, 26);
			panel_1.add(tf_Nota2);
			tf_Nota2.setColumns(10);
		
			
			//label de la nota 3
			JLabel lblNota = new JLabel("Nota 3:");
			lblNota.setBounds(22, 105, 46, 14);
			panel_1.add(lblNota);
			
			//label de TPS
			JLabel lblNewLabel_2_1 = new JLabel("TPS");
			lblNewLabel_2_1.setBounds(22, 141, 46, 14);
			panel_1.add(lblNewLabel_2_1);
			
			comboBox = new JComboBox();
			comboBox.setBounds(126, 138, 129, 20);
			
			comboBox.addItem("Aprobado");
			comboBox.addItem("Desaprobado");
			
			panel_1.add(comboBox);
			
			JTextField tf_Nota3 = new JTextField();
			tf_Nota3.setBounds(126, 99, 129, 26);
			panel_1.add(tf_Nota3);
			tf_Nota3.setColumns(10);
			
	
			
		listNotasTxtField = new ArrayList<JTextField>(3);
		
		try {

				
			listTextField.add(tf_Nota1);
			listTextField.add(tf_Nota2);
			listTextField.add(tf_Nota3);
			listTextField.add(tf_Promedio);
			listTextField.add(tf_Condicion);
			
			listNotasTxtField.add(tf_Nota1);
			listNotasTxtField.add(tf_Nota2);
			listNotasTxtField.add(tf_Nota3);
			
		}
		 catch (IndexOutOfBoundsException e) {
	            System.out.println("Exception thrown : " + e);
	     }
		
		// El ArrayList de los textfield me almacena cada Tfield para no tener varios setters y getters
		// Indices
		// ========
		// 0: Nota1
		// 1: Nota2
		// 2: Nota3
		// 3: Promedio
		// 4: Condicion
		
		crearListenerNotas();
	}

	private void crearListenerNotas() {
		ListIterator<JTextField> it = listNotasTxtField.listIterator();
		
		while(it.hasNext())
		{
			JTextField txtField = it.next();
			crearDocumentEventNotas(txtField);
			it.remove();
		}
	}
	
	private void crearDocumentEventNotas(JTextField txtField) {
		txtField.getDocument().addDocumentListener(new DocumentListener() {
			  public void insertUpdate(DocumentEvent e) {
					  warn();
			  }

			  public void warn() {
					  if (Float.parseFloat(txtField.getText())<=0){
					       JOptionPane.showMessageDialog(null,
					          "Error: Ingrese un numero mayor a 0", "Error Message",
					          JOptionPane.ERROR_MESSAGE);
					     }
					     if (Float.parseFloat(txtField.getText())>10){
						       JOptionPane.showMessageDialog(null,
						          "Error: Ingrese un numero menor a 10", "Error Message",
						          JOptionPane.ERROR_MESSAGE);
						 }
			  }

			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	// Metodo que se llama para actualizar los valores de la ventana
	public static void actualizarVentana() {
		
		logicaTextFields();
		
		
		
	}
	
	private static void logicaTextFields() {
	
		// Se actualiza el valor del textfield del promedio
		listTextField.get(3).setText(String.valueOf(promedio));
		
		// Punto 1
		
		if(comboBox.getSelectedItem() == "Desaprobado")
		{
			listTextField.get(4).setText("Libre");
		}
		
		// Punto 2
		
		try {
			ListIterator<JTextField> it = listNotasTxtField.listIterator();
			
			while(it.hasNext()) {
				String notaTP = it.next().getText();	
				
				System.out.println(notaTP);
				
				if(Integer.parseInt(notaTP) <= 6 )
				{
					listTextField.get(4).setText("Libre");
				}
				it.remove();
			}
		
		}
		catch(IndexOutOfBoundsException ex) {
			
		}
	
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

class Botones implements ActionListener{
	
	private JButton btn_Calcular;
	private JButton btn_Nuevo; 
	private JButton btn_Salir;
	
	Botones(Container contentPane){
		//btn nuevo
		btn_Calcular = new JButton("CALCULAR");
		btn_Calcular.setBounds(318, 87, 129, 36);
		contentPane.add(btn_Calcular);
		btn_Calcular.addActionListener(this);
		//btn nuevo
		btn_Nuevo = new JButton("NUEVO");
		btn_Nuevo.setBounds(318, 129, 129, 36);
		contentPane.add(btn_Nuevo);
		btn_Nuevo.addActionListener(this);
		//btn salir
		btn_Salir = new JButton("SALIR");
		btn_Salir.setBounds(318, 170, 129, 36);
		contentPane.add(btn_Salir);
		btn_Salir.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Almaceno los string de cada textfield que voy a usar en un array
		String strTf_Nota1 = Win_Ejercicio2.listTextField.get(0).getText();
		String strTf_Nota2 = Win_Ejercicio2.listTextField.get(1).getText();
		String strTf_Nota3 = Win_Ejercicio2.listTextField.get(2).getText();
		
		// Array de string de cada nota
		String[] strTf_Notas = {strTf_Nota1, strTf_Nota2, strTf_Nota3};
		
		if(e.getSource()==btn_Calcular) {
						
			// Pregunto si están vacios asi evito errores
			if(!strTf_Notas[0].isEmpty() || 
					!strTf_Notas[1].isEmpty() || 
					!strTf_Notas[2].isEmpty() ) {
				// Se calcula el promedio
				Win_Ejercicio2.promedio = calcularPromedio(strTf_Notas);
			}
			  
		}
		if(e.getSource()==btn_Nuevo) {
			
		}
		if(e.getSource()==btn_Salir) {
			
		}
		
		Win_Ejercicio2.actualizarVentana();
	}
	
	public float calcularPromedio(String ArrNotas[]){
 
		float nota1, nota2, nota3;
		float valorPromedio = 0;
		
		try{
	           nota1 = Float.parseFloat(ArrNotas[0]);
	           nota2 = Float.parseFloat(ArrNotas[1]);
	           nota3 = Float.parseFloat(ArrNotas[2]);
	            
	            DoubleStream promedio = DoubleStream.of(nota1,nota2,nota3);
	            OptionalDouble res = promedio.average();
	            
	            valorPromedio = (float) res.getAsDouble();
	
	            //System.out.println(valorPromedio);
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
		
		return round(valorPromedio, 2);
	} 
	
	//Metodo para redondear hasta 2 cifras el decimal
	public static float round(float d, int decimalPlace) {
	    BigDecimal bd = new BigDecimal(Float.toString(d));
	    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	    return bd.floatValue();
	}
}

