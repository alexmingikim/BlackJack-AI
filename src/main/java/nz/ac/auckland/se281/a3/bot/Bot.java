package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Player;

public class Bot extends Player {

	private BotStrategy strategy;

	/**
	 * Instantiates a bot player. Strategy of the bot is taken as an input from the
	 * user.
	 * 
	 * @param name     name of the bot
	 * @param strategy strategy of the bot (provided by user)
	 */
	public Bot(String name, String strategy) {
		super(name);

		// Set strategy of bot according to user input
		switch (strategy) {
		case "R":
			this.strategy = StrategyFactory.createStrategy("R"); // Create RandomStrategy instance
			break;
		case "LR":
			this.strategy = StrategyFactory.createStrategy("LR"); // Create LowRiskStrategy instance
			break;
		case "HR":
			this.strategy = StrategyFactory.createStrategy("HR"); // Create HighRiskStrategy instance
			break;
		}
	}

	@Override
	public Action decideAction(Hand hand) {
		return strategy.play(hand);
	}

	@Override
	public int makeABet() {
		return strategy.bet();
	}

}
