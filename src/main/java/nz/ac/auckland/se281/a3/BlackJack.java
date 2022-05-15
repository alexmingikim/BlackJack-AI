package nz.ac.auckland.se281.a3;

import java.util.ArrayList;
import java.util.List;

import nz.ac.auckland.se281.a3.bot.Bot;
import nz.ac.auckland.se281.a3.dealer.Dealer;
import nz.ac.auckland.se281.a3.dealer.DealerStrategy;
import nz.ac.auckland.se281.a3.dealer.StrategyTargetHighestBidder;
import nz.ac.auckland.se281.a3.dealer.StrategyTargetTopWinner;

public class BlackJack {

	private List<Player> players;
	private Dealer dealer;
	private Deck deck;
	private DealerStrategy[] strategies;
	private int currentStrategy;

	/**
	 * Instantiates a game of BlackJack. Creates a list of players and adds human
	 * player as the first player of the game. Creates an array of strategies for
	 * the dealer.
	 * 
	 * @param deck deck of cards to be used in the BlackJack game
	 */
	public BlackJack(Deck deck) {
		this.deck = deck;
		players = new ArrayList<>();
		players.add(new Human("Player1")); // add the Human player first.
		strategies = new DealerStrategy[2];
		currentStrategy = 0;
	}

	/**
	 * This constructor is for testing reasons
	 * 
	 * @param cards
	 */
	protected BlackJack(Card... cards) {
		this(new Deck(cards));

	}

	public BlackJack() {
		this(new Deck());
	}

	public List<Player> getPlayers() {
		return players;
	}

	private String getBotStrategy() {
		System.out.println("Choose Bot strategy: random (R) - low risk (LR) - high risk (HR)");
		String result = Main.scanner.next();
		while (!result.equals("R") && !result.equals("LR") && !result.equals("HR") && !result.equals("A")) {
			System.out.println("please type \"R\", \"LR\",  \"HR\"");
			result = Main.scanner.next();
		}
		return result;
	}

	// do not change this method
	public void start() {
		initBots();
		initDealer();
		String res;
		int round = 0;
		do {
			round++;
			for (Participant p : players) {
				p.play(deck, round);
			}
			dealer.play(deck, round);
			printAndUpdateResults(round); // after each game print result and update scoreboard
			System.out.println("Do you want to play again?");
			res = Main.scanner.next();
			while (!res.equals("yes") && !res.equals("no")) {
				System.out.println("please type either \"yes\" or \"no\"");
				res = Main.scanner.next();
			}
		} while (res.equals("yes"));
		printGameStatistics(); // when the user terminates the game print the statistics
	}

	/**
	 * Instantiates Bot players that take a common strategy (strategy the bots take
	 * is defined by the user). Adds the Bot players to the array list "players".
	 */
	protected void initBots() {
		String botStrategyString = getBotStrategy(); // Obtain strategy for bots to take from user
		Bot bot1 = new Bot("Bot1", botStrategyString); // Create bots with desired strategy
		Bot bot2 = new Bot("Bot2", botStrategyString);
		players.add(bot1);
		players.add(bot2);
	}

	/**
	 * Instantiates a dealer which can take one of two strategies. Initially the
	 * dealer takes the StrategyTargetHighestBidder.
	 */
	protected void initDealer() {
		// set the initial strategy using the Strategy pattern
		strategies[0] = new StrategyTargetHighestBidder(this);
		strategies[1] = new StrategyTargetTopWinner(this);
		dealer = new Dealer("Dealer", strategies[currentStrategy]);
	}

	/**
	 * Updates the #Wins, #Losses and #NetWins for each player after a round
	 * finishes.
	 * 
	 * @param dealer dealer which the players are playing against
	 */
	private void updateResults(Dealer dealer) {
		for (Player player : players) {
			player.computeNetWins(dealer);
		}
	}

	/**
	 * Decides whether the dealer should change its strategy upon finishing a round.
	 * 
	 * @param dealer dealer whose strategy should be changed (if need)
	 */
	private void decideIfChangeStrategy(Dealer dealer) {
		// Decide whether to change to target top winner strategy
		if (currentStrategy == 0) {
			for (Player player : players) {
				if (player.getNetWins() >= 2) {
					currentStrategy++;
					dealer.setDealerStrategy(strategies[currentStrategy]);
					return;
				}
			}
		}

		// Decide whether to change to target highest bidder strategy
		if (currentStrategy == 1) {
			int countOfPlayersNetWinsLessThanTwo = 0;
			for (Player player : players) {
				if (player.getNetWins() < 2) {
					countOfPlayersNetWinsLessThanTwo++;
				}
			}
			if (countOfPlayersNetWinsLessThanTwo == players.size()) {
				currentStrategy--;
				dealer.setDealerStrategy(strategies[currentStrategy]);
				return;
			}
		}
	}

	/**
	 * Updates the results (wins and losses) of every player upon finishing a round.
	 * Decides if dealer should change its strategy. Prints how many chips a player
	 * won or lost in the round.
	 * 
	 * @Param round the current round as an int
	 */
	protected void printAndUpdateResults(int round) {
		updateResults(dealer);
		decideIfChangeStrategy(dealer);

		// Print for each player the amount of chip won or lost
		for (Player player : players) {
			if (player.isPlayerWon(dealer) == true) {
				System.out.println(
						"Round " + round + ": " + player.getName() + " won " + player.getHand().getBet() + " chips");
			} else {
				System.out.println(
						"Round " + round + ": " + player.getName() + " lost " + player.getHand().getBet() + " chips");
			}
		}
	}

	/**
	 * Prints the statistic of the game (i.e. how many times each player won and
	 * lost) when it ends.
	 */
	protected void printGameStatistics() {
		for (Player player : players) {
			System.out.println(player.getName() + " won " + player.getNumRoundsWon() + " times and lost "
					+ player.getNumRoundsLost() + " times");
		}

	}

}
