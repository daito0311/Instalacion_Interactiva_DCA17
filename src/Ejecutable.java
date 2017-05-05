import processing.core.PApplet;

public class Ejecutable extends PApplet {

	public static void main(String[] args) {
		PApplet.main("Ejecutable");

	}

	Logica log;

	PApplet app;

	@Override
	public void settings() {
		size(1200, 700);

	}

	@Override
	public void setup() {
		log = new Logica(this);
	}

	@Override
	public void draw() {
		background(255);
		log.pintar(this);

	}

	@Override
	public void mousePressed() {
		log.press();

	}

	@Override
	public void keyPressed() {

		log.key();

	}

}
