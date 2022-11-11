package edu.pacific.comp55.starter;

import java.util.Scanner;
import java.util.*;
public class Convos {
	Random rando;
	house House;
	
	public Convos(house House) {
		this.House = House;
	}
	
	public void demonConvo(Partygoer Player) {
		int checknum = rando.nextInt(6);
		if (checknum == 0) {
		System.out.print("You lost, mortal?");
		}
		if (checknum == 1) {
		System.out.print("There's better things you could be doing than talking to me.");
		}
		if (checknum == 2) {
			if(Player.isDetective()) {
		System.out.print("Sure, there's a murderer for you to find, detective, but you're welcome to waste your time talking to me.");
			}
			if(Player.isKiller()) {
		System.out.print("Oh, by the way there's a cop here. Figured you'd want to know. Try to stay out of trouble. Heheheh");
			}
		}
		if (checknum == 3) {
		System.out.print("You think that Zach character's corpse will go good with chesterworstester sauce?");
			}
		if (checknum == 4) {
			if (House.getDeadpeople() == 0) {
				System.out.print("Ugh, I should have trapped that Zach fool's soul before I killed him. I'm starving...");
			}
			else if (House.getDeadpeople() == 1) {
				System.out.print("One down, a snack, at least.");
			}
			else if (House.getDeadpeople() == 2) {
				System.out.print("Two bodies, two souls, a nice dinner.");
			}
			else if (House.getDeadpeople() == 3) {
				if(Player.isDetective()) {
					System.out.print("You're not very good at this whole stopping people from dying thing, are you?");
						}
						if(Player.isKiller()) {
					System.out.print("Hm, you might actually hold up your end of the bargain.");
						}
			}
			else if (House.getDeadpeople() == 4) {
				if(Player.isDetective()) {
					System.out.print("Hhaha! Look at the bright side, YOU are still alive! Why not just plunge a knife into your neighbor and go home?");
						}
						if(Player.isKiller()) {
					System.out.print("Good. Good! One more body, and your soul goes free! The things people will do to save their skin! Heheh. But you know that better than anyone.");
						}
			}
			else {
				System.out.print("Hm, why can't I smell any bodies right now? Debug this!");
			}
		}
		if (checknum == 5) {
			if (Player.getIdentity() == "Doc") {
				System.out.print("So doctor, planning on saving any lives today? Hhheehhe");
			}
			else if (Player.getIdentity() == "Frank") {
				System.out.print("You could've picked the guy with the gun or the witch, but instead you chose the useless drunk? Very interesting.");
			}
			else if (Player.getIdentity() == "Gertrude") {
				System.out.print("You look like one that doesn't like to play fair. I like it.");
			}
			else if (Player.getIdentity() == "Max") {
				System.out.print("Blather on all you want, you cannot talk your way out of this game, nor a knife in your back.");
			}
			else if (Player.getIdentity() == "Ariana") {
				System.out.print("I can't tell which one of you is more of a parasite, you or that Maximillian meatsack.");
			}
			else if (Player.getIdentity() == "Smithy") {
				System.out.print("Picked the gun, huh? Simpletons favor simple strategies.");
			}
			else if (Player.getIdentity() == "Bob") {
				System.out.print("Oh, didn't see you there.");
			}
			else if (Player.getIdentity() == "Jake") {
				System.out.print("Is this the quarry you were expecting, hunter?");
			}
			else if (Player.getIdentity() == "Todd") {
				System.out.print("Feel free to get killed any time. The young, tragically murdered souls always taste the tangiest.");
			}
			else if (Player.getIdentity() == "Chad") {
				System.out.print("So, you spent it all yet? Was it worth it?");
			}
			else {
				System.out.print("this greeting can't detect the partygoer DEBUG THIS");
			}
		}
		
		System.out.print("1) Tell me about yourself");
		System.out.print("2) What am I supposed to do?");
		System.out.print("3) Goodbye.");
		System.out.print("Enter Response: ");
		Scanner scanner = new Scanner(System.in);
		int response = scanner.nextInt();
		
		while (response != 3) {
			response = scanner.nextInt();
		while (response > 3 || response < 1) {
			System.out.print("Try again:");
			response = scanner.nextInt();
		}
		
		if (response == 1 ) {
			if (diner.getDemonBackStoryCounter() == 0) {
				System.out.print("HHHaaahahaaaahaha! You want to learn about ME! Adorable! It's like you think you can talk your way out of here!");
				System.out.print("Well, I like long walks in hell, hosting dinner parties, and consuming the damned souls of the living. I'm an Aries.");
				System.out.print("So, if you want to get on my good side, enjoy the party, maybe have some poisoned wine, die, and go straight to hell!");
			}
			if (diner.getDemonBackStoryCounter() == 1) {
				System.out.print("Okay really, what are you hoping to accomplish here? This wastes like 5 turns!");
				System.out.print("Well, what is there to say? I was hungry. Circle of life and all that. Top of the food chain, baby.");
				System.out.print("Me, a spider, you, a fly, and this house, a web. Ironic, given how much of it is cobwebs by now.");
				if (Player.isDetective()) {
				System.out.print("A fly with a mission is still just a fly, detective. Buzz buzz.");
				}
				if (Player.isKiller()) {
				System.out.print("Do you think you're a wolf among sheep just because I said you could kill these people? Pathetic. You're still just a worthless fly. Buzz buzz.");	
				}
				System.out.print("You're in MY house. Playing MY game. With MY rules. Play. The. Game.");
			}
			if (diner.getDemonBackStoryCounter() == 2) {
				if (Player.isDetective()) {
					System.out.print("Bet you really wonder why im not helping the murderous little maggot kill you all.");
					System.out.print("Well, it needs to be a sacrifice to me or I don't get to keep the soul. There's rules about this sort of thing.");
					System.out.print("Like, if I do it myself it's just chips without salsa, salad without dressing, cake without frosting. Dreadful, really.");
					System.out.print("The soul is the best part!");
					System.out.print("At my age, I only want to enjoy the finest of cuisines. Think about this. Demons basically live forever, and i'm basically at the end of forever.");
					System.out.print("Whatever forever is supposed to mean, i'm not exactly sure anymore! But if you're not living fine at this age, what's the point of living at all?");
					System.out.print("And i've assembled the tastiest little morsels this side of the mortal coil!");
					System.out.print("I started with some exotic choices. A fresh, genuine warlock, a pickled sommelier, and an undercover detective.");
					System.out.print("Members of high society are always a delicious main course. Succulent, buttery, juicy souls. Can't forget a few of them.");
					System.out.print("I, personally, love a good hero. People who think they can make a difference in the world. It's got a spicy, garliccy flavor to it.");
					System.out.print("Some demons think that they're too tough. Gets all stuck in your teeth, but served rare, they are impeccable.");
					System.out.print("That, combined with your impressive history, oh you will be most juicy indeed.");
				}
				if (Player.isKiller()) {
					System.out.print("Come to beg? Plead for a different way out? Lost your nerve? You are the worm on my hook. Get me my fish.");
					System.out.print("What did you expect when you sell your soul? I'm actually being very nice, the usual punishment is eternal damnation.");
					System.out.print("You know, once I'm done digesting. There's deffinitely more comfortable ways to go to hell. Which, considering hell, is saying something.");
					System.out.print("You already made the decision to bargain their souls for yours. There's no backing out now.");
					System.out.print("But if you fail? Ooh my. A soul so corrupted by it's own greed it's willing to kill 5 more people by its own hand to save itself?");
					System.out.print("Seasoned with desperation, marinated in fear, wine, and poison, with a zesty dash of failure seared right into the soul at the exact moment of death!");
					System.out.print("The body needs to pickled in plenty of wine. Stuffed with the most hearty of meals. Decadence in body is decadence in spirit.");
					System.out.print("Betrayal has a distinct smokiness. Romantic passion tastes like a sweet cherry glaze. But hope? Freshly crushed hope? That's magic, baby. Pure music.");
					System.out.print("But the secret ingredient? Hope. Your hope that you can kill. Their hope of escape. Flavors dancing in the pan.");
					System.out.print("Baby, i've won competitions with this recipe. So if you're going to fail, let that detective arrest you. I'm experimenting with a life-in-prison dry aging process.");
				}
			}
			if (diner.getDemonBackStoryCounter() == 3) {
			if (Player.isDetective()) {
				System.out.print("Well, this is a very poor strategy for finding that killer.");
				System.out.print("Oh well, since you're here, I guess i'll nick a couple more turns off ya.");
				System.out.print("That bumbling freak of a minion of mine has lived a horrible life.");
				System.out.print("Want my advice? Don't sell your soul! For all the resources and power our bargain granted them, they live their life in fear.");
				System.out.print("When we struck the bargain, I gave them what they asked, and took off, as usual.");
				System.out.print("They never read these things, I didn't even put in any fine print. The trick is to make the font really hurt their eyes. Heheee");
				System.out.print("Well anyway, Captain HindSight summons me a week later just bawling. I mean tears and snot everywhere. They were a wreck. Murderers usually are.");
				System.out.print("Turns out they had to time really think about what selling your soul to a demon actually means and they didn't like it. Go figure.");
				System.out.print("So I had this idea. Why not put together a shindig, have this person sacrifice a bunch of folk, and rake in the souls!");
				System.out.print("It just keeps working over and over! People love parties!");
				System.out.print("This current maggot? This is their tenth party!");
				System.out.print("This current house? The fifty-sixth!");
				System.out.print("This current city? Two Hundred and Twelve!");
				System.out.print("So, if I were you, I'd focus on my survival. Git.");
			}
			if (Player.isKiller()) {
				System.out.print("Oh quit sniveling to me, you worm! Go finish the job!");
				System.out.print("It's your own weakness that got you here in the first place. Sold your soul and took the easy way out of life.");
				System.out.print("But it's no life at all, isn't it? You poor thing. I'm already planning our next party.");
				System.out.print("Don't give me that pathetic look. You deal with these people, and you get to go back to your life.");
				System.out.print("This is your last one, you've almost paid your tab! Sold out your fellow humans for your weakness!");
				System.out.print("Hey, you chose this, I didn't make you sell your soul! But you make for a good killer. You were a worthless... whatever you were.");
				System.out.print("What were you before you met me? Nothing! Nothing at all! There is no you there is only me! Now get back to work!");
			}
			}
			if (diner.getDemonBackStoryCounter() == 4) {
			if (Player.isKiller()) {
				System.out.print("Gotta say, you've done a fantastic job wasting your time. Trying to convince the detective there's no killer around? GET OUT OF MY FACE!");
			}
			if (Player.isDetective()) {
				System.out.print("Oh, I see. Maybe you think IM the killer. Sorry, buddy I'm more of the corruption in the hearts of men type and not the throne of skulls type.");
				System.out.print("Back in my younger years, oh I'd put together a skull throne that would damn your very soul. Ah but those days are behind me. You should get back to work.");
			}
			}
			if (diner.getDemonBackStoryCounter() == 5) {
				System.out.print("Okay, this is getting a little wierd. Stop talking to me! If you weren't an important part of my grocery shopping i'd turn you to ash by now! Begone!");
			}
			if (diner.getDemonBackStoryCounter() == 6) {
				System.out.print("Okay that's it! I'm bumping this up to 10 turns! Get a life already!");
			}
			if (diner.getDemonBackStoryCounter() == 7) {
				System.out.print("Really? 15 turns now!");
			}
			if (diner.getDemonBackStoryCounter() == 8) {
				System.out.print("Okay, fine! You want to waste time? Let's waste time! 20. Turns.");
			}
			if (diner.getDemonBackStoryCounter() == 9) {
				System.out.print("You know what? I can't take this anymore! Here, take my old journal if you really want to know! Just get away from me!");
				Player.inventory.add(item.THE_DEMONS_LEGEND);
			}
			if (diner.getDemonBackStoryCounter() >= 10) {
				System.out.print("You're gonna age as much as me if you keep this up...");
			}
			
			
		}
		
		if (response == 2) {
			if (diner.getTipCounter() == 0) {
				System.out.print("You want me to tell you how to fight for your survival? Humans...");
				System.out.print("I don't know! Why don't you try grabbing a knife? Knives are... sharp.");
			}
			if (diner.getTipCounter() == 1) {
				System.out.print(
			}
			}
		}
		}
}
	
}
