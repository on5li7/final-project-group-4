

package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;

public class DiningHallPane extends GraphicsPane {
	private MainApplication screen;
	private house  House;
	
	GImage background;
	GOval door;
	
										
	public DiningHallPane(MainApplication app, house House) {
		this.screen = app;
		this.House = House;
		background = new GImage("DiningHall.jpg", 0, 0);
		background.scale(0.4);
		door = new GOval(100,100,150,150);
		door.setFilled(true);
		door.setFillColor(Color.blue);

	}

	@Override
	public void showContents() {
		screen.add(background);
		screen.add(door);

	}

	@Override
	public void hideContents() {
		screen.remove(background);
		screen.remove(door);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = screen.getElementAt(e.getX(), e.getY());
		if (obj == door) {
			
			screen.switchToMenu();
		}
	}
}

