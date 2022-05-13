package nz.ac.auckland.se281.a3.bot;

public class StrategyFactory {

	public static Strategy createStrategy(String typeOfStrategy) {
		Strategy strategy = null;

		switch (typeOfStrategy) {
		case "R":
			strategy = new RandomStrategy();

		case "LR":
			strategy = new LowRiskStrategy();

		case "HR":
			strategy = new HighRiskStrategy();
		}
		return strategy;
	}

}
