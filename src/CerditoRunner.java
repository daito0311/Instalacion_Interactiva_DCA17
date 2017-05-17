import processing.core.PApplet;

public abstract class CerditoRunner extends Cerdito{

	public CerditoRunner(PApplet app) {
		super(app);
		x = app.width / 2;
		y = (app.height / 3)*2;
	}

	@Override
	public abstract void display();

}
