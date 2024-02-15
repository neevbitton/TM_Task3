//Neev Bitton 318504164 & Orel Dadon 313278061
package assig3_1;

public class Main {

	static Object lock = new Object(); // Common lock for threads
	static boolean t1 = true;
	static boolean t2 = false;
	static boolean t3 = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {

						while (t1 == false) {
							try {
								lock.wait();
							} catch (Exception e) {
							}
						}
						System.out.println("a");
						t1 = false;
						t2 = true;
						lock.notifyAll();

					}
				}

			}

		}.start();

		new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						while (t2 == false) {
							try {
								lock.wait();
							} catch (Exception e) {
							}
						}
						System.out.println("b");
						// We keep the boolean for thread 2 true so it will keep run untill thread 3
						// will finish its code.
						t1 = false;
						t3 = true;
						lock.notifyAll();

					}

				}
			}

		}.start();
		new Thread() {
			public void run() {
				while (true) {
					synchronized (lock) {
						while (t3 == false) {
							try {
								lock.wait();
							} catch (Exception e) {
							}
						}
						System.out.println("c");
						t3 = false;
						t2 = false;
						t1 = true;
						lock.notifyAll();

					}

				}
			}

		}.start();

	}
}
