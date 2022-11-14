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