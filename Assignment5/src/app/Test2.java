package app;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		for (int i = 2; i <= num; i++) {
			boolean isPrime = true;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}

			if (isPrime) {
				System.out.println(i);
			}
		}
	}

}
