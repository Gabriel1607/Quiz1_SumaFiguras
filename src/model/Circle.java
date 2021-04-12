package model;

import processing.core.PApplet;

public class Circle extends Figure {
	public Circle(int tam, int posX, int posY, int direction, int r, int g, int b,int amount, int bounce, PApplet app) {
		super(tam, posX, posY, direction, r, g, b, amount, bounce, app);
	}
	protected void drawFigure() {
		
		app.fill(r,g,b);
		app.ellipse(posX, posY, tam, tam);
		
		app.fill(0);
		app.textAlign(CENTER);
		app.text(getAmount(),getPosX(),getPosY());
	}

	
}
