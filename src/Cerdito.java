import processing.core.PApplet;
import processing.core.PImage;

public abstract class Cerdito {

	protected int x, y;
	protected PImage [] animacionCerdito;
	protected PImage [] animacionCerditoA;
	protected int numActualAnimacion;
	protected int numActualAnimacionA;
	protected int timer;
	protected int tamanox, tamanoy, desfaseT;
	protected PApplet app;
	protected boolean agarrado;



	
	public Cerdito(PApplet app) {
		this.app = app;
		timer=0;
		tamanox = 97;
		tamanoy = 140;
		agarrado = false;
		desfaseT=10;
	}

	public abstract void display(); 
	

	


	public boolean isAgarrado() {
		return agarrado;
	}

	public void setAgarrado(boolean agarrado) {
		this.agarrado = agarrado;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTamanox() {
		return tamanox;
	}

	public void setTamanox(int tamanox) {
		this.tamanox = tamanox;
	}

	public int getTamanoy() {
		return tamanoy;
	}

	public void setTamanoy(int tamanoy) {
		this.tamanoy = tamanoy;
	}


	

}
