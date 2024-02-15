//Neev Bitton 318504164 & Orel Dadon 313278061

package assig3_3;

public class SlicerMachine {

	// Properties
	int numOfCucumbers = 0;
	int numOfTomatoes = 0;
	int numOfPreparedSalads = 0;

	final int cucumbersNeededForOneSalad = 3;
	final int tomatoesNeededForOneSalad = 2;

	// add one cucumber into the slicer chamber
	public synchronized void addOneCucumber() {

		while (numOfCucumbers >= cucumbersNeededForOneSalad) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("adding one cucumber to the machine");
		numOfCucumbers++;
		notifyAll();

	}

	// add one tomato into the slicer chamber
	synchronized void addOneTomato() {
		while (numOfTomatoes >= tomatoesNeededForOneSalad) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		System.out.println("adding one tomato to the machine");
		numOfTomatoes++;
		notifyAll();

	}

	// if there are enough vegetables in the slicer
	// chamber, make another salad
	synchronized void sliceVegetables() {
		while ((numOfCucumbers < cucumbersNeededForOneSalad) || (numOfTomatoes < tomatoesNeededForOneSalad)) {
			try {
				wait();
			} catch (Exception e) {
			}
		}
		makeNewSalad();

	}

	synchronized void makeNewSalad() {
		System.out.println("== preparing one more salad ==");
		numOfPreparedSalads++;
		// update stock
		numOfTomatoes = numOfTomatoes - tomatoesNeededForOneSalad;
		numOfCucumbers = numOfCucumbers - cucumbersNeededForOneSalad;
		notifyAll();
	}

	synchronized int getNumOfPreparedSalads() {
		return numOfPreparedSalads;
	}

}
