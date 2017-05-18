import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Logica {

	
	

	PApplet app;
	PImage pantalla0, pantalla1, pantalla2, pantalla3;
	PImage cerca;
	float numCercas;
	int xtempo;
	int ytempo;
	int pantallas;
	int cerditoEnJuego;
	private ArrayList<Cerdito> cerditos;
	private Runner runner;
	private Cerdito selCerdo;
	private boolean yaestaelcerdo;

	public Logica(PApplet app) {
		
		
		this.app = app;
		yaestaelcerdo = false;
		inicializar();
		cerditos = new ArrayList<Cerdito>();
		runner = new Runner(app.width / 2, 450, 50, 50, 1);

		// CREAR LOS CERDITOS EN EL JUEGO
		for (int i = 0; i < 3; i++) {

			if (i == 0) {
				cerditos.add(new Cerdito(185, 200, 50, 50, 1));

			} else if (i == 1) {
				cerditos.add(new Cerdito(385, 200, 50, 50, 2));

			} else if (i == 2) {
				cerditos.add(new Cerdito(585, 200, 50, 50, 3));

			}

		}

		for (int i = 0; i < cerditos.size(); i++) {
			cerditos.get(i).cargarimagencerdos(app);

		}
		
		runner.cargarimagenes(app);
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

			app.ellipse(app.width / 2 - 20, 500, 100, 40);

			for (int i = 0; i < cerditos.size(); i++) {
				cerditos.get(i).pintar(app);

			}
			app.fill(0, 0, 0, 97);
			app.rect(60, 15, 700, 80);
			app.fill(255);
			app.textSize(30);
			app.text("Selecciona el cerdito que prefieras y", 90, 50);
			app.text("Colocalo en el circulo blanco para jugar", 90, 80);

			if (yaestaelcerdo) {

				app.fill(0, 0, 0, 97);
				app.rect(380 - 60, 530, 120, 50);
				app.fill(255);
				app.textSize(40);
				app.text("Jugar", 380 - 50, 565);
			}

		}
		if (pantallas == 3) {
			// ------------------------------------Runner

			app.background(pantalla3);

			runner.pintar(app);

			
			
		}
		if (pantallas == 4) {
			// ------------------------------------Lo que sea 3
			app.background(255);
		}

	}



	public void pressed() {

		System.out.println(app.mouseX);
		System.out.println(app.mouseY);

		if (app.mouseX > 290 && app.mouseX < 440 && app.mouseY > 478 && app.mouseY < 530 && pantallas == 1) {

			pantallas++;

		}

		if (pantallas == 2) {

			// validar la posicion de los cerditos

			for (int i = 0; i < this.cerditos.size(); i++) {
				if (cerditos.get(i).validar(app.mouseX, app.mouseY)) {
					this.selCerdo = this.cerditos.get(i);

					break;
				}
			}

			// PASAR A JUGAR RUNNER

			if (yaestaelcerdo == true && app.mouseY > 530 && app.mouseY < 580 && app.mouseX > 330 && app.mouseX < 430) {
				pantallas++;

				cerditos.removeAll(cerditos);

			}
		}

		// PANTALLA 3 RUNNER

	}

	public void CrearCerdo(int mouseX, int mouseY) {
		this.cerditos.add(new Cerdito(app.width / 2, 200, 50, 50, 2));

	}

	public void key() {

		// PANTALLAS DEL COMIENZO
		if (app.keyCode == app.ENTER && pantallas == 0) {
			pantallas++;

		}

	}

	public void drag(int mouseX, int mouseY) {

		// ARRASTRAR LOS CERDOS EN LA PANTALLA 2

		if (pantallas == 2) {

			if (this.selCerdo != null) {
				this.selCerdo.mover(mouseX, mouseY);
			}

		}

		// PANTALLA 3 RUNNER

	}

	public void release(int mouseX, int mouseY) {

		// SOLTAR LOS CERDOS EN LA PANTALLA 2

		if (pantallas == 2 && selCerdo != null) {

			if (selCerdo.getPosX() > 380 - 50 && selCerdo.getPosX() < 380 + 50 && selCerdo.getPosY() > 400
					&& selCerdo.getPosY() < 440) {
				yaestaelcerdo = true;
				runner.setTipo(selCerdo.getTipo());
			} else {
				yaestaelcerdo = false;
			}
		}

		this.selCerdo = null;

		// PANTALLA 3 RUNNER

	}

}
