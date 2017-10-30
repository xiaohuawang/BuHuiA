package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import object.Message;

//where a message is a randomly generated integer from the set [0, 30000]

//client is requesting - numbers 0-4 mean that a client is requesting a deposit, 
//whereas numbers digits 5-9 mean that a client is requesting a withdrawal.
//That last digit should be included into a computation of a digital signature.

//a message 15005 means that a client wants to withdraw $1500 from their account,

public class MessageGenerator {

	private int messageNum;
	private List<Integer> messageDetailList = new ArrayList<Integer>();
	private List<Double> messageFractionList = new ArrayList<Double>();

	public ArrayList<Integer> generateRandomMessageDetail(int messageNum) {

		// log("Generating 10 random integers in range 0..99.");

		Random randomGenerator = new Random();
		ArrayList<Integer> messageDetailList = new ArrayList<Integer>();

		for (int idx = 1; idx <= messageNum; ++idx) {
			int randomMess = 10 + randomGenerator.nextInt(29000);
			messageDetailList.add(randomMess);
			// System.out.println("message ="+randomMess);
		}
		return messageDetailList;
	}

	public ArrayList<Double> generateRandomfractionNum(int messageNum) {

		Random randomGenerator = new Random();
		ArrayList<Double> fractionList = new ArrayList<Double>();

		for (int idx = 1; idx <= messageNum; ++idx) {
			double randomFraction = randomGenerator.nextDouble();
			fractionList.add(randomFraction);
			// System.out.println("randomFraction= " + randomFraction);
		}

		return fractionList;
	}

	public ArrayList<Message> setMessage(int messageNum) {

		System.out.println("messageNum= " + messageNum);
		this.messageNum = messageNum;

		ArrayList<Integer> messageDetailList = generateRandomMessageDetail(messageNum);
		ArrayList<Double> messageFractionList = generateRandomfractionNum(messageNum);
		ArrayList<Message> messageList = new ArrayList<Message>();

		for (int i = 0; i < messageNum; i++) {
			Message message = new Message();
			message.setMessageDetail(messageDetailList.get(i));
			message.setFractionNum(messageFractionList.get(i));
			messageList.add(message);
		}
		return messageList;
	}

	// public static void main(String[] args) {
	// MessageGenerator mg = new MessageGenerator();
	// ArrayList<Message> res = mg.setMessage();
	// System.out.println(res.size());
	//
	// for(int i=0;i<mg.messageNum;i++){
	// System.out.println(res.get(i).getFractionNum());
	// System.out.println(res.get(i).getMessageDetail());
	// }
	// }

}
