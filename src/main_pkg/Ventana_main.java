package main_pkg;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana_main implements Runnable{

	//Titulo y creacion del frame
	public JFrame frame = new JFrame("MAIN");
	
	//Este es el main donde se crea la ventana principal
	public static void main(String[] args) {
		
		Ventana_main ventanaprincipal = new Ventana_main();
		ventanaprincipal.run();

	}
	
	public Ventana_main() {
		
	}

	//Uso hilos para correr el codigo de creacion del frame para que las ventanas puedan usarse al mismo tiempo
	@Override
	public void run() {

		try {
			//Alto ancho y posicion donde se crea
			frame.setBounds(100,100,600,400);

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			//label
			JLabel lblTpGrupo = new JLabel("TP4 - GRUPO 5");
			lblTpGrupo.setBounds(212, 0, 150, 14);
			lblTpGrupo.setHorizontalAlignment(SwingConstants.CENTER);
			frame.getContentPane().add(lblTpGrupo);
			
			//Boton Ej1
			JButton btnEjercicio1 = new JButton("Ejercicio 1");
			frame.getContentPane().add(btnEjercicio1);
			//Cuando el boton es clickeado crea una ventana Win_Ejercicio1 y usa el run()
			btnEjercicio1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Win_Ejercicio1 ej1 = new Win_Ejercicio1();
					//ej1.run();
					Thread hilo1 = new Thread(ej1);
					hilo1.start();
				}
			});
			btnEjercicio1.setBounds(225, 99, 130, 30);
			
			//Boton Ej2
			JButton btnEjercicio2 = new JButton("Ejercicio 2");
			frame.getContentPane().add(btnEjercicio2);
			btnEjercicio2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Win_Ejercicio2 ej2 = new Win_Ejercicio2();
					ej2.run();
					Thread hilo = new Thread(ej2);
					hilo.start();
				}
			});
			btnEjercicio2.setBounds(225, 159, 130, 30);
			
			
			//Boton Ej3
			JButton btnEjercicio3 = new JButton("Ejercicio 3");
			frame.getContentPane().add(btnEjercicio3);
			btnEjercicio3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Win_Ejercicio3 ej3 = new Win_Ejercicio3();
					ej3.run();
				}
			});
			btnEjercicio3.setBounds(225, 219, 130, 30);

			
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
