package nz.ac.auckland.se281.a3.bot;

import nz.ac.auckland.se281.a3.Participant.Action;

public interface Strategy {

	Action play();

	int bet();

}
