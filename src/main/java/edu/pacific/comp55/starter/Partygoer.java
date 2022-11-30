package edu.pacific.comp55.starter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;


public class Partygoer {
	
	ArrayList<Room> currentRoute;
	Goal currGoal;
	Room currroom;
	house thehouse;
	String identity;
	Boolean isPlayer;
	Boolean isDetective;
	Boolean isKiller;
	GoalSets newGoalSets;
	Random rando;
	ArrayList<Goal> allPossibleGoals;
	ArrayList<item> Inventory; //need to set a cap of 4
	
	public Partygoer(String identity, Boolean isKiller, Boolean isDetective, Room startingRoom, house thehouse) {
		this.identity = identity;
		this.isKiller = isKiller;
		this.isDetective = isDetective;
		this.currroom = startingRoom;
		this.thehouse = thehouse;
	}
	
	public static void placeinRoom(Partygoer p, Room r) {
		p.currroom = r;
		r.occupants.add(p);
	}
	
	//This function calls moveonRoute, which will move the character and return true if there is a current route.
	//If moveonRoute is false, the player AI will instead check the room for their goal.
	public void takeTurn() {
		if (isPlayer == true) {
			this.playerTurn();
		}
		else {
			if (moveOnRoute()) {
				
			}
		}
	}
	
	//This is the function that waits for the player to click on something to do something
	//This will instead just take an integer to choose an action in the text version.
	public void playerTurn() {
		
	}
	
	//This function will tell the house to move on to the next character.
	public void endTurn() {
		thehouse.nextPlayer();
	}
	
public static void main(String[] args) {
testMove();
}

	public Boolean isDetective() {
		return isDetective;
	}

	public Boolean isKiller() {
		return isKiller;
	}
	
	public Boolean isPlayer() {
		return isPlayer;
	}

	public String getIdentity() {
		return identity;
	}

	
//Every turn, the partygoer will call moveOnRoute, which will move the character and return true if the route has rooms.
//If moveOnRoute returns false, the ai will call route, which will call move if the character is adjacent.
//If the destination is not adjacent, route will generate a path to the destination, and store it in the ArrayList.
 public void Move(Room destination) {
	currroom.occupants.remove(this);
	this.currroom = destination;
	destination.occupants.add(this);
	this.endTurn();
}

public void Route(Room destination) {
	currentRoute = new ArrayList<Room>(); 
	//Checks to see if they are standing in the room
	if (currroom == destination) {
		System.out.print("Already there!");
		return;
	}
	else if (currroom.adjacentRooms.contains(destination)){
		System.out.print("It's nearby!");
		currentRoute.add(destination);
		return;
		}
	else {
		System.out.print("Need to take the bus...");
		int int1 = thehouse.getBusStop(currroom);
		int int2 = thehouse.getBusStop(destination);
	//Checks the nearest bus stop, and adds the bus route plus the destination to the route.	
		ArrayList<Room> busRoute = thehouse.busRoute(int1, int2);
		for (int p=0; p<busRoute.size(); p++) {
			currentRoute.add(busRoute.get(p));
		}
		if (currentRoute.contains(destination) == false) {
			currentRoute.add(destination);
		}
	}
}

public Boolean moveOnRoute(Room destination) {
	if (currroom.adjacentRooms.contains(destination)) {
		System.out.print("It's right here!");
		currentRoute.remove(destination);
		Move(destination);
		return true;
	}
	else if (currentRoute.size() != 0) {
	Room daroom = currentRoute.get(0);
	currentRoute.remove(currentRoute.get(0));
	Move(daroom);
	return true;
	}
	else {
		return false;
	}
	
}

public static void testMove() {
	System.out.println("Testing move() function");
	house testHouse = new house();
	testHouse.allPartygoers.get(0);
	testHouse.allPartygoers.get(0).Route(testHouse.Balcony);
	System.out.println("Show route from dining hall to balcony " );
	for (int i=0; i < testHouse.allPartygoers.get(0).currentRoute.size(); i++) {
		System.out.print(testHouse.RoomtoString(testHouse.allPartygoers.get(0).currentRoute.get(i)) + ", ");
	}
	System.out.print("\n");
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.Balcony);
	System.out.print("Now to cliff!" + "\n");
	testHouse.allPartygoers.get(0).Route(testHouse.TheCliff);
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.TheCliff);
	System.out.print("Now to dungeon!" + "\n");
	testHouse.allPartygoers.get(0).Route(testHouse.Dungeon);
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.Dungeon);
	System.out.print("Now to wine cellar!" + "\n");
	testHouse.allPartygoers.get(0).Route(testHouse.WineCellar);
	testHouse.allPartygoers.get(0).testMoveOnRoute(testHouse.WineCellar);
}

