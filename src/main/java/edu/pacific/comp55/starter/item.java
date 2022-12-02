package edu.pacific.comp55.starter;

public enum item {
	TORCH, LANTERN, OIL, MONEY, COFFEE, BANDAGE, ANTIDOTE, FIRST_AID_KIT, DAGGER,
	INK, TAPE, HEMLOCK, BAD_FOOD, NIGHTSHADE, TREE_FROG_VENOM, SEDATIVES, POISON,
	CHLOROFORM, KNIFE1, KNIFE2, KNIFE3, KNIFE4, SWORD, PISTOL, RIFLE, RITES_OF_THE_HORSEMAN,
	THE_7_RITES_OF_RUIN, FAMILIARS, THE_DEMONS_LEGEND, FAE_JOKE_BOOK, SKULL,
	DOLL, JADE_STONE, RAT, BROKEN_KEY, BISMUTH, COBALT, DEMON_TOOTH,
	COBWEB, EYE_OF_NEWT, SENTIMENTAL_PEN, FEMUR, BRIMSTONE, CLOVE_OF_GARLIC,
	OLD_PICTURE, CRUSTY_TOADSTOOL, FROG, ROACH, GOAT_HEAD, URN, SPIDER,
	FRAGRANT_PLANT, MEDICINAL_PLANT, NOXIOUS_PLANT, SCREWDRIVER, WRENCH, HAMMER;
	
	public String toString() {
		switch(this) {
			case TORCH: return "torch";
			case LANTERN: return "lantern";
			case OIL: return "oil";
			case MONEY: return "money";
			case COFFEE: return "coffee";
			case BANDAGE: return "bandage";
			case ANTIDOTE: return "antidote";
			case FIRST_AID_KIT: return "first_aid_kit";
			case INK: return "ink";
			case TAPE: return "tape";
			case HEMLOCK: return "hemlock";
			case BAD_FOOD: return "bad_food";
			case NIGHTSHADE: return "nightshade";
			case TREE_FROG_VENOM: return "tree_frog_venom";
			case SEDATIVES: return "sedatives";
			case CHLOROFORM: return "chloroform";
			case KNIFE1: return "knife";
			case KNIFE2: return "knife";
			case KNIFE3: return "knife";
			case KNIFE4: return "knife";
			case SWORD: return "sword";
			case PISTOL: return "pistol";
			case RIFLE: return "rifle";
			case RITES_OF_THE_HORSEMAN: return "Rites_of_the_Horseman";
			case THE_7_RITES_OF_RUIN: return "The_7_Rites_of_Ruin";
			case FAMILIARS: return "Familiars";
			case THE_DEMONS_LEGEND: return "The_Demon's_Legend";
			case FAE_JOKE_BOOK: return "Fae_Joke_Book";
			case DOLL: return "doll";
			case JADE_STONE: return "jade_stone";
			case RAT: return "rat";
			case BROKEN_KEY: return "broken_key";
			case BISMUTH: return "bismuth";
			case COBALT: return "cobalt";
			case DEMON_TOOTH: return "demon_tooth";
			case COBWEB: return "cobweb";
			case EYE_OF_NEWT: return "eye_of_newt";
			case SENTIMENTAL_PEN: return "sentimental_pen";
			case FEMUR: return "femur";
			case BRIMSTONE: return "brimstone";
			case CLOVE_OF_GARLIC: return "clove_of_garlic";
			case OLD_PICTURE: return "old_picture";
			case CRUSTY_TOADSTOOL: return "crusty_toadstool";
			case FROG: return "frog";
			case ROACH: return "roach";
			case GOAT_HEAD: return "goat_head";
			case URN: return "urn";
			case SPIDER: return "spider";
			case FRAGRANT_PLANT: return "fragrant_plant";
			case MEDICINAL_PLANT: return "medicinal_plant";
			case NOXIOUS_PLANT: return "noxious_plant";
			case SCREWDRIVER: return "screwdriver";
			case WRENCH: return "wrench";
			case HAMMER: return "hammer";
		}
		return "n/a";
	}
		
	
}
