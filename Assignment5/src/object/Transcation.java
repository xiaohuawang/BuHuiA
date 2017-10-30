package object;

import java.util.ArrayList;

import generator.ClientGenerator;

public class Transcation {

	private Bank bank;
	private ClientGenerator cg;

	public Transcation() {
		bank = new Bank();
		cg = new ClientGenerator();
	}

	public ArrayList<String> transactionStart(String clientNumStr, String messageNumStr, String fractionStr)
			throws Exception {

		int transationID = 1;
		int clientNum = Integer.parseInt(clientNumStr);
		int messageNum = Integer.parseInt(messageNumStr);
		double fractionNum = Double.parseDouble(fractionStr);

		ArrayList<Client> clientList = cg.creatClient(clientNum, messageNum, fractionNum);

		System.out.println("size= " + clientList.size());
		ArrayList<String> resultList = new ArrayList<String>();

		for (int i = 0; i < clientNum; i++) {
			if ((clientList.get(i).getMessage() == null)) {
				System.out.println("seed =" + clientList.get(i).getSeed());
				System.out.println("private key= " + clientList.get(i).getPrivateKey(clientList.get(i).getSeed()));
				System.out.println("message= " + clientList.get(i).getMessage());
				System.out.println("deposit Limit= " + clientList.get(i).getDepositLimt());
				System.out.println("withdraw Limit= " + clientList.get(i).getWithdrawalLimit());
				System.out.println();
				
			} else if (clientList.get(i).getMessage() != null) {
				System.out.println("trancactionId =" + transationID);
				System.out.println("seed =" + clientList.get(i).getSeed());
				System.out.println("deposit Limit= " + clientList.get(i).getDepositLimt());
				System.out.println("withdraw Limit= " + clientList.get(i).getWithdrawalLimit());
				System.out.println("private key= " + clientList.get(i).getPrivateKey(clientList.get(i).getSeed()));
				System.out.println("message= " + clientList.get(i).getMessage().getMessageDetail());
				System.out.println("密文= " + clientList.get(i).getencodedStr());
				bank.getPublicKey(clientList.get(i).getSeed());
				if (clientList.get(i).getMessage().getMessageDetail() == 0) {
					System.out.println("verified = no");
				} else {
					System.out.println("verified = yes");
				}
				System.out.println("原文= " + bank.getdecodedStr(clientList.get(i).getencodedStr()));
				System.out.println();

				StringBuilder sb = new StringBuilder();
				sb.append(transationID + "   ");
				sb.append(clientList.get(i).getTransactionTime() + "  ");
				sb.append(clientList.get(i).getClientId() + "         ");
				sb.append(clientList.get(i).getMessage().getMessageDetail() + "    ");
				if (clientList.get(i).getMessage().getMessageDetail() == 0) {
					sb.append("no        ");
				} else {
					sb.append("yes        ");
				}
				sb.append(bank.getdecodedStr(clientList.get(i).getencodedStr()) + "               ");
				sb.append(clientList.get(i).getencodedStr() + " ");
				resultList.add(sb.toString());

				transationID++;
			}
		}
		return resultList;
	}
}
