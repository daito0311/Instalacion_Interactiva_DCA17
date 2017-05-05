import java.util.ArrayList;

import com.sun.javafx.font.directwrite.RECT;

import javafx.scene.layout.Background;
import processing.core.PApplet;
import processing.core.PImage;
//NOTA: Holi Piedrahita, si lo estas modificando, estoy de camino a casa, tengo un error, pero no se que es. Ya esta integrado, porfa, el nivel uno es 
//el nivelGeneral=1 y pantallas = 4. Gracias por respetar el orden, crea muchos metodos, es mas lindo trabajar asi. Graciaaas :3

public class Logica {

	private int pantallas;
	private PApplet app;
	private ArrayList<Elemento> elementos;
	private float xcreator;
	private int tipoelem;

	private PImage banda;
	private PImage fondoini, fondomenu, fondoNiveles, fondoAdhesivos, fondolvl1, fondolvl2;

	
	//ATRIBUTOS nivel 2
	private int w = 10, h = 20;
	private int casillaTam = 30;
	private int Grid[][] = new int[w][h];
	Pieza piezas = new Pieza();
	private int piezaPos[] = new int[2];
	private int muestraPos[] = new int[2];
	private int delay = 0;
	private int delayDifficult = 50;
	private int score = 0;
	private int time;// tiempo mostrado
	private int actual;// tiempo en que inicia
	private int current;// todo el tiempo que ha pasado desde que inici�
	private boolean start = false;// boolean del momento en que inicia
	private int timeLimit;// limite de tiempo para perder
	private int lineas = 0;
	private int nivel = 1;
	private PImage background;
	private int nivelGeneral = 0;
	private PImage imgCasa;
	private String imgCasaPaja;
	private String imgCasaMadera;
	private String imgCasaLadrillo;
	
	public Logica(PApplet app) {

		this.app = app;
		this.pantallas = 0;
		this.tipoelem = 1;
		this.xcreator = 600;
		app.textFont(app.createFont("Back to Black Demo", 20));
		
		if (nivelGeneral == 2) {
			nivel2setup();
		}

		// IMAGENES
		banda = app.loadImage("../data/banda.png");
		fondoini = app.loadImage("../data/Pantallas-00-Intro.png");
		fondomenu = app.loadImage("../data/Pantallas-00-Menu.png");
		fondoNiveles = app.loadImage("../data/Pantallas-00-Niveles.png");
		fondoAdhesivos = app.loadImage("../data/Pantallas-00-Adhesivos.png");
		// fondolvl1= app.loadImage("../data/Pantallas-00-Menu.png");
		fondolvl2 = app.loadImage("../data/Background-02.png");

		// ARREGLOS

		elementos = new ArrayList<Elemento>();

	}
	
	public void pintar(PApplet app) {

		// System.out.println(pantallas);
		app.smooth();
		app.frameRate(60);
		// PANTALLA DE INICIO
		if (pantallas == 0) {
			app.image(fondoini, 0, 0);
		}

		if (pantallas == 1) {

			app.image(fondomenu, 0, 0);
			app.fill(255, 255, 0);

			app.fill(0, 33, 52);
			app.textSize(55);
			app.textAlign(app.CENTER);
			app.text("Jugar", app.width / 2 - 250, 600);

			app.text("Adhesivos", app.width / 2 + 190, 600);
		}
		// NIVELES
		if (pantallas == 2) {

			app.image(fondoNiveles, 0, 0);
		}

		if (pantallas == 3) {

			app.image(fondoAdhesivos, 0, 0);
		}
		// PANTALLA DE JUEGO 1 (JUEGO DE LA BANDA GUITAR HERO DONDE BAJAN
		// LOS ELEMENTOS)
		if (pantallas == 4) {

			app.image(banda, 0, 0, 1280, 720);

			app.ellipse(xcreator, 125, 25, 25);

			switch (tipoelem) {
			case 1:
				app.fill(255, 0, 0);
				app.rect(300, 20, 100, 20);
				break;

			case 2:
				app.fill(0, 0, 255);
				app.rect(300, 20, 100, 20);
				break;

			case 3:
				app.fill(0, 255, 0);
				app.rect(300, 20, 100, 20);
				break;
			}

			for (int i = 0; i < elementos.size(); i++) {

				elementos.get(i).pintar(app);
				elementos.get(i).mover(app);
			}
		}

//		 PANTALLA DE JUEGO 2 (Tetris)
		 if(pantallas == 5){
		
		 app.image(fondolvl2, 0, 0);
		 }

		 if (nivelGeneral == 2) {
			 nivel2draw();
		 }
	}

