package edu.pacific.comp55.starter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.pacific.comp55.starter.Rituals.effect;


public class Partygoer {
	
	public ArrayList<Fact> fingerprints;
	public ArrayList<Room> currentRoute;
	public ArrayList<Fact> knownFacts;
	public ArrayList<Fact> evidence;
	Goal currGoal;
	Goal heldGoal;
	int busynum;
	public ArrayList<Rituals> knownRituals = new ArrayList<Rituals>();
	int aggronum;
	Room currroom;
	house thehouse;
	String identity;
	Boolean isPlayer;
	Boolean isDetective;
	Boolean isKiller;
	Boolean Bloodied;
	Boolean Dead;
	Scanner userinput;
	GoalSets newGoalSets;
	Random rando;
	public ArrayList<Goal> allPossibleGoals;
	public ArrayList<item> Inventory; //need to set a cap of 4
	//BusyCounter
	public Boolean isArrested;
	
	//add getClue() which takes addtoKnownFact from Partygoer to make the madlibs
	public Partygoer(String identity, Boolean isKiller, Boolean isDetective, Room startingRoom, house thehouse) {
		this.identity = identity;
		this.isKiller = isKiller;
		this.busynum = 0;
		this.aggronum = 0;
		this.Dead = false;
		this.Bloodied = false;
		this.rando = new Random();
		this.isPlayer = false;
		this.isArrested = false;
		this.isKiller = false;
		this.isDetective = isDetective;
		this.knownRituals = new ArrayList<Rituals>();
		this.newGoalSets = new GoalSets();
		this.Inventory = new ArrayList<item>();
		this.fingerprints = new ArrayList<Fact>();
		this.evidence = new ArrayList<Fact>();
		this.currroom = startingRoom;
		this.thehouse = thehouse;
		this.currentRoute = new ArrayList<Room>();
		this.allPossibleGoals = new ArrayList<Goal>();
	}

	
	public void placeinRoom(Partygoer p, Room r) {
		p.currroom = r;
		r.occupants.add(p);
	}
	
	public Fact physicalEvidence(Fact inputfact) {
		Fact returnfact = inputfact;
		if (thehouse.getTime() > inputfact.getTime()+10) {
			returnfact.setTime(0);
		}
		fingerprints.add(inputfact);
		returnfact.instigator = null;
		return returnfact;
	}
	
	public Boolean addItem(item addeditem, ArrayList<item> source) {
				if ((source == this.Inventory && source.size() < 4) || (source == this.currroom.looseStuff && this.currroom.looseStuff.size() < 5)) {
				source.add(addeditem);
				}
			else {
				discardItem(addeditem, source);
			}
				return true;
		}
	
	public void discardItem(item inputitem, ArrayList<item> source) {
		if (isPlayer == true && source != currroom.looseStuff) {
			System.out.print("Choose Item to discard \n");
			System.out.print("1. " + source.get(0).toString());
			System.out.print("2. " + source.get(1).toString());
			System.out.print("3. " + source.get(2).toString());
			System.out.print("4. " + source.get(3).toString());
			System.out.print("5. " + "Keep your items, drop " + inputitem.toString() + " instead");
			String response = userinput.nextLine();
			if (response == "1") {
				source.remove(source.get(0));
				source.add(inputitem);
				addItem(inputitem, currroom.looseStuff);
			}
			else if (response == "2") {
				source.remove(source.get(1));
			}
			else if (response == "3") {
				source.remove(source.get(2));
			}
			else if (response == "4") {
				source.remove(source.get(3));
			}
			else if (response == "5") {
			addItem(inputitem, currroom.looseStuff);
			}
			else {
				discardItem(inputitem, source);
			}
		}
			else {
				source.remove(rando.nextInt(source.size()));
				source.add(inputitem);
				}
		}
	
	//This function calls moveonRoute, which will move the character and return true if there is a current route.
	//If moveonRoute is false, the player AI will instead check the room for their goal.
	public void f() {
		if (Dead) {
			return;
		}
		if (busynum != 0) {
			busynum--;
			return;
		}
		if (isPlayer == true) {
			this.playerTurn();
		}
		else {
			//AI TURN FOLLOWS
			if (currGoal == Goal.HARDROUTE) {
				if(currentRoute.size() == 0) {
					currGoal = heldGoal;
					heldGoal = null;
				}
				else {
					moveOnRoute(currentRoute.get(0));
					return;
				}
			}
			if (aggronum != 0) {
				if (aggronum == 1) {
				pickGoal();
				aggronum = 0;
				}
				else {
					if (currroom.occupants.size() == 2) {
						if (currroom.occupants.get(0) == this) {
							assault(this, currroom.occupants.get(1));
						}
						else {
							assault(this, currroom.occupants.get(0));
						}
					}
					else {
						Move(currroom.adjacentRooms.get(rando.nextInt(currroom.adjacentRooms.size())));
					}
					return;
				}
			}
			//AI TURN AFTER CHECKS
			if (currGoal == null) {
				pickGoal();
			}
			if (doGoal()) {
				return;
			}
			if(currentRoute.size() == 0) {
			Route(GoalInterpLocation(currGoal));
			}
			moveOnRoute(GoalInterpLocation(currGoal));
		}
	}
	
