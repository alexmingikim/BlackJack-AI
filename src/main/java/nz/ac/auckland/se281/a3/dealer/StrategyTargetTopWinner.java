package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class StrategyTargetTopWinner extends DealerStrategy {

	/**
	 * Instantiates a dealer strategy that targets the player with the highest net
	 * wins
	 * 
	 * @param game instance of BlackJack game
	 */
	public StrategyTargetTopWinner(BlackJack game) {
		this.game = game;
	}

	@Override
	// Target player with the highest net wins
	public Player decideTarget() {

		int highestNetWins = 0; // Initialise
		Player targetPlayer = null; // Initialise

		for (Player player : game.getPlayers()) {
			if (player.getNetWins() > highestNetWins) {
				highestNetWins = player.getNetWins();
				targetPlayer = player; // Target player has highest net wins
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

		if ((hand.getScore() >= targetPlayer.getHand().getScore()) || (targetPlayer.getHand().getScore() > 21)
				|| (targetPlayer.getHand().getScore() == 21 && hand.getScore() >= 17)) {
			return Action.HOLD;
		}
		// Otherwise HIT
		else {
			return Action.HIT;
		}
	}
}
