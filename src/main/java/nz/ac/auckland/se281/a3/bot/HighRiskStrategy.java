package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class HighRiskStrategy implements Strategy {

	@Override
	public Action play(Hand hand) {
		// HOLD if current hand has a score of at least 19
		if (hand.getScore() >= 19) {
			return Action.HOLD;
		}
		// Otherwise HIT
		else {
			return Action.HIT;
		}
	}

	@Override
	public int bet() {
		// Create a random bet between 50 and 100 (inclusive)
		Random random = new Random();
		int numberRandom = random.nextInt(50, 101);
		return numberRandom;
	}

}