	public Boolean fingerPrintCheck(Partygoer unsub) {
		for (int i=0; i < fingerprints.size(); i++) {
			if (fingerprints.get(i).instigator == unsub) {
				return true;
			}
		}
		return false;
	}
	
	public Boolean doGoal() {
		if (currGoal == Goal.BREWING_ANTIDOTE_APOTH || currGoal == Goal.BREWING_ANTIDOTE_CELLAR || 
				currGoal == Goal.BREWING_ANTIDOTE_WITCH || currGoal == Goal.BREWING_KO_APOTH || 
				currGoal == Goal.BREWING_KO_CELLAR || currGoal == Goal.BREWING_KO_WITCH || 
				currGoal == Goal.BREWING_PERFUME_APOTH || 
				currGoal == Goal.BREWING_PERFUME_CELLAR || currGoal == Goal.BREWING_PERFUME_WITCH || 
				currGoal == Goal.BREWING_POISON_APOTH || currGoal == Goal.BREWING_POISON_CELLAR || 
				currGoal == Goal.BREWING_POISON_WITCH) {
			if (currroom == thehouse.WineCellar || currroom == thehouse.Apothecary || currroom == thehouse.Outdoors_1) {
				this.thehouse.Brewing(this);
				return true;
			}
			else {
				return false;
			}
		}
		else if (currGoal == Goal.GET_FRAGRANT_PLANT_GREENHOUSE || currGoal == Goal.GET_NOXIOUS_PLANT_GREENHOUSE 
				|| currGoal == Goal.GET_POISONOUS_PLANT_GREENHOUSE || currGoal == Goal.GET_MEDICINAL_PLANT_GREENHOUSE) {
			if (currroom == thehouse.GreenHouse) {
				currGoal = Goal.RANSACK;
			}
			else {
				return false;
			}
		}
		else if (currGoal == Goal.DRINKING_CELLAR || currGoal == Goal.DRINKING_HALL 
				|| currGoal == Goal.DRINKING_KITCHEN) {
			if (currroom == thehouse.WineCellar || currroom == thehouse.Kitchen || currroom == thehouse.DiningHall) {
			thehouse.eat(this);
			return true;
			}
			else {
			return false;
			}
		}
		else if (currGoal == Goal.CRAFTING_BOMB || currGoal == Goal.CRAFTING_LOCKPICK 
				|| currGoal == Goal.CRAFTING_LOCKPICK || currGoal == Goal.FIX_KEY) {
			if (currroom == thehouse.Workshop) {
			thehouse.workbench(this);
			return true;
				}
			else {
				return false;
				}
			}
		else if (currGoal == Goal.RANSACK) {
			addItem(Ransack(), Inventory);
			return true;
		}
		else if (currGoal == Goal.EATING) {
			if (currroom == thehouse.DiningHall) {
			thehouse.eat(this);
			return true;
			}
			else {
				return false;
			}
		}
		else if (currGoal == Goal.OOHSHINY) {
		if (currroom.looseStuff.isEmpty()) {
			return false;
		}
		else {
			Inventory.add(currroom.looseStuff.get(rando.nextInt(currroom.looseStuff.size())));
			return true;
		}
		}
		else if (currGoal == Goal.POISON_FOOD) {
			if (Inventory.contains(item.TREE_FROG_VENOM) || Inventory.contains(item.POISON)) {
				if (currroom == thehouse.Kitchen) {
					thehouse.poisoning(this);
					return true;
				}
				else {
					return false;
				}
			}
				else {
					int check = rando.nextInt(2);
					if (check == 0) {
					currGoal = Goal.GET_POISONOUS_PLANT_GREENHOUSE;
					}
					if (check == 1) {
					currGoal = Goal.GET_POISONOUS_PLANT_OUTDOORS;
					}
					return doGoal();
				}
		}
		else if (currGoal == Goal.POISON_WINE_CELLAR || currGoal == Goal.POISON_WINE_KITCHEN) {
			if (Inventory.contains(item.TREE_FROG_VENOM) || Inventory.contains(item.POISON)) {
				if (currroom == thehouse.Kitchen) {
					thehouse.KitchenWinePoison = true;
					return true;
				}
				else if (currroom == thehouse.WineCellar) {
					thehouse.CellarWinePoison = true;
					return true;
				}
				else {
					return false;
				}
			}
				else {
					int check = rando.nextInt(2);
					if (check == 0) {
					currGoal = Goal.GET_POISONOUS_PLANT_GREENHOUSE;
					}
					if (check == 1) {
					currGoal = Goal.GET_POISONOUS_PLANT_OUTDOORS;
					}
					return doGoal();
				}
		}
		else if (currGoal == Goal.CAST_RITUAL_BALCONY || currGoal == Goal.CAST_RITUAL_OD1 
				|| currGoal == Goal.CAST_RITUAL_OD2 || currGoal == Goal.CAST_RITUAL_OD3 ||
					currGoal == Goal.CAST_RITUAL_OD4) {
					if (castRitual() == false) {
						currGoal = Goal.RANSACK;
					};
		}
		return false;
	}
	
	
	
