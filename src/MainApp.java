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
		size(1200, 700);
//		fullScreen();
	}

	@Override
	public void setup() {
		logica = new Logica(this);
	}
	
	public void draw(){
		logica.display();
	}
	
	public void mousePressed(){
		logica.mouseP();
	}
	
	public void mouseDragged(){
		logica.mouseDr();
	}
	
	public void mouseReleased(){
		logica.mouseRe();
	}
	public void keyPressed(){
		logica.keyP();
	}
}
