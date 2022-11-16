package edu.pacific.comp55.starter; 

import java.util.ArrayList;
import java.util.HashMap;


public class house {
	public static Room DiningHall;
	public static Room Apothecary;
	public static Room Kitchen;
	public static Room WineCellar;
	public static Room GreenHouse;
	public static Room TheStudy;
	public static Room Armory;
	public static Room Workshop;
	public static Room TheCliff;
	public static Room Dungeon;
	public static Room Balcony;
	public static Room Outdoors_1;
	public static Room Outdoors_2;
	public static Room Outdoors_3;
	public static Room Outdoors_4;
	public static Room Hallway;
	public static Room Bedroom_1;
	public static Room Bedroom_2;
	public static Room Bedroom_3;
	public static Room Bedroom_4;
	public static Room Bedroom_5;
	public static Room Bedroom_6;
	public static Room Bedroom_7;
	public static Room Bedroom_8;
	public static Room Bedroom_9;
	public static Room Bedroom_10;
	public static Room Morgue;
	static int currentPG;
	ArrayList<Partygoer> allPartygoers;
	ArrayList<GoalSets> allGoalSets;
	//sets the time of the house
		private int time;
		
		HashMap<String, ArrayList<Goals>> goalsets;
		public void generateGoalsets() {
			.add
		}
		
		public ArrayList<Room> busRoute(int beginning, int end) {
			ArrayList<Room> route = new ArrayList<Room>();
			//Apothecary is stop 1. Hallway is stop 2. Armory is stop 3. Kitchen is stop 4. Outdoors bottem left is stop 5.
			if (beginning == 1 && end == 2) {
				
				route.add(TheStudy);
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 1 && end == 3) {
				
				route.add(Balcony);
				route.add(Armory);
			}
			if (beginning == 1 && end == 4) {
				
				route.add(TheStudy);
				route.add(DiningHall);
				route.add(Kitchen);
			}
			if (beginning == 1 && end == 5) {
				
				route.add(TheStudy);
				route.add(DiningHall);
				route.add(GreenHouse);
				route.add(Outdoors_4);
				route.add(Outdoors_3);
			}
			if (beginning == 2 && end == 1) {
				
				route.add(DiningHall);
				route.add(TheStudy);
				route.add(Apothecary);
			}
			if (beginning == 2 && end == 3) {
				
				route.add(DiningHall);
				route.add(Workshop);
				route.add(Armory);
			}
			if (beginning == 2 && end == 4) {
				
				route.add(DiningHall);
				route.add(Kitchen);
			}
			if (beginning == 2 && end == 5) {
				
				route.add(DiningHall);
				route.add(Kitchen);
				route.add(Outdoors_2);
				route.add(Outdoors_1);
				route.add(Outdoors_3);
			}
			if (beginning == 3 && end == 1) {
				
				route.add(Balcony);
				route.add(Apothecary);
			}
			if (beginning == 3 && end == 2) {
				
				route.add(Workshop);
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 3 && end == 4) {
				
				route.add(Workshop);
				route.add(DiningHall);
				route.add(Kitchen);
			}
			if (beginning == 3 && end == 5) {
				
				route.add(Workshop);
				route.add(DiningHall);
				route.add(GreenHouse);
				route.add(Apothecary);
			}
			if (beginning == 4 && end == 1) {
				
				route.add(DiningHall);
				route.add(TheStudy);
				route.add(Apothecary);
			}
			if (beginning == 4 && end == 2) {
				
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 4 && end == 3) {
				
				route.add(DiningHall);
				route.add(Workshop);
				route.add(Armory);
			}
			if (beginning == 4 && end == 5) {
				
				route.add(Outdoors_2);
				route.add(Outdoors_1);
				route.add(Outdoors_3);
			}
			if (beginning == 5 && end == 1) {
				
				route.add(Outdoors_4);
				route.add(GreenHouse);
				route.add(DiningHall);
				route.add(TheStudy);
				route.add(Apothecary);
			}
			if (beginning == 5 && end == 2) {
				
				route.add(Outdoors_4);
				route.add(GreenHouse);
				route.add(DiningHall);
				route.add(Hallway);
			}
			if (beginning == 5 && end == 3) {
				
				route.add(Outdoors_4);
				route.add(GreenHouse);
				route.add(DiningHall);
				route.add(Workshop);
				route.add(Armory);
			}
			if (beginning == 5 && end == 4) {
				
				route.add(Outdoors_1);
				route.add(Outdoors_2);
				route.add(Kitchen);
			}
			return route;
		}
		
		//checks when it's night or day 
		private static Boolean isDark;
		
		public void nextPlayer() {
			if(currentPG == 9) {
				currentPG = 0;
				allPartygoers.get(currentPG).takeTurn();
			}
		}
		
		//the number of dead people
		private int deadpeople;
		
		//The partygoer whose turn it currently is.
		Partygoer currPlayer;
		
