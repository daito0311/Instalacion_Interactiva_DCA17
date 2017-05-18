import de.voidplus.leapmotion.Arm;
import de.voidplus.leapmotion.Finger;
import de.voidplus.leapmotion.Hand;
import de.voidplus.leapmotion.LeapMotion;
import processing.core.PApplet;
import processing.core.PVector;

public class MainApp extends PApplet {
	
	public static void main(String[] args) {
		PApplet.main("MainApp");
	}

	Logica logica;
	PApplet app;
	LeapMotion leap;
	@Override
	public void settings() {
		size(800, 600);
//		fullScreen();
	}

	@Override
	public void setup() {
		logica = new Logica(this);
		leap = new LeapMotion(this);
	}
	
	public void draw(){
		logica.pintar();
		
	
		

		  int fps = leap.getFrameRate();
		  for (Hand hand : leap.getHands ()) {


		    // ==================================================
		    // 2. Hand

		    int     handId             = hand.getId();
		    PVector handPosition       = hand.getPosition();
		    PVector handStabilized     = hand.getStabilizedPosition();
		    PVector handDirection      = hand.getDirection();
		    PVector handDynamics       = hand.getDynamics();
		    float   handRoll           = hand.getRoll();
		    float   handPitch          = hand.getPitch();
		    float   handYaw            = hand.getYaw();
		    boolean handIsLeft         = hand.isLeft();
		    boolean handIsRight        = hand.isRight();
		    float   handGrab           = hand.getGrabStrength();
		    float   handPinch          = hand.getPinchStrength();
		    float   handTime           = hand.getTimeVisible();
		    PVector spherePosition     = hand.getSpherePosition();
		    float   sphereRadius       = hand.getSphereRadius();

		    // --------------------------------------------------
		    // Drawing
		    hand.draw();


		    // ==================================================
		    // 3. Arm

		    if (hand.hasArm()) {
		      Arm     arm              = hand.getArm();
		      float   armWidth         = arm.getWidth();
		      PVector armWristPos      = arm.getWristPosition();
		      PVector armElbowPos      = arm.getElbowPosition();
		    }


		    // ==================================================
		    // 4. Finger

		    Finger  fingerThumb        = hand.getThumb();
		    // or                        hand.getFinger("thumb");
		    // or                        hand.getFinger(0);

		    Finger  fingerIndex        = hand.getIndexFinger();
		    // or                        hand.getFinger("index");
		    // or                        hand.getFinger(1);

		    Finger  fingerMiddle       = hand.getMiddleFinger();
		    // or                        hand.getFinger("middle");
		    // or                        hand.getFinger(2);

		    Finger  fingerRing         = hand.getRingFinger();
		    // or                        hand.getFinger("ring");
		    // or                        hand.getFinger(3);

		    Finger  fingerPink         = hand.getPinkyFinger();
		    // or                        hand.getFinger("pinky");
		    // or                        hand.getFinger(4);        


		    for (Finger finger : hand.getFingers()) {
		      // or              hand.getOutstretchedFingers();
		      // or              hand.getOutstretchedFingersByAngle();

		      int     fingerId         = finger.getId();
		      PVector fingerPosition   = finger.getPosition();
		      PVector fingerStabilized = finger.getStabilizedPosition();
		      PVector fingerVelocity   = finger.getVelocity();
		      PVector fingerDirection  = finger.getDirection();
		      float   fingerTime       = finger.getTimeVisible();
		    
}
		  }
	
		
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
