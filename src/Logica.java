import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	// holi
	PApplet app;
	PImage pantalla0, pantalla1 ,pantalla2, pantalla3;
	PImage cerca;
	float numCercas;
	int xtempo;
	int ytempo;
	int pantallas;
	int cerditoEnJuego;
	private ArrayList <Cerdito> cerditos;
	// variable para saber que cerdito esta jugando, 0=paja,
						// 1=madera, 2 =ladrillo

	public Logica(PApplet app) {
		this.app = app;
		inicializar();
		cerditos = new ArrayList <Cerdito> ();

	}
	
	
	
	public void inicializar() {
		// ------------------------------------imagenes

		cerca = app.loadImage("Pantalla1-2-10.png");
		pantalla0 = app.loadImage("Pantalla0.png");
		pantalla1 = app.loadImage("Pantalla1.png");
		pantalla2 = app.loadImage("Pantalla2.png");
		pantalla3 = app.loadImage("Pantalla3.png");

		
		
		
	}

	
	

	public void pintar() {
		
		
		
		if (pantallas == 0) {
			// ------------------------------------intro
			app.background(pantalla0);

		}
		if (pantallas == 1) {
			// ------------------------------------niveles
			app.background(pantalla1);
		}
		if (pantallas == 2) {
			// ------------------------------------seleccion Personajes
			app.noStroke();
			app.background(pantalla2);
			

			
			
			
		}
		if (pantallas == 3) {
			// ------------------------------------Runner
			
		}
		if (pantallas == 4) {
			// ------------------------------------Lo que sea 3
			app.background(255);
		}

	}

	
	
	
	public void pressed() {
		
System.out.println(pantallas);
System.out.println(app.mouseY);

if (app.mouseX > 290 && app.mouseX < 440 && app.mouseY > 478 && app.mouseY < 530 && pantallas == 1) {
	
	pantallas++;
	
}

	}

	
	public void key() {
		
		if (app.keyCode == app.ENTER && pantallas==0) {
			pantallas++;
			
			
			
		}
		
	}

	
}
