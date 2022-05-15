package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

public class Dealer extends Participant {
	private DealerStrategy dealerStrategy;

	/**
	 * Instantiates a dealer of the game BlackJack and initialises the strategy of
	 * the dealer.
	 * 
	 * @param name           name of the dealer
	 * @param dealerStrategy initial strategy the dealer will take
	 */
	public Dealer(String name, DealerStrategy dealerStrategy) {
		super(name);
		this.dealerStrategy = dealerStrategy;
	}

	@Override
	public Action decideAction(Hand hand) {
		return dealerStrategy.play(hand);
	}

	public void setDealerStrategy(DealerStrategy dealerStrategy) {
		this.dealerStrategy = dealerStrategy;
	}

}
