package edu.pacific.comp55.starter;
import java.util.ArrayList;
import java.util.HashSet;


public class Partygoer {
	
	ArrayList<Room> currentRoute;
	Goals currGoal;
	Room currroom;
	house thehouse;
	String identity;
	Boolean isPlayer;
	Boolean isDetective;
	Boolean isKiller;
	
	public void takeTurn() {
		if (isPlayer == true) {
			this.playerTurn();
		}
		else {
			if (!moveOnRoute(currentRoute)) {
				
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
ArrayList<String> Partygoer = new ArrayList<String>();
Partygoer.add("Maximillian"); //Politician (reduces slight fear and gains slight attitude in partygoers in every conversation)
Partygoer.add("Bob"); //Homeless man (Hard to notice and like. Can hide in plain sight and gather info very easily, but the partygoers don’t believe a thing he says. INCLUDING IF HE KNOWS WHO THE KILLER IS. Meaning, if the player chooses to play as him, the player will have to confront the killer themselves.)
Partygoer.add("Frank"); //Sommelier (can’t be poisoned, very friendly and strong when he’s drunk, people always accept a drink from him, except the player, keeps his trusty flask on hand)
Partygoer.add("Zach Riface"); //sacrificed in the opening scene to start the game (player can’t choose him)
Partygoer.add("Chad"); //CEO of big company (Starts with a full inventory of money, which can be used to BRIBE the party. The party will, in turn, bribe each other with this money once they have it.)
Partygoer.add("Todd"); //comes from old money, teenager (as a partygoer, has the highest risk of paranoia and fear, starts with one money, doesn’t need to sleep.)
Partygoer.add("Constable Smithy"); //A retired cop. (starts with the pistol, people don’t mind seeing him armed)
Partygoer.add("Ariana Stocracy"); //A member of high society. Previously poisoned her husband, allegedly (Starts with sedative and antidote if they are the player, poison if they are the killer. Can SEDUCE a person who has full Attitude, mimicking the effects of the lust ritual, yes, this means that as the killer, she can end the game by seducing the player. As the player, she can end the game by seducing the killer.)
Partygoer.add("Doctor Rieklen"); //A renowned surgeon (Can mend injuries and poisonings without any items. This has a chance to fail as this character’s fear rises. Both the player and the killer can play as him, once he’s dead, injuries are permanent, unless healing items are acquired. If he is the killer, or if his fear/attitude sum is high enough, he can perform MALICIOUS MALPRACTICE on characters that come to him for healing, killing them instantly.)
Partygoer.add("Jake of the West"); //Bounty Hunter (Can see through any lies, can detect MOTIVES with just clues.)
Partygoer.add("Gertrude Biblio"); //An occultist librarian (Starts with knowledge of all books in the game, which can be coaxed out of her.)
System.out.println(Partygoer);
}

	public boolean isDetective() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isKiller() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getIdentity() {
		// TODO Auto-generated method stub
		return null;
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

public ArrayList<Room> Route(Room destination) {
	ArrayList<Room> returnedset = new ArrayList<Room>(); 
	//Checks to see if they are standing in the room
	if (currroom == destination) {
		return returnedset;
	}
	else if (currroom.adjacentRooms.contains(destination)){
		returnedset.add(destination);
		return returnedset;
		}
	else {
		int int1 = 0;
		int int2 = 0;
		for (int i=0; i<currroom.adjacentRooms.size(); i++) {
			if (currroom.adjacentRooms.get(i).getBusStop() != 0) {
				returnedset.add(currroom.adjacentRooms.get(i));
				int1 = currroom.adjacentRooms.get(i).getBusStop();
				}
		for (int o=0; o<destination.adjacentRooms.size(); o++) {
				if (destination.adjacentRooms.get(o).getBusStop() != 0) {
					int2 = destination.adjacentRooms.get(o).getBusStop();
				}
			}	//Checks the nearest bus stop, and adds the bus route plus the destination to the route.	
		}
		ArrayList<Room> busRoute = thehouse.busRoute(int1, int2);
		for (int p=0; p<busRoute.size(); p++) {
			returnedset.add(busRoute.get(p));
		}
		return returnedset;
	}
}

public Boolean moveOnRoute(ArrayList<Room> route) {
	if (currentRoute.size() == 0) {
		return false;
	}
	else {
	Room daroom = currentRoute.get(0);
	currentRoute.remove(currentRoute.get(0));
	Move(daroom);
	return true;
	}
}



}

