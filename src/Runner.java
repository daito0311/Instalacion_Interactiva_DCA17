import processing.core.PApplet;
import processing.core.PImage;

public class Runner {

	public float posX, posY;
	private int tipo;
	private float ancho, alto;
	private PImage cerdoPaja, cerdoLena, cerdoLadrillo;
	
	
	public Runner (float posX, float posY, float ancho, float alto, int tipo) {
	
	
		this.posX = posX;
		this.posY = posY;
		this.ancho = ancho;
		this.alto = alto;
		this.tipo = tipo;
	
	}	
	
	
	public void pintar(PApplet app){
		
		
	switch (tipo) {
	case 1:
		app.fill(255,0,0);
		app.ellipse(posX, posY, ancho, alto);
		break;

	case 2:
		app.fill(0,255,0);
		app.ellipse(posX, posY, ancho, alto);
		break;
		
	case 3:
		app.fill(0,0,255);
		app.ellipse(posX, posY, ancho, alto);
		break;
	}
	}


	public int getTipo() {
		return tipo;
	}


	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
	
}
