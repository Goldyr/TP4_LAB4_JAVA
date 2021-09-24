package main_pkg;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Win_Ejercicio1 extends JFrame implements Runnable{

	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtTelefono;
	public JTextField txtFecha;
	private JButton btnMostrar;
	public JLabel lblDatoNombre;
	public JLabel lblDatoApellido;
	public JLabel lblDatoTelefono;
	public JLabel lblDatoFecha;


	public Win_Ejercicio1() {
		//Alto ancho y posicion donde se crea
			this.setBounds(100,100,600,400);

			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.getContentPane().setLayout(null);
			
			JLabel lblTitulo = new JLabel("Ejercicio 1");
			this.getContentPane().add(lblTitulo);
			this.setVisible(true);
			
			//label nombre
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(65, 30, 46, 14);
			this.getContentPane().add(lblNombre);
			
			///textbox nombre
			txtNombre = new JTextField();
			txtNombre.setBounds(150, 27, 140, 20);
			this.getContentPane().add(txtNombre);
			txtNombre.setColumns(10);
			
			//Label apellido
			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(65, 70, 46, 14);
			this.getContentPane().add(lblApellido);
			
			///Textbox apellido
			txtApellido = new JTextField();
			txtApellido.setBounds(150, 67, 140, 20);
			this.getContentPane().add(txtApellido);
			txtApellido.setColumns(10);
			
			//label telefono
			JLabel lblTelefono= new JLabel("Telefono");
			lblTelefono.setBounds(65, 110, 46, 14);
			this.getContentPane().add(lblTelefono);
			
			//textbox Telefono
			txtTelefono = new JTextField();
			txtTelefono.setBounds(150, 107, 140, 20);
			this.getContentPane().add(txtTelefono);
			txtTelefono.setColumns(10);
			
			//label Fecha
			JLabel lblFecha = new JLabel("Fecha Nac.");
			lblFecha.setBounds(65, 150, 63, 14);
			this.getContentPane().add(lblFecha);
			
			//textbox Fecha
			txtFecha = new JTextField();
			txtFecha.setBounds(150, 147, 140, 20);
			this.getContentPane().add(txtFecha);
			txtFecha.setColumns(10);
			
			//boton mostrar
			btnMostrar = new JButton("Mostrar");
			btnMostrar.setBounds(201, 192, 89, 23);
			this.getContentPane().add(btnMostrar);
			
			//label datos
			JLabel lblDatos = new JLabel("Los datos ingresados fueron: ");
			lblDatos.setBounds(10, 261, 189, 14);
			this.getContentPane().add(lblDatos);
			
			lblDatoNombre = new JLabel("-");
			lblDatoNombre.setBounds(209, 261, 65, 14);
			this.getContentPane().add(lblDatoNombre);
			
			lblDatoApellido = new JLabel("-");
			lblDatoApellido.setBounds(284, 261, 65, 14);
			this.getContentPane().add(lblDatoApellido);
			
			lblDatoTelefono = new JLabel("-");
			lblDatoTelefono.setBounds(359, 261, 65, 14);
			this.getContentPane().add(lblDatoTelefono);
			
			lblDatoFecha = new JLabel("-");
			lblDatoFecha.setBounds(458, 261, 65, 14);
			this.getContentPane().add(lblDatoFecha);
			
			BotonMostrar btn = new BotonMostrar(txtNombre, txtApellido, txtTelefono, txtFecha, this);		
			btnMostrar.addActionListener(btn);
			setVisible(true);

	}

	//Uso hilos para correr el codigo de creacion del frame para que las ventanas puedan usarse al mismo tiempo
	@Override
	public void run() {

		try {
			Win_Ejercicio1 frame = new Win_Ejercicio1();
			frame.setVisible(true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class BotonMostrar implements ActionListener{
	private JTextField Nombre;
	private JTextField Apellido;
	private JTextField Telefono;
	private JTextField Fecha;
	private Win_Ejercicio1 form;
	
	public BotonMostrar(JTextField Nom, JTextField Ape, JTextField Tel, JTextField Fec, Win_Ejercicio1 Formu) {
		Nombre= Nom;
		Apellido= Ape;
		Telefono = Tel;
		Fecha = Fec;
		form= Formu;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//form = new Win_Ejercicio1();
		
		boolean Datos = VerificarDatos();
		
		if(Datos==true) {
		form.lblDatoNombre.setText(Nombre.getText());
		form.lblDatoApellido.setText(Apellido.getText());
		form.lblDatoTelefono.setText(Telefono.getText());
		form.lblDatoFecha.setText(Fecha.getText());
		
		form.txtNombre.setBackground(Color.WHITE);
		form.txtApellido.setBackground(Color.WHITE);
		form.txtTelefono.setBackground(Color.WHITE);
		form.txtFecha.setBackground(Color.WHITE);
		
		form.txtNombre.setText("");
		form.txtApellido.setText("");
		form.txtTelefono.setText("");
		form.txtFecha.setText("");
		}
	
	}
	
	public boolean VerificarDatos() {
		
		if(Nombre.getText().length()==0 || Apellido.getText().length()==0 || Telefono.getText().length()==0 || Fecha.getText().length()==0) {
			
			if(Nombre.getText().length()==0) {
				form.txtNombre.setBackground(Color.RED);
			}
			
			if(Apellido.getText().length()==0) {
				form.txtApellido.setBackground(Color.RED);
			}
					
			if(Telefono.getText().length()==0) {
				form.txtTelefono.setBackground(Color.RED);
			}
						
			if(Fecha.getText().length()==0) {
				form.txtFecha.setBackground(Color.RED);
			}
			
			return false;
		}
		
		return true;
	}
	

	public JTextField getNombre() {
		return Nombre;
	}


	public void setNombre(JTextField nombre) {
		Nombre = nombre;
	}

	
	public JTextField getApellido() {
		return Apellido;
	}


	public void setApellido(JTextField apellido) {
		Apellido = apellido;
	}


	public JTextField getTelefono() {
		return Telefono;
	}


	public void setTelefono(JTextField telefono) {
		Telefono = telefono;
	}


	public JTextField getFecha() {
		return Fecha;
	}


	public void setFecha(JTextField fecha) {
		Fecha = fecha;
	}
	
}
