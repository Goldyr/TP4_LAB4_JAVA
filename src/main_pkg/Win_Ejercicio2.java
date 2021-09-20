package main_pkg;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Win_Ejercicio2 implements Runnable{

	
	public JFrame frame = new JFrame("Ejercicio2");
	public Win_Ejercicio2() {
		
	}

	//Uso hilos para correr el codigo de creacion del frame para que las ventanas puedan usarse al mismo tiempo
	@Override
	public void run() {

		try {

			//Alto ancho y posicion donde se crea
			frame.setBounds(100,100,600,400);

			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblTitulo = new JLabel("Ejercicio 2");
			frame.getContentPane().add(lblTitulo);
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
