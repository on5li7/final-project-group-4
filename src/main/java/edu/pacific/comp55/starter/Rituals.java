package edu.pacific.comp55.starter;
import java.util.ArrayList;
import java.util.Random;

public class Rituals {
public item item1;
public item item2;
Random rando;
public ArrayList<item> ritualItemPool;
public effect Spell;

Rituals() {
	ritualItemPool  = new ArrayList<item>();
	ritualItemPool.add(item.RAT);
	ritualItemPool.add(item.GOAT_HEAD);
	ritualItemPool.add(item.BISMUTH);
	ritualItemPool.add(item.BRIMSTONE);
	ritualItemPool.add(item.COBALT);
	ritualItemPool.add(item.COBWEB);
	ritualItemPool.add(item.DEMON_TOOTH);
	ritualItemPool.add(item.CLOVE_OF_GARLIC);
	ritualItemPool.add(item.ROACH);
	ritualItemPool.add(item.DOLL);
	ritualItemPool.add(item.SKULL);
	ritualItemPool.add(item.FEMUR);
	ritualItemPool.add(item.URN);
	ritualItemPool.add(item.EYE_OF_NEWT);
	ritualItemPool.add(item.SPIDER);
	int check = rando.nextInt(ritualItemPool.size());
	this.item1 = ritualItemPool.get(check);
	ritualItemPool.remove(ritualItemPool.get(check));
	check = rando.nextInt(ritualItemPool.size());
	this.item2 = ritualItemPool.get(check);
	ritualItemPool.remove(ritualItemPool.get(check));
	check = rando.nextInt(2);
	if (check = 0) {
		this.Spell = effect.REVIVE;
	}
}

public enum effect {
	REVIVE, KILL
}
}
