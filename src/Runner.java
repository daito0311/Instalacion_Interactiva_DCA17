import processing.core.PApplet;
import processing.core.PImage;

public class Runner {

	public float posX, posY;
	private int tipo;
	private float ancho, alto;
	private PImage cerdoPaja, cerdoLena, cerdoLadrillo;
	private int vidas;
	private int score;
	private int initime;

	public Runner(float posX, float posY, float ancho, float alto, int tipo) {
		this.vidas = 5;
		this.posX = posX;
		this.posY = posY;
		this.ancho = ancho;
		this.alto = alto;
		this.tipo = tipo;

	}

	public void cargarimagenes(PApplet app) {

		cerdoLadrillo = app.loadImage("../data/CerditoRunnerLadrillo-01.png");
		cerdoLena = app.loadImage("../data/CerditoRunnerMadera-01.png");
		cerdoPaja = app.loadImage("../data/CerditoRunnerPaja-01.png");

	}

	public void pintar(PApplet app) {

		switch (tipo) {
		case 1:

			// PAJA
			
			app.image(cerdoPaja, posX, posY, 229 / 4, 227 / 4);
			break;

		case 2:

			// LADRILLOS

			
			app.image(cerdoLadrillo, posX, posY, 229 / 4, 227 / 4);
			break;

		case 3:
			// MADERA
			
			app.image(cerdoLena, posX, posY, 229 / 4, 227 / 4);
			break;
		}
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	

	public void mover(float x) {

		this.posX = x;

	}
	
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
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

	public void quitarvida() {
		vidas--;
		
		
	}

}
