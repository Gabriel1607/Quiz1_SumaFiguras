package model;

import processing.core.PApplet;

public class Square extends Figure {
	public Square(int tam, int posX, int posY, int direction, int r, int g, int b,int amount, int bounce, PApplet app) {
		super(tam, posX, posY, direction, r, g, b, amount, bounce, app);
	}
	protected void drawFigure() {
		
		app.fill(r,g,b);
		app.rectMode(CENTER);
		app.rect(posX, posY, tam, tam);
		
		app.fill(0);
		app.textAlign(CENTER);
		app.text(getAmount(),getPosX(),getPosY());	
	}
		
}
