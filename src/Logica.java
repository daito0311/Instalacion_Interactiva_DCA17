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


		// CREAR LOS CERDITOS EN EL JUEGO
	for (int i = 0; i < 3; i++) {
			
			if (i == 0) {
				cerditos.add(new Cerdito (185, 200, 50, 50, 1));
				
			} else if (i == 1) {
				cerditos.add(new Cerdito (385, 200, 50, 50, 2));
				
			}else if (i == 2) {
				cerditos.add(new Cerdito (585, 200, 50, 50, 3));
				
			}
			
		}
		
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
			
			for (int i = 0; i < cerditos.size(); i++) {
				cerditos.get(i).pintar(app);
				
			}

			
			
			
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
