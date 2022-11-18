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
	}
	
	
	


