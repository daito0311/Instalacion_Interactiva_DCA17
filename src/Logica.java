import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	// holi
	PApplet app;
	PImage pantalla0;
	PImage pantalla1;
	PImage pantalla2;
	Cerdito cerditoPaja;
	Cerdito cerditoMadera;
	Cerdito cerditoLadrillo;
	Cerdito cel;
	PImage cerca;
	int xtempo;
	int ytempo;
	int pantallas;

	public Logica(PApplet app) {
		this.app = app;
		inicializar();

	}

	public void display() {
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

			organizarCerditos();

			app.imageMode(app.CORNER);
			app.image(cerca, 0, 0, 1200, 700);

		}
		if (pantallas == 3) {
			// ------------------------------------Runner
			app.background(255);
		}
		if (pantallas == 4) {
			// ------------------------------------Lo que sea 3
			app.background(255);
		}

	}

	public void mouseP() {

		if (pantallas == 0) {
			// ------------------------------------intro
		}
		if (pantallas == 1) {
			// ------------------------------------niveles
		}
		if (pantallas == 2) {
			// ------------------------------------seleccion Personajes
			seleccionCerditoPressed();
			

		}
		if (pantallas == 3) {
			// ------------------------------------Runner

		}
		if (pantallas == 4) {
			// ------------------------------------Lo que sea 3

		}
	}


	public void mouseDr() {

		if (pantallas == 0) {
			// ------------------------------------intro
		}
		if (pantallas == 1) {
			// ------------------------------------niveles
		}
		if (pantallas == 2) {
			// ------------------------------------seleccion Personajes
			if (cel != null) {
				cel.setX(app.mouseX);
				cel.setY(app.mouseY);

			}
		}
		if (pantallas == 3) {
			// ------------------------------------Runner

		}
		if (pantallas == 4) {
			// ------------------------------------Lo que sea 3

		}

	}

	public void mouseRe() {
		if (pantallas == 0) {
			// ------------------------------------intro
		}
		if (pantallas == 1) {
			// ------------------------------------niveles
		}
		if (pantallas == 2) {
			// ------------------------------------seleccion Personajes
			seleccionCerditoRelease();


		}
		if (pantallas == 3) {
			// ------------------------------------Runner

		}
		if (pantallas == 4) {
			// ------------------------------------Lo que sea 3

		}

	}

	

	public void keyP() {
		if (app.keyCode == 'A') {
			System.out.println("holi");
			pantallas++;
		}
	}

	// --------------------------------------------------------Otros Métodos
	public boolean validarDistancia(int posx, int posy, int posx2, int posy2) {
		return PApplet.dist(posx, posy, posx2, posy2) < 90;
	}

	public void inicializar() {
		// ------------------------------------imagenes

		cerca = app.loadImage("Pantalla1-2-10.png");
		pantalla0 = app.loadImage("Pantalla0.png");
		pantalla1 = app.loadImage("Pantalla1.png");
		pantalla2 = app.loadImage("Pantalla2.png");
		// ------------------------------------cerditos
		cerditoPaja = new CerditoPaja(app);
		cerditoMadera = new CerditoMadera(app);
		cerditoLadrillo = new CerditoLadrillo(app);
		// ------------------------------------imagenes
		pantallas = 0;
	}

	public void seleccionCerditoPressed() {
		if (validarDistancia(cerditoPaja.getX(), cerditoPaja.getY(), app.mouseX, app.mouseY)) {
			xtempo = cerditoPaja.getX();
			ytempo = cerditoPaja.getY();
			cerditoPaja.setAgarrado(true);
			cel = cerditoPaja;

		}
		if (validarDistancia(cerditoMadera.getX(), cerditoMadera.getY(), app.mouseX, app.mouseY)) {
			xtempo = cerditoMadera.getX();
			ytempo = cerditoMadera.getY();
			cerditoMadera.setAgarrado(true);
			cel = cerditoMadera;
		}
		if (validarDistancia(cerditoLadrillo.getX(), cerditoLadrillo.getY(), app.mouseX, app.mouseY)) {
			xtempo = cerditoLadrillo.getX();
			ytempo = cerditoLadrillo.getY();
			cerditoLadrillo.setAgarrado(true);
			cel = cerditoLadrillo;
		}
		
	}
	
	private void seleccionCerditoRelease() {
		if (cel != null) {

			if (validarDistancia(app.mouseX, app.mouseY, app.width / 2, (app.height / 4) * 3)) {

				if (cel == cerditoPaja) {

					cerditoMadera.setX((app.width / 6) * 3);
					cerditoMadera.setY((app.height / 3) * 2);

					cerditoLadrillo.setX(((app.width / 6) * 5) - 100);
					cerditoLadrillo.setY(((app.height / 3) * 2) + 30);

					cerditoMadera.setTamanox(97);
					cerditoMadera.setTamanoy(140);

					cerditoLadrillo.setTamanox(97);
					cerditoLadrillo.setTamanoy(140);
				}
				if (cel == cerditoMadera) {

					cerditoPaja.setX(((app.width / 6) * 1) + 100);
					cerditoPaja.setY(((app.height / 3) * 2) + 30);

					cerditoLadrillo.setX(((app.width / 6) * 5) - 100);
					cerditoLadrillo.setY(((app.height / 3) * 2) + 30);

					cerditoPaja.setTamanox(97);
					cerditoPaja.setTamanoy(140);

					cerditoLadrillo.setTamanox(97);
					cerditoLadrillo.setTamanoy(140);

				}
				if (cel == cerditoLadrillo) {

					cerditoPaja.setX(((app.width / 6) * 1) + 100);
					cerditoPaja.setY(((app.height / 3) * 2) + 30);

					cerditoMadera.setX((app.width / 6) * 3);
					cerditoMadera.setY((app.height / 3) * 2);

					cerditoPaja.setTamanox(97);
					cerditoPaja.setTamanoy(140);

					cerditoMadera.setTamanox(97);
					cerditoMadera.setTamanoy(140);

				}
				cel.setX((app.width / 2) - 30);
				cel.setY((int) ((app.height / 3) * 2.3));
				cel.setTamanox(152);
				cel.setTamanoy(220);
			} else {
				cel.setX(xtempo);
				cel.setY(ytempo);

			}
			cel = null;
			cerditoPaja.setAgarrado(false);
			cerditoLadrillo.setAgarrado(false);
			cerditoMadera.setAgarrado(false);
		}
		
	}


	public void organizarCerditos() {
		int xt = (app.width / 2) - 30;
		int yt = (int) ((app.height / 3) * 2.3);
		// ------------------Para que los cerditos se coloquen sobre otros
		if (cerditoPaja.getY() == ((app.height / 3) * 2) + 30 || cerditoLadrillo.getY() == ((app.height / 3) * 2) + 30
				|| cerditoMadera.getY() == (app.height / 3) * 2) {
			app.imageMode(app.CENTER);

			cerditoMadera.display();
			cerditoPaja.display();
			cerditoLadrillo.display();
		}
		if (cel != null) {
			if (cerditoPaja.getX() == xt && cerditoPaja.getY() == yt) {
				app.imageMode(app.CENTER);

				cerditoLadrillo.display();
				cerditoMadera.display();
				cerditoPaja.display();
			}
			if (cerditoMadera.getX() == xt && cerditoPaja.getY() == yt) {
				app.imageMode(app.CENTER);

				cerditoPaja.display();
				cerditoLadrillo.display();
				cerditoMadera.display();

			}
			if (cerditoLadrillo.getX() == xt && cerditoPaja.getY() == yt) {
				app.imageMode(app.CENTER);

				cerditoPaja.display();
				cerditoMadera.display();
				cerditoLadrillo.display();

			}

		} else {
			app.imageMode(app.CENTER);

		}
	}

	public int getPantallas() {
		return pantallas;
	}

	public void setPantallas(int pantallas) {
		this.pantallas = pantallas;
	}

}
