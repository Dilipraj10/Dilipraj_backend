package day5;

import java.util.Random;
import java.util.function.Consumer;

public class Consumerexp {
	
	static void printMessage(String name){  
        System.out.println("Hello "+name);  
    }  
    static void printValue(int val){  
        System.out.println(val);  
    }

    public Integer getInteger() {
        return new Random().nextInt();
    }
    
	public static void main(String[] args) {
		
	    Consumer<String> c= Consumerexp::printMessage;
	    Consumer<Integer> c1= Consumerexp::printValue;
	    c.accept("Dilip");
	    c1.accept(19);
	    }  

	}


