package nz.ac.auckland.se281.a3;

import nz.ac.auckland.se281.a3.dealer.Dealer;

/**
 * 
 * You can (and should) add new fields and/or methods
 *
 */
public abstract class Player extends Participant {
	protected int bet;
	private int netWins = 0;
	private int numRoundsWon = 0;
	private int numRoundsLost = 0;

	public Player(String name) {
		super(name);
		bet = makeABet();
	}

	// Decide if player won
	public boolean isWon(Dealer dealer) {
		// Conditions for a player to win:
		// (1) Player has blackjack but dealer does not
		// (2) Player and dealer both do not have blackjack but player has higher score
		// (3) Player is not busted but dealer is busted
		if ((this.getHand().getScore() == 21 && dealer.getHand().getScore() != 21)
				|| ((this.getHand().getScore() != 21 && dealer.getHand().getScore() != 21)
						&& (this.getHand().getScore() > dealer.getHand().getScore()))
				|| ((this.getHand().getScore() <= 21) && (dealer.getHand().getScore() > 21))) {
			return true;
		} else {
			return false;
		}
	}

	public int computeNetWins(Dealer dealer) {
		if (isWon(dealer) == true) {
			numRoundsWon++;
		} else {
			numRoundsLost++;
		}
		return netWins = numRoundsWon - numRoundsLost;
	}

	public abstract int makeABet();

	public int getBet() {
		return bet;
	}

}
