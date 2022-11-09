package edu.pacific.comp55.starter;

import java.util.ArrayList;

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
	public static Room Outdoors_1;
	public static Room Outdoors_2;
	public static Room Outdoors_3;
	public static Room Outdoors_4;
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
	//sets the time of the house
		private int time;
		
		//checks when it's night or day 
		private Boolean isDark;
		
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
		public static void main(String[] args) {
			ArrayList<String> House = new ArrayList<String>();
			DiningHall = new Room();
			Apothecary = new Room();
			Kitchen = new Room();
			WineCellar = new Room();
			GreenHouse = new Room();
			TheStudy = new Room();
			Armory = new Room();
			Workshop = new Room();
			Dungeon = new Room();
			Outdoors_1 = new Room();
			Outdoors_2 = new Room();
			Outdoors_3 = new Room();
			Outdoors_4 = new Room();
		    Bedroom_1 = new Room();
			Bedroom_2 = new Room();
			Bedroom_3 = new Room();
			Bedroom_4 = new Room();
			Bedroom_5 = new Room();
			Bedroom_6 = new Room();
			Bedroom_7 = new Room();
			Bedroom_8 = new Room();
			Bedroom_9 = new Room();
			Bedroom_10 = new Room();
			TheCliff = new Room();	
			System.out.println(House);
		}
}
