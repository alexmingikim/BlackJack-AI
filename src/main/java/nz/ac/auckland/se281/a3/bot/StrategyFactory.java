package nz.ac.auckland.se281.a3.bot;

public class StrategyFactory {

	public static Strategy createStrategy(String typeOfStrategy) {
		Strategy strategy = null;

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
