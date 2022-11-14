package edu.pacific.comp55.starter;
import java.util.ArrayList;

public class Fact {
	public class fact {
		
		//Unique ID for each fact so that incomplete facts can be combined.
		int ID;

		//Who
		Partygoer instigator;
		ArrayList<Partygoer> victims;
		ArrayList<Partygoer> bystanders;

		//What or how
		Convos theevent;

		//When
		int thetime;

		//Where
		Room Room;

		//Checks to see if any of the above factoids are lies
		Boolean eventislie;
		Boolean timeislie;
		Boolean roomislie;
		Boolean instislie;
		Boolean vicislie;
		Boolean byislie;

		//Can be turned into EVIDENCE?
		Boolean incriminating;


		//This is put into the addToKnownFact function, in the first argument in order to create a known fact from nothing.
		public void createNullFact() {
			this.ID = -1;
			this.instigator = null;
			this.victims = null;
			this.bystanders = null;
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

		public Convos getTheEvent() {
			return theevent;
		}

		public Room getRoom() {
			return Room;
		}

		public void setRoom(Room newroom) {
			this.Room = newroom;
		}

		public void setTheEvent(Convos newevent) {
			this.theevent = newevent;
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
		public Boolean addToKnownFact (fact knownFact, fact incomingfact) {
			
			
			//If fact is a null fact, it is initialized with incomingfact's data.
			if (knownFact.getID() == -1) {
				knownFact.setID(incomingfact.getID());
			}
			
			//Checks to see if a factoid is unknown or a lie, and puts in the new data.
			//One cannot disprove lies with more lies
			if (knownFact.getID() == incomingfact.getID()) {
			
			if (knownFact.getInstigator() == null || knownFact.isInstLie()) {
				knownFact.setInstigator(incomingfact.getInstigator());
				knownFact.setInstLie(incomingfact.isInstLie());
			}
			if (knownFact.getVictim() == null || knownFact.isVicLie()) {
				knownFact.setVictims(incomingfact.getVictim());
				knownFact.setVicLie(incomingfact.isVicLie());
			}
			if (knownFact.getBystanders() == null || knownFact.isByLie()) {
				knownFact.setBystanders(incomingfact.getBystanders());
				knownFact.setByLie(incomingfact.isByLie());
			}
			if (knownFact.getTheEvent() == null || knownFact.isEventLie()) {
				knownFact.setTheEvent(incomingfact.getTheEvent());
				knownFact.setEventLie(incomingfact.isEventLie());
			}
			if (knownFact.getTime() == 0 || knownFact.isEventLie()) {
				knownFact.setTime(incomingfact.getTime());
				knownFact.setTimeLie(incomingfact.isRoomLie());
			}
			if (knownFact.getRoom() == null || knownFact.isRoomLie()) {
				knownFact.setRoom(incomingfact.getRoom());
				knownFact.setRoomLie(incomingfact.isRoomLie());
			}
			
			return true;
			}
			else {
				return false;
			}
		}
		}

}