	public Boolean castRitual() {
		if(currroom == thehouse.Balcony || currroom == thehouse.TheCliff || currroom == thehouse.Outdoors_1
		|| currroom == thehouse.Outdoors_2 || currroom == thehouse.Outdoors_3 || currroom == thehouse.Outdoors_4)
		{
		int ritualnum = rando.nextInt(knownRituals.size());
		int PGcheck = rando.nextInt(thehouse.allPartygoers.size());
		if (Inventory.contains(knownRituals.get(ritualnum).item1) && 
			Inventory.contains(knownRituals.get(ritualnum).item2)) {
					if (isKiller) {
						while (thehouse.allPartygoers.get(PGcheck) == this || thehouse.allPartygoers.get(PGcheck).Dead) {
							PGcheck = rando.nextInt(thehouse.allPartygoers.size());
						}
						thehouse.allPartygoers.get(PGcheck).Dead = true;
						thehouse.deadpeople++;
					}
					else if (thehouse.deadpeople >= 1){
						while (thehouse.allPartygoers.get(PGcheck).Dead == false && thehouse.deadpeople >= 1) {
							PGcheck = rando.nextInt(thehouse.allPartygoers.size());
						}
						thehouse.allPartygoers.get(PGcheck).Dead = false;
						thehouse.deadpeople--;	
					}
					else {
						return false;
					}
		}
					else {
					return false;
					}
						
				Fact ritualfact = new Fact(thehouse.factcounter);
				thehouse.factcounter++;
				ritualfact.theevent = (" cast a spell, ");
				if(knownRituals.get(ritualnum).Spell == effect.KILL) {
					ritualfact.theevent = ritualfact.theevent + "killing " + ritualfact.victims.add(thehouse.allPartygoers.get(PGcheck));
				}
				else if(knownRituals.get(ritualnum).Spell == effect.REVIVE) {
					ritualfact.theevent = ritualfact.theevent + "reviving " + ritualfact.victims.add(thehouse.allPartygoers.get(PGcheck));
				}
				ritualfact.Room = currroom;
				ritualfact.thetime = thehouse.getTime();
				ritualfact.instigator = this;
				if (knownRituals.get(ritualnum).Spell == effect.KILL) {
					ritualfact.incriminating = true;
				}
				else if (knownRituals.get(ritualnum).Spell == effect.REVIVE) {
					ritualfact.incriminating = false;
				}
				currroom.clues.add(ritualfact);
				return true;
				}
		else {
			return false;
		}
	}
			