public void testMoveOnRoute(Room destination) {
while(this.currentRoute.size() > 0 || currentRoute.get(0) != null || this.currroom != destination) {
	System.out.print("Should be true: " + (this.moveOnRoute(destination)) + "\n");
	System.out.print("Current Room: " + (currroom.theHouse.RoomtoString(currroom)) + "\n");
	if (this.currroom == destination) {
	System.out.print("Ended because we got to the destination!");
	return;
	}
	if (this.currentRoute.size() == 0) {
	System.out.print("Ended because route array has no values.");
	return;
	}
	if (this.currentRoute.get(0) == null) {
	System.out.print("Ended because first value in array is null.");
	this.currentRoute = new ArrayList<Room>();
	}
}
	if (currroom == destination) {
		System.out.print("Made it!");
	}
	else {
		System.out.print("Did not make it.");
	}
}

public boolean checkItem(item inputItem) {
	return Inventory.contains(inputItem);
}

public void pickGoal() {
	// TODO Auto-generated method stub
	allPossibleGoals = new ArrayList<Goal>();
	for (int i=0;i<newGoalSets.innocuous.size();i++) {
		allPossibleGoals.add(newGoalSets.innocuous.get(i));
	}
	for (int a=0;a<newGoalSets.sociable.size();a++) {
		allPossibleGoals.add(newGoalSets.sociable.get(a));
	}
	for (int b=0;b<newGoalSets.drinking.size();b++) {
		allPossibleGoals.add(newGoalSets.drinking.get(b));
	}
	for (int c=0;c<newGoalSets.poisonous.size();c++) {
		allPossibleGoals.add(newGoalSets.poisonous.get(c));
	}
	for (int d=0;d<newGoalSets.gathering.size();d++) {
		allPossibleGoals.add(newGoalSets.gathering.get(d));
	}
	for (int e=0;e<newGoalSets.murderous.size();e++) {
		allPossibleGoals.add(newGoalSets.murderous.get(e));
	}
	for (int f=0;f<newGoalSets.rituals.size();f++) {
		allPossibleGoals.add(newGoalSets.rituals.get(f));
	}
	currGoal = allPossibleGoals.get(rando.nextInt(allPossibleGoals.size()));
}

public Room GoalInterpLocation(Goal goal) {
	currGoal = goal;
	if (goal==Goal.BREWING_POISON_WITCH||goal==Goal.BREWING_ANTIDOTE_WITCH||goal==Goal.BREWING_PERFUME_WITCH||goal==Goal.BREWING_KO_WITCH) {
		return thehouse.Outdoors_1;
	}
	else if (goal==Goal.BREWING_POISON_CELLAR||goal==Goal.BREWING_ANTIDOTE_CELLAR||goal==Goal.BREWING_PERFUME_CELLAR||goal==Goal.BREWING_KO_CELLAR
			||goal==Goal.POISON_WINE_CELLAR||goal==Goal.GATHER_ALCOHOL||goal==Goal.DRINKING_CELLAR) {
		return thehouse.WineCellar;
	}
	else if (goal==Goal.BREWING_POISON_APOTH||goal==Goal.BREWING_ANTIDOTE_APOTH||goal==Goal.BREWING_PERFUME_APOTH||goal==Goal.BREWING_KO_APOTH) {
		return thehouse.Apothecary;
	}
	else if (goal==Goal.CRAFTING_LOCKPICK||goal==Goal.CRAFTING_PISTOL||goal==Goal.MAKE_BOMB) {
		return thehouse.Workshop;
	}
	else if (goal==Goal.GET_FRAGRANT_PLANT_GREENHOUSE||goal==Goal.GET_POISONOUS_PLANT_GREENHOUSE||goal==Goal.GET_NOXIOUS_PLANT_GREENHOUSE) {
		return thehouse.GreenHouse;
	}
	else if (goal==Goal.GET_FRAGRANT_PLANT_OUTDOORS) {
		return thehouse.Outdoors_2;
	}
	else if (goal==Goal.GET_NOXIOUS_PLANT_OUTDOORS) {
		return thehouse.Outdoors_3;
	}
	else if (goal==Goal.GET_POISONOUS_PLANT_OUTDOORS) {
		return thehouse.Outdoors_4;
	}
	else if (goal==Goal.POISON_WINE_KITCHEN||goal==Goal.DRINKING_KITCHEN||goal==Goal.POISON_FOOD) {
		return thehouse.Kitchen;
	}
	else if (goal==Goal.DRINKING_HALL||goal==Goal.LOOSEN_CHANDELIER) {
		return thehouse.DiningHall;
	}
	else if (goal==Goal.BALCONY_STALKER||goal==Goal.LOOSEN_BALCONY) {
		return thehouse.Balcony;
	}
	else if (goal==Goal.CLIFF_STALKER) {
		return thehouse.TheCliff;
	}
	return null;
}



}

