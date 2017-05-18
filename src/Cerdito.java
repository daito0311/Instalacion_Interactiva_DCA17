import processing.core.PApplet;

public class Cerdito {
	
	public float posX, posY;
private  int tipo;
private float ancho, alto;

	public Cerdito(float posX, float posY, float ancho, float alto,  int tipo) {
		
		
		this.posX = posX;
		this.posY = posY;
		this.ancho = ancho;
		this.alto = alto;
		this.tipo = tipo;
	}

	public void pintar(PApplet app) {
		
		
		
		app.fill(255,0,0);
		app.ellipse(posX, posY, ancho, alto);
		
		
	}
	
	
	

}
