package object;

import java.util.Date;
import java.util.Map;

import rsa.RSAEncryption;

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
	private Date transactionTime;
	private boolean hasMessage;
	private Message message;
	private String privateKey;
	private String seed;
	// private MessageGenerator mg;

	public Client(int clientId, boolean hasMessage, Date transactionTime, int depositLimt, int withdrawalLimit) {
		this.clientId = clientId;
		this.hasMessage = hasMessage;
		this.transactionTime = transactionTime;
		this.depositLimt=depositLimt;
		this.withdrawalLimit=withdrawalLimit;
	}

	public Date getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Message getMessage() {
		return message;
	}

	public int getClientId() {
		return clientId;
	}

	public void setSeed(String seed) {
		this.seed = seed;
	}

	public String getSeed() {
		return seed;
	}

	public int getDepositLimt() {
		return depositLimt;
	}

	public int getWithdrawalLimit() {
		return withdrawalLimit;
	}

	public String getPrivateKey(String seed) throws Exception {
		// seed = "abc123";
		Map<String, Object> keyMap = RSAEncryption.initKey(seed);// 初始化密钥
		privateKey = RSAEncryption.getPublicKey(keyMap);

		return privateKey;
	}

	public String getencodedStr() throws Exception {
		return RSAEncryption.encryptByPublicKey(String.valueOf(getMessage().getMessageDetail()),
				this.getPrivateKey(seed));
	}
}
