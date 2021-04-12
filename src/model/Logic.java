package model;

import java.util.ArrayList;


import processing.core.PApplet;

public class Logic extends PApplet {
	PApplet app;
	String[] loadText;
	ArrayList<String> words;
	ArrayList<Figure> figures;
	Figure circle;
	Figure square;
	Figure triangle;
	public Logic(PApplet app) {
		words = new ArrayList<String>();
		figures = new ArrayList<Figure>();
		this.app = app;
		loadText = app.loadStrings("../resource/TXT.txt");
		//System.out.println(loadText[0]);
		//System.out.println(loadText[1]);
		//System.out.println(loadText[2]);
		//System.out.println(loadText[3]);
		//System.out.println(loadText[4]);
		//System.out.println(loadText[5]);
		//System.out.println(loadText[6]);
		/*for (int i = 0; i < loadText.length; i++) {
			String[] tempArray = loadText[i].split("\\r\\n|\\n\\r"); 
			//"\r\n" es para hacer un salto de linea
			for (int j = 0; j < tempArray.length; j++) {
				words.add(tempArray[j]);
				
			}
	
			
		}*/
		
	}
	public void TextFigures() {
		for (int i = 0; i < loadText.length; i++) {
			String[] figureAtributes = loadText[i].split(" ");
			String figType = loadText[0];
			int tam = Integer.parseInt(figureAtributes[1]);
			int posx = Integer.parseInt(figureAtributes[2]);
			int posy = Integer.parseInt(figureAtributes[3]);
			int direction = Integer.parseInt(figureAtributes[4]);
			int amount = Integer.parseInt(figureAtributes[5]);
			if (figType.equals("Circulo")) {
				Circle c = new Circle(tam, posx, posy, direction, 255, 0, 0, amount, app);
				figures.add(c);

			} else if (figType.equals("Cuadrado")) {
				Square s = new Square(tam, posx, posy, direction, 255, 0, 0, amount, app);
				figures.add(s);
			}
		}
	}
	public void drawFigures() {
		for (int i = 0; i < figures.size(); i++) {
			figures.get(i).drawFigure();

		}
	}
	public void drawCircle() {
		circle.drawFigure();
	}

	public void drawSquare() {
		square.drawFigure();
	}
}
