package Parser;

import java.util.regex.*;

import Command.*;
import Game.GameInterface;

/**
 * @author Ema
 */
public final class Parser {  //using command and factory desing patterns 

	private String guestTeam;
	private String homeTeam;
	
	private String team;
	
	
	private GameInterface game;
	
	
	//constructor
	public Parser(GameInterface game) {
		this.game = game;
	}
	
	
	public CommandInterface parse(String string) {  //handles the inputs
		if(Pattern.matches("^Start: '(.+)' - '(.+)'$", string)) {
			Pattern r = Pattern.compile("Start: '(.+)' - '(.+)'$"); 
			
			Matcher m = r.matcher(string);
			
			while (m.find()) {
				guestTeam = m.group(1);
				homeTeam = m.group(2);
			}
			
			return new StartComm(game, this);
		}
		else if(Pattern.matches("^'(.+)'$", string)) {
			Pattern pattern = Pattern.compile("'(.+)'");
			Matcher matcher = pattern.matcher(string);
			
			while (matcher.find()) {
				
				team = matcher.group(1);
	
			}
			
			return new ScoreComm(game, this);
		}
		else if(string.equals("print")) {
			return new PrintComm(game);
		}
		else if(string.equals("end")) {
			return new StopComm(game);
		}
		else
			return new ErrorComm(game);
	}
	
	public String getGuestTeam() {
		return guestTeam;
	}

	public String getHomeTeam() {
		return homeTeam;
	}

	public String getTeam() {
		return team;
	}

 
}
