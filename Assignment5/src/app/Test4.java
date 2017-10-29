package app;

public class Test4 {

	public void suanShu(long num) {
		if (num == 1) {
			System.out.println("the number is relativelyprime with any number (except 0)");
		}
		System.out.print(num + ": 1,");
		for (long j = 2; j < num; j++) {
			int i = 2;
			while ((num % i != 0 || j % i != 0) && (i <= j)) {
				i++;
			}
			if (i == (j + 1)) {
				System.out.println("come");
				System.out.println("j= "+j);
//				primes.add(j);
			}
		}
	}



	public static void main(String args[]) {
		Test4 n1 = new Test4();
		n1.suanShu(123456);
	}
}
