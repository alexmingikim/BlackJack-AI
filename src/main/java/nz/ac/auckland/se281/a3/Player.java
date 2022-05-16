package nz.ac.auckland.se281.a3;

import nz.ac.auckland.se281.a3.dealer.Dealer;

public abstract class Player extends Participant {
	private int netWins = 0;
	private int numRoundsWon = 0;
	private int numRoundsLost = 0;

	public Player(String name) {
		super(name);
	}

	/**
	 * Decides if a player won or lost against the dealer for a given round.
	 * 
	 * @param dealer dealer which a player is playing against
	 * @return true if player won or false if player lost
	 */
	public boolean isPlayerWon(Dealer dealer) {
		// Conditions for a player to win:
		// Player must not be busted AND
		// (1) Player has blackjack but dealer does not
		// (2) Player has higher score than dealer
		// (3) Player is not busted but dealer is busted
		if ((this.getHand().isBust() == false)
				&& (((this.getHand().isBlackJack() == true) && (dealer.getHand().isBlackJack() == false))
						|| ((this.getHand().getScore() > dealer.getHand().getScore()))
						|| (dealer.getHand().isBust() == true))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Computes the number of net wins for a given player.
	 * 
	 * @param dealer dealer which a player is playing against
	 */
	public void computeNetWins(Dealer dealer) {
		if (isPlayerWon(dealer) == true) {
			numRoundsWon++;
		} else {
			numRoundsLost++;
		}
		netWins = numRoundsWon - numRoundsLost;
	}

	public abstract int makeABet();

	public int getNetWins() {
		return netWins;
	}

	public int getNumRoundsWon() {
		return numRoundsWon;
	}

	public int getNumRoundsLost() {
		return numRoundsLost;
	}

}
