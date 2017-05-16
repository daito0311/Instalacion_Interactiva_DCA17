import processing.core.PApplet;
import processing.core.PImage;

public class CerditoPaja extends Cerdito {
	// holi
	public CerditoPaja(PApplet app) {
		super(app);
		// TODO Auto-generated constructor stub
		x = ((app.width / 6) * 1)+100;
		y = ((app.height / 3) * 2)+30;

		animacionCerdito = new PImage[4];
		for (int l = 0; l < animacionCerdito.length; l++) {
			animacionCerdito[l] = app.loadImage("Paja-0" + (l + 1) + ".png");
			System.out.println(l + 1);
			// Cargar imagen en direccion
		}
		animacionCerditoA = new PImage[8];
		for (int l = 0; l < animacionCerditoA.length; l++) {
			animacionCerditoA[l] = app.loadImage("PajaA-0" + (l + 1) + ".png");
			System.out.println(l + 1);
			// Cargar imagen en direccion
		}
	}

	public void display() {
		app.imageMode(app.CENTER);

		if (agarrado == true) {
			app.image(animacionCerditoA[numActualAnimacionA], x, y, tamanox, tamanoy-desfaseT);
			if (app.frameCount % 1 == 0) {
				numActualAnimacionA++;
				if (numActualAnimacionA >= animacionCerditoA.length) {
					numActualAnimacionA = 0;
				}
			}
			app.fill(255, 0, 0);
		} else {
			app.image(animacionCerdito[numActualAnimacion], x, y, tamanox, tamanoy);
			if (app.frameCount % 1 == 0) {

				boolean stop = false;
				boolean startT = false;

				if (numActualAnimacion == 0) {
					stop = true;
					startT = true;
					int ramdomly = (int) app.random(50, 100);
					if (timer >= ramdomly) {
						startT = false;
						timer = 0;
						stop = false;
					}
				}
				if (stop == false) {
					numActualAnimacion++;
				}
				if (startT == true) {
					timer++;
				}
				// System.out.println(timer);

				if (numActualAnimacion >= animacionCerdito.length) {
					numActualAnimacion = 0;
				}

				// if (numActualAnimacion >= 3) {
				// System.out.println(pantallas);
				//
				// pantallas=1;
				//
				// }
				//
				// System.out.println(pantallas);
			}
			app.fill(0, 255, 255);
		}
		app.ellipse(x, y, 30, 30);

	}

}
