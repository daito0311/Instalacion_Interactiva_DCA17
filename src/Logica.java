import java.util.ArrayList;

import com.sun.javafx.font.directwrite.RECT;

import javafx.scene.layout.Background;
import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	private int pantallas;
	private PApplet app;
	private ArrayList<Elemento> elementos;
	private float xcreator;
	private int tipoelem;

	private PImage banda;
	private PImage fondoini, fondomenu, fondoNiveles,fondoAdhesivos, fondolvl1, fondolvl2;

	public Logica(PApplet app) {

		this.app = app;
		this.pantallas = 0;
		this.tipoelem = 1;
		this.xcreator = 600;
		app.textFont(app.createFont("Back to Black Demo", 20));

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
		if(pantallas == 0){
			app.image(fondoini, 0, 0);
		}
		
		if(pantallas == 1){

			app.image(fondomenu, 0, 0);
			app.fill(255, 255, 0);

			app.fill(0, 33, 52);
			app.textSize(55);
			app.textAlign(app.CENTER);
			app.text("Jugar", app.width / 2 - 250, 600);

			app.text("Adhesivos", app.width / 2 + 190, 600);
		}
		// INSTRUCCIONES
		if(pantallas == 2){

			app.image(fondoNiveles, 0, 0);
		}
		
		if(pantallas == 3){

			app.image(fondoAdhesivos, 0, 0);
		}
		// PANTALLA DE JUEGO 1 (JUEGO DE LA BANDA GUITAR HERO DONDE BAJAN
		// LOS ELEMENTOS)
		if(pantallas == 4){

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
		
		

	}

	public void press() {

		// hacer click en anhesivos

		if (app.mouseX > app.width / 2 + 100 && app.mouseX < app.width / 2 + 100 + 160 && app.mouseY > 550
				&& app.mouseY < 590 && pantallas == 1) {

			pantallas = 3;
			System.out.println("adhesivo");
			System.out.println(pantallas);

		}

		// hacer clic en jugar

		if (app.mouseX > app.width / 2 - 250 && app.mouseX < app.width / 2 - 250 + 160 && app.mouseY > 550
				&& app.mouseY < 590 && pantallas == 1) {
			pantallas = 2;
			System.out.println("jugar");
			System.out.println(pantallas);
		}

		// hacer clic en nivel 1

		if (app.mouseX > 0 && app.mouseX < (app.width / 3) && app.mouseY > 0 && app.mouseY < app.height
				&& pantallas == 2) {
			pantallas = 4;
		}

		// hacer clic en nivel 2

		if (app.mouseX > (app.width / 3) && app.mouseX < (app.width / 3) * 2 && app.mouseY > 0
				&& app.mouseY < app.height && pantallas == 2) {
			pantallas = 5;
		}

		// hacer clic en nivel 3

		if (app.mouseX > (app.width / 3) * 2 && app.mouseX < (app.width / 3) * 3 && app.mouseY > 0
				&& app.mouseY < app.height && pantallas == 2) {
			pantallas = 6;
		}

	}

	public void key() {

		if (app.keyCode == app.ENTER && pantallas == 0) {

			pantallas++;

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

}
