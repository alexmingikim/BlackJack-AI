package nz.ac.auckland.se281.a3.bot;

import java.util.Random;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant.Action;

public class RandomStrategy implements BotStrategy {

	@Override
	public Action play(Hand hand) {
		// Generate random float between 0.0 and 1.0
		Random random = new Random();
		float numberRandom = random.nextFloat();

		Action resultAction;
		// Half of time --> HIT
		if (numberRandom < 0.5f) {
			resultAction = Action.HIT;
		}
		// Other half of time --> HOLD
		else {
			resultAction = Action.HOLD;
		}
		return resultAction;
	}

	@Override
	public int bet() {
		// Create a random bet between 1 and 100 (inclusive)
		Random random = new Random();
		int numberRandom = random.nextInt(1, 101);
		return numberRandom;
	}

}
