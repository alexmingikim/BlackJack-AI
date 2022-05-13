package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

/**
 * you should change this class for TASK 1
 */
public class Bot extends Player {

	private Strategy strategy;

	public Bot(String name, String strategy) {
		super(name);

		switch (strategy) {
		case "R":
			this.strategy = StrategyFactory.createStrategy("R"); // Create RandomStrategy instance
		case "LR":
			this.strategy = StrategyFactory.createStrategy("LR"); // Create LowRiskStrategy instance
		case "HR":
			this.strategy = StrategyFactory.createStrategy("HR"); // Create HighRiskStrategy instance
		}
	}

	@Override
	public Action decideAction(Hand hand) {
		return Action.HOLD;
	}

	@Override
	public int makeABet() {
		return 1;
	}

}
