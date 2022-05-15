package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;
import nz.ac.auckland.se281.a3.Player;

public abstract class DealerStrategy {
	protected BlackJack game;

	/**
	 * For a given strategy of the dealer decides which player to target
	 * 
	 * @return player to target
	 */
	abstract Player decideTarget();

	/**
	 * For a given strategy of the dealer decides how the dealer should play (HOLD
	 * or HIT)
	 * 
	 * @param hand of the dealer
	 * @return either HOLD or HIT
	 */
	abstract Action play(Hand hand);

}
