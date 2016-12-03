# Dungeons of Doom

An emulation of the board game "Dungeons of Doom". This game was made using pure java code.

# Synopsis

The Dungeon of Doom is played on a rectangular grid, which serves as the
game's board. A human player, acting as a brave fortune-hunter, can move and
pick up gold. The goal is to get enough gold and then exit the dungeon. The
game is played in rounds. On each round, the player sends a command and if
the command is successful, an action takes place.

# How to play

A full list of the available commands is available below:

- HELLO - Displays the amount of gold required to complete the level.
- LOOK - Displays a 5x5 grid around the play as the central piece.
- PICKUP - If there is gold on the floor, it picks it up.
- MOVE <DIRECTION> - Moves the player in that direction. Directions possible are N/S/E/W.
- QUIT - Ends the game.

(All actions are case-sensitive)

The game ends either:
- When the player has collected enough gold and moves onto the exit square.
- When the Bot catches (moves onto the same square as) the Player.
- When the player enters 'QUIT'.

# Author
Created by Leon Boehmer in November 2016.