	public void press() {

		// hacer click en anhesivos

		if (app.mouseX > app.width / 2 + 100 && app.mouseX < app.width / 2 + 100 + 160 && app.mouseY > 550
				&& app.mouseY < 590 && pantallas == 1) {

			pantallas = 3;

		}

		// hacer clic en jugar

		if (app.mouseX > app.width / 2 - 250 && app.mouseX < app.width / 2 - 250 + 160 && app.mouseY > 550
				&& app.mouseY < 590 && pantallas == 1) {
			pantallas = 2;
		}

		if (pantallas == 2 && app.mouseX < (app.width / 3) && app.mouseX > 0 && app.mouseY < 700 && app.mouseY > 0) {
			nivelGeneral = 1;
			pantallas = 4;
		}
		if (pantallas == 2 && app.mouseX < (app.width / 3) * 2 && app.mouseX > (app.width / 3) && app.mouseY < 700
				&& app.mouseY > 0) {
			nivelGeneral = 2;
			pantallas = 5;
		}
		if (pantallas == 2 && app.mouseX < (app.width / 3) * 3 && app.mouseX > (app.width / 3) * 2 && app.mouseY < 700
				&& app.mouseY > 0) {
			nivelGeneral = 3;
			pantallas = 6;
		}

	}

	public void key() {

		if (app.keyCode == app.ENTER && pantallas == 0) {

			pantallas++;

		}
		
		if(nivelGeneral ==2){
			nivel2keys();
		}

		if (app.keyCode == app.LEFT && xcreator > 495) {
			this.xcreator -= 1 * 2;

		}

		if (app.keyCode == app.RIGHT && xcreator < 695) {
			this.xcreator += 1 * 2;

		}

		if (app.key == 'q' || app.key == 'Q') {
			tipoelem++;

			if (tipoelem > 3) {
				tipoelem = 1;

			}

		}

		if (app.key == 'a' || app.key == 'A') {

			switch (tipoelem) {
			case 1:
				elementos.add(new Elemento(xcreator, 125, 25, 25, 1));

				break;

			case 2:
				elementos.add(new Elemento(xcreator, 125, 25, 25, 2));
				break;

			case 3:
				elementos.add(new Elemento(xcreator, 125, 25, 25, 3));
				break;
			}

		}
	}

