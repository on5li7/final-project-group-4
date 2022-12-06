package edu.pacific.comp55.starter;

public enum Goal {
		//Needs. Should be on a timer. If ignored partygoer incurs debuffs. Not used in class version.
		EATING, SLEEPING, 
		
		//Brewing goals seperated by what they're brewing and where.
		BREWING_POISON_WITCH, BREWING_ANTIDOTE_WITCH, BREWING_PERFUME_WITCH, BREWING_KO_WITCH,
		BREWING_POISON_CELLAR, BREWING_ANTIDOTE_CELLAR, BREWING_PERFUME_CELLAR, BREWING_KO_CELLAR,
		BREWING_POISON_APOTH, BREWING_ANTIDOTE_APOTH, BREWING_PERFUME_APOTH, BREWING_KO_APOTH,
		
		//Gathering goals. Need to make a wander function so A.I. wanders until it finds something of interest.
		RANSACK, GET_KNIFE, CRAFTING_LOCKPICK, CRAFTING_PISTOL, 
		GET_RIFLE, GET_SWORD, OOHSHINY, GOSSIPING, GET_FRAGRANT_PLANT_GREENHOUSE,
		GET_FRAGRANT_PLANT_OUTDOORS, GET_RITUAL_ITEM, GET_MEDICINAL_PLANT_GREENHOUSE, GET_MEDICINAL_PLANT_OUTDOORS,
		
		HARDROUTE,
		
		//Book actions.
		GET_RITUALS, CAST_RITUAL_BALCONY, CAST_RITUAL_CLIFF,
		CAST_RITUAL_OD1, CAST_RITUAL_OD2, CAST_RITUAL_OD3, CAST_RITUAL_OD4,
		
		//Poisonous actions
		GET_POISONOUS_PLANT_GREENHOUSE, GET_NOXIOUS_PLANT_GREENHOUSE, 
		GET_POISONOUS_PLANT_OUTDOORS, GET_NOXIOUS_PLANT_OUTDOORS, GET_FROG,
		POISON_FOOD, POISON_WINE_CELLAR, POISON_WINE_KITCHEN,
		
		//Drunk goals
		DRINKING_CELLAR, DRINKING_HALL, DRINKING_KITCHEN,
		
		//MURDEROUS!!!
		ASSAULT, CLEANUP_KITCHEN, CLEANUP_OUTDOORS, DEFENSIVE_KILL,
		
