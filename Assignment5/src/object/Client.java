package object;

import java.util.List;
import java.util.Map;
import java.util.Random;

import app.TestRSA;
import generator.MessageGenerator;

//– Transaction number – Date,
//– Time,
//– Client ID,
//– Message,
//– Digital signature,
//– Verified,
//– Transactions status.

public class Client {

	private int clientId;
	private int depositLimt;
	private int withdrawalLimit;
	private boolean hasMessage;
	private Message message;
	// private MessageGenerator mg;

	public Client(int clientId, boolean hasMessage) {
		this.clientId = clientId;
		this.hasMessage=hasMessage;
	}

	private String privateKey;

	// public int getMessage() {
	//// System.out.println("client's message= "+message);
	// return message;
	// }

	// public void setMessage(MessageGenerator mg) {
	// List<Integer> messageList=mg.generateRandomMessage();
	// Random random = new Random();
	// int index = random.nextInt(messageList.size());
	// message=messageList.get(index);
	//// System.out.println(messageList.get(index));
	// }

	public void setMessage(Message message){
		this.message=message;
	}
	
	public Message getMessage(){
		return message;
	}
	
	public int getClientId() {
		return clientId;
	}

	public String getPrivateKey() throws Exception {
		String seed = "abc123";// 种子
		Map<String, Object> keyMap = TestRSA.initKey(seed);// 初始化密钥
		privateKey = TestRSA.getPrivateKey(keyMap);

		return privateKey;
	}
}
