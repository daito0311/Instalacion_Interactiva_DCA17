import processing.core.PApplet;
import processing.core.PImage;

public class Logica {
	// holi
	PApplet app;

	Cerdito cerditoPaja;
	Cerdito cerditoMadera;
	Cerdito cerditoLadrillo;
	Pantalla pantalla;
	Cerdito cel;
	PImage cerca;
	int xtempo;
	int ytempo;
	int pantallas;


	public Logica(PApplet app) {
		this.app = app;
		cerca  = app.loadImage("Pantalla1-2-10.png");
		pantalla = new Pantalla(app, this);
		cerditoPaja = new CerditoPaja(app);
		cerditoMadera = new CerditoMadera(app);
		cerditoLadrillo = new CerditoLadrillo(app);
		pantallas = 0;
		
	}

	public void display() {
//		pantalla.display();
		if (pantallas == 0) {
			// ------------------------------------intro
			app.background(255);
		}
		if (pantallas == 1) {
			// ------------------------------------niveles
			app.background(255);
		}
		if (pantallas == 2) {
			// ------------------------------------seleccion Personajes
			app.noStroke();
			app.background(255);
			
			
			cerditoPaja.display();
			cerditoLadrillo.display();
			cerditoMadera.display();
			app.imageMode(app.CORNER);
//			app.image(cerca, 0, 0, 1200, 700);

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

			if (cel != null) {

				if (validarDistancia(app.mouseX, app.mouseY, app.width / 2, app.height / 2)) {
					
					if (cel == cerditoPaja) {
						
						
						if (cerditoMadera.getY() == app.height / 2) {
							cerditoMadera.setX((app.width / 6) * 3);
							cerditoMadera.setY((app.height / 3) * 2);
						}
						if (cerditoLadrillo.getY() == app.height / 2) {
							cerditoLadrillo.setX((app.width / 6) * 5);
							cerditoLadrillo.setY((app.height / 3) * 2);
						}
					}
					if (cel == cerditoMadera) {

						if (cerditoPaja.getY() == app.height / 2) {
							cerditoPaja.setX((app.width / 6) * 1);
							cerditoPaja.setY((app.height / 3) * 2);
						}
						if (cerditoLadrillo.getY() == app.height / 2) {
							cerditoLadrillo.setX((app.width / 6) * 5);
							cerditoLadrillo.setY((app.height / 3) * 2);
						}
					}
					if (cel == cerditoLadrillo) {

						if (cerditoPaja.getY() == app.height / 2) {
							cerditoPaja.setX((app.width / 6) * 1);
							cerditoPaja.setY((app.height / 3) * 2);
						}
						if (cerditoMadera.getY() == app.height / 2) {
							cerditoMadera.setX((app.width / 6) * 3);
							cerditoMadera.setY((app.height / 3) * 2);
						}
					}
					cel.setX(app.width / 2);
					cel.setY((int)((app.height / 3) * 2.3));
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
		return PApplet.dist(posx, posy, posx2, posy2) < 50;
	}

	public int getPantallas() {
		return pantallas;
	}

	public void setPantallas(int pantallas) {
		this.pantallas = pantallas;
	}

	
}
