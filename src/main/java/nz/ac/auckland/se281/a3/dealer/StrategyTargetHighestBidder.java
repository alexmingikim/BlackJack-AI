package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public class StrategyTargetHighestBidder implements DealerStrategy {

	// Target player with highest bet
	public Player decideTarget(BlackJack game) {
		Player target;

		// Human is the target
		if (game.getPlayers().get(0).getBet() == Math.max(game.getPlayers().get(0).getBet(),
				Math.max(game.getPlayers().get(1).getBet(), game.getPlayers().get(2).getBet()))) {
			return game.getPlayers().get(0);
		}
		// Bot1 is the target
		else if (game.getPlayers().get(1).getBet() == Math.max(game.getPlayers().get(1).getBet(),
				game.getPlayers().get(2).getBet())) {
			return game.getPlayers().get(1);
		}
	}

	@Override
	Action play() {
		// TODO Auto-generated method stub
		return null;
	}

}
