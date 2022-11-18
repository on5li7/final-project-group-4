package edu.pacific.comp55.starter;
import java.util.*; 

public class GoalSets {

	
public static ArrayList<Goal> innocuous;
public static ArrayList<Goal> sociable;
public static ArrayList<Goal> drinking;
public static ArrayList<Goal> poisonous;
public static ArrayList<Goal> gathering;
public static ArrayList<Goal> murderous;
public static ArrayList<Goal> rituals;

public void generateSets() {
innocuous.add(Goal.EATING);
innocuous.add(Goal.DRINKING_HALL);
innocuous.add(Goal.GOSSIPING);
innocuous.add(Goal.RANSACK);
innocuous.add(Goal.OOHSHINY);

sociable.add(Goal.GOSSIPING);
sociable.add(Goal.GOSSIPING);
sociable.add(Goal.GOSSIPING);
sociable.add(Goal.GOSSIPING);

drinking.add(Goal.DRINKING_CELLAR);
drinking.add(Goal.DRINKING_HALL);
drinking.add(Goal.DRINKING_KITCHEN);
drinking.add(Goal.DRINKING_CELLAR);
drinking.add(Goal.DRINKING_HALL);
drinking.add(Goal.DRINKING_KITCHEN);
drinking.add(Goal.DRINKING_CELLAR);
drinking.add(Goal.DRINKING_HALL);
drinking.add(Goal.DRINKING_KITCHEN);

gathering.add(Goal.OOHSHINY);
gathering.add(Goal.OOHSHINY);
gathering.add(Goal.RANSACK);
gathering.add(Goal.RANSACK);
gathering.add(Goal.RANSACK);
gathering.add(Goal.RANSACK);
gathering.add(Goal.GET_KNIFE);
gathering.add(Goal.GET_RIFLE);
gathering.add(Goal.GET_SWORD);
}
}
