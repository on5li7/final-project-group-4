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
			if (user.checkItem(item.NOXIOUS_PLANT)) {
				System.out.print("1) Poison: 6 turns");
			}
			else{
				System.out.print("Poison: Requires poisonous plants");
			}
			if (user.checkItem(item.MEDICINAL_PLANT)) {
				System.out.print("2) Antidote: 4 turns");
			}
			else{
				System.out.print("Antidote: Requires medicinal Plants");
			}
			if (user.checkItem(item.FRAGRANT_PLANT)) {
				System.out.print("Perfume: 2 turns");
			}
			else{
				System.out.print("Perfume: Requires Fragrant Plants");
			}
		}
		else {
			if (user.getGoal() == "Poison") {
				if (user.checkItem(item.NOXIOUS_PLANT)) {
					System.out.print("1) Poison: 6 turns");
				}
				else{
					System.out.print("Poison: Requires poisonous plants");
				}
			}
			else if (user.getGoal() == "Antidote") {
				if (user.checkItem(item.MEDICINAL_PLANT)) {
					System.out.print("2) Antidote: 4 turns");
				}
				else{
					System.out.print("Antidote: Requires medicinal Plants");
				}
			}
			else if (user.getGoal() == "Perfume") {
				if (user.checkItem(item.FRAGRANT_PLANT)) {
					System.out.print("Perfume: 2 turns");
				}
				else{
					System.out.print("Perfume: Requires Fragrant Plants");
				}
			}
			}
		}
	//knife set, has four knives, each PLAYER can only take one. knife1 goes to killer, then we have knife2,3,4 available for the game
	public void Knifeset(Partygoer user) {
		if(user.isPlayer()) {
			System.out.print("Choose an option");
			if (user.checkItem(item.KNIFE1)) {
				System.out.print("1) Grab Knife: 2 turns");
			}
			else {
				System.out.print("Knife: Did not grab knife");
			}
		}
			else {
				if(user.getGoal() == "Murderous") {
					if(user.checkItem(item.KNIFE1)) {
						System.out.print("1) Stab: 3 turns");
					}
				}		
		}
	}
	//drinking, should give strength and charisma but reduce dexterity. For now just a boolean check, no effect on player
	//eating, in dining hall, should change hungry from no to yes
	//for drinking and eating give them a message that tells the user maybe you shouldn't eat or drink so much, there's a killer on the loose
	//workbench, in workshop, where you can build a pistol should take a lot of turns and will be suspicious
	//in workshop, broken_key you can fix to get to the armory, get in the gun case and get the rifle
	public void fix_key(Partygoer user) {
		if(user.currroom == house.Workshop) {
			if(user.checkItem(item.BROKEN_KEY)) {
				System.out.print("You have a broken key, let's fix it?");
			}
			else {
				System.out.print("Nothing for us to do here for now...");
			}
		}
	}
	//riflecase, checks if you have a fixed_key then you can get the rifle
	//conversation interactions between partygoers, will be in partygoer.java, like pushing someone off a cliff when you click them
	//Chandelier in dining hall, you can loosen, with either a wrench or a screwdriver(not both)
	
	//function where a partygoer finds a body, and it displays the how the body was killed, the name of the body, and how long it has been dead.
	
	}
	
	
	


