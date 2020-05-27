# 2048 

This is an implementation of the classic 2048 Game, which I created for a University project.

## Version

1.0

## Game

This is a single-player game, which is played on a 4x4 grid. 
Our objective is to move the numbered tiles and combining them to create a tile with the number 2048.
(Be aware, that you can only merge 2 tiles if they have the same numerical value.)

## Requirements

Building the project requires JDK 11 or later and [Apache Maven](https://maven.apache.org/)

### Comment

When it seems that we can't move to any direction, let's try each.
If we were right and we stayed in the same state, as we were in before, then we lose.
In that case the application moves to another screen, where we can read information about those players,
who had successfully won the game before.
