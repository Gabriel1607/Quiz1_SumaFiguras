package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic extends PApplet {
	PApplet app;
	String[] loadText;
	ArrayList<String> words;
	ArrayList<Figure> figures;
	public Logic(PApplet app) {
		words = new ArrayList<String>();
		figures = new ArrayList<Figure>();
		this.app = app;
		loadText = app.loadStrings("../resource/TXT.txt");
		
		for (int i = 0; i < loadText.length; i++) {
			String[] tempArray = loadText[i].split("\\r\\n|\\n\\r"); 
			//"\r\n" es para hacer un salto de linea
			for (int j = 0; j < tempArray.length; j++) {
				words.add(tempArray[j]);
				
			}
	
			
		}
	}
	public void drawCircle() {

	}

	public void drawSquare() {
	
	}
}
