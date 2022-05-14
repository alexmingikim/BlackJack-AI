package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class StrategyTargetHighestBidder extends DealerStrategy {

	public StrategyTargetHighestBidder(BlackJack game) {
		this.game = game;
	}

	// Target player with highest bet
	public Player decideTarget() {

		// Human player is the target
		if (game.getPlayers().get(0).makeABet() == Math.max(game.getPlayers().get(0).makeABet(),
				Math.max(game.getPlayers().get(1).makeABet(), game.getPlayers().get(2).makeABet()))) {
			return game.getPlayers().get(0);
		}
		// Bot1 is the target
		else if (game.getPlayers().get(1).makeABet() == Math.max(game.getPlayers().get(1).makeABet(),
				game.getPlayers().get(2).makeABet())) {
			return game.getPlayers().get(1);
		}
		// Bot2 is the target
		else {
			return game.getPlayers().get(2);
		}
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
