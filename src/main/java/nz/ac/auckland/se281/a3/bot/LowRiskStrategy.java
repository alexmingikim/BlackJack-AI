package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class LowRiskStrategy implements Strategy {

	@Override
	public Action play(Hand hand) {
		// HOLD if current hand has a score of at least 17
		if (hand.getScore() >= 17) {
			return Action.HOLD;
		}
		// Otherwise HIT
		else {
			return Action.HIT;
		}
	}

	@Override
	public int bet() {
		// Create a random bet between 10 and 50 (inclusive)
		Random random = new Random();
		int numberRandom = random.nextInt(10, 51);
		return numberRandom;
	}

}
