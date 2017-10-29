package app;

import java.util.List;

import generator.MessageGenerator;

//Simulator takes several input arguments:  
//– Number of unique bank clients       0-50000
//– Number of distinct transactions     
//– Fraction of invalid messages        0 correct 1 incorrect
//– Output files 

//The simulator then randomly creates the requested number of unique clients, 
//and the requested number of unique pairs (message, digital signature), 
//taking into account parameter fraction of incorrect message parameter, 
//as explained below. For each of the unique (message, digital signature) pair, 
//it then simulates the verification process, and writes the simulation results into the provided output

public class App {
	
	
	
	public static void main(String[] args){
		MessageGenerator mg=new MessageGenerator();
		List<Integer> messageList=mg.generateRandomMessage();
		
		for(int i=0;i<messageList.size();i++){
			System.out.println(messageList.get(i));
		}
		
	}

}