		public void assault(Partygoer attacker, Partygoer defender) {
			int attackerstr = 0;
			int defenderstr = 0;
			if (attacker.Inventory.contains(item.RIFLE)) {
				attackerstr = 4;
			}
			else if (attacker.Inventory.contains(item.PISTOL)) {
				attackerstr = 3;
			}
			else if (attacker.Inventory.contains(item.SWORD) ) {
				attackerstr = 2;
			}
			else if (attacker.Inventory.contains(item.KNIFE)) {
			attackerstr = 1;	
			}
			if (attacker.isKiller && attackerstr == 1) {
				attackerstr = 2;
			}
			if (defender.Inventory.contains(item.RIFLE)) {
				defenderstr = 4;
			}
			else if (defender.Inventory.contains(item.PISTOL)) {
				defenderstr = 3;
			}
			else if (defender.Inventory.contains(item.SWORD) ) {
				defenderstr = 2;
			}
			else if (defender.Inventory.contains(item.KNIFE)) {
			defenderstr = 1;	
			}
			if (defender.isKiller && defenderstr == 1) {
				defenderstr = 2;
			}
			
			if (defenderstr > attackerstr) {
				attacker.Dead = true;
				defender.Bloodied = true;
				defender.currGoal = Goal.CLEANUP_KITCHEN;
				Fact newFact = new Fact(thehouse.factcounter);
				thehouse.factcounter++;
				newFact.setInstigator(defender);
				newFact.setTheEvent("murder");
				newFact.motive = Goal.DEFENSIVE_KILL;
				newFact.victims.add(attacker);
				newFact.thetime = thehouse.getTime();
				newFact.incriminating = false;
				newFact.Room = currroom;
				if(defender.Inventory.contains(item.SWORD)) {
					defender.Inventory.remove(item.SWORD);
					defender.Inventory.add(item.BLOODY_SWORD);
				}
				if(defender.Inventory.contains(item.KNIFE)) {
					defender.Inventory.remove(item.KNIFE);
					defender.Inventory.add(item.BLOODY_KNIFE);
				}
			}
			else if (defenderstr <= attackerstr) {
				defender.Dead = true;
				attacker.Bloodied = true;
				attacker.currGoal = Goal.CLEANUP_KITCHEN;
				Fact newFact = new Fact(thehouse.factcounter);
				thehouse.factcounter++;
				newFact.setInstigator(attacker);
				newFact.setTheEvent("murder");
				newFact.motive = Goal.DEFENSIVE_KILL;
				newFact.victims.add(defender);
				newFact.thetime = thehouse.getTime();
				newFact.incriminating = false;
				newFact.Room = currroom;
				if(attacker.Inventory.contains(item.SWORD)) {
					attacker.Inventory.remove(item.SWORD);
					attacker.Inventory.add(item.BLOODY_SWORD);
				}
				if(attacker.Inventory.contains(item.KNIFE)) {
					attacker.Inventory.remove(item.KNIFE);
					attacker.Inventory.add(item.BLOODY_KNIFE);
				}
			}
		}
		
		
		public item Ransack() {
			busynum = 3;
			int check = rando.nextInt(4);
			if (currroom == thehouse.DiningHall) {
				if (check == 0) {
					return item.BRIMSTONE;
				}
				if (check == 1) {
					return item.BISMUTH;
				}
				if (check == 2) {
					return item.BROKEN_KEY;
				}
				if (check == 3) {
					return item.COFFEE;
				}
			}
		else if (currroom == thehouse.Balcony) {
				if (check == 0) {
					return item.HEMLOCK;
				}
				if (check == 1) {
					return item.MONEY;
				}
				if (check == 2) {
				return item.JADE_STONE;
				}
				if (check == 3) {
				return item.SPIDER;
				}
			}
		else if (currroom == thehouse.Apothecary) {
			if (check == 0) {
				return item.ANTIDOTE;
			}
			if (check == 1) {
				return item.BANDAGE;
			}
			if (check == 2) {
			return item.SEDATIVES;
			}
			if (check == 3) {
			return item.CHLOROFORM;
			}
		}
			else if (currroom == thehouse.TheStudy) {
				if (check == 0) {
					return item.RITES_OF_THE_HORSEMAN;
				}
				if (check == 1) {
					return item.FAE_JOKE_BOOK;
				}
				if (check == 2) {
				return item.THE_7_RITES_OF_RUIN;
				}
				if (check == 3) {
				return item.FAMILIARS;
				}
			}
				else if (currroom == thehouse.Morgue) {
					if (check == 0) {
						return item.CHLOROFORM;
					}
					if (check == 1) {
						return item.ANTIDOTE;
					}
					if (check == 2) {
					return item.SKULL;
					}
					if (check == 3) {
					return item.GOAT_HEAD;
					}
				}
			else if (currroom == thehouse.Armory) {
				if (check == 0) {
					return item.TORCH;
				}
				if (check == 1) {
					return item.OLD_PICTURE;
				}
				if (check == 2) {
				return item.DAGGER;
				}
				if (check == 3) {
				return item.SWORD;
				}
			}
				else if (currroom == thehouse.Dungeon) {
					if (check == 0) {
						return item.POISON;
					}
					if (check == 1) {
						return item.FIRST_AID_KIT;
					}
					if (check == 2) {
					return item.RAT;
					}
					if (check == 3) {
					return item.SKULL;
					}
				}
				else if (currroom == thehouse.Workshop) {
					if (check == 0) {
						return item.WRENCH;
					}
					if (check == 1) {
						return item.SCREWDRIVER;
					}
					if (check == 2) {
					return item.BROKEN_KEY;
					}
					if (check == 3) {
					return item.TORCH;
					}
				}
				else if (currroom == thehouse.Bedroom_1 || currroom == thehouse.Bedroom_2 || currroom == thehouse.Bedroom_3 || currroom == thehouse.Bedroom_4 || currroom == thehouse.Bedroom_5 || currroom == thehouse.Bedroom_6 || currroom == thehouse.Bedroom_7 || currroom == thehouse.Bedroom_8 || currroom == thehouse.Bedroom_9 || currroom == thehouse.Bedroom_10) {
						if (check == 0) {
							return item.COBWEB;
						}
						if (check == 1) {
							return item.GOAT_HEAD;
						}
						if (check == 2) {
						return item.DOLL;
						}
						if (check == 3) {
						return item.SPIDER;
						}
				}
				else if (currroom == thehouse.Hallway) {
					if (check == 0) {
						return item.WRENCH;
					}
					if (check == 1) {
						return item.SCREWDRIVER;
					}
					if (check == 2) {
					return item.BROKEN_KEY;
					}
					if (check == 3) {
					return item.TORCH;
					}
				}
					else if (currroom == thehouse.WineCellar) {
						if (check == 0) {
							return item.RAT;
						}
						if (check == 1) {
							return item.OIL;
						}
						if (check == 2) {
						return item.LANTERN;
						}
						if (check == 3) {
						return item.CLOVE_OF_GARLIC;
						}
					}
					else if (currroom == thehouse.Kitchen) {
						if (check == 0) {
							return item.OIL;
						}
						if (check == 1) {
							return item.COFFEE;
						}
						if (check == 2) {
						return item.RAT;
						}
						if (check == 3) {
						return item.ROACH;
						}
			}
					else if (currroom == thehouse.GreenHouse) {
						if (check == 0) {
							return item.FRAGRANT_PLANT;
						}
						if (check == 1) {
							return item.MEDICINAL_PLANT;
						}
						if (check == 2) {
						return item.NOXIOUS_PLANT;
						}
						if (check == 3) {
						return item.HEMLOCK;
						}
					}
						else if (currroom == thehouse.Outdoors_1) {
							if (check == 0) {
								return item.EYE_OF_NEWT;
							}
							if (check == 1) {
								return item.DEMON_TOOTH;
							}
							if (check == 2) {
							return item.MEDICINAL_PLANT;
							}
							if (check == 3) {
							return item.THE_7_RITES_OF_RUIN;
							}
						}
							else if (currroom == thehouse.Outdoors_2) {
								if (check == 0) {
									return item.ROACH;
								}
								if (check == 1) {
									return item.RAT;
								}
								if (check == 2) {
								return item.LANTERN;
								}
								if (check == 3) {
								return item.NOXIOUS_PLANT;
								}
							}
								else if (currroom == thehouse.Outdoors_3) {
									if (check == 0) {
										return item.JADE_STONE;
									}
									if (check == 1) {
										return item.BISMUTH;
									}
									if (check == 2) {
									return item.DAGGER;
									}
									if (check == 3) {
									return item.HEMLOCK;
									}
								}
								else if (currroom == thehouse.Outdoors_4) {
										if (check == 0) {
											return item.FRAGRANT_PLANT;
										}
										if (check == 1) {
											return item.LANTERN;
										}
										if (check == 2) {
										return item.URN;
										}
										if (check == 3) {
										return item.SKULL;
										}
									}
								else if (currroom == thehouse.TheCliff) {
									if (check == 0) {
										return item.THE_DEMONS_LEGEND;
									}
									if (check == 1) {
										return item.SKULL;
									}
									if (check == 2) {
									return item.FEMUR;
									}
									if (check == 3) {
									return item.SENTIMENTAL_PEN;
									}
								}
								
									return item.RAT;
								
					}
		
	
	
