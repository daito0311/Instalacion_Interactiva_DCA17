import processing.core.PApplet;

public class MainApp extends PApplet {
	// holi
	public static void main(String[] args) {
		PApplet.main("MainApp");
	}

	Logica logica;
	PApplet app;

	@Override
	public void settings() {
		size(800, 600);
//		fullScreen();
	}

	@Override
	public void setup() {
		logica = new Logica(this);
	}
	
	public void draw(){
		logica.pintar();
	}
	
	public void mousePressed(){
	logica.pressed();
	}
	
	public void mouseDragged(){
		logica.drag(mouseX, mouseY);
	}
	
	public void mouseReleased(){
		logica.release(mouseX, mouseY);
	}
	public void keyPressed(){
	logica.key();
	}
}
