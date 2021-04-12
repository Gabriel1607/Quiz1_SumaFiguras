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
		TextFigures();
//System.out.println(figures.size());
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
			String figType = figureAtributes[0];
			int tam = Integer.parseInt(figureAtributes[1]);
			int posx = Integer.parseInt(figureAtributes[2]);
			int posy = Integer.parseInt(figureAtributes[3]);
			int direction = Integer.parseInt(figureAtributes[4]);
			int amount = Integer.parseInt(figureAtributes[5]);
		
			if (figType.equals("Circulo")) {
				Circle c = new Circle(tam, posx, posy, direction, 255, 0, 0, amount,0,app);
				figures.add(c);
				
			} else if (figType.equals("Cuadrado")) {
				Square s = new Square(tam, posx, posy, direction, 0, 255, 0, amount,0,app);
				figures.add(s);
			}
		}
	}
	public void drawFigures() {
		for (int i = 0; i < figures.size(); i++) {
			figures.get(i).drawFigure();

		}
		
	}
	public void moveFigures() {
		for (int i = 0; i < figures.size(); i++) {
			figures.get(i).move();

		}
	}
	public void pauseFigures() {
		for (int i = 0; i < figures.size(); i++) {
			if (app.mouseX > (figures.get(i).getPosX() - (figures.get(i).getTam() / 2))
					&& app.mouseX < (figures.get(i).getPosX() + (figures.get(i).getTam() / 2))
					&& app.mouseY > (figures.get(i).getPosY() - (figures.get(i).getTam() / 2))
					&& app.mouseY < (figures.get(i).getPosY() + (figures.get(i).getTam() / 2))) {
				figures.get(i).setMov(!figures.get(i).isMov());
			}
		}
	}
	public void drawCircle() {
		circle.drawFigure();
	}

	public void drawSquare() {
		square.drawFigure();
	}
}
