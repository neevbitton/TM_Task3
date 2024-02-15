//Neev Bitton 318504164 & Orel Dadon 313278061

package assig3_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Please Type How Many Salads To Prepare:");
		Scanner scan = new Scanner(System.in);
		final int numOfSaladsToPrepare = scan.nextInt(); // num of salads input.
		System.out.println("Preparing " + numOfSaladsToPrepare + " Salads...");
		SlicerMachine slicer = new SlicerMachine();
		CucumbersThread c1 = new CucumbersThread(slicer);
		TomatoesThread t1 = new TomatoesThread(slicer);
		SlicerThread s1 = new SlicerThread(slicer, numOfSaladsToPrepare);
		c1.start();
		t1.start();
		s1.start();

		try {
			// this join command to purpose not to interrupt the tomatoes and cucumbers job
			// before its done.
			s1.join();
		} catch (Exception e) {
		}

		c1.interrupt();
		t1.interrupt();

		System.out.println("Done");
		scan.close();
	}

}
