package generator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class KeyGenerator {

	private long n;
	private long φ;
	private long e;
	private long d;

	// p, q, n , d, e is defined by the professor in the lecture
	public void geneate() {

		BigInteger p = BigInteger.probablePrime(7, new Random());
		BigInteger q = BigInteger.probablePrime(7, new Random());
		BigInteger nBig = p.multiply(q);
		n = Long.parseLong(nBig.toString());
		BigInteger one = new BigInteger("1");
		BigInteger φBig = p.subtract(one).multiply(q.subtract(one));
		φ = Long.parseLong(φBig.toString());

		List<Long> res = getPrimeList(φ);
		// System.out.println(res.size());

		System.out.println("p= " + p);
		System.out.println("q= " + q);
		System.out.println("n= " + n);
		System.out.println("φ= " + φ);

		this.getPrimeList((int) φ);
	}

	public List<Long> getPrimeList(long φ) {
		
		List<Long> primes = new ArrayList<>();
		if (φ == 1) {
			System.out.println("the number is relativelyprime with any number (except 0)");
		}
		System.out.print(φ);
		for (long j = 2; j < φ; j++) {
			int i = 2;
			while ((φ % i != 0 || j % i != 0) && (i <= j)) {
				i++;
			}
			if (i == (j + 1)) {
//				System.out.println("come");
				System.out.println("j= " + j);
				primes.add(j);
			}
		}
		return primes;
	}

	public long getRandomE() {

		geneate();
		List<Long> primes = getPrimeList(φ);

		Random random = new Random();
		int index = random.nextInt(primes.size());
		System.out.println("e= " + primes.get(index));
		Long e = primes.get(index);
		return e;
	}

	// e*d mod n=1
	public long getRandomD() {

		for (long d = 1; d < φ; d++) {

			BigInteger dBig = BigInteger.valueOf(d);
			BigInteger eBig = BigInteger.valueOf(e);
			BigInteger φBig = BigInteger.valueOf(φ);

			if (dBig.multiply(eBig).mod(φBig).equals(BigInteger.valueOf(1))) {
				System.out.println("come here");
				System.out.println("d= " + d);
				return d;
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		KeyGenerator kg = new KeyGenerator();
		// kg.geneate();
		// kg.getPrimeList(φ)
		kg.getRandomE();
		kg.getRandomD();
	}
}
