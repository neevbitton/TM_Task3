//Neev Bitton 318504164 & Orel Dadon 313278061

package assig3_3;

public class SlicerThread extends Thread {
	// Properties
	private int numOfSalads;
	private SlicerMachine m;

	public SlicerThread(SlicerMachine m, int numOfSalads) {
		this.m = m;
		this.numOfSalads = numOfSalads;

	}

	// Run function
	public void run() {
		while (m.getNumOfPreparedSalads() < numOfSalads) {
			m.sliceVegetables();
		}
		// When the slicer finish to prepare the number of salads he should, interrupt
		// the thread.
		Thread.currentThread().interrupt();
	}

}
