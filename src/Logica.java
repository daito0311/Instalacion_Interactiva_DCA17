import com.sun.javafx.font.directwrite.RECT;

import javafx.scene.layout.Background;
import processing.core.PApplet;

public class Logica {

	
	private int pantallas;
	PApplet app;
	
	
	public Logica(PApplet app) {
		this.app = app;
	this.pantallas = 0;	
		
		
	}

	public void pintar(PApplet app) {

		
		switch (pantallas) {
		
		// PANTALLA DE INICIO 
		case 0:
			
			app.fill(255,255,0);
			app.rect(app.width/2-300, 550, 160, 40);
			
			app.rect(app.width/2+100, 550, 160, 40);
			
			app.fill(0);
			app.textSize(23);
			app.text("Jugar",app.width/2-250, 578);
			
			app.text("Instrucciones",app.width/2+108, 578);
		
			
			
			break;
 // INSTRUCCIONES
		case 1:
			
		
			
			
			break;
			
			// PANTALLA DE JUEGO 1  (JUEGO DE LA BANDA GUITAR HERO DONDE BAJAN LOS ELEMENTOS)
		case 2:
			
			
			
			
			
			break;
		}
		
		
		
	}

	public void press() {
		
		if (app.mouseX>app.width/2+100 && app.mouseX<app.width/2+100+160 && app.mouseY >550 && app.mouseY <590 && pantallas == 0) {
		
			pantallas =1;
			
		
		}
		
		if (app.mouseX> app.width/2-250 && app.mouseX< app.width/2-250+160 &&  app.mouseY >550 && app.mouseY <590 && pantallas == 0 ) {
			pantallas =2;
		}

		
		
	}

}
