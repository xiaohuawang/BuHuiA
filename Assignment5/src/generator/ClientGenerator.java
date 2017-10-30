package generator;

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

	private int clientNum = 100;
	private int messageNum = 20;
//	private int transcationTimeRange

	public List<Integer> clientIdList = new ArrayList<Integer>();
	public List<Date> transactionTimeList = new ArrayList<Date>();

	public ArrayList<Client> creatClient() {
		System.out.println("create client");
		System.out.println("Total number of client = " + clientNum);

		ArrayList<Client> clientList = new ArrayList<Client>();
		MessageGenerator mg = new MessageGenerator();
		ArrayList<Message> messageList = mg.setMessage();
		System.out.println("size= " + messageList.size());
		Random random = new Random();
		setclientId();
		// define all the variable
		for (int i = 0; i < clientNum; i++) {
			int number = random.nextInt(clientNum) + 1;
			if (number > messageNum) {
				Client client = new Client(clientIdList.get(i), false);
				client.setMessage(null);
				clientList.add(client);
			} else {
				Client client = new Client(clientIdList.get(i), true);
				client.setMessage(messageList.get(random.nextInt(messageNum)));
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
			long unixtime = startTime + 5 * 1000;

			Date d = new Date(unixtime);
			transactionTimeList.add(d);
		}
	}

	public static void main(String[] args) {
		ClientGenerator cg = new ClientGenerator();
		

		// cg.setMessageList();
		// cg.setMessageFractionList();
		// cg.setMessage();
		//
		// System.out.println(cg.clientIdList.size());

		// System.out.println(cg.messageList.size());
		//
		
		cg.setTranscationTime();
		
		
//		ArrayList<Client> clientList = cg.creatClient();
//		
//		System.out.println("client list.size= " + clientList.size());
//		for (int i = 0; i < clientList.size(); i++) {
//			System.out.println("id= " + clientList.get(i).getClientId());
//			if (clientList.get(i).getMessage() != null) {
//				System.out.println("id= " + clientList.get(i).getMessage().getFractionNum());
//				System.out.println("id= " + clientList.get(i).getMessage().getMessageDetail());
//			} else {
//				System.out.println("id= " + clientList.get(i).getMessage());
//			}
//			System.out.println();
//		}
	}

}
