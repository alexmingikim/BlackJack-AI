package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class StrategyTargetHighestBidder extends DealerStrategy {

	/**
	 * Instantiates a dealer strategy that targets the highest bidder for a given
	 * round.
	 * 
	 * @param game instance of BlackJack game
	 */
	public StrategyTargetHighestBidder(BlackJack game) {
		this.game = game;
	}

	@Override
	// Target player with highest bet
	public Player decideTarget() {

		int bet = 0; // Initialise
		Player targetPlayer = null; // Initialise

		for (Player player : game.getPlayers()) {
			if (player.getHand().getBet() > bet) {
				bet = player.getHand().getBet();
				targetPlayer = player; // Target player has highest bet
			}
		}
		return targetPlayer;
	}

	@Override
	public Action play(Hand hand) {
		// Conditions under which dealer will HOLD
		// (1) Dealer's score is equal or higher than score of target player (i.e.
		// highest bidder)
		// (2) Target player is busted
		// (3) Target player did BlackJack and score of dealer is at least 17
		Player targetPlayer = decideTarget();

		if ((hand.getScore() >= targetPlayer.getHand().getScore()) || (targetPlayer.getHand().isBust() == true)
				|| ((targetPlayer.getHand().isBlackJack() == true) && (hand.getScore() >= 17))) {
			return Action.HOLD;
		}
		// Otherwise HIT
		else {
			return Action.HIT;
		}
	}

}
