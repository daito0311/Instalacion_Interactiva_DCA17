import processing.core.PApplet;
import processing.core.PImage;

public class Pantalla {
	PImage pantalla;
	PImage pantalla1;
	PImage pantalla2;
	// holi	
	int pantallas;
	PApplet app;
	Logica logica;

	public Pantalla(PApplet app, Logica logica) {
		this.logica = logica;
		this.app = app;
		pantalla = app.loadImage("Pantalla0.png");
		pantalla1 = app.loadImage("Pantalla1.png");
		pantalla2 = app.loadImage("Pantalla2.png");

	}

	public void display() {
		pantallas = logica.getPantallas();
		System.out.println(pantallas);
		
			if (pantallas == 0) {
				System.out.println(pantallas);
				app.imageMode(app.CORNER);
				app.image(pantalla, 0, 0, 1200, 700);
			}
			if (pantallas == 1) {
				app.imageMode(app.CORNER);
				app.image(pantalla1, 0, 0, 1200, 700);
			}
			if (pantallas == 2) {
				app.imageMode(app.CORNER);
				app.image(pantalla2, 0, 0, 1200, 700);
			}



	}
}