	public void nivel2setup(){

//		if (nivel == 1) {
//			imgCasa = app.loadImage(imgCasaPaja);
//		}
//		if (nivel == 2) {
//			imgCasa = app.loadImage(imgCasaMadera);
//		}
//		if (nivel == 3) {
//			imgCasa = app.loadImage(imgCasaLadrillo);
//		}
		piezas = new Pieza();
		piezaPos[0] = 4;
		// piezaPos[0] = w / 2;
		piezaPos[1] = 0;

		muestraPos[0] = 0;
		// piezaPos[0] = w / 2;
		muestraPos[1] = 0;
		start = true;
	}
	public void nivel2draw(){

		app.noStroke();
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				if (Grid[i][j] == 0)
					app.fill(255);
				else if (Grid[i][j] == 1)
					app.fill(50, 150, 255);
				else if (Grid[i][j] == 2)
					app.fill(0, 0, 255);
				else if (Grid[i][j] == 3)
					app.fill(255, 150, 0);
				else if (Grid[i][j] == 4)
					app.fill(255, 255, 0);
				else if (Grid[i][j] == 5)
					app.fill(100, 255, 0);
				else if (Grid[i][j] == 6)
					app.fill(150, 0, 150);
				else
					app.fill(255, 0, 0);
				app.rect(i * casillaTam + (1200 - (casillaTam * w + 50)), j * casillaTam + 50, casillaTam - 4,
						casillaTam - 4);
			}
		}
		piezaDisplay();
		delay++;
		if (delay > delayDifficult) {
			delay = 0;
			piezaPos[1]++;
		}

		verificar();

		app.pushMatrix();
		app.translate((1200 - (casillaTam * w + 50 + 150)), 70);
		textosDisplay();
		// muestraDisplay();
		app.popMatrix();

		verificarTiempo();

		if (lineas == 4 && nivel == 1) {
			nivel++;
			lineas = 0;
		}
		if (lineas == 5 && nivel == 2) {
			nivel++;
			lineas = 0;
		}
		if (lineas == 6 && nivel == 3) {// gana

		}

		if (nivel == 2)
			delayDifficult = 25;
		if (nivel == 3)
			delayDifficult = 10;
	}
	
	public void verificarTiempo() {
		if (start == true) {
			actual = app.millis();
			start = false;
		}
		current = app.millis();
		time = (current - actual) / 1000;
	}
	
	public void textosDisplay() {
		app.fill(218, 75, 56);
		app.textSize(20);
		app.textAlign(app.LEFT);
		// app.text("Pieza :" , 0,60);
		app.text("Score : " + score, 0, 0);
		app.text("Tiempo: " + time, 0, 30);
		app.text("Lineas: " + lineas, 0, 60);
		String nivelTx = null;
		if (nivel == 1)
			nivelTx = "Paja";
		if (nivel == 2)
			nivelTx = "Madera";
		if (nivel == 3)
			nivelTx = "Ladrillo";
		app.text("Nivel: " + nivelTx, 0, 90);

	}
	
	public void lost() {
		app.fill(0, 200);
		app.rect(0, 0, app.width, app.height);
		app.noLoop();
	}

	public void verificar() {
		boolean stop = false;
		for (int i = 0; i < 4; i++) {

			if ((piezas.getShapeY(i) + piezaPos[1]) < h - 1) {

				if (Grid[(piezas.getShapeX(i) + piezaPos[0])][(piezas.getShapeY(i) + piezaPos[1]) + 1] != 0)
					stop = true;

			} else
				stop = true;
		}
		if (stop) {
			for (int i = 0; i < 4; i++) {
				if ((piezas.getShapeY(i) + piezaPos[1]) < 0) {
					lost();
				} else
					Grid[(piezas.getShapeX(i) + piezaPos[0])][(piezas.getShapeY(i) + piezaPos[1])] = piezas.getColor();
			}
			int count = 0;
			for (int y = 0; y < h; y++) {
				boolean destroy = true;
				for (int x = 0; x < w; x++) {
					if (Grid[x][y] == 0)
						destroy = false;
				}
				if (destroy) {
					lineas++;
					count++;
					for (int y2 = y - 1; y2 > -1; y2--) {
						for (int x = 0; x < w; x++) {
							Grid[x][y2 + 1] = Grid[x][y2];
						}
					}
				}
			}
			if (count > 0) {
				if (count == 1)
					score += 40;
				else if (count == 2)
					score += 100;
				else if (count == 3)
					score += 300;
				else
					score += 1200;
			}

			piezas = new Pieza();

			piezaPos[0] = 4;
			piezaPos[1] = 0;

			for (int i = 0; i < 4; i++) {

				if ((piezas.getShapeY(i) + piezaPos[1]) < h - 1) {
					if ((piezas.getShapeX(i) + piezaPos[0]) < w - 1 && (piezas.getShapeY(i) + piezaPos[1]) > 0
							&& (piezas.getShapeY(i) + piezaPos[1]) < h - 1) {
						if (Grid[(piezas.getShapeX(i) + piezaPos[0])][(piezas.getShapeY(i) + piezaPos[1]) + 1] != 0)
							lost();
					}
				}

			}
		}
	}

	public void piezaDisplay() {

		if (piezas.getColor() == 0)
			app.fill(255);
		else if (piezas.getColor() == 1)
			app.fill(50, 150, 255);
		else if (piezas.getColor() == 2)
			app.fill(0, 0, 255);
		else if (piezas.getColor() == 3)
			app.fill(255, 150, 0);
		else if (piezas.getColor() == 4)
			app.fill(255, 255, 0);
		else if (piezas.getColor() == 5)
			app.fill(100, 255, 0);
		else if (piezas.getColor() == 6)
			app.fill(150, 0, 150);
		else
			app.fill(255, 0, 0);
		for (int i = 0; i < 4; i++) {
			app.rect((piezas.getShapeX(i) + piezaPos[0]) * casillaTam + (1200 - (casillaTam * w + 50)),
					(piezas.getShapeY(i) + piezaPos[1]) * casillaTam + 50, casillaTam - 4, casillaTam - 4);

		}
	}
	
	public void nivel2keys(){

		if (app.keyCode == 37) {
			boolean stop = false;
			for (int i = 0; i < 4; i++) {
				if ((piezas.getShapeX(i) + piezaPos[0]) > 0) {
					if ((piezas.getShapeX(i) + piezaPos[0]) < w - 1 && (piezas.getShapeY(i) + piezaPos[1]) > 0
							&& (piezas.getShapeY(i) + piezaPos[1]) < h - 1) {
						if (Grid[(piezas.getShapeX(i) + piezaPos[0]) - 1][(piezas.getShapeX(i) + piezaPos[0])] != 0)
							stop = true;
					}
				} else
					stop = true;
			}
			if (!stop)
				piezaPos[0]--;
		}

		if (app.keyCode == 38) {
			piezas.rot();
			if ((piezas.getMinX() + piezaPos[0]) < 0) {
				piezaPos[0] -= (piezas.getMinX() + piezaPos[0]);
			}
			if ((piezas.getMaxX() + piezaPos[0]) > w - 1) {
				piezaPos[0] -= (piezas.getMinX() + piezaPos[0]) - (w - 1);
			}
			if ((piezas.getMinY() + piezaPos[1]) < 0) {
				piezaPos[0] -= (piezas.getMinY() + piezaPos[1]);
			}
			if ((piezas.getMaxY() + piezaPos[1]) > h - 1) {
				piezaPos[0] -= (piezas.getMaxX() + piezaPos[1]) - (h - 1);
			}
		}
		if (app.keyCode == 39) {

			boolean stop = false;
			for (int i = 0; i < 4; i++) {
				if ((piezas.getShapeX(i) + piezaPos[0]) < w - 1) {
					if ((piezas.getShapeX(i) + piezaPos[0]) > 0 && (piezas.getShapeY(i) + piezaPos[1]) > 0
							&& (piezas.getShapeY(i) + piezaPos[1]) < h - 1) {
						if (Grid[(piezas.getShapeX(i) + piezaPos[0]) + 1][(piezas.getShapeX(i)
								+ piezaPos[0])] != 0) {
							stop = true;
						}

					}
				} else
					stop = true;
			}
			if (!stop)
				piezaPos[0]++;

		}
		if (app.keyCode == 40) {
			score++;
			piezaPos[1]++;
			verificar();
		}
		
	
	}
}
