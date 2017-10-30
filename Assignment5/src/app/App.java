package app;

import java.util.ArrayList;

import object.Transcation;
import writeFile.WriteResult;

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

//40 20 0.2 TransactionResult.csv
public class App {

	public static void main(String[] args) throws Exception {
		
		Transcation transaction=new Transcation();
		WriteResult wResult=new WriteResult();
		
		ArrayList<String> resultList=transaction.transactionStart(args[0],args[1],args[2]);
		wResult.writeResult(resultList,args[3]);
		
	}

}
