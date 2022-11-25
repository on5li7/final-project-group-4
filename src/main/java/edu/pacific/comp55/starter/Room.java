package edu.pacific.comp55.starter;
import java.util.*;
import acm.graphics.GImage;
import java.util.HashMap;
public class Room {
	
ArrayList<item> looseStuff;

private Boolean inDoors;

ArrayList<Convos> Interactables;

house theHouse;

Convos Ritual;

GImage background;

ArrayList<Room> adjacentRooms;

public int getAdjacentSetSize() {
	return adjacentRooms.size();
}
//The bus stops are 1-5. If the room is not a bus stop, this is 0.
//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
int BusStop;

HashSet<Partygoer> occupants;
public int getBusStop() {
	return BusStop;
}

public void interactables() {
	HashMap<String, String> Interactable = new HashMap<>(); //Room, Interactable
Interactable.put("Outdoors_1", "Brewing");
Interactable.put("WineCellar", "Brewing");
Interactable.put("Apothecary", "Brewing");
Interactable.put("Kitchen", "Knife");
Interactable.put("Torch", "Balcony");
Interactable.put("Torch", "Cliff");
Interactable.put("Lantern", "Dungeon");
Interactable.put("Oil", "Morgue");
Interactable.put("Money", "Study");
Interactable.put("Coffee", "Kitchen");
Interactable.put("Bandage", "Armory");
Interactable.put("Antidote", "GreenHouse");
//TODO:Finish adding interactables
}

public Room(ArrayList<item> looseStuff, house thehouse, Boolean inDoors, ArrayList<Convos> Interactables, Convos Ritual, ArrayList<Room> adjacentRooms, HashSet<Partygoer> occupants, int BusStop) {
	this.looseStuff = looseStuff;
	this.theHouse = thehouse;
	this.inDoors = inDoors;
	this.Interactables = Interactables;
	this.Ritual = Ritual;
	this.adjacentRooms = adjacentRooms;
	this.occupants = occupants;
	this.BusStop = BusStop;
}
}
//TODO: Need to add interactables in rooms ie. knive set in kitchen, brewing pot in outdoors 1, in wine cellar, apothecary
//Add interactable items in the room that calls the item's function.
//public void brewing(partygoer "TheGuy"){
//if(TheGuy.isplayer()){
//"1. Poison - 6 turns " //if they have the items just show how many turns, and give option to do it. if they don't have the items, write the requirements. does not take any turns to look at these options
//"2. Antidote - 4 turns "
//"3. Perfume - 2 turns "
//On partygoer they should have a counter, they will stay there for however many turns until the poison is made
//}
//else { check current goal to see what they're trying to do

//Interactables in the room will probably use HASHMAP, to assign the rooms as a value for each item.