		//Sabotage. Cliff stalker has the character waiting at cliff for a victim so that they can be pushed off.
		LOOSEN_CHANDELIER, CLIFF_STALKER, CRAFTING_BOMB, LOOSEN_BALCONY, 
		BALCONY_STALKER, GET_WRENCH, GET_SCREWDRIVER, GET_HAMMER,
		FIX_KEY, DRINKING, KILL,
		;
		public String toString() {
			switch(this) {
			case GET_RITUAL_ITEM: return "Gotta get some items for this spell...";
			case HARDROUTE: return "Gotta go to a specific room for a non-specific function.";
			case CAST_RITUAL_BALCONY: return "Gonna cast a spell on the balcony";
			case CAST_RITUAL_CLIFF: return "Gonna cast a spell on the cliff... i suppose.";
			case CAST_RITUAL_OD1: return "Gonna cast a spell in the witch's den.";
			case CAST_RITUAL_OD2: return "Gonna cast a spell by the graveyard";
			case CAST_RITUAL_OD3: return "Gonna cast a spell in the woods";
			case CAST_RITUAL_OD4: return "Gonna cast a spell in the pond.";
			case OOHSHINY: return "What's that on the floor?";
			case EATING: return "hungry...";
			case SLEEPING: return "sleepy...";
			case BREWING_POISON_WITCH: return "Going to brew poison outside";
			case BREWING_POISON_CELLAR: return "Going to brew poison in the cellar";
			case BREWING_POISON_APOTH: return "Going to brew poison in the apothecary";
			case BREWING_ANTIDOTE_WITCH: return "Going to brew antidote outside";
			case BREWING_ANTIDOTE_CELLAR: return "Going to brew antidote cellar";
			case BREWING_ANTIDOTE_APOTH: return "Going to brew antidote in the apothecary";
			case BREWING_PERFUME_WITCH: return "Going to brew perfume outside";
			case BREWING_PERFUME_CELLAR: return "Going to brew perfume in the cellar";
			case BREWING_KO_WITCH: return "Going to brew chloroform outside";
			case BREWING_KO_APOTH: return "Going to brew chloroform in the apothecary";
			case BREWING_KO_CELLAR: return "Going to brew chloroform in the cellar";
			case ASSAULT: return "Stabbin' time!";
			case RANSACK: return "Searching the room...";
			case GET_KNIFE: return "I wonder if there's a knife in the kitchen...";
			case GET_SWORD: return "Maybe the armory's got a sword...";
			case GET_FRAGRANT_PLANT_OUTDOORS: return "Going outside for a fragrant flower.";
			case GET_FRAGRANT_PLANT_GREENHOUSE: return "Going to the greenhouse for a fragrant flower.";
			case GET_POISONOUS_PLANT_OUTDOORS: return "Going to the greenhouse for a poisonous plant";
			case GET_POISONOUS_PLANT_GREENHOUSE: return "Going to the greenhouse for a poisonous plant";
			case GET_NOXIOUS_PLANT_GREENHOUSE: return "Going to the greenhouse for a noxious bulb.";
			case GET_NOXIOUS_PLANT_OUTDOORS: return "Going outside for a noxious bulb";
			case GOSSIPING: return "What's the tea, sis?";
			case POISON_FOOD: return "Going to poison the food in the kitchen.";
			case POISON_WINE_KITCHEN: return "Going to poison the wine in the kitchen";
			case POISON_WINE_CELLAR: return "Going to poison the wine in the cellar";
			case GET_WRENCH: return "Going to get a wrench from the workshop.";
			case GET_SCREWDRIVER: return "Going to get a screwdriver from the workshop";
			case GET_HAMMER: return "Going to get a screwdriver from the workshop";
			case GET_RIFLE: return "Going to open the rifle case!";
			case FIX_KEY: return "If i fix this key in the workshop... I can have the rifle.";
			case CLEANUP_KITCHEN: return "Gotta cover my tracks... there's a sink in the kitchen!";
			case CLEANUP_OUTDOORS: return "Gotta cover my tracks, there's a pond outside!";
			case CLIFF_STALKER: return "If I wait here at the cliff, I can push someone to their doom!";
			case LOOSEN_BALCONY: return "I can turn the balcony into a death trap! Where's a hammer?";
			case BALCONY_STALKER: return "If I wait here at the balcony, I can push someone to their doom!";
			case LOOSEN_CHANDELIER: return "I can kill someone at dinner with the chandelier! Where's a wrench?";
			case BREWING_PERFUME_APOTH: return "Gonna make perfume in the apothecary";
			case CRAFTING_BOMB: return "Gotta make a bomb in the workshop.";
			case CRAFTING_LOCKPICK: return "Gotta make a lockpick in the workshop";
			case CRAFTING_PISTOL: return "Gotta make a pistol in  the workshop.";
			case DEFENSIVE_KILL: return "This should only been seen in facts.";
			case DRINKING_CELLAR: return "Going to the cellar for a drink";
			case DRINKING_HALL: return "Going to the dining hall for a drink.";
			case DRINKING_KITCHEN: return "Going to the kitchen for a drink.";
			case GET_FROG: return "Going outside for a poison frog.";
			case GET_MEDICINAL_PLANT_GREENHOUSE: return "Going to the greenhouse for a medicinal root.";
			case GET_MEDICINAL_PLANT_OUTDOORS: return "Going outside for a medicinal root.";
			case GET_RITUALS: return "Need to learn some spells.";
			default: return "I have no goals and am a figure of ridicule within the community.";
			}
		}
}
