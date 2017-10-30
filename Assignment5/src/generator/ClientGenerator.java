package generator;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import object.Client;
import object.Message;

public class ClientGenerator {

	private int clientNum;
	private int messageNum;
	private double fractionNum;
	// private int transcationTimeRange

	private List<Integer> clientIdList = new ArrayList<Integer>();
	private List<String> seedList = new ArrayList<String>();
	public List<Date> transactionTimeList = new ArrayList<Date>();
	public List<Integer> depositLimitList=new ArrayList<Integer>();
	public List<Integer> withdrawLimitList=new ArrayList<Integer>();

	public ArrayList<Client> creatClient(int clientNum,int messageNum, double fractionNum) {
        
		this.clientNum=clientNum;
		this.messageNum=messageNum;
		this.fractionNum=fractionNum;
		
		System.out.println("create client");
		System.out.println("Total number of client = " + clientNum);
		System.out.println("Total number of messageNum = " + messageNum);
		
		ArrayList<Client> clientList = new ArrayList<Client>();
		MessageGenerator mg = new MessageGenerator();
		ArrayList<Message> messageList = mg.setMessage(messageNum);
//		System.out.println("size= " + messageList.size());
		Random random = new Random();

		setclientId();
		setTranscationTime();
		setSeed();
		setWithdrawLimit();
		setDepositLimit();
		
		// define the client
		for (int i = 0; i < clientNum; i++) {
			int number = random.nextInt(clientNum) + 1;
			if (number > messageNum) {
				Client client = new Client(clientIdList.get(i), false, transactionTimeList.get(i),depositLimitList.get(i),withdrawLimitList.get(i));
				client.setMessage(null);
				client.setSeed(seedList.get(i));
				clientList.add(client);
			} else {
				
				Client client = new Client(clientIdList.get(i), true, transactionTimeList.get(i),depositLimitList.get(i),withdrawLimitList.get(i));
				Message messageTemp=messageList.get(random.nextInt(messageNum));
				if(messageTemp.getFractionNum()<fractionNum){
					messageTemp.setMessageDetail(0);
				}
				client.setMessage(messageTemp);	
				client.setSeed(seedList.get(i));
				clientList.add(client);
			}
		}
		return clientList;
	}

	public void setclientId() {

		Random random = new Random();
		for (int i = 0; i < clientNum * 2; i++) {
			int number = random.nextInt(clientNum * 2) + 1;
			if (!clientIdList.contains(number)) {
				clientIdList.add(number);
			}
		}
	}

	public void setTranscationTime() {
		for (int i = 0; i < clientNum; i++) {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String currentTime = df.format(Calendar.getInstance().getTime());
			long startTime = Timestamp.valueOf(currentTime).getTime();
			long unixtime = startTime + 5 * 10000 * i;
			Date d = new Date(unixtime);
			transactionTimeList.add(d);
		}
	}

	public String randomStr(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random random = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(random.nextInt(AB.length())));
		return sb.toString().toLowerCase();
	}

	public void setSeed() {

		for (int i = 0; i < clientNum; i++) {
			seedList.add(randomStr(6));
		}
	}
	
	public void setWithdrawLimit() {
		
		Random random = new Random();
		for (int i = 0; i < clientNum; i++) {			
			int withdrawLimit=random.nextInt(3000);
			withdrawLimitList.add(withdrawLimit);
		}
	}
	
	public void setDepositLimit() {
		
		Random random = new Random();
		for (int i = 0; i < clientNum; i++) {
			int depositLimit=random.nextInt(2000);
			depositLimitList.add(depositLimit);
		}
	}

}
