package model;

import processing.core.PApplet;

public class Square extends Figure {
	public Square(int tam, int posX, int posY, int direction, int r, int g, int b,int amount, PApplet app) {
		super(tam, posX, posY, direction, r, g, b, amount, app);
	}
	protected void drawFigure() {
		app.fill(r,g,b);
		app.rect(posX, posY, tam, tam);
		
		app.fill(0);
		app.textAlign(CENTER);
		app.text(getAmount(),getPosX(),getPosY());	
	}
	protected void move() {
		if (isMov) {
			posY += (2*direction);
			if (posY - tam/2 <= 30 || posY + (tam/2) >= height-20) {
				direction = (direction *-1); 
			}
		}
	}
	
}
