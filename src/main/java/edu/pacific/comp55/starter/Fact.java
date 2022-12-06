package edu.pacific.comp55.starter;
import java.util.ArrayList;

public class Fact {
		
		//Unique ID for each fact so that incomplete facts can be combined.
		public int ID;

		//Who
		public Partygoer instigator;
		public ArrayList<Partygoer> victims;
		public ArrayList<Partygoer> bystanders;

		//What or how
		public String theevent;

		public String getTheEvent() {
			return theevent;
		}
		
		public void setTheEvent(String event) {
			theevent = event;
		}
		//When
		public int thetime;

		//Where
		public Room Room;
		
		Goal motive;
		
		//Checks to see if any of the above factoids are lies
		Boolean eventislie;
		Boolean timeislie;
		Boolean roomislie;
		Boolean instislie;
		Boolean vicislie;
		Boolean byislie;

		//Can be turned into EVIDENCE?
		Boolean incriminating;

		public int time;
		
		Fact(int ID) {
			this.ID = ID;
			createNullFact();
		}

		//This is put into the addToKnownFact function, in the first argument in order to create a known fact from nothing.
		public void createNullFact() {
			this.instigator = null;
			this.victims = new ArrayList<Partygoer>();
			this.bystanders = new ArrayList<Partygoer>();
			this.theevent = null;
			this.thetime = 0;
			this.instislie = false;
			this.vicislie = false;
			this.byislie = false;
			this.eventislie = false;
			this.timeislie = false;
			this.Room = null;
			this.roomislie = false;
			this.incriminating = false;
			this.motive = null;
		}



		public void setID(int ID) {
			this.ID = ID;
		}

		public int getID() {
			return ID;
		}

		public Partygoer getInstigator() {
			return instigator;
		}

		public void setInstigator(Partygoer theguy) {
			this.instigator = theguy;
		}

		public ArrayList<Partygoer> getVictim() {
			return victims;
		}

		public ArrayList<Partygoer> getBystanders() {
			return bystanders;
		}

		public void setBystanders(ArrayList<Partygoer> bystanders) {
			this.bystanders = bystanders;
		}

		public void setVictims(ArrayList<Partygoer> victims) {
			this.victims = victims;
		}

		public int getTime() {
			return thetime;
		}

		public void setTime(int time) {
			this.thetime = time;
		}

		public Room getRoom() {
			return Room;
		}

		public void setRoom(Room newroom) {
			this.Room = newroom;
		}

		public Boolean isEventLie() {
			return eventislie;
		}
			
		public void setEventLie(Boolean lie) {
			this.eventislie = lie;
		}

		public Boolean isInstLie() {
			return instislie;
		}

		public void setInstLie(Boolean lie) {
			this.instislie = lie;
		}

		public Boolean isVicLie() {
			return vicislie;
		}

		public void setVicLie(Boolean lie) {
			this.vicislie = lie;
		}

		public Boolean isByLie() {
			return byislie;
		}

		public void setByLie(Boolean lie) {
			this.byislie = lie;
		}

		public Boolean isTimeLie() {
			return timeislie;
		}

		public void setTimeLie(Boolean lie) {
			this.timeislie = lie;
		}

		public Boolean isRoomLie() {
			return roomislie;
		}

		public void setRoomLie(Boolean lie) {
			this.roomislie = lie;
		}


		//Generates a new fact if passed a null fact in the first argument.
		public Boolean addToKnownFact (Fact incomingfact) {
			
			
			//If fact is a null fact, it is initialized with incomingfact's data.
			if (this.getID() == 0) {
				this.setID(incomingfact.getID());
			}
			
			//Checks to see if a factoid is unknown or a lie, and puts in the new data.
			//One cannot disprove lies with more lies
			if (this.getID() == incomingfact.getID()) {
			
			if ((this.getInstigator() == null || this.isInstLie()) && incomingfact.getInstigator() != null) {
				this.setInstigator(incomingfact.getInstigator());
				this.setInstLie(incomingfact.isInstLie());
			}
			if ((this.getVictim() == null || this.isVicLie()) && incomingfact.victims.size() != 0) {
				this.setVictims(incomingfact.getVictim());
				this.setVicLie(incomingfact.isVicLie());
			}
			if ((this.getBystanders() == null || this.isByLie()) && incomingfact.bystanders.size() != 0) {
				this.setBystanders(incomingfact.getBystanders());
				this.setByLie(incomingfact.isByLie());
			}
			if ((this.getTheEvent() == null || this.isEventLie()) && incomingfact.getTheEvent() != null) {
				this.setTheEvent(incomingfact.getTheEvent());
				this.setEventLie(incomingfact.isEventLie());
			}
			if ((this.getTime() == 0 || this.isEventLie()) && incomingfact.getTime() != 0) {
				this.setTime(incomingfact.getTime());
				this.setTimeLie(incomingfact.isRoomLie());
			}
			if ((this.getRoom() == null || this.isRoomLie()) && incomingfact.getRoom() != null) {
				this.setRoom(incomingfact.getRoom());
				this.setRoomLie(incomingfact.isRoomLie());
			}
			
			return true;
			}
			else {
				return false;
			}
		}
		}

