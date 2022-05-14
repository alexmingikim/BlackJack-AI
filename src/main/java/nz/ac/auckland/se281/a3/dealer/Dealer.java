package nz.ac.auckland.se281.a3.dealer;

import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {
	private DealerStrategy dealerStrategy;

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
