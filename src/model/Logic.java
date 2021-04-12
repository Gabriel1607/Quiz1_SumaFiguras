package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic extends PApplet {
	PApplet app;
	String[] loadText;
	ArrayList<String> words;
	ArrayList<Figure> figures;
	public Logic(PApplet app) {
		
		this.app = app;
		loadText = app.loadStrings("../data/TXT.txt");
		words = new ArrayList<String>();
		for (int i = 0; i < loadText.length; i++) {
			words.add(loadText[i].split("\\r\\n"));
			//"\r\n" es para hacer un salto de linea
		}
	}
	public void drawCircle() {

	}

	public void drawSquare() {
	
	}
}
