package nz.ac.auckland.se281.a3.bot;

public class StrategyFactory {

	/**
	 * Instantiates a certain strategy of a bot (using the factory design pattern).
	 * 
	 * @param typeOfStrategy strategy to be taken by a bot
	 * @return instance of a bot strategy
	 */
	public static BotStrategy createStrategy(String typeOfStrategy) {
		BotStrategy strategy = null;

		switch (typeOfStrategy) {
		case "R":
			strategy = new RandomStrategy();
			break;
		case "LR":
			strategy = new LowRiskStrategy();
			break;
		case "HR":
			strategy = new HighRiskStrategy();
			break;
		}
		return strategy;
	}

}
