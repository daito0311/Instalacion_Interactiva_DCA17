import java.util.ArrayList;

import com.sun.javafx.font.directwrite.RECT;

import javafx.scene.layout.Background;
import processing.core.PApplet;
import processing.core.PImage;

public class Logica {

	
	private int pantallas;
	private PApplet app;
	private ArrayList <Elemento> elementos;
	private float xcreator;
	
	
	private int tipoelem;
	
	private PImage banda;
	
	private PImage fondoini, fondomenu, niveles;
	
	
	
	public Logica(PApplet app) {
		
		
		this.app = app;
	this.pantallas = 0;	
	this.tipoelem = 1;
	this.xcreator = 600;
	
	 // IMAGENES 
	banda = app.loadImage("../data/banda.png");
	fondoini = app.loadImage("../data/Pantallas-00-Intro.png");
	fondomenu = app.loadImage("../data/Pantallas-00-Menu.png");	
	
	
	// ARREGLOS
	
	elementos = new ArrayList<Elemento>();
		
	}

	public void pintar(PApplet app) {

		app.smooth();
		app.frameRate(60);
		switch (pantallas) {
		
		// PANTALLA DE INICIO 
		case 0:
			
			app.image(fondoini, 0, 0);
			
			
			
			break;
 // INSTRUCCIONES
		case 1:
			
			app.image(fondomenu, 0, 0);
			app.fill(255,255,0);
			app.rect(app.width/2-300, 550, 160, 40);
			
			app.rect(app.width/2+100, 550, 160, 40);
			
			app.fill(0);
			app.textSize(23);
			app.text("Jugar",app.width/2-250, 578);
			
			app.text("Instrucciones",app.width/2+108, 578);
		
			
			
			break;
			
			// PANTALLA DE JUEGO 1  (JUEGO DE LA BANDA GUITAR HERO DONDE BAJAN LOS ELEMENTOS)
		case 2:
			app.image(banda, 0, 0, 1280, 720);
			
			
			app.ellipse(xcreator, 125, 25, 25);
			
			
			switch (tipoelem) {
			case 1:
				app.fill(255,0,0);
				app.rect(300, 20, 100, 20);
				break;

			case 2:
				app.fill(0,0,255);
				app.rect(300, 20, 100, 20);
				break;
				
			case 3:
				app.fill(0,255,0);
				app.rect(300, 20, 100, 20);
				break;
			}
			
			
			for (int i = 0; i < elementos.size(); i++) {
				
				elementos.get(i).pintar(app);
				elementos.get(i).mover(app);
			}
			
			
			
			break;
		}
		
		
		
	}
	
	
	

	public void press() {
		
		// hacer click en instrucciones
		
		if (app.mouseX>app.width/2+100 && app.mouseX<app.width/2+100+160 && app.mouseY >550 && app.mouseY <590 && pantallas == 1) {
		
			pantallas =3;
			
		
		}
		
		// hacer clic en jugar
		
		if (app.mouseX> app.width/2-250 && app.mouseX< app.width/2-250+160 &&  app.mouseY >550 && app.mouseY <590 && pantallas == 1) {
			pantallas =2;
		}

		
		
	}

	public void key() {
		
		
		
		
		if (app.keyCode == app.ENTER && pantallas ==0) {
			
			pantallas ++;
			
		}
		
		
		if (app.keyCode == app.LEFT && xcreator>495) {
			this.xcreator-=1*2;
			
		}
		
		
		if (app.keyCode == app.RIGHT && xcreator<695) {
			this.xcreator+=1*2;
			
		}
		
		if ( app.key == 'q' || app.key  == 'Q') {
			tipoelem ++;
		
			if (tipoelem >3) {
			tipoelem = 1;	
				
			}
			
			
			
		}

		if ( app.key == 'a' || app.key  == 'A') {
			
			switch (tipoelem) {
			case 1:
				elementos.add(new Elemento(xcreator, 125, 25,25, 1));
				
				break;

			case 2:
				elementos.add(new Elemento(xcreator, 125, 25,25, 2));
				break;
				
			case 3:
				elementos.add(new Elemento(xcreator, 125, 25,25, 3));
				break;
			}
			
			
		}
	}

}
