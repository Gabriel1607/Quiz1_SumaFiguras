package model;

import processing.core.PApplet;

public abstract class Figure extends PApplet{
	PApplet app;
	protected int posX,posY,tam,direction,amount,r,g,b;
public Figure(int tam, int posX, int posY, int direction, int r, int g, int b, int amount, PApplet app) {
		
		this.tam=tam;
		this.posX=posX;
		this.posY=posY;
		this.direction=direction;
		this.app=app;
		this.amount=amount; 
		
		this.r = r;
		this.g = g;
		this.b = b;
		
	

	}

protected abstract void drawFigure();
protected abstract void move();
	

}
