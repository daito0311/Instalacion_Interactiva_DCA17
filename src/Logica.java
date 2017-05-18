import java.util.ArrayList;

import com.sun.javafx.font.directwrite.RECT;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class Logica {

	PApplet app;
	PImage pantalla0, pantalla1, pantalla2, pantalla3, gameover, win;
	PImage cerca, vida, madera, ladrillo, paja, lobo, casapaja, casamadera, casaladrillo, escenario3;
	float numCercas;
	int xtempo;
	int ytempo;
	public int pantallas = 0;
	int cerditoEnJuego;
	private ArrayList<Cerdito> cerditos;
	private ArrayList<Elemento> elementos;
	Runner runner;
	private Cerdito selCerdo;
	private boolean yaestaelcerdo, casapajaLista, casaLadrilloLista, casamaderaLista;
	private int cantpaja, cantmadera, cantladrillo;
	private Elemento borrador;
	private Casa casa;
	private float xlobo;
	private float ylobo;
	private float push;
	private float down;

	public Logica(PApplet app) {
		this.xlobo = app.width / 2;
		ylobo = 200;
		down = -200;
		push = 0;
		this.app = app;
		yaestaelcerdo = false;
		inicializar();
		cerditos = new ArrayList<Cerdito>();
		elementos = new ArrayList<Elemento>();
		runner = new Runner(app.width / 2, 450, 50, 50, 1);
		casa = new Casa(245, 140, 1);

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
		gameover = app.loadImage("Perdiste.png");
		win = app.loadImage("Ganaste.png");

		vida = app.loadImage("../data/vida.png");
		madera = app.loadImage("../data/Elemento-02.png");
		paja = app.loadImage("../data/Elemento-03.png");
		ladrillo = app.loadImage("../data/Elemento-01.png");
		lobo = app.loadImage("../data/Nivel3-06.png");

		casamadera = app.loadImage("../data/Nivel3-07.png");
		casapaja = app.loadImage("../data/Nivel3-09.png");
		casaladrillo = app.loadImage("../data/Nivel3-08.png");

		escenario3 = app.loadImage("../data/Escenario3.png");

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

			for (int i = 0; i < elementos.size(); i++) {
				elementos.get(i).pintar(app);
				elementos.get(i).mover();
			}
			app.textSize(36);
			app.fill(0, 0, 0, 97);
			app.rect(-10, 0, 144, 310);

			app.image(paja, 40, 40, 143 / 3, 143 / 3);
			app.fill(0);
			app.text("x" + cantpaja, 65, 50);
			app.image(madera, 40, 100, 143 / 3, 143 / 3);
			app.text("x" + cantmadera, 65, 110);
			app.image(ladrillo, 40, 160, 143 / 3, 143 / 3);
			app.text("x" + cantladrillo, 65, 170);

			app.text("Vidas", 15, 250);
			app.text("x " + runner.getVidas(), 35, 290);
			app.textSize(12);
			runner.pintar(app);

			if (cantpaja > 0) {

				app.image(casapaja, 730, 100, 543 / 5, 864 / 5);
				app.fill(0, 0, 0, 80);
				app.noStroke();
				app.rect(680, 100, 100, 40);
				app.fill(255);
				app.textSize(20);
				app.text("Construir", 685, 125);
				casapajaLista = true;
			}

			if (cantmadera > 0) {
				app.image(casamadera, 730, 300, 543 / 5, 864 / 5);
				app.fill(0, 0, 0, 80);
				app.noStroke();
				app.rect(680, 300, 100, 40);
				app.fill(255);
				app.textSize(20);
				app.text("Construir", 685, 325);
				casamaderaLista = true;

			}

			if (cantladrillo > 0) {
				app.image(casaladrillo, 730, 500, 543 / 5, 864 / 5);
				app.fill(0, 0, 0, 80);
				app.noStroke();
				app.rect(680, 500, 100, 40);
				app.fill(255);
				app.textSize(20);
				app.text("Construir", 685, 525);
				casaLadrilloLista = true;
			}

			creadorElementos();
			eliminadordeElementos();

			perder(app);

		}
		if (pantallas == 4) {
			// ------------------------------------Lo que sea 3

			
			
			

			app.background(255);
			app.imageMode(app.CORNER);
			app.image(escenario3, 0, 0, 800, 600);

			app.imageMode(app.CENTER);
			app.image(lobo, xlobo, ylobo, 559 / 2, 687 / 2);

			app.imageMode(app.CORNER);

			casa.pintar(app);
			
			
			// MANTENER EN EL RANGO 
			
			
			
				down+=1;	
				if (app.frameCount%200==0) {
					down+=2;
					
				}
			System.out.println(down);
			
			if (down-push >0) {
				if (casa.getTipo()==3) {
					pantallas =6;
			}else {
				pantallas =5;}
				
			}
			app.fill(255);
				app.rect(700, 60, 20, 400);
				
				
				
				app.fill(255,0,0);
				
				app.rect(700, 460, 20, down-push);
				
				app.fill(0,255,0);
				app.rect(700, 200, 20, 5);
				app.fill(0,255,0);
				app.rect(700, 170, 20, 5);
				app.textSize(20);
				app.fill(0);
				app.text("debes resistir los ataques del lobo lo más que puedas", 130, 30);
				
				
				
			
			
		}

		if (pantallas == 5) {
			app.background(255);
			app.imageMode(app.CORNER);
			app.image(gameover, 0, 0, 800, 600);

		}

		if (pantallas == 6) {
			app.background(255);
			app.imageMode(app.CORNER);
			app.image(win, 0, 0, 800, 600);

		}
	}

	private void creadorElementos() {

		// OBSTACULOS

		if (app.frameCount % 250 == 0) {

			elementos.add(new Elemento(app.random(135 + 25, 568 - 25), 10, 50, 50, 0));

		}

		// ELEMENTOS PAJA
		if (app.frameCount % 220 == 0) {

			elementos.add(new Elemento(app.random(135 + 25, 568 - 25), 10, 50, 50, 1));

		}

		// MADERA
		if (app.frameCount % 400 == 0) {

			elementos.add(new Elemento(app.random(135 + 25, 568 - 25), 10, 50, 50, 2));

		}

		// LADRILLO
		if (app.frameCount % 900 == 0) {

			elementos.add(new Elemento(app.random(135 + 25, 568 - 25), 10, 50, 50, 3));

		}

	}

	private void eliminadordeElementos() {
		for (int i = 0; i < elementos.size(); i++) {
			if (elementos.get(i).getPosY() > 600) {
				borrador = elementos.get(i);

			} else if (app.dist(runner.getPosX(), runner.getPosY(), elementos.get(i).getPosX(),
					elementos.get(i).getPosY()) < 20) {
				borrador = elementos.get(i);

				switch (elementos.get(i).getTipo()) {

				case 0:
					runner.quitarvida();
					break;

				case 1:
					cantpaja++;
					break;

				case 2:
					cantmadera++;
					break;

				case 3:
					cantladrillo++;
					break;
				}
			}

		}
		elementos.remove(borrador);
		borrador = null;
	}

	public void pressedLeap(float leapX, float leapY) {

		if (pantallas == 2) {

			// validar la posicion de los cerditos

			for (int i = 0; i < this.cerditos.size(); i++) {
				if (cerditos.get(i).validar(leapX, leapY)) {
					this.selCerdo = this.cerditos.get(i);

					break;
				}
			}

			// PASAR A JUGAR RUNNER

			if (yaestaelcerdo == true && leapY > 530 && leapY < 580 && leapX > 330 && leapX < 430) {
				pantallas++;

				cerditos.removeAll(cerditos);

			}
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

	public void key() {

		// PANTALLAS DEL COMIENZO
		if (app.keyCode == app.ENTER && pantallas == 0) {
			pantallas++;

		}
		
		if (pantallas == 4) {
			
			if (app.key == 'a') {
				push+=10;
				
				System.out.println(push);
			}
			
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

	public void dragLeap(float leapX, float leapY) {

		if (pantallas == 2) {

			if (this.selCerdo != null) {
				this.selCerdo.moverLeap(leapX, leapY);

			}

		}
	}

	public void releaseLeap(float leapX, float leapY) {
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

	public void perder(PApplet app) {

		if (runner.getVidas() <= 0) {
			elementos.removeAll(elementos);
			pantallas = 5;

		}
	}

	public ArrayList<Cerdito> getCerditos() {
		return cerditos;
	}

	public void setCerditos(ArrayList<Cerdito> cerditos) {
		this.cerditos = cerditos;
	}

	public int getPantallas() {
		return pantallas;
	}

	public void setPantallas(int pantallas) {
		this.pantallas = pantallas;
	}

	public void construircasapaja() {
		if (casapajaLista) {
			casa.setTipo(1);
			pantallas = 4;

		}

	}

	public void construircasamadera() {
		if (casamaderaLista) {
			casa.setTipo(2);
			pantallas = 4;
		}

	}

	public void construircasaLadrillos() {
		if (casaLadrilloLista) {
			casa.setTipo(3);
			pantallas = 4;
		}

	}

}
