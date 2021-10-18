package Command;

import java.util.ArrayList;
import java.util.logging.Logger;

import Game.GameInterface;;

/**
 * @author Ema
 
 */
public class PrintComm implements CommandInterface { //prints current score of the game
	
	private final static Logger LOGGER = Logger.getLogger(PrintComm.class.getName());

	private GameInterface game;

	public PrintComm(GameInterface game){
	      this.game = game;
	}
	
	@Override
	public String execute() {
		return game.print();
	}


}
