
# CSCI 1302 - Reversi-Alpha

* **UML DUE THU 2016-02-18 (Feburary 18th) @ 11:59**
* **Full Project DUE THU 2016-03-03 (March 3rd) @ 11:59 PM**

This document contains the description for the Reversi Alpha project
assigned to the students in the Spring 2016 CSCI 1302 classes
at the University of Georgia. 

**Please read the entirety of this file before
beginning your project.** 

## Academic Honesty

You agree to the Academic Honesty policy as outlined in the course syllabus and
course website. Please follow the instructions contained in the Resources section below in order to do your 
development on nike.

## Updates

Updates will be posted in this document. You will be informed about any changes through **Piazza** and **ELC** so please keep a lookout for them.

## Project Description
Reversi (also known as “Othello”) is a two-player board game that involves strategically placing two-sided pieces on a grid until no more pieces can be placed.  Each move made results in one or more pieces getting flipped, changing ownership of those pieces.  Your job is to implement this game on the command line, allowing for all different player matchups including human vs. computer, human vs. human, and computer vs. computer.  You will implement different levels of computer intelligence. To get a better understanding of the game, play a couple of rounds of [http://www.gamesforthebrain.com/game/reversi/](http://www.gamesforthebrain.com/game/reversi/). For further reading, go to [https://en.wikipedia.org/wiki/Reversi](https://en.wikipedia.org/wiki/Reversi).

### Reversi Overview 
-	The game board is an 8×8 grid.
-	The two opponents, dark and light, alternate turns.
-	Game pieces have two sides: dark and light.
-	Dark makes the first move.
-	For each turn, the player must place a single piece with their color facing up in an empty cell, so that there exists at least one straight line (horizontal, vertical, or diagonal) between that piece and another piece of the same color, with an unbroken line of the opposing team’s color in-between.
-	The surrounded pieces of the other color should be flipped, changing ownership from your opponent to you.
-	One move may create multiple lines, so multiple lines of opposing pieces can be flipped.
-	If a player cannot make a move, their turn if forfeited.
-	The game ends when:
	*	Neither player can make a move, or;
	*	The board is full.
	*	Whichever player has more pieces showing their color at the end wins the game.  A tie is possible.



#### Command Syntax Format

In the sections below, each command will the syntax format that it must adhere
to in order to be considered correct. Syntactically incorrect commands are
considered an error. Information about displaying errors to the player is
contained in a section below. 

In a syntax format string, one or more white space is represented as a
<code>-</code>. Command tokens are enclosed in <code>[]</code> braces. If the
contents of a token are surrounded by <code>""</code> marks, then that token can 
only take on that literal value. If more than one literal value is accepted for
a token, then the quoted literals are separated by <code>/</code>. If the
contents of a token are surrounded by <code>()</code> marks, then that token can
only take on a value of the type expressed in parentheses.  

Syntax format strings are provided in this document in order to help you, the
student, understand how syntactically correct commands could potentially be 
inputted by the player. These strings do not directly correspond to anything in
the Java programming language. You should be able to use the information
provided in these syntax format strings to parse commands entered by the
user. 

## Project Tasks
###UML
First, design your project’s class diagram in UML. You may use [StarUML](http://staruml.io/), [Astah](http://astah.net/) or any other software that can be used to draw UML diagrams. This is due **UML DUE Thursday 2016-02-18 (Feburary 18th) @ 11:59** Your design should utilize the techniques we learned in class to show the appropriate relationships between the following classes:

*	```Board```: An interface that defines operations of a game board.
*	```ReversiBoard```: A class that implements the Board interface to hold a Reversi board.
*	```Player```: An abstract class that represents a player of the game.
*	```HumanPlayer```: A subclass of Player that represents a human player and plays by taking input from the user.
*	```ComputerPlayer```: A subclass of Player, but still abstract, that represents a computer player.
*	```RandomComputerPlayer```: A subclass of ComputerPlayer that plays by randomly selecting a valid play. 

The UML diagrams should be saved as PNG files and placed in a directory called ```uml``` under your project directory.
You will be writing the classes from scratch. This document is here to show you what minimum amount of classes you need to have. You may write more classes you see that suitable. 
###Interface
Your code should run by running:
```
java Reversi Human RandomComputerPlayer
```
Your game will be an interactive command-line application that is configured using command-line arguments.  In my example, available spaces are marked with the underscore character, but this is not required.  You should find an intuitive way to play against a computer, such as hard coding a delay before the computer makes its move.  I used X and O as the dark and light pieces here, but you may experiment with other options.  Here is an example run.  
<pre>

###Instructions
You need to have an instruction file that will describe you project and how it works. The file should be inside your project directory and describe how you implemented the functionality of this project and how to use your application.

$ java Reversi Human RandomComputerPlayer

Welcome to Reversi!  Moves should be entered in "[row] [column]" format.
  
    1 2 3 4 5 6 7 8
  1 . . . . . . . .
  2 . . . . . . . .
  3 . . . . _ . . .
  4 . . . X O _ . .
  5 . . _ O X . . .
  6 . . . _ . . . .
  7 . . . . . . . .
  8 . . . . . . . .

Enter your move, X player: 3 5

    1 2 3 4 5 6 7 8
  1 . . . . . . . .
  2 . . . . . . . .
  3 . . . _ X _ . .
  4 . . . X X . . .
  5 . . . O X _ . .
  6 . . . . . . . .
  7 . . . . . . . .
  8 . . . . . . . .

Enter your move, O player: 3 4

</pre>


## Project Grading

The UML design is worth **15%** of this project's grade.Your project will be graded based on a combination of test cases and source code inspection. If your program does not compile on Nike, then it will **not** be 
graded. If your program crashes (throws an exception and or exits unexpectedly),
then no points are earned for that test case, even if there is partial output.

TAs will run your code and play a couple of rounds testing the functionality described in this document.

## Extra Credit Tasks
Implement the following class:

```IntelligentComputerPlayer```: A subclass of ComputerPlayer that can regularly beat the random computer player. This means this class should be able to make a deliberate decision that could end up winning a round.
```IntelligentComputerPlayer``` should implement some kind of strategy to beat ```RandomComputerPlayer```.  One approach could be the greedy one: make the move that will flip the most pieces each time.  If you’re feeling creative, you may want to try some other techniques or even create some additional player classes.  Briefly describe the techniques you used in your ```README```.  


## How to Setup the Project Directory

You should create a directory called <code>cs1302-reversi-alpha-LastName1-LastName2</code> in
your present working directory that contains the project files. Replace ```LastName1``` and
```LastName2``` with the last names of your group members.

If you have any problems with any of these procedures, then please contact
your instructor.

## Submission Instructions

You will still be submitting your project via Nike. Make sure your project files
are on <code>nike.cs.uga.edu</code>. Change into the parent directory of your
project directory and let <code>PROJ_DIR</code> represent the name of your 
project directory in the instructions provided below. If you've followed the
instructions provided in this document, then the name of your project directory
is likely <code>cs1302-reversi-alpha-LastName1-LastName2</code>. While in your project parent
directory, execute the following command, depending on which section you are in:

### CRN 26245 (Cotterell 9AM)

    $ submit cs1302-reversi-alpha-LastName1-LastName2 cs1302a

### CRN 26311 (Cotterell 11AM)

    $ submit cs1302-reversi-alpha-LastName1-LastName2 cs1302b

### CRN 36424 (Ramaswamy)

    $ submit cs1302-reversi-alpha-LastName1-LastName2 cs1302c

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:

<pre>
$ tar zcvf cs1302-reversi-alpha-LastName1-LastName2.tar.gz cs1302-reversi-alpha-LastName1-LastName2
$ mutt -s "[cs1302] cs1302-reversi-alpha-LastName1-LastName2" -a cs1302-reversi-alpha-LastName1-LastName2.tar.gz -- your@email.com < /dev/null
</pre>

If you have any problems submitting your project then please email your
instructor as soon as possible. However, emailing him about something like this
the day or night the project is due is probably not the best idea.

