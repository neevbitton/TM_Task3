//Neev Bitton 318504164 & Orel Dadon 313278061
package assig3_2;

public class Judge extends Thread {
	private GamePlay game;

	//Constructor
	public Judge(GamePlay game) {
		this.game = game;
	}

	//Judge will continue its work in a loop till its interrupted. 
	public void makeAva() {
		while (!Thread.currentThread().isInterrupted()) {
			game.makeCoinAvail(false);
			try {
				Thread.currentThread().sleep(1000);
			} catch (Exception e) {
			}
			game.makeCoinAvail(true);
			try {
				Thread.currentThread().sleep(500);
			} catch (Exception e) {
			}
		}
	}

	public void run() {
		makeAva();
	}

}
