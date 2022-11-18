package edu.pacific.comp55.starter;

import java.util.Scanner;
import java.util.*;
public class Convos {
	Random rando;
	house House;
	
	public Convos(house House) {
		this.House = House;
	}
	
	public void Brewing(Partygoer user) {
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
			if (user.getGoal() == "Poison") {
				if (user.checkItem("PoisonPlant")) {
					System.out.print("1) Poison: 6 turns");
				}
				else{
					System.out.print("Poison: Requires poisonous plants");
				}
			}
			else if (user.getGoal() == "Antidote") {
				if (user.checkItem("MedicinalPlant")) {
					System.out.print("2) Antidote: 4 turns");
				}
				else{
					System.out.print("Antidote: Requires medicinal Plants");
				}
			}
			else if (user.getGoal() == "Perfume") {
				if (user.checkItem("FragrantPlant")) {
					System.out.print("Perfume: 2 turns");
				}
				else{
					System.out.print("Perfume: Requires Fragrant Plants");
				}
			}
			}
		}
	//knife set, has four knives, each PLAYER can only take one. knife1 goes to killer, then we have knife2,3,4 available for the game
	public void knifeset(Partygoer user) {
		if(user.isPlayer()) {
			System.out.print("Choose an option");
			
		}
	}
	//drinking, should give strength and charisma but reduce dexterity. For now just a boolean check, no effect on player
	//eating, in dining hall, should change hungry from no to yes
	//workbench, in workshop, where you can build a pistol should take a lot of turns and will be suspicious
	//in workshop, broken_key you can fix to get to the armory, get in the gun case and get the rifle
	//riflecase, checks if you have a fixed_key then you can get the rifle
	//conversation interactions between partygoers, will be in partygoer.java, like pushing someone off a cliff when you click them
	//Chandelier in dining hall, you can loosen, with either a wrench or a screwdriver(not both)
	
	//function where a partygoer finds a body, and it displays the how the body was killed, the name of the body, and how long it has been dead.
	
	}
	
	
	


