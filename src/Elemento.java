import processing.core.PApplet;
import processing.core.PImage;

public class Elemento {

	public float posX, posY;
	private int tipo;
	private float ancho, alto;
	private PImage paja, madera, ladrillo, roca;

	public Elemento(float x, float y, float ancho, float alto, int tipo) {

		this.posX = x;
		this.posY = y;
		this.ancho = ancho;
		this.alto = alto;
		this.tipo = tipo;

	}



	public void pintar(PApplet app) {

		
		
		
		switch (tipo) {
		case 0:
 // OBSTACULO 
			roca= app.loadImage("../data/Elemento-04.png");
			app.image(roca, posX, posY, 40,40);
			break;

		case 1:
			paja = app.loadImage("../data/Elemento-03.png");
			
			app.image(paja, posX, posY, 35,35);
			
			break;

		case 2:
			madera = app.loadImage("../data/Elemento-02.png");
			app.image(madera, posX, posY, 35,35);

			break;

		case 3:
			ladrillo = app.loadImage("../data/Elemento-01.png");
			app.image(ladrillo, posX, posY, 35,35);
			break;

		}

	}

	public void mover() {

		
	posY++;
	
	
	
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
