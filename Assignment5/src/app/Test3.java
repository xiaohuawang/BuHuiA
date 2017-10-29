package app;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (long e = 1; e <= 10; e++) {
			boolean isPrime = true;
			for (int index = 2; index <= Math.sqrt(e); index++) {
				if (e % index == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				 System.out.println(e);
//				primes.add(e);
			}
		}
	}

}
