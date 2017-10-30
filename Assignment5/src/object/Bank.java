package object;

import java.util.Map;

import app.TestRSA;

public class Bank {

	private String publicKey;

	public String getPublicKey() throws Exception {

		// String source = "12005";
		String seed = "abc123";// 种子
		Map<String, Object> keyMap = TestRSA.initKey(seed);// 初始化密钥
		publicKey = TestRSA.getPublicKey(keyMap);

		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

}
