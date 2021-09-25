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
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.Choice;
import java.awt.Container;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Win_Ejercicio2 extends JFrame implements Runnable   {

	private static final long serialVersionUID = 1L;
	
	public JFrame frame = new JFrame("Ejercicio2");
	private JTextField tf_Nota1;
	private JTextField tf_Nota2;
	private JTextField tf_Nota3;
	private JTextField tf_Promedio;
	private JTextField tf_Condicion;


	//sets and gets
	
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

	public void setTf_Nota3(JTextField tf_Nota3) {
		this.tf_Nota3 = tf_Nota3;
	}
	
	public JTextField getTf_Promedio() {
		return tf_Promedio;
	}

	public void setTf_Promedio(JTextField tf_Promedio) {
		this.tf_Promedio = tf_Promedio;
	}

	public JTextField getTf_Condicion() {
		return tf_Condicion;
	}

	public void setTf_Condicion(JTextField tf_Condicion) {
		this.tf_Condicion = tf_Condicion;
	}
	
	public Win_Ejercicio2() {
		getContentPane().setLayout(null);
		//Alto ancho y posicion donde se crea
		this.setBounds(100,100,600,400);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Ejercicio 2");
		this.getContentPane().add(lblTitulo);
		
		tf_Nota1 = new JTextField();
		tf_Nota1.setBounds(128, 44, 129, 26);
		getContentPane().add(getTf_Nota1());
		tf_Nota1.setColumns(10);
		
		//label de la nota 1
		JLabel lblNewLabel = new JLabel("Nota 1:");
		lblNewLabel.setBounds(37, 50, 46, 14);
		getContentPane().add(lblNewLabel);
		//label de la nota 2
		JLabel lblNota_1 = new JLabel("Nota 2:");
		lblNota_1.setBounds(37, 87, 46, 14);
		getContentPane().add(lblNota_1);
		//label de la nota 3
		JLabel lblNota = new JLabel("Nota 3:");
		lblNota.setBounds(37, 124, 46, 14);
		getContentPane().add(lblNota);
		//label de TPS
		JLabel lblNewLabel_2_1 = new JLabel("TPS");
		lblNewLabel_2_1.setBounds(37, 161, 46, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		tf_Nota2 = new JTextField();
		tf_Nota2.setColumns(10);
		tf_Nota2.setBounds(128, 81, 129, 26);
		getContentPane().add(tf_Nota2);
		
		tf_Nota3 = new JTextField();
		tf_Nota3.setColumns(10);
		tf_Nota3.setBounds(128, 118, 129, 26);
		getContentPane().add(tf_Nota3);
		
		
		
		//label de condicion
		JLabel lblNewLabel_2_2 = new JLabel("Condicion");
		lblNewLabel_2_2.setBounds(37, 284, 81, 14);
		getContentPane().add(lblNewLabel_2_2);
		
		//label de promedio
		JLabel lblNewLabel_1_1 = new JLabel("Promedio:");
		lblNewLabel_1_1.setBounds(37, 247, 81, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		tf_Promedio = new JTextField();
		tf_Promedio.setColumns(10);
		tf_Promedio.setBounds(128, 241, 129, 26);
		getContentPane().add(tf_Promedio);
		
		tf_Condicion = new JTextField();
		tf_Condicion.setColumns(10);
		tf_Condicion.setBounds(128, 278, 129, 26);
		getContentPane().add(tf_Condicion);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(128, 158, 129, 20);
		getContentPane().add(comboBox);
		
		Botones btn= new Botones(getContentPane(), this);
		
		
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
			Calculo();
		}
		if(e.getSource()==btn_Nuevo) {
			
		}
		if(e.getSource()==btn_Salir) {
			
		}
		
	}
	
	public void Calculo(){
 
		try{
	            int nota1 = Integer.parseInt(ventana2.getTf_Nota1().getText());
	            int nota2 = Integer.parseInt(ventana2.getTf_Nota2().getText());
	            int nota3 = Integer.parseInt(ventana2.getTf_Nota3().getText());
	            
	            IntStream promedio = IntStream.of(nota1,nota2,nota3);
	            OptionalDouble res = promedio.average();
	            int valor = (int) res.getAsDouble() ;
	            System.out.println(valor);
	            ventana2.getTf_Promedio().setText(String.valueOf(valor));
	        }
	        catch (NumberFormatException ex){
	            ex.printStackTrace();
	        }
		
		return;
	} 
	
}