	//This is the function that waits for the player to click on something to do something
	//This will instead just take an integer to choose an action in the text version.
	public void playerTurn() {
		Scanner input = new Scanner(System.in);
		ArrayList<Object> methodList = new ArrayList<Object>();
		//Adds moves
		int choicenum = 1;
		System.out.print(choicenum + ". search the room for something useful.");
		methodList.add(Ransack());
		for (int i=0; i < currroom.adjacentRooms.size(); i++) {
			choicenum++;
			methodList.add(Move(currroom.adjacentRooms.get(i)));
			System.out.print(choicenum + ". move to the " + thehouse.RoomtoString(currroom.adjacentRooms.get(i)));
		}
		//Adds the knifeset
		if (currroom == thehouse.Kitchen|| thehouse.knifeset.size() != 0) {
			choicenum++;
			System.out.print(choicenum + ". Grab a knife.");
			methodList.add(thehouse.Knifeset(this));
		}
		if (currroom == thehouse.Kitchen|| thehouse.knifeset.size() == 0) {
			System.out.print("No more knives!");
		}
		//Adds the clues.
		for (int i = 0; i<currroom.clues.size(); i++) {
			choicenum++;
			System.out.print(choicenum + ". A clue!");
			methodList.add(getClue(currroom.clues.get(i)));
		}
		if (currroom == thehouse.Apothecary || currroom ==  thehouse.Outdoors_3 || currroom == thehouse.WineCellar) {
			choicenum++;
			methodList.add(thehouse.Brewing(this));
			System.out.print(choicenum + " Brew a potion ");
			if (currroom == thehouse.Apothecary) {
				System.out.print("with the mortar and pestle.");
			}
			if (currroom == thehouse.Outdoors_3) {
				System.out.print("in the witch's pot.");
			}
			if (currroom == thehouse.WineCellar) {
				System.out.print("in the still.");
			}
			System.out.print("\n");
		}
		//Rifleset
		if (currroom == thehouse.Armory) {
			if (Inventory.contains(item.FIXED_KEY)) {
				choicenum++;
				System.out.print(choicenum + " Get a rifle? You have the key!");
				methodList.add(addItem(item.RIFLE, Inventory));
			}
		}
		
		//Adds the loose trash in the room.
		for (int i=0; i<currroom.looseStuff.size(); i++) {
			choicenum++;
			System.out.print(choicenum + "somebody just left a " + currroom.looseStuff.get(i).toString() + " here...");
			methodList.add(addItem(currroom.looseStuff.get(i), Inventory));
		}
		if (currroom == thehouse.TheCliff) {
			for (int i=0; i < currroom.occupants.size(); i++) {
				if (currroom.occupants.get(i) != this) {
					choicenum++;
					System.out.print(choicenum + ". Push " + currroom.occupants.get(i).identity + " off the cliff?");
					methodList.add(cliffPush(currroom.occupants.get(i)));
				}
			}
		}
		//Workbench
		if (currroom == thehouse.Workshop) {
			choicenum++;
			System.out.print(choicenum + ". craft something at the workbench.");
			methodList.add(thehouse.workbench(this));
		}
		for (int i=0; i<currroom.occupants.size(); i++) {
			if (currroom.occupants.get(i) != this) {
				choicenum++;
				System.out.print("Talk to " + currroom.occupants.get(i).identity);
				methodList.add(converse(currroom.occupants.get(i)));
			}
		}
		int choice = input.nextInt();
		if (choice > methodList.size() || choice < 0) {
			input.close();
			playerTurn();
		}
		else {
			methodList.get(choice);
		}
		input.close();
	}
	
	
	public Boolean converse(Partygoer pg2) {
				System.out.print("Choose an action");
				System.out.print("1) Check " + pg2.identity + "'s fingerprints");
				System.out.print("2) Gossip with " + pg2.identity);
				System.out.print("3) Search pockets of" + pg2.identity);
				if (pg2.evidence.size() >= 5) {
					System.out.print("4) Arrest " + pg2.identity);
				}
				try (Scanner inputChoice = new Scanner(System.in)) {
					int userChoice = inputChoice.nextInt();
					System.out.println("You entered " + userChoice);
					if (userChoice==1) {
						fingerPrintCheck(pg2);
					}
					else if (userChoice==2) {
						gossip(pg2);
					}
					else if (userChoice==3) {
						search(pg2);
					}
					else if (userChoice==4) {
						if (fingerPrintCheck(pg2)) {
							System.out.print(pg2.identity + "'s fingerprints match the instigator's!");
							thehouse.factcounter++;
							for(int i=0; i<5; i++) {
							evidence.add(new Fact(thehouse.factcounter));	
							}
						}
						else {
							System.out.print(pg2.identity + "'s fingerprints do not match the instigator's.");
						}
					}
					else {
						System.out.print("Make another choice!");
						converse(pg2);
					}
				}
				return true;
			}

public Boolean gossip(Partygoer pg2) {
	int checkNum1 = 0;
	int checkNum2 = 0;
	int checkNum3 = 0;
	int randoInt = 0;
	while (checkNum1==0||checkNum2==0||checkNum3==0) {
		randoInt = rando.nextInt(5) + 1;
		if (randoInt==checkNum1||randoInt==checkNum2||randoInt==checkNum3) {
			if (checkNum1==0) {
				checkNum1 = randoInt;
			}
			else if (checkNum2==0) {
				checkNum2 = randoInt;
			}
			else if (checkNum3==0) {
				checkNum3 = randoInt;
			}
		}
	}
	thehouse.factcounter++;
	Fact newFact = new Fact(thehouse.factcounter);
	int knowngossip = rando.nextInt(pg2.knownFacts.size());
	if (checkNum1 == 1 || checkNum2 == 1|| checkNum3 == 1) {
		newFact.setInstigator(knownFacts.get(knowngossip).getInstigator());
	}
	if (checkNum1 == 2 || checkNum2 == 2 || checkNum3 == 2) {
		newFact.theevent = knownFacts.get(knowngossip).theevent;
	}
	if (checkNum1 == 3 || checkNum2 == 3 || checkNum3 == 3) {
		newFact.thetime = knownFacts.get(knowngossip).thetime;
	}
	if (checkNum1 == 4 || checkNum2 == 4 || checkNum3 == 4) {
		newFact.Room = knownFacts.get(knowngossip).Room;
	}
	if (checkNum1 == 5 || checkNum2 == 5 || checkNum3 == 5) {
		newFact.Room = knownFacts.get(knowngossip).Room;
	}
	System.out.print("You learned a new fact about " + pg2.identity + "!");
	return true;
}

public Boolean arrest(Partygoer partygoer) {
	if (partygoer.evidence.size()==5) {
		System.out.print(partygoer.identity + " is arrested!");
		partygoer.placeinRoom(partygoer, thehouse.Dungeon);
		partygoer.Dead = true;
		return partygoer.Dead;
	}
	else {
		System.out.print("Not enough evidence. Cannot arrest " + partygoer.identity + ".");
		partygoer.Dead = false;
		return partygoer.Dead;
	}
}


public Boolean search(Partygoer partygoer) {
	System.out.print("Searching " + partygoer.identity + "\n");

	if (partygoer.Inventory.size()==0) {
		System.out.print(partygoer.identity + "'s pockets are empty");
		return false;
	}
	else {
		System.out.print(partygoer.identity + "'s pockets contain: \n");
		for (int i=0;i<partygoer.Inventory.size();i++) {
			System.out.print((i+1) + ": " + partygoer.Inventory.get(i).toString()+ "\n");
		}
		for (int i=0; i<knownFacts.size(); i++) {
			if (knownFacts.get(i).theevent == "stabbing" && (partygoer.Inventory.contains(item.BLOODY_KNIFE)) || partygoer
					.Inventory.contains(item.BLOODY_SWORD)) {
				System.out.print("Caught red handed!");
				for (int o=0; o<5; o++) {
					partygoer.evidence.add(knownFacts.get(i));
				}
				return true;
			}
		}
	}
	return true;
}

	
	public Boolean cliffPush(Partygoer victim) {
		victim.Dead = true;
		victim.currroom.occupants.remove(victim);
		return victim.Dead;
	}
	
	
	public Boolean getClue(Fact inputfact) {
		busynum = 2;
		for (int i=0; i<knownFacts.size(); i++) {
			if (knownFacts.get(i).getID() == inputfact.getID()) {
				knownFacts.get(i).addToKnownFact(inputfact);
				return true;
			}
		}
			return false;
	}
	
