import de.voidplus.leapmotion.Arm;
import de.voidplus.leapmotion.Finger;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.LeapMotion;
import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

public class MainApp extends PApplet {

	public static void main(String[] args) {
		PApplet.main("MainApp");
	}

	Logica logica;
	PApplet app;
	LeapMotion leap;
	int pantallasLeap;
	PImage guante1, guante2;
	private Cerdito selCerdo;

	@Override
	public void settings() {
		size(800, 600);
		// fullScreen();
	}

	@Override
	public void setup() {
		logica = new Logica(this);
		leap = new LeapMotion(this);
		
		guante1 = loadImage("../data/guante-02.png");
		guante2 = loadImage("../data/guante-03.png");
	}

	public void draw() {
		logica.pintar();

		System.out.println(pantallasLeap);
		int fps = leap.getFrameRate();
		for (Hand hand : leap.getHands()) {

			if (hand.isRight() == true) {

				// SELECCION DE CERDITO PANTALLA 2
				pantallasLeap = logica.getPantallas();

				if (pantallasLeap == 2) {
					
					
					if (hand.getPinchStrength()>0.7) {
						image(guante2, hand.getIndexFinger().getPosition().x, hand.getIndexFinger().getPosition().y, 1259/9, 1443/9);
					}else {
						image(guante1, hand.getIndexFinger().getPosition().x, hand.getIndexFinger().getPosition().y, 1259/9, 1443/9);
						
					}

					logica.pressedLeap(hand.getIndexFinger().getPosition().x, hand.getIndexFinger().getPosition().y);

					if (hand.getPinchStrength() > 0.7) {
						System.out.println("presionando");
						logica.dragLeap(hand.getIndexFinger().getPosition().x, hand.getIndexFinger().getPosition().y);

					}

					else {

						logica.releaseLeap(hand.getIndexFinger().getPosition().x,
								hand.getIndexFinger().getPosition().y);
					}

					for (int i = 0; i < logica.getCerditos().size(); i++) {
						if (hand.getPinchStrength() > 0.7) {

							logica.getCerditos().get(i).moverLeap(hand.getIndexFinger().getPosition().x,
									hand.getIndexFinger().getPosition().y);
						}
					}

				}

				else if (pantallasLeap == 3) {

					// RUNNER

					if (hand.getPosition().x > 165 && hand.getPosition().x < 640) {
						logica.runner.mover(hand.getPosition().x);

						
					}
					
					if (hand.getPosition().x >680 && hand.getPosition().y > 40 && hand.getPosition().y<200 && hand.getGrabStrength() > 0.7) {
						
						logica.construircasapaja();
					}else if (hand.getPosition().x >680 && hand.getPosition().y > 240 && hand.getPosition().y<400 && hand.getGrabStrength() > 0.7) {
						logica.construircasamadera();
					}else if (hand.getPosition().x >680 && hand.getPosition().y > 440 && hand.getPosition().y<600 && hand.getGrabStrength() > 0.7) {
						logica.construircasaLadrillos();
					}
					
					
					

					// RUNER

					
				}

			} // finaliza hand is right

			textSize(12);

			// ==================================================
			// 2. Hand

			int handId = hand.getId();
			PVector handPosition = hand.getPosition();
			PVector handStabilized = hand.getStabilizedPosition();
			PVector handDirection = hand.getDirection();
			PVector handDynamics = hand.getDynamics();
			float handRoll = hand.getRoll();
			float handPitch = hand.getPitch();
			float handYaw = hand.getYaw();
			boolean handIsLeft = hand.isLeft();
			boolean handIsRight = hand.isRight();
			float handGrab = hand.getGrabStrength();
			float handPinch = hand.getPinchStrength();
			float handTime = hand.getTimeVisible();
			PVector spherePosition = hand.getSpherePosition();
			float sphereRadius = hand.getSphereRadius();

			// --------------------------------------------------
			// Drawing
			//hand.draw();

			// ==================================================
			// 3. Arm

			if (hand.hasArm()) {
				Arm arm = hand.getArm();
				float armWidth = arm.getWidth();
				PVector armWristPos = arm.getWristPosition();
				PVector armElbowPos = arm.getElbowPosition();
			}

			// ==================================================
			// 4. Finger

			Finger fingerThumb = hand.getThumb();
			// or hand.getFinger("thumb");
			// or hand.getFinger(0);

			Finger fingerIndex = hand.getIndexFinger();
			// or hand.getFinger("index");
			// or hand.getFinger(1);

			Finger fingerMiddle = hand.getMiddleFinger();
			// or hand.getFinger("middle");
			// or hand.getFinger(2);

			Finger fingerRing = hand.getRingFinger();
			// or hand.getFinger("ring");
			// or hand.getFinger(3);

			Finger fingerPink = hand.getPinkyFinger();
			// or hand.getFinger("pinky");
			// or hand.getFinger(4);

			for (Finger finger : hand.getFingers()) {
				// or hand.getOutstretchedFingers();
				// or hand.getOutstretchedFingersByAngle();

				int fingerId = finger.getId();
				PVector fingerPosition = finger.getPosition();
				PVector fingerStabilized = finger.getStabilizedPosition();
				PVector fingerVelocity = finger.getVelocity();
				PVector fingerDirection = finger.getDirection();
				float fingerTime = finger.getTimeVisible();

			}
		}

	}

	public void mousePressed() {
		logica.pressed();
	}

	public void mouseDragged() {
		logica.drag(mouseX, mouseY);
	}

	public void mouseReleased() {
		logica.release(mouseX, mouseY);
	}

	public void keyPressed() {
		logica.key();
	}
}
