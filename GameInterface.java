package Game;

import java.util.ArrayList;

/**
 * @author Ema
 */
public interface GameInterface {

	public String start(String awayTeam, String homeTeam);
	public String print();
	public String score(String team);
	public String end();
	public String invalid();

}