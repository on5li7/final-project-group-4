package edu.pacific.comp55.starter;
import java.util.*;
import acm.graphics.GImage;
import java.util.ArrayList;

public class Room {
	public Room DiningHall;
	public Room Apothecary;
	public Room Kitchen;
	public Room WineCellar;
	public Room GreenHouse;
	public Room TheStudy;
	public Room Armory;
	public Room Workshop;
	public Room TheCliff;
	public Room Outdoors_1;
	public Room Outdoors_2;
	public Room Outdoors_3;
	public Room Outdoors_4;
	public Room Bedroom_1;
	public Room Bedroom_2;
	public Room Bedroom_3;
	public Room Bedroom_4;
	public Room Bedroom_5;
	public Room Bedroom_6;
	public Room Bedroom_7;
	public Room Bedroom_8;
	public Room Bedroom_9;
	public Room Bedroom_10;

HashSet<Room> adjacentRooms;
//The bus stops are 1-5. If the room is not a bus stop, this is 0.
//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
int BusStop;

HashSet<Partygoer> occupants;
public int getBusStop() {
	return BusStop;
}
}



