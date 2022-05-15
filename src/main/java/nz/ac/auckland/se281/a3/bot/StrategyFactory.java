package nz.ac.auckland.se281.a3.bot;

public class StrategyFactory {

	/**
	 * Instantiates a certain strategy of a bot (using the factory design pattern).
	 * 
	 * @param typeOfStrategy strategy to be taken by a bot
	 * @return instance of a bot strategy
	 */
	public static BotStrategy createStrategy(String typeOfStrategy) {
		BotStrategy strategy = null; // Initialise

		switch (typeOfStrategy) {
		case "R": // Random
			strategy = new RandomStrategy();
			break;
		case "LR": // Low risk
			strategy = new LowRiskStrategy();
			break;
		case "HR": // High risk
			strategy = new HighRiskStrategy();
			break;
		}
		return strategy;
	}

}
