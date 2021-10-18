package Command;

import java.util.ArrayList;
import java.util.logging.Logger;

import Game.GameInterface;

import Parser.Parser;

/**
 * @author Ema

 */
public class StartComm implements CommandInterface{
	
	private final static Logger LOGGER = Logger.getLogger(StartComm.class.getName());
	
	private GameInterface game;
	private Parser gameParser;
	
	public StartComm(GameInterface game, Parser gameParser){
	      this.game = game;
	      this.gameParser = gameParser;
	}
	
	@Override
	public String execute() {
		return game.start(gameParser.getGuestTeam(), gameParser.getHomeTeam());
	}


}
