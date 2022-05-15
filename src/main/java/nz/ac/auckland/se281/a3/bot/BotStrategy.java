package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public interface BotStrategy {

	/**
	 * Decides how a bot player taking a specific strategy will play a game of
	 * BlackJack.
	 * 
	 * @param hand hand of the bot player
	 * @return either HOLD or HIT
	 */
	Action play(Hand hand);

	/**
	 * Decides how many chips a bot player will bet for a given round.
	 * 
	 * @return number of chips bot bets
	 */
	int bet();

}
