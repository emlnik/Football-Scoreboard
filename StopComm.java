package Command;

import java.util.ArrayList;
import java.util.logging.Logger;

import Game.GameInterface;;

/**
 * @author Ema
 */
public class StopComm implements CommandInterface { //finishes the game
	
	private final static Logger LOGGER = Logger.getLogger(StopComm.class.getName());
	
	private GameInterface game;

	public StopComm(GameInterface game){
	      this.game = game;
	}
	
	@Override
	public String execute() {
		return game.end();
	}

}
