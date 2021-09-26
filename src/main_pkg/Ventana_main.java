package main_pkg;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_main extends JFrame{


	
	//Este es el main donde se crea la ventana principal
	public static void main(String[] args) {
		
		Ventana_main ventanaprincipal = new Ventana_main();
		ventanaprincipal.setVisible(true);
	}
	
	public Ventana_main() {
		
		//Alto ancho y posicion donde se crea
		this.setBounds(100,100,600,400);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		//label
		JLabel lblTpGrupo = new JLabel("TP4 - GRUPO 5");
		lblTpGrupo.setBounds(212, 0, 150, 14);
		lblTpGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		this.getContentPane().add(lblTpGrupo);
		
		//Boton Ej1
		JButton btnEjercicio1 = new JButton("Ejercicio 1");
		this.getContentPane().add(btnEjercicio1);
		//Cuando el boton es clickeado crea una ventana Win_Ejercicio1 y usa el run()
		btnEjercicio1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Win_Ejercicio1 ej1 = new Win_Ejercicio1();
				ej1.setVisible(true);
			}
		});
		btnEjercicio1.setBounds(225, 99, 130, 30);
		
		//Boton Ej2
		JButton btnEjercicio2 = new JButton("Ejercicio 2");
		this.getContentPane().add(btnEjercicio2);
		btnEjercicio2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Win_Ejercicio2 ej2 = new Win_Ejercicio2();
				ej2.setVisible(true);
			}
		});
		btnEjercicio2.setBounds(225, 159, 130, 30);
		
		
		//Boton Ej3
		JButton btnEjercicio3 = new JButton("Ejercicio 3");
		this.getContentPane().add(btnEjercicio3);
		btnEjercicio3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Win_Ejercicio3 ej3 = new Win_Ejercicio3();
				ej3.setVisible(true);
			}
		});
		btnEjercicio3.setBounds(225, 219, 130, 30);

		
		
	}


}
