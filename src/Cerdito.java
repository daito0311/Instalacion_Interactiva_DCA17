import processing.core.PApplet;
import processing.core.PImage;

public class Cerdito {

	public float posX, posY;
	private int tipo;
	private float ancho, alto;
	private PImage cerdoPaja, cerdoLena, cerdoLadrillo;

	public Cerdito(float posX, float posY, float ancho, float alto, int tipo) {

		this.posX = posX;
		this.posY = posY;
		this.ancho = ancho;
		this.alto = alto;
		this.tipo = tipo;
	}

	public void pintar(PApplet app) {

		switch (tipo) {
		case 1:

			app.imageMode(app.CENTER);
			app.image(cerdoPaja, posX, posY, 203 / 2, 292 / 2);

			break;

		case 2:

			app.imageMode(app.CENTER);
			app.image(cerdoLena, posX, posY, 203 / 2, 292 / 2);

			break;

		case 3:

			app.imageMode(app.CENTER);
			app.image(cerdoLadrillo, posX, posY, 203 / 2, 292 / 2);

			break;
		}

	}

	public void cargarimagencerdos(PApplet app) {

		cerdoLadrillo = app.loadImage("../data/Ladrillo-01.png");
		cerdoLena = app.loadImage("../data/Madera-01.png");
		cerdoPaja = app.loadImage("../data/Paja-01.png");
	}

	public boolean validar(int lx, int ly) {

		if (lx > posX - 30 && lx < posX + 30 && ly > posY - 60 && ly < posY + 60) {

			System.out.println("ENTRO");
			return true;
		}
		return false;

	}

	public void mover(int x, int y) {
		this.posX = x;
		this.posY = y;

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

	public float getAncho() {
		return ancho;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public float getAlto() {
		return alto;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

}
