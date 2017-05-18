import processing.core.PApplet;
import processing.core.PImage;

public class Casa {
	
	private float posX, posY;
	private int tipo;
	private PImage Casademadera, Casadepaja, casadeladrillo;
	
	public Casa(float posX, float posY, int tipo) {
	
		this.posX = posX;
		this.posY = posY;

		
	}
	
	public void pintar(PApplet app) {
		
		
		switch (tipo) {
		case 1:
			Casadepaja = app.loadImage("../data/Nivel3-09.png");
			app.image(Casadepaja, posX, posY, 551/2, 840/2);
			break;

		case 2:
			Casademadera = app.loadImage("../data/Nivel3-07.png");
			app.image(Casademadera, posX, posY, 551/2, 840/2);
			break;
			
		case 3:
			
			casadeladrillo = app.loadImage("../data/Nivel3-08.png");
			app.image(casadeladrillo, posX, posY,  551/2, 840/2);
			break;
		}
		
		
		
		
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	
	
}
