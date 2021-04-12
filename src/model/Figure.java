package model;

import processing.core.PApplet;

public abstract class Figure extends PApplet{
	PApplet app;
	protected int posX,posY,tam,direction,amount,r,g,b,bounce;
	protected boolean isMov;
public Figure(int tam, int posX, int posY, int direction, int r, int g, int b, int amount, int bounce, PApplet app) {
		
		this.tam=tam;
		this.posX=posX;
		this.posY=posY;
		this.direction=direction;
		this.app=app;
		this.amount=amount; 
		this.bounce=bounce;
		
		this.r = r;
		this.g = g;
		this.b = b;
		
	isMov=true;

	}

public int getPosX() {
	return posX;
}

public void setPosX(int posX) {
	this.posX = posX;
}

public int getPosY() {
	return posY;
}

public void setPosY(int posY) {
	this.posY = posY;
}

public int getTam() {
	return tam;
}

public void setTam(int tam) {
	this.tam = tam;
}

public int getDirection() {
	return direction;
}

public void setDirection(int direction) {
	this.direction = direction;
}

public int getAmount() {
	return amount;
}

public void setAmount(int amount) {
	this.amount = amount;
}

public int getR() {
	return r;
}

public void setR(int r) {
	this.r = r;
}

public int getG() {
	return g;
}

public void setG(int g) {
	this.g = g;
}

public int getB() {
	return b;
}

public void setB(int b) {
	this.b = b;
}

protected abstract void drawFigure();
protected void move() {
	if (isMov) {
		
			if (posY <= 0 || posY >= 700) {
				direction = direction * -1;
			}
			posY += (2*direction);

		
	}
}

public boolean isMov() {
	return isMov;
}

public void setMov(boolean isMov) {
	this.isMov = isMov;
}
	

}
