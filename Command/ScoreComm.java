package Command;

import java.util.ArrayList;
import java.util.logging.Logger;

import Game.GameInterface;
import Parser.Parser;;

/**
 * @author Ema
 */
public class ScoreComm implements CommandInterface {    //updates score of the game
	
	private final static Logger LOGGER = Logger.getLogger(ScoreComm.class.getName());
	
	private GameInterface game;
	private Parser gameParser;

	public ScoreComm(GameInterface game,Parser gameParser){
	      this.game = game;
	      this.gameParser = gameParser;
	}
	
	@Override
	public String execute() {
		return game.score(gameParser.getTeam());
	}
	


}
