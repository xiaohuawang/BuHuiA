package app;

import java.util.Random;

public class Test2 {

	public static void main(String[] args) {
		Random random = new Random();
		for (int i = 0; i < 20; i++) {
			int number = random.nextInt(100) + 1;
			System.out.println("number= " + number);
		}
	}
}
