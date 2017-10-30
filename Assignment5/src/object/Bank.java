package object;

import java.util.Map;

import rsa.RSAEncryption;

public class Bank {

	private String publicKey;
	private Client client;

	// public String getClientSeed(){
	// Cli
	// }

	public String getPublicKey(String seed) throws Exception {

		// String source = "12005";
		// String seed = "abc123";// 种子
		Map<String, Object> keyMap = RSAEncryption.initKey(seed);// 初始化密钥
		publicKey = RSAEncryption.getPrivateKey(keyMap);

		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	

	public String getdecodedStr(String encodedStr) throws Exception {
		return RSAEncryption.decryptByPrivateKey(encodedStr, this.publicKey);
	}

}
