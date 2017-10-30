package app;

import java.util.ArrayList;
import java.util.Random;

public class TestRandom {

	  public static void main(String[] args) {
	        Object[] values = new Object[20];
	        Random random = new Random();
	        ArrayList<Integer> list = new ArrayList<Integer>();

	        for(int i = 0; i < values.length;i++){
	            int number = random.nextInt(10) + 1;
	            
	            if(!list.contains(number)){
	                list.add(number);
	            }
	        }
	        
	        values = list.toArray();
	        
	        // 遍历数组并打印数据
	        for(int i = 0;i < values.length;i++){
	            System.out.print(values[i] + "\t");
	            
	            if(( i + 1 ) % 10 == 0){
	                System.out.println("\n");
	            }
	        }
	    }
}