		public int getTime() {
			return time;
		}
		public void setTime(int time) {
			this.time = time;
		}
		public Boolean getIsDark() {
			return isDark;
		}
		public void setIsDark(Boolean isDark) {
			this.isDark = isDark;
		}
		public int getDeadpeople() {
			return deadpeople;
		}
		public void setDeadpeople(int deadpeople) {
			this.deadpeople = deadpeople;
		}
		//For each arraylist in each room. .add the room
		public static ArrayList<Room> adjacentRooms(Room room) {
			ArrayList<Room> adjRooms = new ArrayList<Room>();
			if (room==DiningHall) {
				adjRooms.add(Kitchen);
				adjRooms.add(GreenHouse);
				adjRooms.add(Hallway);
				adjRooms.add(Apothecary);
			}
			else if (room==Apothecary) {
				adjRooms.add(DiningHall);
			}
			else if (room==Kitchen) {
				adjRooms.add(DiningHall);
				adjRooms.add(GreenHouse);
				adjRooms.add(Outdoors_2);
			}
			else if (room==WineCellar) {
				adjRooms.add(Kitchen);
				adjRooms.add(Outdoors_2);
			}
			else if (room==GreenHouse) {
				adjRooms.add(Kitchen);
				adjRooms.add(Outdoors_4);
				adjRooms.add(DiningHall);
			}
			else if (room==TheStudy) {
				adjRooms.add(DiningHall);
				adjRooms.add(Apothecary);
				adjRooms.add(Morgue);
			}
			else if (room==Armory) {
				adjRooms.add(Workshop);
				adjRooms.add(Balcony);
				adjRooms.add(Dungeon);
			}
			else if (room==Workshop) {
				adjRooms.add(Armory);
				adjRooms.add(DiningHall);
			}
			else if (room==Dungeon) {
				adjRooms.add(Armory);
			}
			else if (room==Outdoors_1) {
				adjRooms.add(Outdoors_2);
				adjRooms.add(Outdoors_3);
				adjRooms.add(TheCliff);
			}
			else if (room==Outdoors_2) {
				adjRooms.add(Outdoors_1);
				adjRooms.add(Outdoors_4);
				adjRooms.add(Kitchen);
				adjRooms.add(WineCellar);
			}
			else if (room==Outdoors_3) {
				adjRooms.add(TheCliff);
				adjRooms.add(Outdoors_1);
				adjRooms.add(Outdoors_4);
			}
			else if (room==Outdoors_4) {
				adjRooms.add(Outdoors_3);
				adjRooms.add(Outdoors_2);
				adjRooms.add(GreenHouse);
			}
			else if (room==Bedroom_1) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_2) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_3) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_4) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_5) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_6) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_7) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_8) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_9) {
				adjRooms.add(Hallway);
			}
			else if (room==Bedroom_10) {
				adjRooms.add(Hallway);
			}
			else if (room==TheCliff) {
				adjRooms.add(Outdoors_1);
				adjRooms.add(Outdoors_3);
			}
			else if (room==Hallway) {
				adjRooms.add(Bedroom_1);
				adjRooms.add(Bedroom_2);
				adjRooms.add(Bedroom_3);
				adjRooms.add(Bedroom_4);
				adjRooms.add(Bedroom_5);
				adjRooms.add(Bedroom_6);
				adjRooms.add(Bedroom_7);
				adjRooms.add(Bedroom_8);
				adjRooms.add(Bedroom_9);
				adjRooms.add(Bedroom_10);
				adjRooms.add(DiningHall);
				adjRooms.add(Balcony);
			}
			else if (room==Morgue) {
				adjRooms.add(TheStudy);
				adjRooms.add(Apothecary);
			}
			return adjRooms;
		}
		
		public static void main(String[] args) {
			ArrayList<String> House = new ArrayList<String>();
			DiningHall = new Room(null, isDark, null, null, adjacentRooms(DiningHall), null, 0);
			Apothecary = new Room(null, isDark, null, null, adjacentRooms(Apothecary), null, 1);
			Kitchen = new Room(null, isDark, null, null, adjacentRooms(Kitchen), null, 4);
			WineCellar = new Room(null, isDark, null, null, adjacentRooms(WineCellar), null, 0);
			GreenHouse = new Room(null, isDark, null, null, adjacentRooms(GreenHouse), null, 0);
			TheStudy = new Room(null, isDark, null, null, adjacentRooms(TheStudy), null, 0);
			Armory = new Room(null, isDark, null, null, adjacentRooms(Armory), null, 3);
			Workshop = new Room(null, isDark, null, null, adjacentRooms(Workshop), null, 0);
			Dungeon = new Room(null, isDark, null, null, adjacentRooms(Dungeon), null, 0);
			Outdoors_1 = new Room(null, isDark, null, null, adjacentRooms(Outdoors_1), null, 0);
			Outdoors_2 = new Room(null, isDark, null, null, adjacentRooms(Outdoors_2), null, 0);
			Outdoors_3 = new Room(null, isDark, null, null, adjacentRooms(Outdoors_3), null, 5);
			Outdoors_4 = new Room(null, isDark, null, null, adjacentRooms(Outdoors_4), null, 0);
		    Bedroom_1 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_1), null, 0);
			Bedroom_2 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_2), null, 0);
			Bedroom_3 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_3), null, 0);
			Bedroom_4 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_4), null, 0);
			Bedroom_5 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_5), null, 0);
			Bedroom_6 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_6), null, 0);
			Bedroom_7 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_7), null, 0);
			Bedroom_8 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_8), null, 0);
			Bedroom_9 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_9), null, 0);
			Bedroom_10 = new Room(null, isDark, null, null, adjacentRooms(Bedroom_10), null, 0);
			TheCliff = new Room(null, isDark, null, null, adjacentRooms(TheCliff), null, 0);
			Hallway = new Room(null,isDark,null,null,adjacentRooms(Hallway),null,2);
			Morgue = new Room(null,isDark,null,null,adjacentRooms(Morgue),null,0);
			System.out.println(House);
		}
}
