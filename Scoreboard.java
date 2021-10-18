package App;

import gui.ScoreboardGui;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import Game.Football;
import Parser.Parser;

/*
 *********************************
 
 *TODO finish making database and showing all content of it!!!
 
 *********************************
 */



/**
 * @author Ema
 * Inputs:
 * 1.	Start: '<Name of home team(first capital letter)>' - '<Name of guest team(first capital letter)>' -to start a game
 * 2.	'<Team>' -to add a goal
 * 3.	print -showing current result of the game
 * 4.	end - finishing the game 
 */
public class Scoreboard {
	
	
	public static void main(String[] args) {
		
		Football footBall = new Football();
		Parser gameParser = new Parser(footBall);
		

		ScoreboardGui window = new ScoreboardGui(gameParser,footBall);
		window.setVisible(true);
	
	
}
}
