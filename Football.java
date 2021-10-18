package Game;



import java.util.logging.Logger;

/**
 * @author Ema

 */
public class Football implements GameInterface {
	
	public static enum State {
		START, PLAYING ,END
	}
	
	private final static Logger LOGGER = Logger.getLogger(Football.class.getName());
			
	private String guestTeam;
	private String homeTeam;
	
	private int guestScore;
	private int homeScore;
	

	
	private State state;
	
	
	public Football(){  //constructor
		reset();  //starting new game
	}
	

	@Override
	public String start(String guestTeam, String homeTeam) { //new game starts
		reset();
			
		state = State.START;
		
		this.guestTeam = guestTeam;
		this.homeTeam = homeTeam;
		
		return String.format("%s %d - %s %d\n", this.guestTeam, guestScore, this.homeTeam, homeScore);

	}
	
	
	@Override
	public String print() {  //prints the results of current game 
		if (state == State.END) {
			return "No game in progress";
		}
		
		return printInfo();
	}
	

	

	@Override
	public String score(String team) { //adds goal
		if (state == State.END) {
			return "No game in progress";
		}
		
		state = State.PLAYING;
		
		if(this.guestTeam.equals(team)) {
			guestScore++;
		
		}
		
		if(this.homeTeam.equals(team)) {
			homeScore++;
			
		}
		
		return "G O A L !!!\n" + printInfo();
	}

	@Override
	public String end() { //stops the game
	
		state = State.END;
		reset();
		
		return "The game has finished!\n";	
	}
	
	
	public String printInfo(){   //current info of the game
		
		String string = guestTeam + " " + guestScore + " ";
		
	
		
		string += " - " + homeTeam + " " + homeScore + " ";
		
	
		return string;
	}

	
	

	@Override
	public String invalid() {   //if the input is invalid
		if((state == State.START || state == State.PLAYING )) {
			return " 'Input error!! - type 'print' for info of the game'.";
		}
		else
			return " 'Input error!! - start game by typing through typing 'Start:'<Name of home team>' - '<Name of guest team>''.";
	}
	
	
	public void reset() { //making new game
		guestTeam = "";
		homeTeam = "";
		guestScore = 0;
		homeScore = 0;
		state = State.END;
	
	}

	public State getState() {
		return state;
	}
	
	public String getGuestTeam() {
		return guestTeam;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	
	public int getGuestScore(){
		return guestScore;
	}
	
	public int getHomeScore() {
		return homeScore;
	}
}
