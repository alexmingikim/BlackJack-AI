package nz.ac.auckland.se281.a3.dealer;

import java.util.List;

import nz.ac.auckland.se281.a3.BlackJack;
import nz.ac.auckland.se281.a3.Hand;
import nz.ac.auckland.se281.a3.Participant;
import nz.ac.auckland.se281.a3.Player;

/**
 * 
 * You should change this class for Task 2
 *
 */
public class Dealer extends Participant {
	private DealerStrategy dealerStrategy;
	private int scoreOfHumanPlayer;
	private int scoreOfBotOne;
	private int scoreOfBotTwo;
	private int betOfHumanPlayer;
	private int betOfBotOne;
	private int betOfBotTwo;
	private List<Player> players;

	public Dealer(String name, BlackJack game) {
		super(name);

		scoreOfHumanPlayer = game.getPlayers().get(0).getHand().getScore();
		scoreOfBotOne = game.getPlayers().get(1).getHand().getScore();
		scoreOfBotTwo = game.getPlayers().get(2).getHand().getScore();
		betOfHumanPlayer = game.getPlayers().get(0).makeABet();
		betOfBotOne = game.getPlayers().get(1).makeABet();
		betOfBotTwo = game.getPlayers().get(2).makeABet();
		players = game.getPlayers();

	}

	@Override
	public Action decideAction(Hand hand) {
		return dealerStrategy.play(hand);
	}

	public int getScoreOfPlayerOne() {
		return scoreOfHumanPlayer;
	}

	public int getScoreOfBotOne() {
		return scoreOfBotOne;
	}

	public int getScoreOfBotTwo() {
		return scoreOfBotTwo;
	}

	public int getBetOfHumanPlayer() {
		return betOfHumanPlayer;
	}

	public int getBetOfBotOne() {
		return betOfBotOne;
	}

	public int getBetOfBotTwo() {
		return betOfBotTwo;
	}

	public List<Player> getPlayers() {
		return players;
	}

}
