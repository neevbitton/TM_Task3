//Neev Bitton 318504164 & Orel Dadon 313278061
package assig3_2;

public class GamePlay {
	private boolean coin_available_=true;
	private int rounds_counter_=0;

	public synchronized void makeCoinAvail(boolean val) {
		this.coin_available_ = val;
		if (val)
			notifyAll(); // If coin become available, threads will wake up.
	}

	public synchronized int flipCoin() {
		while (!coin_available_) {
			try {
				System.out.println("Thread " + Thread.currentThread().getName() + " is waiting for coin");
				wait();
			} catch (Exception e) {
			}
			if(rounds_counter_==10)
				return 0;
		}
		System.out.println("Thread " + Thread.currentThread().getName() + " is fliping coin");
		makeCoinAvail(false);
		rounds_counter_++;
		int rand = (int) (Math.random() * 2); // Picking random number between 0-1.
		makeCoinAvail(true);
		return rand;

	}

	/**
	 * Counter of rounds.
	 * @return int - counter of rounds.
	 */
	public synchronized int getNumOfRounds() {
		return rounds_counter_;
	}

}
