package edu.pacific.comp55.starter;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GRect;

public class Outdoors1Pane extends GraphicsPane {
	private MainApplication screen;
	private house  House;
	
	GImage background;
	GButton outdoors2Door;
	GButton outdoors4Door;
	GButton cliffDoor;
	GImage ArianaDining;
	GImage BobDining;
	GImage ChadDining;
	GImage SmithyDining;
	GImage RieklenDining;
	GImage FrankDining;
	GImage GertrudeDining;
	GImage JakeDining;
	GImage MaxDining;
	
	public void populateRoom() {
		//ArrayList<GImage> partygoersDining = new ArrayList<GImage> ();
		ArianaDining = new GImage("ArianaStocracy.png",100,100);
		ArianaDining.scale(0.2);
		BobDining = new GImage("Bob.png", 200, 100);
		BobDining.scale(0.2);
		ChadDining = new GImage("Chad.png", 300, 100);
		ChadDining.scale(0.2);
		SmithyDining = new GImage("ConstableSmithy.png",150,150);
		SmithyDining.scale(0.2);
		RieklenDining = new GImage("DrRieklen.png",50,150);
		RieklenDining.scale(0.2);
		FrankDining = new GImage("Frank.png",250,150);
		FrankDining.scale(0.2);
		GertrudeDining = new GImage("GertrudeBiblio.png",100,200);
		GertrudeDining.scale(0.2);
		JakeDining = new GImage("JakeoftheWest.png",200,200);
		JakeDining.scale(0.2);
		MaxDining = new GImage("Maximillian.png",300,200);
		MaxDining.scale(0.2);
	}
	
										
	public Outdoors1Pane(MainApplication app, house House) {
		this.screen = app;
		this.House = House;
		background = new GImage("Outdoors1.jpg", 0, 0);
		background.scale(0.4);
		outdoors2Door = new GButton("To Outdoors 2",650,50,100,100);
		outdoors4Door = new GButton("To Outdoors 4",650,300,100,100);
		cliffDoor = new GButton("To Cliff",50,200,100,100);
		populateRoom();
	}

	@Override
	public void showContents() {
		screen.add(background);
		screen.add(ArianaDining);
		screen.add(BobDining);
		screen.add(ChadDining);
		screen.add(SmithyDining);
		screen.add(RieklenDining);
		screen.add(FrankDining);
		screen.add(GertrudeDining);
		screen.add(JakeDining);
		screen.add(MaxDining);
		screen.add(outdoors2Door);
		screen.add(outdoors4Door);
		screen.add(cliffDoor);
	}

	@Override
	public void hideContents() {
		screen.removeAll();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = screen.getElementAt(e.getX(), e.getY());
		if (obj == outdoors2Door) {
			screen.switchToOutdoors2();
		}
		if (obj==outdoors4Door) {
			screen.switchToOutdoors4();
		}
		if (obj==cliffDoor) {
			screen.switchToCliff();
		}
	}
}

