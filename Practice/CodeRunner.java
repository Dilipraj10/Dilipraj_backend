package Practice;

import java.util.Scanner;

public class  {

	public static int[] arrayAsc(int[] arr)
	{
		int temp;
		for(int i=0;i<arr.length; i++) {
			if(arr[i]<arr[i+1])
			{
				temp=arr[i+1];
				arr[i+1]=arr[i];
				arr[i]=temp;
						
			}
				
				
		}
		return arr;
		
	}
	
	
		
		
	}
	
	public static void main(String[] args) {
			
		System.out.println("hello world");
		System.out.println("enter array size");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] num1 = new int[n];
		System.out.println("enter the array ele:");
		for (int i = 0; i < num1.length; i++) {
			num1[i] = scan.nextInt();
		}
		System.out.println("the ele are:");

		for (int i = 0; i < num1.length; i++) {
			System.out.println(num1[i]);
		}
		
		
		CodeRunner cr= new CodeRunner();
		int[] asc=arrayAsc(num1);
		int[] des=arrayAsc(num1);
		System.out.println(asc);
		System.out.println(des);

		

	}

}
