package edu.pacific.comp55.starter;
import java.util.*;


public class Goals {
	public enum AllGoals {
		BREWINGWITCH, BREWINGCELLAR, BREWINGAPOTHECARY, DRINKINGCELLAR, 
		GOSSIPING, EATING, MOVING,
		DRINKINGKITCHEN, DRINKINGHALL, 
		
	}
	Random rando;
	
	//This needs to be moved to partygoer when it is posted.
	public void Move(Room destination) {
		currroom.partygoers.remove(this);
		this.currroom = destination;
		destination.partygoers.put(this);
	}
	
	public HashSet<Room> Route(Room destination) {
		HashSet<Room> returnedset = new HashSet<Room>; 
		//Checks to see if they are standing in the room
		if (currroom == destination) {
			return null;
		}
		else {
			for (int i; i < currroom.getAdjacentSetSize(); i++) {
				//Checks to see if an adjacent room is the destination.
				if (currroom.getAdjacentRooms().at(i) == destination) {
					returnedset.put(currroom.getAdjacentRooms().at(i));
					return returnedset;
				}
			}
			//Checks the nearest bus stop, and adds the bus route plus the destination to the route.
			for (int i; i < currroom.getAdjacentSetSize(); i++) {
				if (currroom.getAdjacentRooms().at(i).isBusStop()) {
					returnedset.put(currroom.getAdjacentRooms().at(i));
					return returnedset;
				}
			}
			
		}
	}
	
	public Boolean moveOnRoute(HashSet<Room> route) {
		
	}
	
	public void Brewing(partygoer user) {
		if (user.isPlayer()) {
			System.out.print("Choose an option");
			if (user.checkItem("PoisonPlant")) {
				System.out.print("1) Poison: 6 turns");
			}
			else{
				System.out.print("Poison: Requires poisonous plants");
			}
			if (user.checkItem("MedicinalPlant")) {
				System.out.print("2) Antidote: 4 turns");
			}
			else{
				System.out.print("Antidote: Requires medicinal Plants");
			}
			if (user.checkItem("FragrantPlant")) {
				System.out.print("Perfume: 2 turns");
			}
			else{
				System.out.print("Perfume: Requires Fragrant Plants");
			}
		}
		else {
			
		}
	}
	

		
		
		
		
		
		
		
	
	}
}; 