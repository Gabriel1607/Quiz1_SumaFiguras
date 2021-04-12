package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {
Logic logic;
PApplet app;
public Controller(PApplet app) {
	this.app = app;
	logic = new Logic(app);
}
public void drawFigures() {
	logic.drawFigures();
}
public void moveFigures() {
	logic.moveFigures();
}
public void pauseFigures() {
	logic.pauseFigures();
}
public void generateFigures() {
	logic.generateFigures();
}
public void drawCircle() {
	logic.drawCircle();
}
public void drawSquare() {
	logic.drawSquare();
}
}
