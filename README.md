# 55starterfiles
Starter Project for Comp 55

You will use this project as your base.
Make sure that you understand the two files provided here

## UML Class Diagram for files provided
![](media/55GroupProjectUML.jpg)

## UML Sequence Diagram for files provided
![](media/55GroupProjectSequenceDiagram.png)

## Section 1: Overview of New Feature (Changing Backgrounds) 
By using the ACM program, I would implement background changes for the rooms of the mansion. I would also include doors for each room that allow the player to go to a different room when clicked on. For example, the game starts in the dining hall, and the player can choose to move to the kitchen or another room such as the greenhouse. You can only go to certain rooms in each room. For example, if the player is in the wine cellar, they can only move to the kitchen. 

## Section 2: Pseudocode 
Start in MainApplication class 

declare the variables for the house and panes for the rooms

initialize these variables in the run() function

create functions that allow player to switch to different rooms

create a new pane for the dining hall called DiningHallPane

declare the variables for the background image and a button for the door that leads to kitchen 

in DiningHallPane() initialize the variables

create a function that shows the contents of the dining hall

create a function that removes the contents of the dining hall when switching to another room 

create a new pane for the kitchen called KitchenPane 

repeat the steps in making the DiningHallPane for the kitchen

In DiningHallPane create a function that allows the player to switch to the kitchen when the door button is clicked on

continue these steps for the remainder of the rooms 

## Section 3: Steps Implemented to Add Feature

1) I started in the dining hall pane and then made panes for the kitchen and wine cellar. 

2) I then connected these panes by "doors" so that the player can move from room to room by clicking these doors (they are also labeled with what room it leads to). 

3) I slowly added more rooms (greenhouse, study, hallway, and workshop) to the dining hall one by one. For each room I made "doors" to lead to the dining hall and added "doors" to the dining hall so that it leads to these rooms.

4) Since these rooms branch off into different rooms, I started with the right side of the mansion. I added the apothecary to the study and then the balcony to the apothecary and connected them with the doors. The balcony connects to the hallway and armory, too. The workshop and armory share doors. The dungeon is only connected to the armory. 

5) I then started adding rooms to the left side. There are four outdoor areas in total and the player can only move to adjacent rooms of each outdoors. The kitchen has a door with Outdoors 2 and the greenhouse shares a door with Outdoors 3. 

6) I added the cliff and connected it to Outdoor areas 1 and 4. 
