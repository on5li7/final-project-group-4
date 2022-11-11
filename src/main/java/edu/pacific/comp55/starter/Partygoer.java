package edu.pacific.comp55.starter;
import java.util.ArrayList;


public class Partygoer {
	
	
	
	
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
}
