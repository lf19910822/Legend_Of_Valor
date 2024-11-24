# CS611-Assignment 1
## Tic Tac Toe // Order and Chaos
---------------------------------------------------------------------------
- Name: Lu, Fan
- Email: lf1991@bu.edu
- Student ID: U44379300

- Name: Yu, Chenxu
- Email: yuchenxu@bu.edu
- Student ID: U06437190

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
    This folder contains all .txt data from homework instruction.\

### Folder src/Items:
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

	4. wall:
	The class of wall piece.

	5. aMonster:
	The class of monster piece.

    6. heroPossiblePosition
    Used in teleport  to temporarily display the spaces a hero can teleport to, 
    each marked with a unique index as its sign.


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

### Folder src/workLogics:
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
3. Monsters can not only move downward but also move left and right, allowing them to potentially bypass heroes, thereby 
increasing the game's difficulty.
4. Most logics are implemented in Formulas class. We can easily change the formulas of damage, defense, exp, etc. by changing the
multipliers in Formulas class.
5. We have colorful terminal output. We use the interface ColorsCodes to handle colors.
6. Music. Please TAKE OFF YOUR HEADPHONES!!!.

Patterns:
1. We use Factory pattern to handle the heroes loading process. If we want to add a new type of hero, we only need to add 
the .txt file and a new class for the hero.
2. We use Facade pattern in CharacterMaps and itemLists. Both of them provide a unified interface to get the data from .txt files.
3. We use Singleton pattern in AudioPlayer. We only need one instance of AudioPlayer to play music.
## How to compile and run
---------------------------------------------------------------------------
Navigate to the directory "hw5" after unzipping the files
Run the following instructions:
1. cd src;
2. javac Main.java
3. java Main

If you want to run it in your IDE, Be sure that the working directory is ../hw5/src, not ../hw5.

