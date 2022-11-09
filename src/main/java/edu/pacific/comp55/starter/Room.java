package edu.pacific.comp55.starter;
import java.util.*;
import acm.graphics.GImage;
import java.util.ArrayList;

public class Room {
	
item[] looseStuff;

private Boolean inDoors;

ArrayList<Convos> Interactables;

Convos Ritual;

GImage background;

HashSet<Room> adjacentRooms;
//The bus stops are 1-5. If the room is not a bus stop, this is 0.
//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
int BusStop;

HashSet<Partygoer> occupants;
public int getBusStop() {
	return BusStop;
}

public Room(item[] looseStuff, Boolean inDoors, ArrayList<Convos> Interactables, Convos Ritual, HashSet<Room> adjacentRooms, HashSet<Partygoer> occupants, int BusStop) {
	this.looseStuff = looseStuff;
	this.inDoors = inDoors;
	this.Interactables = Interactables;
	this.Ritual = Ritual;
	this.adjacentRooms = adjacentRooms;
	this.occupants = occupants;
	this.BusStop = BusStop;
}
}



