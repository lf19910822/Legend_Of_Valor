# CS611-Assignment 1
## Tic Tac Toe // Order and Chaos
---------------------------------------------------------------------------
- Name: Fan Lu
- Email: lf1991@bu.edu
- Student ID: U44379300

## Files
---------------------------------------------------------------------------
### Folder src/Characters
    The Folder Characters contains classes to represent monsters and humans.

	Classes:
	1. Character:
	The parent class of Monster and human, which contains some common attributes between human and monster.

	2. Human:
	The parent class of all three types of heroes. This class deals with items and levels and.

	3. Paladin or Sorcerer or Warriors: 
	The classes for different types of heroes. Each of them has their own levelUp() method.

	4.Monster:
	The class of Monster. The Monsters’ HP depends on their levels.

	5.CharacterMaps:
	The class of all characters loaded from .txt file. We put all heroes and monsters in their own Map. As a result, 
    we have three maps for different monsters and three for heroes. All data from .txt files will be checked and 
    distinguished automatically. 

### Folder src/Colors
    This folder contains an interface who handles colors.

	Interface:
	1. ColorsCodes:
	This interface contains a lot of color codes. 

### Folder src/data:
    This folder contains all .txt data from homework instruction.
    Folder src/Items:
    This folder contains all Items, like weapon, spell, armory and potion. Every item has their own type.

	Classes:
	1. Items:
	The parent class of all items. All items have name, price, level and type.

	2. Armory:
	The class of Armory.
	
	3. Spell
	The parent class of all three types of spells.

	4. fire/ice/lightSpell:
	The class of different spells and they differ in attribute “spellType”.

	5. Weapon:
	The class of weapon

### Folder src/places:
    This folder contains all places and each place is a piece.

	classes:
	1. common:
	The class of a base place, who has a rate to give heroes group a fight.
	
	2. herosGroup:
	The class of herosGroup piece, who contains a list of heroes in a game.

	3. market:
	The class of market piece.

	3. wall:
	The class of wall piece.

	3. monster:
	The class of monster piece.

### Folder src/tool:
    This class contains all the tools that can be used in anywhere in the project.

	Interface:
	1. formats:
	The interface contains many string formats. We use them when we need to print some information with format.

	2. toolClass:
	The class of all tools and every tool is static so we don’t need to new an instance to use these tools. 
    The tools can be divided into two groups: random tools and loading tools.
    The random tools deal with random logic, like getting a random number or throwing a dice. Also, we can get a random 
    value from any map or list.
    The loading tools deal with loading .txt files, like getting data line by line from a .txt file.
    Folder src/workLogics:
    This folder contains some important game logic like shopping or battle.

	Classes:
	1. Battle:
	The class of battle, who handles the whole work flow of a battle. In each round, heroes can attack, use spell, pick 
    a weapon or armory, print information, use potion or keep waiting. 

	2. Formulas:
	The class of most formulas. We calculate the damage, dodge chance, Exp and Gold after battle …… in this class. 
    Most of formulas are able to accept different multiply powering to fit in different logics.

	3. Market:
	The class of shopping, not the class of Market piece. This class handles the whole workflow of shopping with one hero. 
    The goods in Market are random and the shopping results will be kept during the game flow.
	Class market is a market factory because every market on the map needs to be individual. In this way, we ensure that 
    they are different market instances.

### Folder src:
    The root folder contains all game files.

	Classes:
	1. board:
	The class of board.
	
	2. Cell:
	The class of sell.

	3. Main:
	The class that contains the main function.

	4. workFlow:
	The class of game flow. 

## Notes
---------------------------------------------------------------------------
1. All heroes and monsters are loaded from .txt files and put into their own maps.
2. Every element on the map, like hero, monster, wall, market, is a piece. And every cell on the map is a piece stack.
For example: if a piece moves, we pop it out from the former cell and push it into the new cell. The former place on
the former cell will get back to the top of stack automatically. In this way, we can easily move any piece on the map and 
stack different items on the same cell.
3. The Market and Battle classes use factory pattern. We can only use their interfaces through their "get" methods. In this way,
we ensure that all markets and battles are individual. And because every market is individual, their goods are different and 
will be kept through a game flow.
4. The levelUp method in Human uses observer pattern. When a hero levels up, it will notify and update the EXP needed for next level.
In this way, when a hero gains exp, he can keep leveling up until he reaches the max level.
5. Most logics are implemented in Formulas class. We can easily change the formulas of damage, defense, exp, etc. by changing the
multipliers in Formulas class.
## How to compile and run
---------------------------------------------------------------------------
Navigate to the directory "hw4" after unzipping the files
Run the following instructions:
1. cd src;
2. javac Main.java
3. java Main

