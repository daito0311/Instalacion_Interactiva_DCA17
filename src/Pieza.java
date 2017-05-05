import processing.core.PApplet;

public class Pieza {
	protected PApplet app;
	protected int pieza[][] = new int[4][2];
	protected int col=0;
	
	
	public Pieza() {
	//	col= (int) (app.random(1,8));
		col= (int) (Math.random()*8)+1;
		if(col==1){
			pieza[1][0] = 1;
			pieza[2][0] = -1;
			pieza[3][0] = -2;

		}
		else if(col==2){
			pieza[1][0] = 1;
			pieza[2][0] = -1;
			pieza[3][0] = -1;
			pieza[3][1] = -1;
		}
		else if(col==3){
			pieza[1][0] = 1;
			pieza[2][0] = -1;
			pieza[3][0] = 1;
			pieza[3][1] = -1;
		}
		else if(col==4){
			pieza[1][0] = 1;
			pieza[2][1] = 1;
			pieza[3][0] = 1;
			pieza[3][1] = 1;
		}
		else if(col==5){
			pieza[1][0] = -1;
			pieza[2][1] = -1;
			pieza[3][0] = 1;
			pieza[3][1] = -1;
		}
		else if(col==6){
			pieza[1][0] = 1;
			pieza[2][0] = -1;
			pieza[3][1] = -1;
		}
		else{
			pieza[1][0] = 1;
			pieza[2][0] = -1;
			pieza[3][0] = -1;
			pieza[3][1] = -1;
		}
		
	}
	
	public void rot(){
		
		for (int i = 0; i < 4; i++) {
			int buff = pieza[i][0];
			pieza[i][0] = pieza[i][1];
			pieza[i][1] = - buff;
		}
	}
	
	public int getShapeX(int i){
		return pieza[i][0];
	}
	public int getShapeY(int i){
		return pieza[i][1];
	}
	public int getMaxX(){
		int i= 0;
		for (int j = 0; j < 4; j++) {
			if (pieza[j][0] > pieza [i][0])i=j;
		}
		return pieza[i][0];
	}
	
	public int getMinX(){
		int i= 0;
		for (int j = 0; j < 4; j++) {
			if (pieza[j][0] < pieza [i][0])i=j;
		}
		return pieza[i][0];
	}
	
	public int getMaxY(){
		int i= 0;
		for (int j = 0; j < 4; j++) {
			if (pieza[j][1] > pieza [i][1])i=j;
		}
		return pieza[i][1];
	}
	
	public int getMinY(){
		int i= 0;
		for (int j = 0; j < 4; j++) {
			if (pieza[j][1] < pieza [i][1])i=j;
		}
		return pieza[i][1];
	}
	
	public int getColor(){return col;}
}
