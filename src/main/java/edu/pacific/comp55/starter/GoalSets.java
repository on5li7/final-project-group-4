package edu.pacific.comp55.starter;
import java.util.*; 

public class GoalSets {

	
public ArrayList<Goal> innocuous;
public ArrayList<Goal> sociable;
public ArrayList<Goal> drinking;
public ArrayList<Goal> poisonous;
public ArrayList<Goal> gathering;
public ArrayList<Goal> murderous;
public ArrayList<Goal> rituals;

public GoalSets() {
	this.innocuous = new ArrayList<Goal>();
	this.sociable = new ArrayList<Goal>();
	this.drinking = new ArrayList<Goal>();
	this.poisonous = new ArrayList<Goal>();
	this.gathering = new ArrayList<Goal>();
	this.murderous = new ArrayList<Goal>();
	this.rituals = new ArrayList<Goal>();
	
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
