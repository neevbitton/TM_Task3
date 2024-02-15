//Neev Bitton 318504164 & Orel Dadon 313278061
package assig3_2;

public class Main {
	public static void main(String[] args) {
		GamePlay game = new GamePlay();
		Gamer g1 = new Gamer(game);
		Gamer g2 = new Gamer(game);
		Judge j1 = new Judge(game);
		g1.start();
		g2.start();
		j1.start();
		try {
			g1.join();
			g2.join();

		} catch (Exception e) {
		}
		j1.interrupt();
		// Result of game declaration
		if (g1.getScore() > g2.getScore())
			System.out.println("Player 1 wins");
		else if (g1.getScore() < g2.getScore())
			System.out.println("Player 2 wins");
		else
			System.out.println("Tie");

	}

}
