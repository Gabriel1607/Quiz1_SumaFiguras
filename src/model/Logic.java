package model;

import java.util.ArrayList;
import java.util.Random;

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
	}
	public void TextFigures() {
		for (int i = 0; i < loadText.length; i++) {
			//Separamos el TXT en cada espacio
			String[] figureAtributes = loadText[i].split(" ");
			//Le asignamos a cada variable una posicion del arreglo para tener los atributos
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
	public void generateFigures() {

		int Sq=0;
		int Ci=1;
		//Usamos Random para elegir entre dos ints que representan los dos tipos de figura
		int figType = new Random().nextBoolean() ? Sq : Ci;
		int tam = (int) app.random(10, 100);
		int posX = (int) app.random(0, 700);
		int posY = (int) app.random(0, 700);
		int direction = (int) app.random(0, 2);
		int r = (int) app.random(0, 255);
		int g = (int) app.random(0, 255);
		int b = (int) app.random(0, 255);
		
		if (direction == 0) {
			direction = -1;
		}
		int amount = (int) app.random(1, 10);
		//Si es de tipo 0, es un circulo
		if (figType == 0) {
			Circle c = new Circle(tam,posX, posY, direction, r, g, b, amount,0, app);
			figures.add(c);
			//Si es de tipo 1, es un cuadrado
		} else if (figType == 1) {
			Square s = new Square(tam,posX, posY, direction, r, g, b, amount,0, app);
			figures.add(s);
		}
	}
	private void addTriangle(int posX, int posY, int value) {
		int tam = (int) random(10,80);
		int direction = 1;
		
		int r= (int) random (0,255);
		int g= (int) random (0,255);
		int b= (int) random (0,255);
		
		figures.add(new Triangle(tam, posX, posY, direction, r, g, b, value,0, app));
	}
	public void fuseFigures() {
		boolean r = false;
		for (int i = 0; i < figures.size() && r == false; i++) {

			for (int j = 0; j < figures.size() && r == false; j++) {
				//Con esto podemos ignorar los triangulos
				if (!(figures.get(i) instanceof Triangle)&& !(figures.get(j) instanceof Triangle)) {
					//Con esto nos aseguramos que las figuras sean diferentes
					if (i != j) {
						//Comprobamos que las figuras se estén chocando con la función dist
						if (PApplet.dist(figures.get(i).getPosX(), figures.get(i).getPosY(),
						   figures.get(j).getPosX(), figures.get(j).getPosY()) <= figures.get(i).getTam() / 2 + figures.get(j).getTam() / 2)
						{
							//Hacemos que se cree el triangulo con cada colision
					addTriangle(figures.get(i).getPosX(), figures.get(i).getPosY(),
					 // Hacemos que se sumen los valores de las figuras que colisionan
					 figures.get(i).getAmount() + figures.get(j).getAmount());
										//Remover las figuras que colisionan	
											figures.remove(j);
											figures.remove(i);
											//
											r = true;
						}
					}

				}

			}
		}
	}
	
}
