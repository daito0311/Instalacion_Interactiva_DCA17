import processing.core.PApplet;
import processing.core.PImage;

public class CerditoRunnerPaja extends CerditoRunner{

	public CerditoRunnerPaja(PApplet app) {
		super(app);
		animacionCerdito = new PImage[4];
		for (int l = 0; l < animacionCerdito.length; l++) {
			animacionCerdito[l] = app.loadImage("CerditoRunnerPaja-0" + (l + 1) + ".png");
			System.out.println(l + 1);
			// Cargar imagen en direccion
		}
	}

	@Override
	public void display() {
		app.image(animacionCerdito[numActualAnimacion], x, y, 100, 100);
		if (app.frameCount % 4 == 0) {
			numActualAnimacion++;
			if (numActualAnimacion >= animacionCerdito.length) {
				numActualAnimacion = 0;
			}
		}
		app.fill(255, 0, 0);
		
	}

}