	public void printFact(Fact inputfact) {
		if (inputfact.instigator == null) {
		System.out.print("somebody ");
		}
		else {
			System.out.print(inputfact.instigator.identity + " ");
		}
		if (inputfact.theevent == null) {
			System.out.print("did something ");
		}
		else if (inputfact.theevent != null && inputfact.incriminating) {
			System.out.print("commited " + inputfact.theevent);
		}
		else if (inputfact.theevent != null && inputfact.incriminating == false) {
			System.out.print("did " + inputfact.theevent);
		}
		if(inputfact.roomislie == null) {
			System.out.print("somewhere");
		}
		else {
			System.out.print(" in the " + thehouse.RoomtoString(currroom));
		}
		if (inputfact.thetime == 0) {
			System.out.print(" at some point ");
		}
		else {
			System.out.print("on turn " + inputfact.thetime);
		}
		if (inputfact.victims.size() != 0 || inputfact.incriminating == true) {
			for (int i=0; i<inputfact.victims.size(); i++) {
				System.out.print(" to poor " + inputfact.victims.get(i) + "! And");
			}
			System.out.print(" they won't get away with it!");
		}
	}

	
//Every turn, the partygoer will call moveOnRoute, which will move the character and return true if the route has rooms.
//If moveOnRoute returns false, the ai will call route, which will call move if the character is adjacent.
//If the destination is not adjacent, route will generate a path to the destination, and store it in the ArrayList.
 public Boolean Move(Room destination) {
	currroom.occupants.remove(this);
	this.currroom = destination;
	destination.occupants.add(this);
	return true;
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
	if (currentRoute.get(0) == null) {
		System.out.print("Null destination. Wandering.");
		Move(currroom.adjacentRooms.get(rando.nextInt(currroom.adjacentRooms.size())));
		currentRoute.remove(currentRoute.get(0));
		return true;
	}
	else if (currroom.adjacentRooms.contains(destination)) {
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

public void pickGoal() {
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
	if (isKiller) {
	for (int c=0;c<newGoalSets.poisonous.size();c++) {
		allPossibleGoals.add(newGoalSets.poisonous.get(c));
	}
	}
	for (int d=0;d<newGoalSets.gathering.size();d++) {
		allPossibleGoals.add(newGoalSets.gathering.get(d));
	}
	if (isKiller) {
	for (int e=0;e<newGoalSets.murderous.size();e++) {
		allPossibleGoals.add(newGoalSets.murderous.get(e));
		}
	}
	for (int f=0;f<newGoalSets.rituals.size();f++) {
		allPossibleGoals.add(newGoalSets.rituals.get(f));
	}
	currGoal = allPossibleGoals.get(rando.nextInt(allPossibleGoals.size()));
}

public Room GoalInterpLocation(Goal goal) {
	currGoal = goal;
	if (goal==Goal.BREWING_POISON_WITCH||goal==Goal.BREWING_ANTIDOTE_WITCH||
		goal==Goal.BREWING_PERFUME_WITCH||goal==Goal.BREWING_KO_WITCH
		||goal==Goal.CAST_RITUAL_OD1 || goal==Goal.GET_MEDICINAL_PLANT_OUTDOORS) {
		return thehouse.Outdoors_1;
	}
	else if (goal==Goal.BREWING_POISON_CELLAR||goal==Goal.BREWING_ANTIDOTE_CELLAR||
			goal==Goal.BREWING_PERFUME_CELLAR||goal==Goal.BREWING_KO_CELLAR
			||goal==Goal.POISON_WINE_CELLAR||goal==Goal.DRINKING_CELLAR) {
		return thehouse.WineCellar;
	}
	else if (goal==Goal.BREWING_POISON_APOTH||goal==Goal.BREWING_ANTIDOTE_APOTH||
			goal==Goal.BREWING_PERFUME_APOTH||goal==Goal.BREWING_KO_APOTH) {
		return thehouse.Apothecary;
	}
	else if (goal==Goal.CRAFTING_LOCKPICK||goal==Goal.CRAFTING_PISTOL||
			goal==Goal.CRAFTING_BOMB ||goal ==Goal.FIX_KEY ||
			goal==Goal.GET_WRENCH || goal==Goal.GET_HAMMER ||
			goal==Goal.GET_SCREWDRIVER) {
		return thehouse.Workshop;
	}
	else if (goal==Goal.GET_FRAGRANT_PLANT_GREENHOUSE||goal==Goal.GET_POISONOUS_PLANT_GREENHOUSE
			||goal==Goal.GET_NOXIOUS_PLANT_GREENHOUSE) {
		return thehouse.GreenHouse;
	}
	else if (goal==Goal.GET_FRAGRANT_PLANT_OUTDOORS || goal==Goal.CAST_RITUAL_OD2) {
		return thehouse.Outdoors_2;
	}
	else if (goal==Goal.GET_NOXIOUS_PLANT_OUTDOORS || goal==Goal.CAST_RITUAL_OD3) {
		return thehouse.Outdoors_3;
	}
	else if (goal==Goal.GET_POISONOUS_PLANT_OUTDOORS || goal==Goal.CAST_RITUAL_OD4) {
		return thehouse.Outdoors_4;
	}
	else if (goal==Goal.POISON_WINE_KITCHEN||goal==Goal.DRINKING_KITCHEN||goal==Goal.POISON_FOOD) {
		return thehouse.Kitchen;
	}
	else if (goal==Goal.DRINKING_HALL||goal==Goal.LOOSEN_CHANDELIER) {
		return thehouse.DiningHall;
	}
	else if (goal==Goal.BALCONY_STALKER||goal==Goal.LOOSEN_BALCONY ||goal==Goal.CAST_RITUAL_BALCONY) {
		return thehouse.Balcony;
	}
	else if (goal==Goal.CLIFF_STALKER) {
		return thehouse.TheCliff;
	}
	return null;
}


public void takeTurn() {
	// TODO Auto-generated method stub
	
}
}