## Input/Output Example
---------------------------------------------------------------------------
```
********************************Legends of valor********************************
Press Enter to continue...

Please form your heroes group first:
You have picked 0/3 heroes, this hero is in line 1
Please pick a hero from the following list:
1. Warrior
2. Sorcerer
3. Paladin
1
You chose Warrior
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| NAME           | Muamman_Duathall |
| HP             | 100            |
| MP             | 300            |
| EXP            | 6              |
| Level          | 1              |
| Agility        | 500            |
| Strength       | 900            |
| Dexterity      | 750            |
| Gold           | 2546           |
+----------------+----------------+

You have picked 1/3 heroes, this hero is in line 2
Please pick a hero from the following list:
1. Warrior
2. Sorcerer
3. Paladin
2
You chose Sorcerer
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| NAME           | Undefeated_Yoj |
| HP             | 100            |
| MP             | 400            |
| EXP            | 7              |
| Level          | 1              |
| Agility        | 400            |
| Strength       | 800            |
| Dexterity      | 700            |
| Gold           | 2500           |
+----------------+----------------+

You have picked 2/3 heroes, this hero is in line 3
Please pick a hero from the following list:
1. Warrior
2. Sorcerer
3. Paladin
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

The story unfolds......
Press Enter to continue...

Enter HELP on the map for controlling help:
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 1
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
m
Please pick what you want:
Muamman_Duathall's gold is: 2546
1. Armory
2. Weapon
3. Potion
4. Spell
5. Quit
1
You chose Armory!

ARMORYS
| Name                 | Price      | Level      | Damage Reduction     |
| Breastplate          | 350        | 3          | 600                  |0
| Full_Body_Armor      | 1000       | 8          | 1100                 |1
| Wizard_Shield        | 1200       | 10         | 1500                 |2
| Guardian_Angel       | 1000       | 10         | 1000                 |3

Please type the index of the item you want to buy
0
Muamman_Duathall bought the item Breastplate
Now he has 2196gold left
Want to buy again? 1    YES, 0    NO and quit
1
Muamman_Duathall's gold is: 2196
1. Armory
2. Weapon
3. Potion
4. Spell
5. Quit
2
You chose Weapon!

Weapons
| Name                 | Price | Level | Damage | RequiredHands |
| Axe                  | 550   | 5     | 850    | 1             |0
| Dagger               | 200   | 1     | 250    | 1             |1

Please type the index of the item you want to buy
0
Muamman_Duathall bought the item Axe
Now he has 1646gold left
Want to buy again? 1    YES, 0    NO and quit
0
Do you want to sell your items? 1 YES, 0 NO and quit
0
See you again!
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 1
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 1
Now it's hero H3's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 2
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
item
0 - Pick an armory or weapon
1 - print items on body
2 - Drop all weapons
3 - Drop all Armors
4 - Use a potion
5 - Quit
0

Weapons:
| Name                 | Price | Level | Damage | RequiredHands |
| Axe                  | 550   | 5     | 850    | 1             |	0


Armories:
| Name                 | Price      | Level      | Damage Reduction     |
| Breastplate          | 350        | 3          | 600                  |	1

Choose an item to pick, or type 'q' to quit
0
Hero Muamman_Duathall picked weapon Axe
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 2
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 2
Now it's hero H3's turn to move
Hero H3 steps on a Bush!
Hero H3's dexterity is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 3
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
item
0 - Pick an armory or weapon
1 - print items on body
2 - Drop all weapons
3 - Drop all Armors
4 - Use a potion
5 - Quit
0

Weapons:
| Name                 | Price | Level | Damage | RequiredHands |


Armories:
| Name                 | Price      | Level      | Damage Reduction     |
| Breastplate          | 350        | 3          | 600                  |	0

Choose an item to pick, or type 'q' to quit
0
Hero Muamman_Duathall picked armory Breastplate
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 3
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H2's turn to move
Hero H2 steps on a Koulou!
Hero H2's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
s
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 3
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H3's turn to move
Hero H3 steps on a Koulou!
Hero H3's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
s
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 4
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 4
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H2 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 4
Now it's hero H3's turn to move
Hero H3 steps on a Bush!
Hero H3's dexterity is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H3 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 5
Now it's hero H1's turn to move
Hero H1 steps on a Bush!
Hero H1's dexterity is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 5
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H2 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 5
Now it's hero H3's turn to move
Hero H3 steps on a Bush!
Hero H3's dexterity is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H3 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 6
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 6
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H2 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 6
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H3's turn to move
Hero H3 steps on a Bush!
Hero H3's dexterity is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H3 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 7
Now it's hero H1's turn to move
Hero H1 steps on a Koulou!
Hero H1's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
You cannot move on, there is a monster besides
Press Enter to continue...


  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 7
Now it's hero H1's turn to move
Hero H1 steps on a Koulou!
Hero H1's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
attack
Monsters to be attacked:
M in the upper left of hero:
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| Type           | spirits        |
| NAME           | Andromalius |
| HP             | 300            |
| Level          | 3              |
| Base Damage    | 550            |
| Defense        | 450            |
| Dodge          | 25             |
+----------------+----------------+


Please choose a monster to attack:
Andromalius : 0
***Invalid input***
Please choose a monster to attack:
Andromalius : 0
0
1  regular attack
2  spell attack
3  show hero's information
4  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Andromalius        | spirits        | 300            | 450            | 25             |	0
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Muamman_Duathall   | Andromalius        | 1435           | 0.88           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Muamman_Duathall attacked Andromalius with 1435 damage
Monster Andromalius is dead!
Hero Muamman_Duathall finished his turn
Press Enter to continue...

The monster is defeated!
Hero regains HP and MP:
Muamman_Duathall regained 20 HP and 60 MP.
You have leveled up! Now you are level 2
Now you need 10 EXP to level up again.

Hero gains: 300 gold and 15 EXP!
Press Enter to continue...

One total battle round ends
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 7
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H2 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 7
Now it's hero H3's turn to move
Hero H3 steps on a Bush!
Hero H3's dexterity is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H3 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |M      |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 8
Now it's hero H1's turn to move
Hero H1 steps on a Koulou!
Hero H1's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
attack
Monsters to be attacked:
M above hero:
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| Type           | exoskeletons   |
| NAME           | Merrshaullk |
| HP             | 1000           |
| Level          | 10             |
| Base Damage    | 1000           |
| Defense        | 900            |
| Dodge          | 55             |
+----------------+----------------+


Please choose a monster to attack:
Merrshaullk : 0
0
1  regular attack
2  spell attack
3  show hero's information
4  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Merrshaullk        | exoskeletons   | 1000           | 900            | 55             |	0
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Muamman_Duathall   | Merrshaullk        | 1345           | 0.73           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Muamman_Duathall attacked Merrshaullk with 1345 damage
Monster Merrshaullk is dead!
Hero Muamman_Duathall finished his turn
Press Enter to continue...

The monster is defeated!
Hero regains HP and MP:
Muamman_Duathall regained 22 HP and 66 MP.
You have leveled up! Now you are level 3
Now you need -6 EXP to level up again.

You have leveled up! Now you are level 4
Now you need 65 EXP to level up again.

Hero gains: 1000 gold and 50 EXP!
Press Enter to continue...

One total battle round ends
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 8
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
a
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |H3     |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 8
Now it's hero H3's turn to move
Hero H3 steps on a Bush!
Hero H3's dexterity is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
attack
Monsters to be attacked:
M above hero:
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| Type           | dragon         |
| NAME           | Phaarthurnax |
| HP             | 600            |
| Level          | 6              |
| Base Damage    | 600            |
| Defense        | 700            |
| Dodge          | 60             |
+----------------+----------------+


Please choose a monster to attack:
Phaarthurnax : 0
0
1  regular attack
2  spell attack
3  show hero's information
4  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Phaarthurnax       | dragon         | 600            | 700            | 60             |	0
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Garl_Glittergold   | Phaarthurnax       | 460            | 0.70           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Garl_Glittergold attacked Phaarthurnax with 460 damage
Hero Garl_Glittergold finished his turn
Press Enter to continue...

Now is monster Phaarthurnax's turn
Monster Phaarthurnax is attacking hero Garl_Glittergold
Monster Phaarthurnax attacked Garl_Glittergold with 600 damage
Hero Garl_Glittergold is in faint!
Heros: 
+--------------------+----------------+----------------+----------------+
| Name               | HP             | MP             | Damage         |
+--------------------+----------------+----------------+----------------+
+--------------------+----------------+----------------+----------------+
Hero is in faint!
Monster Phaarthurnax finished his turn
Press Enter to continue...

Hero Garl_Glittergold is defeated! He will reborn in the Nexus!
Press Enter to continue...

One total battle round ends
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 9
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H1's turn to move
Hero H1 steps on a Koulou!
Hero H1's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
attack
Monsters to be attacked:
M above hero:
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| Type           | exoskeletons   |
| NAME           | Brandobaris |
| HP             | 300            |
| Level          | 3              |
| Base Damage    | 350            |
| Defense        | 450            |
| Dodge          | 30             |
+----------------+----------------+


Please choose a monster to attack:
Brandobaris : 0
0
1  regular attack
2  spell attack
3  show hero's information
4  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Brandobaris        | exoskeletons   | 300            | 450            | 30             |	0
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Muamman_Duathall   | Brandobaris        | 1435           | 0.85           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Muamman_Duathall attacked Brandobaris with 1435 damage
Monster Brandobaris is dead!
Hero Muamman_Duathall finished his turn
Press Enter to continue...

The monster is defeated!
Hero regains HP and MP:
Muamman_Duathall regained 26 HP and 79 MP.
Hero gains: 300 gold and 15 EXP!
Press Enter to continue...

One total battle round ends
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 9
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H2's turn to move
Hero H2 steps on a Koulou!
Hero H2's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
d
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 9
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H3's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
a
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |H1     |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 10
Now it's hero H1's turn to move
Hero H1 steps on a Koulou!
Hero H1's strength is increased by 200
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 10
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
s
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 10
Now it's hero H3's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
p
Hero H3 do nothing in this turn
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |M      |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 11
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
attack
Monsters to be attacked:
M above hero:
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| Type           | dragon         |
| NAME           | BunsenBurner |
| HP             | 400            |
| Level          | 4              |
| Base Damage    | 400            |
| Defense        | 500            |
| Dodge          | 45             |
+----------------+----------------+


Please choose a monster to attack:
BunsenBurner : 0
0
1  regular attack
2  spell attack
3  show hero's information
4  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| BunsenBurner       | dragon         | 400            | 500            | 45             |	0
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Muamman_Duathall   | BunsenBurner       | 1522           | 0.78           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Muamman_Duathall attacked BunsenBurner with 1522 damage
Monster BunsenBurner is dead!
Hero Muamman_Duathall finished his turn
Press Enter to continue...

The monster is defeated!
Hero regains HP and MP:
Muamman_Duathall regained 26 HP and 79 MP.
Hero gains: 400 gold and 20 EXP!
Press Enter to continue...

One total battle round ends
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 11
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
a
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 11
Now it's hero H3's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
d
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 12
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 12
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
d
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 12
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H3's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
attack
Monsters to be attacked:
M in the upper left of hero:
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| Type           | dragon         |
| NAME           | Phaarthurnax |
| HP             | 140            |
| Level          | 6              |
| Base Damage    | 600            |
| Defense        | 700            |
| Dodge          | 60             |
+----------------+----------------+


Please choose a monster to attack:
Phaarthurnax : 0
0
1  regular attack
2  spell attack
3  show hero's information
4  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Phaarthurnax       | dragon         | 140            | 700            | 60             |	0
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Garl_Glittergold   | Phaarthurnax       | 460            | 0.70           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Garl_Glittergold attacked Phaarthurnax with 460 damage
Monster Phaarthurnax is dead!
Hero Garl_Glittergold finished his turn
Press Enter to continue...

The monster is defeated!
Hero regains HP and MP:
Garl_Glittergold regained 20 HP and 20 MP.
You have leveled up! Now you are level 2
Now you need -4 EXP to level up again.

You have leveled up! Now you are level 3
Now you need 30 EXP to level up again.

Hero gains: 600 gold and 30 EXP!
Press Enter to continue...

One total battle round ends
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |H1     |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 13
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |H1     |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 13
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
a
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |M      |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |H1     |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |M      |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |M      |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 13
Now it's hero H3's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
a
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |M      |  |H1     |  |XX   XX|  |M      |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 14
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
You cannot move on, there is a monster besides
Press Enter to continue...

  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |M      |  |H1     |  |XX   XX|  |M      |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 14
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
attack
Monsters to be attacked:
M to the left of hero:
+----------------+----------------+
| Attribute      | Value          |
+----------------+----------------+
| Type           | exoskeletons   |
| NAME           | Kiaransalee |
| HP             | 800            |
| Level          | 8              |
| Base Damage    | 850            |
| Defense        | 950            |
| Dodge          | 85             |
+----------------+----------------+


Please choose a monster to attack:
Kiaransalee : 0
0
1  regular attack
2  spell attack
3  show hero's information
4  Do nothing
1
Monsters: 
+--------------------+----------------+----------------+----------------+----------------+
| Name               | Type           | HP             | Defense        | Dodge          |
+--------------------+----------------+----------------+----------------+----------------+
| Kiaransalee        | exoskeletons   | 800            | 950            | 85             |	0
+--------------------+----------------+----------------+----------------+----------------+
+--------------------+--------------------+----------------+----------------+
| Attacker           | Monster            | Damage         | Hit Rate       |
+--------------------+--------------------+----------------+----------------+
| Muamman_Duathall   | Kiaransalee        | 1432           | 0.58           |
+--------------------+--------------------+----------------+----------------+
Are you sure to attack? 1  Yes  0  No
1
Hero Muamman_Duathall attacked Kiaransalee with 1432 damage
Monster Kiaransalee is dead!
Hero Muamman_Duathall finished his turn
Press Enter to continue...

The monster is defeated!
Hero regains HP and MP:
Muamman_Duathall regained 26 HP and 79 MP.
You have leveled up! Now you are level 5
Now you need 139 EXP to level up again.

Hero gains: 800 gold and 40 EXP!
Press Enter to continue...

One total battle round ends
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |H1     |  |XX   XX|  |M      |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |H2     |  |       |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 14
Now it's hero H2's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
d
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |H1     |  |XX   XX|  |M      |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |M      |  |M      |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |       |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |M      |  |       |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |H3     |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 14
Now it's hero H3's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
d
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |M      |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Round 15
Monsters generated!
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |M      |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |H1     |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |M      |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
Now it's hero H1's turn to move
WASD: Move
P: Do nothing
I: Print Introductions
M: Enter a market(If you are in Nexus)
Item: Pick or Drop an item
ATTACK: Attack a monster
RECALL: Recall a hero
TELEPORT: Teleport a hero
Q: Quit
w
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |H1   M |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  B - B - B  P - P - P  I - I - I  B - B - B  B - B - B
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |M      |  |M      |  |XX   XX|  |M      |  |       |
  C - C - C  P - P - P  I - I - I  B - B - B  K - K - K  I - I - I  P - P - P  K - K - K
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |M      |  |M      |
  B - B - B  P - P - P  I - I - I  P - P - P  O - O - O  I - I - I  P - P - P  B - B - B
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |       |
  K - K - K  K - K - K  I - I - I  P - P - P  P - P - P  I - I - I  O - O - O  P - P - P
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  |       |  |       |  |XX   XX|  |       |  |       |  |XX   XX|  |       |  |       |
  P - P - P  P - P - P  I - I - I  K - K - K  K - K - K  I - I - I  P - P - P  K - K - K
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  |       |  |       |  |XX   XX|  |       |  |M      |  |XX   XX|  |       |  |M      |
  P - P - P  B - B - B  I - I - I  K - K - K  P - P - P  I - I - I  P - P - P  B - B - B
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
  |       |  |       |  |XX   XX|  |       |  |H2     |  |XX   XX|  |       |  |H3     |
  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N  I - I - I  N - N - N  N - N - N
****************Game over, Heroes win!****************

```