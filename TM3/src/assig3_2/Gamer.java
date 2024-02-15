//Neev Bitton 318504164 & Orel Dadon 313278061
package assig3_2;

public class Gamer extends Thread {
	private int goodFlipsCounter;
	private GamePlay game;

	public Gamer(GamePlay game) {
		goodFlipsCounter = 0;
		this.game = game;
	}

	public void play() {
		while (!Thread.currentThread().isInterrupted() && game.getNumOfRounds() < 10) {
			goodFlipsCounter += game.flipCoin();
			try {
				Thread.currentThread().sleep(1000);
			} catch (Exception e) {
			}
		}
	}
	/**
	 * Getter for good flips counter.
	 * @return int - counter of good flips.
	 */
	public int getScore() {
		return goodFlipsCounter;
	}

	//run function
	public void run() {
		play();
	}

}
