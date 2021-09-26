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
import javax.swing.JTextPane;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.Choice;
import java.awt.Container;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Win_Ejercicio2 extends JFrame implements Runnable   {

	private static final long serialVersionUID = 1L;
	
	public JFrame frame = new JFrame("Ejercicio2");
	
	private JTextField tf_Nota1;
	private JTextField tf_Nota2;
	private JTextField tf_Nota3;
	private JTextField tf_Promedio;
	private JTextField tf_Condicion;
	private JComboBox comboBoxTP;
	
	private float promedioAlumno = 0;
	
	public Win_Ejercicio2() {
		
		crearVisual();
		actualizarVentana();
	}
	
	private void crearVisual()
	{
		this.setTitle("Ejercicio 2");
		getContentPane().setLayout(null);
		//Alto ancho y posicion donde se crea
		this.setBounds(100,100,600,400);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		Botones btn= new Botones(getContentPane(), this);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(28, 11, 283, 188);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		//label de la nota 1
		JLabel lblNewLabel = new JLabel("Nota 1:");
		lblNewLabel.setBounds(32, 26, 58, 14);
		panel.add(lblNewLabel);
		//label de la nota 2
		JLabel lblNota_1 = new JLabel("Nota 2:");
		lblNota_1.setBounds(32, 65, 58, 14);
		panel.add(lblNota_1);
		//label de la nota 3
		JLabel lblNota = new JLabel("Nota 3:");
		lblNota.setBounds(32, 110, 46, 14);
		panel.add(lblNota);
		
		tf_Nota1 = new JFormattedTextField();
		tf_Nota1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) e.consume();
			}
		});
		tf_Nota1.setBounds(115, 20, 129, 26);
		panel.add(tf_Nota1);
		tf_Nota1.setColumns(10);
		
		tf_Nota2 = new JFormattedTextField();
		tf_Nota2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) e.consume();
			}
		});
		tf_Nota2.setBounds(115, 59, 129, 26);
		panel.add(tf_Nota2);
		tf_Nota2.setColumns(10);
		
		tf_Nota3 = new JFormattedTextField();
		tf_Nota3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar())) e.consume();
			}
		});
		tf_Nota3.setBounds(115, 104, 129, 26);
		panel.add(tf_Nota3);
		tf_Nota3.setColumns(10);
		//label de TPS
		JLabel lblNewLabel_2_1 = new JLabel("TPS");
		lblNewLabel_2_1.setBounds(32, 147, 46, 14);
		panel.add(lblNewLabel_2_1);
		
		comboBoxTP = new JComboBox();
		comboBoxTP.setModel(new DefaultComboBoxModel(new String[] {"Aprobado", "Desaprobado"}));
		comboBoxTP.setBounds(115, 144, 129, 20);
		panel.add(comboBoxTP);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Notas del estudiante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(28, 211, 283, 118);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		//label de promedio
		JLabel lblNewLabel_1_1 = new JLabel("Promedio:");
		lblNewLabel_1_1.setBounds(29, 32, 75, 14);
		panel_1.add(lblNewLabel_1_1);
		
		
		
		//label de condicion
		JLabel lblNewLabel_2_2 = new JLabel("Condicion");
		lblNewLabel_2_2.setBounds(29, 71, 81, 14);
		panel_1.add(lblNewLabel_2_2);
		
		tf_Promedio = new JTextField();
		tf_Promedio.setEditable(false);
		tf_Promedio.setBounds(115, 26, 129, 26);
		panel_1.add(tf_Promedio);
		tf_Promedio.setColumns(10);
		
		tf_Condicion = new JTextField();
		tf_Condicion.setEditable(false);
		tf_Condicion.setBounds(115, 65, 129, 26);
		panel_1.add(tf_Condicion);
		tf_Condicion.setColumns(10);
	}
	
	public void actualizarVentana() {
		
		tf_Promedio.setText(String.valueOf(promedioAlumno));
		
		logicaCondicionNotas();
		
	}
	
	private void logicaCondicionNotas()
	{
		try {
			float nota1, nota2, nota3;
			nota1 = Float.parseFloat(tf_Nota1.getText());
			nota2 = Float.parseFloat(tf_Nota2.getText());
			nota3 = Float.parseFloat(tf_Nota3.getText());
			
			if(comboBoxTP.getSelectedItem() == "Desaprobado") {
				tf_Condicion.setText("Libre");
				return;
			}
			
			if(nota1 < 6 || nota2 < 6 ||nota3 < 6) {
				tf_Condicion.setText("Libre");
				return;
	        }
			
			if(nota1 >= 8 && nota2 >= 8 && nota3 >= 8
					&& comboBoxTP.getSelectedItem() =="Aprobado") {
				tf_Condicion.setText("Promocionado");
				return;
	        }

			if(nota1 >=6 && nota1<=8 && 
					nota2>=6  && nota2<=8 && 
					nota3>=6 && nota3<=8 && 
					comboBoxTP.getSelectedItem() =="Aprobado") {
				tf_Condicion.setText("Regular");
	        }
		}
		
		catch(Exception ex) {
			
		}
	}
	
	
	
	
	//sets and gets
	
		public void setPromedioAlumno(float promedio) {
			promedioAlumno = promedio;
		}
		
		public float getPromedioAlumno() {
			return promedioAlumno;
		}
		
		public JTextField getTf_Nota1() {
			return tf_Nota1;
		}

		public void setTf_Nota1(JTextField tf_Nota1) {
			this.tf_Nota1 = tf_Nota1;
		}
		
		
		public JTextField getTf_Nota2() {
			return tf_Nota2;
		}

		public void setTf_Nota2(JTextField tf_Nota2) {
			this.tf_Nota2 = tf_Nota2;
		}
		
		public JTextField getTf_Nota3() {
			return tf_Nota3;
		}

	//Uso hilos para correr el codigo de creacion del frame para que las ventanas puedan usarse al mismo tiempo
	@Override
	public void run() {

		try {
			Win_Ejercicio2 frame = new Win_Ejercicio2();

			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Botones implements ActionListener{
	
	private JButton btn_Calcular;
	private JButton btn_Nuevo; 
	private JButton btn_Salir;
	private Win_Ejercicio2 ventana2;
	
	Botones(Container contentPane, Win_Ejercicio2 vent){
		ventana2= vent;
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
		
		if(e.getSource()==btn_Calcular) {
			ventana2.setPromedioAlumno(calcularPromedio());
		}
		if(e.getSource()==btn_Nuevo) {
			
		}
		if(e.getSource()==btn_Salir) {
			
		}
		
		ventana2.actualizarVentana();
	
	}
	
	public float calcularPromedio(){
 
		float valorPromedio = 0;
		
		try{
	            float nota1 = Float.parseFloat(ventana2.getTf_Nota1().getText());
	            float nota2 = Float.parseFloat(ventana2.getTf_Nota2().getText());
	            float nota3 = Float.parseFloat(ventana2.getTf_Nota3().getText());
	            
	            DoubleStream promedio = DoubleStream.of(nota1,nota2,nota3);
	            OptionalDouble res = promedio.average();
	            
	            valorPromedio = (float)res.getAsDouble() ;
	          
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
		
		return  round(valorPromedio, 2);
	} 
	


//Metodo para redondear hasta 2 cifras el decimal
public static float round(float d, int decimalPlace) {
    BigDecimal bd = new BigDecimal(Float.toString(d));
    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
    return bd.floatValue();
}
}
