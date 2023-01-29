# 55starterfiles
Starter Project for Comp 55

You will use this project as your base.
Make sure that you understand the two files provided here

## UML Class Diagram for files provided
![](media/55GroupProjectUML.jpg)

## UML Sequence Diagram for files provided
![](media/55GroupProjectSequenceDiagram.png)

## Section 1: Overview of New Feature (Changing Backgrounds) 
By using the ACM program, I would implement background changes for the rooms of the mansion. I would also include arrows for each room that moves the player to a different room when clicked on. For example, the game starts in the dining hall, and the player can either choose to move to the kitchen, study, armory, or greenhouse. If the player is in the wine cellar, they can only move to the kitchen. Since the move() functions allow the player to move though different rooms too, there will be visual representations of "bus stops" on the map and in certain rooms.

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
