package app;

import generator.MessageGenerator;
import object.Bank;
import object.Client;

//Simulator takes several input arguments:  
//– Number of unique bank clients       0-50000
//– Number of distinct transactions     0-10000
//– Fraction of invalid messages        0 correct 1 incorrect
//– Output files 

//The simulator then randomly creates the requested number of unique clients, 
//and the requested number of unique pairs (message, digital signature), 
//taking into account parameter fraction of incorrect message parameter, 
//as explained below. For each of the unique (message, digital signature) pair, 
//it then simulates the verification process, and writes the simulation results into the provided output

public class App {

	public static void main(String[] args) throws Exception {
		
		Bank bank =new Bank();
		System.out.println(bank.getPublicKey());
		
		//client id 1
		Client client =new Client(1,true);
		System.out.println(client.getPrivateKey());
		MessageGenerator mg=new MessageGenerator();
//		client.setMessage(mg);
//		System.out.println(client.getMessage());
	}

}
