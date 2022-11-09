package edu.pacific.comp55.starter;
import java.util.*; 

public class GoalSets {
private HashMap<String, HashSet<Goals>> GoalSets = new HashMap<String, HashSet<Goals>>();

public HashMap<String, HashSet<Goals>> getGoalSets() {
	return GoalSets;
}

public void setGoalSets(HashMap<String, HashSet<Goals>> goalSets) {
	GoalSets = goalSets;
}
	
}
