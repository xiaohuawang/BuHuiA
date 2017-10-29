package generator;

import java.util.ArrayList;
import java.util.Random;

//where a message is a randomly generated integer from the set [0, 30000]

//client is requesting - numbers 0-4 mean that a client is requesting a deposit, 
//whereas numbers digits 5-9 mean that a client is requesting a withdrawal.
//That last digit should be included into a computation of a digital signature.

//a message 15005 means that a client wants to withdraw $1500 from their account,

public class MessageGenerator {

	public ArrayList<Integer> generateRandomMessage() {

		// log("Generating 10 random integers in range 0..99.");

		// note a single Random object is reused here
		Random randomGenerator = new Random();
		ArrayList<Integer> messageList = new ArrayList<Integer>();

		for (int idx = 1; idx <= 50; ++idx) {
			int randomMess = 10 + randomGenerator.nextInt(29000);
			messageList.add(randomMess);
		}

		return messageList;
	}

}
