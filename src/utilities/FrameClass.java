package utilities;

import javax.swing.JFrame;

public class FrameClass extends JFrame{
	
	private static final long serialVersionUID = 1L;

	// Tamaño de la ventana
	private int [] dimensionsXY = {600, 400};
	
	// Posicion de la ventana
	private int [] positionsXY = {100,100};
	
	public int[] getDimensionsXY() {
		return dimensionsXY;
	}

	public void setDimensionsXY(int[] dimensionsXY) {
		this.dimensionsXY = dimensionsXY;
	}

	public int[] getPositionsXY() {
		return positionsXY;
	}

	public void setPositionsXY(int[] positionsXY) {
		this.positionsXY = positionsXY;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	private String title = "Default title";
	
	// Constructor con titulo, valores por defecto width=600 height=400
	// Setea la posicion de la ventana en 100 y 100
	public FrameClass(String title){

		this.title = title;
		
		setTitle(title);
		setBounds(positionsXY[0], positionsXY[1], dimensionsXY[0], dimensionsXY[1]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
	}
	
	// Constructor con titulo, ancho y alto. Setea la posicion de la ventana en 100 y 100
	public FrameClass(String title, int width, int height){
		
		this.title = title;
		setTitle(title);
		
		this.dimensionsXY[0] = width;
		this.dimensionsXY[1] = height;
		
		setBounds(positionsXY[0], positionsXY[1], dimensionsXY[0], dimensionsXY[1]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}
	
	// Constructor con titulo, ancho y alto. Setea la posicion de la ventana en 100 y 100
	public FrameClass(String title, int width, int height, int initialPosX, int initialPosY){
		
		this.title = title;

		
		this.dimensionsXY[0] = width;
		this.dimensionsXY[1] = height;
		
		this.positionsXY[0] = initialPosX;
		this.positionsXY[1] = initialPosY;
		
		setBounds(positionsXY[0], positionsXY[1], dimensionsXY[0], dimensionsXY[1]);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
	}



}
