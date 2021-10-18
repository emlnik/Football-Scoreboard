package Command;

import java.util.ArrayList;
import java.util.logging.Logger;

import Game.*;

/**
 * @author Ema
 */
public class ErrorComm implements CommandInterface {  //handles invalid command
	
	private final static Logger LOGGER = Logger.getLogger(ErrorComm.class.getName());
	
	private GameInterface game;

	public ErrorComm(GameInterface game){
	      this.game = game;
	}
	
	@Override
	public String execute() {
		return game.invalid();
	}


}
