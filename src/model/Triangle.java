package model;

import processing.core.PApplet;

public class Triangle extends Figure {
	public Triangle(int tam, int posX, int posY, int direction, int r, int g, int b,int amount, PApplet app) {
		super(tam, posX, posY, direction, r, g, b, amount, app);
	}
	protected void drawFigure() {
		app.fill(r,g,b);		
		app.triangle(getPosX() - getTam() / 2,getPosY() + getTam() / 2,
				getPosX(),getPosY() - getTam() / 2,
				getPosX() + getTam() / 2,
				getPosY()+getTam()/2);	  
		
		app.fill(255);
		app.textAlign(CENTER);
		app.text(getAmount(),getPosX(),getPosY()+ getTam()/3);
	}
	protected void move() {
		if (isMov) {
			posY += (2*direction);
			if (posY - tam/2 <= 29 || posY + (tam/2) >= height-20) {
				direction = (direction *-1); 
			}
		}
	}
	
}
