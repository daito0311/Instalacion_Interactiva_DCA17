import processing.core.PApplet;
import processing.core.PImage;

public class Runner {

	public float posX, posY;
	private int tipo;
	private float ancho, alto;
	private PImage cerdoPaja, cerdoLena, cerdoLadrillo;

	public Runner(float posX, float posY, float ancho, float alto, int tipo) {

		this.posX = posX;
		this.posY = posY;
		this.ancho = ancho;
		this.alto = alto;
		this.tipo = tipo;

	}

	public void pintar(PApplet app) {

		switch (tipo) {
		case 1:
			app.fill(255, 0, 0);
			app.ellipse(posX, posY, ancho, alto);
			app.image(cerdoLadrillo, posX, posY, 229 / 3, 227 / 3);
			break;

		case 2:
			app.fill(0, 255, 0);
			app.ellipse(posX, posY, ancho, alto);
			app.image(cerdoLadrillo, posX, posY, 229 / 3, 227 / 3);
			break;

		case 3:
			app.fill(0, 0, 255);
			app.ellipse(posX, posY, ancho, alto);
			app.image(cerdoLadrillo, posX, posY, 229 / 3, 227 / 3);
			break;
		}
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void cargarimagenes(PApplet app) {

		cerdoLadrillo = app.loadImage("../data/CerditoRunnerLadrillo-01.png");
		cerdoLena = app.loadImage("../data/CerditoRunnerMadera-01.png");
		cerdoPaja = app.loadImage("../data/CerditoRunnerPaja-01.png");

	}
	
	public void mover(int leapx) {
		this.posX = leapx;
		

	}

}
