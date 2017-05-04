import processing.core.PApplet;

public class Elemento {
	
	private float x;
	private float y;
	private float ancho;
	private float alto;
	private int tipo;
	
	public Elemento(float xcreator, int y, int alto, int ancho, int tipo) {
		
		this.x = xcreator;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.tipo = tipo;
	
	}
	
	
	public void pintar(PApplet app) {

		switch (tipo) {
		
		// PAJA
		case 1:
			app.fill(255,0,0);
			app.ellipse(x, y, alto, ancho);
			break;

			// MADERA
		case 2:
			app.fill(0,0,255);
			app.ellipse(x, y, alto, ancho);
			break;
			
			//LADRILLO
		case 3:
			app.fill(0,255,0);
			app.ellipse(x, y, alto, ancho);
			break;
		}
		
		
		
		
		
	}
	
	public void mover(PApplet app) {

		
		y+=4;
		
		ancho += 0.03;
		alto += 0.03;
	}

}