## Input/Output Example
---------------------------------------------------------------------------
```
 Legends: Monsters and Heroes 
Welcome, brave heroes, to a land shrouded in mystery and danger. 
You, marked as P on the map, travel as a united group of adventurers, bound by fate to face daunting challenges. 
Beware the F symbols————these mark encounters where fierce enemies await, ready to test your strength.
Seek the M for safe havens; these are bustling markets where you can trade, gather supplies, and gain much-needed respite.
As you journey, you’ll encounter the impassable # walls, which block your path, forcing you to navigate wisely. Forge ahead with courage, for glory and honor await!
Press Enter to continue...

Please form your heroes group first:
You have picked 0/3 heroes
Please pick a hero from the following list:
1. Warrior
2. Sorcerer
3. Paladin
4. Quit
3
You chose Paladin
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| NAME           | Garl_Glittergold |
| HP             | 100            |
| MP             | 100            |
| EXP            | 5              |
| Level          | 1              |
| Agility        | 500            |
| Strength       | 600            |
| Dexterity      | 400            |
| Gold           | 2500           |
+----------------+----------------+

You have picked 1/3 heroes
Please pick a hero from the following list:
1. Warrior
2. Sorcerer
3. Paladin
4. Quit
4
The story unfolds......
Press Enter to continue...

Enter HELP on the map for controlling help:
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |  P  |     |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit
a
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |  P  |     |     |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit
d
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |  P  |     |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit
d
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |     |  P  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit
d
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |     |     |  P  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit
d
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |     |     |     |  P  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
You are in a market, Do you want to enter? 1 YES, 0 NO
1
Welcome to the market！The buyer now is: Garl_Glittergold
Please pick what you want：
Garl_Glittergold's gold is: 2500
1. Armory
2. Weapon
3. Potion
4. Spell
5. Quit
1
You chose Armory!

ARMORYS
| Name                 | Price      | Level      | Damage Reduction     |
| Platinum_Shield      | 150        | 1          | 200                  |0
| Breastplate          | 350        | 3          | 600                  |1
| Guardian_Angel       | 1000       | 10         | 1000                 |2

Please type the index of the item you want to buy
2
Garl_Glittergold bought the item Guardian_Angel
Now he has 1500gold left
Want to buy again? 1    YES, 0    NO and quit
0
Do you want to sell your items? 1 YES, 0 NO and quit
0
See you again!
Press Enter to continue...

+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |     |     |     |  P  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit
a
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |     |     |  P  |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit
s
You are in a fight
!!!Battle starts!!!
Round 1
Heros: 
+--------------------+----------------+----------------+----------------+
| Name               | HP             | MP             | Damage         |
+--------------------+----------------+----------------+----------------+
| Garl_Glittergold   | 10             | 100            | 600            |	1
+--------------------+----------------+----------------+----------------+

Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Casper             | spirits        | 100            | 100            | 50             |	0
+--------------------+----------------+----------------+----------------+----------------+
Now is hero Garl_Glittergold's turn
1  regular attack
2  spell attack
3  pick weapon or armory
4  show hero's information
5  Use potion
6  Do nothing
3

Weapons:
| Name                 | Price | Level | Damage | RequiredHands |


Armories:
| Name                 | Price      | Level      | Damage Reduction     |
| Guardian_Angel       | 1000       | 10         | 1000                 |	0

Choose an item to pick, or type 'q' to quit
0
Hero Garl_Glittergold picked armory Guardian_Angel
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Casper             | spirits        | 100            | 100            | 50             |	0
+--------------------+----------------+----------------+----------------+----------------+
Press Enter to continue...

Now is monster Casper's turn
Monster Casper is attacking hero Garl_Glittergold
Monster Casper attacked Garl_Glittergold with 0 damage
Heros: 
+--------------------+----------------+----------------+----------------+
| Name               | HP             | MP             | Damage         |
+--------------------+----------------+----------------+----------------+
| Garl_Glittergold   | 10             | 100            | 600            |	1
+--------------------+----------------+----------------+----------------+
Press Enter to continue...


Round 2
Heros: 
+--------------------+----------------+----------------+----------------+
| Name               | HP             | MP             | Damage         |
+--------------------+----------------+----------------+----------------+
| Garl_Glittergold   | 10             | 100            | 600            |	1
+--------------------+----------------+----------------+----------------+

Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Casper             | spirits        | 100            | 100            | 50             |	0
+--------------------+----------------+----------------+----------------+----------------+
Now is hero Garl_Glittergold's turn
1  regular attack
2  spell attack
3  pick weapon or armory
4  show hero's information
5  Use potion
6  Do nothing
***Invalid input***
1  regular attack
2  spell attack
3  pick weapon or armory
4  show hero's information
5  Use potion
6  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Casper             | spirits        | 100            | 100            | 50             |	0
+--------------------+----------------+----------------+----------------+----------------+
Choose a monster by index to attack
0
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Garl_Glittergold   | Casper             | 580            | 0.75           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Garl_Glittergold attacked Casper with 580 damage
Monster Casper is dead!
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+----------------+----------------+----------------+----------------+
All monsters are dead! heroes win!
Battle ends!
All heroes regain HP and MP:
Garl_Glittergold regained 20 HP and 20 MP.
All heroes not in faint gain: 100 gold and 5 EXP!
Press Enter to continue...

+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |     |     |  #  |  F  |  F  |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |  #  |  F  |     |  #  |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  F  |  #  |     |     |     |     |     |  M  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  F  |     |  #  |  #  |     |  P  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |  #  |  M  |  M  |  F  |  F  |     |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|  M  |     |  #  |  F  |     |     |  F  |  #  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |     |     |     |  #  |  F  |     |  F  |
+-----+-----+-----+-----+-----+-----+-----+-----+
|     |  #  |     |  F  |     |     |  F  |     |
+-----+-----+-----+-----+-----+-----+-----+-----+
W: Move Up
S: Move Down
A: Move Left
D: Move Right
I: Print Introductions
M: Print Map
R: reset Map
Q: Quit


```