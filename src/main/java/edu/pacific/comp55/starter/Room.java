package edu.pacific.comp55.starter;
import java.util.*;
import acm.graphics.GImage;
import java.util.ArrayList;

public class Room {
public static void main(String[] args) {
	ArrayList<String> Rooms = new ArrayList<String>();
	Rooms.add("Dining Hall");
	Rooms.add("Apothecary");
	Rooms.add("Kitchen");
	Rooms.add("Wine Cellar");
	Rooms.add("GreenHouse");
	Rooms.add("The Study");
	Rooms.add("Armory");
	Rooms.add("Workshop");
	Rooms.add("Dungeon");
	Rooms.add("Outdoors");
	Rooms.add("The Cliff");	
}


HashSet<Room> adjacentRooms;
//The bus stops are 1-5. If the room is not a bus stop, this is 0.
//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
int BusStop;

HashSet<Partygoer> occupants;
public int getBusStop() {
	return BusStop;
}
}



