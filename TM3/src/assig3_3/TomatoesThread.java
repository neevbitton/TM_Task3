//Neev Bitton 318504164 & Orel Dadon 313278061

package assig3_3;

public class TomatoesThread extends Thread {
	private SlicerMachine m;

	// Constructor
	public TomatoesThread(SlicerMachine m) {
		this.m = m;

	}

	// Run function
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			m.addOneTomato();
		}
	}
}
