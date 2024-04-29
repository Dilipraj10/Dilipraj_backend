package Practice;

import java.util.Scanner;

public class ArrayOpertions {

	public void createArr() {

		Scanner scan = new Scanner(System.in);
		System.out.println("enter the size of array");
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
	}

	public void printArr(int[] arr) {
		System.out.println("enter the array ele:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public void reverseArr(int[] arr) {
		System.out.println("reversed array:");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}

	public void mergeArr(int[] arr1, int[] arr2) {
		int[] arr3=new int[arr1.length+arr2.length];
		int k=0;
		for(int i=0;i<arr1.length;i++) {
			arr3[k]=arr1[i];
			k++;
		}
		
		for(int i=0;i<arr2.length;i++) {
			arr3[k]=arr2[i];
			k++;
		}
		
		
		for(int i=0; i<arr3.length;i++) {
			System.out.print(arr3[i]);
			
		}
		
		
	}
	
	
	public void maxNum(int[] arr)
	{
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
		System.out.println("max value is:" +max);
	}
	
	
	public void minNum(int[] arr)
	{
		int min=Integer.MAX_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
			}
		}
		System.out.println("min value is :" +min);
	}
	
	
	public void union()
	{
		int[] arr1= {1,2,3,4,5,6};
		int[] arr2= {4,5,6,8,9};

		int[] arr3 = new int[arr1.length+arr2.length];
		int k=0;
		for(int i=0;i<arr1.length;i++)
		{
			arr3[k]=arr1[i];
			k++;
		}
		
//		
		for(int i=0; i<arr3.length;i++) {
			for(int j=0;j<arr2.length;j++) {
				if(arr3[i]!=arr2[j])
				{
					arr3[k]=arr2[j];
					k++;
				}
			}
		
		}
		
//		for(int i=0;i<arr3.length;i++) {
//			System.out.print(arr3[k]);
//		}
	}
	
	public void OccArr()
	{
		int[] arr= {1,2,3,5,6,7,5,5};
		int k=5;
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==k)
			{
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	
	public void removeDup()
	{
		int[] arr1 = {1, 2, 3, 5, 6, 7, 5, 5};
        int[] arr2 = new int[arr1.length];
        int k = 0;

        // Iterate through the array to find unique elements
        for (int i = 0; i < arr1.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < k; j++) {
                if (arr1[i] == arr2[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                arr2[k] = arr1[i];
                k++;
            }
        }

        // Print the array without duplicates
        for (int i = 0; i < k; i++) {
            System.out.print(arr2[i] + " ");
        }
	}
	
	
	
	public void pattren()
	{
//		11111
//		22222
//		33333
//		44444
//		55555
		
		int n=5;
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public void pattrenAnother()
	{
//		12345
//		12345
//		12345
//		12345
//		12345

		
		int n=5;
		for(int i=1; i<=n; i++)
		{
			for(int j=1; j<=n; j++)
			{
//				row
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	
	public void pattrenAnotherOne()
	{
//		1
//		23
//		345
//		4567
//		56789

		
		int n=5;
		for(int i=1; i<=n; i++)
		{
			int k=i;
			for(int j=1; j<=n; j++)
			{
//				
				System.out.print(k + " ");
				k++;
			}
			System.out.println();
		}
	}
	
	
	
	
	

	public static void main(String[] args) {
//
//		Scanner scan = new Scanner(System.in);
//		System.out.println("enter the size of array");
//		int n = scan.nextInt();
//		int[] num1 = new int[n];
//		System.out.println("enter the array ele:");
//		for (int i = 0; i < num1.length; i++) {
//			num1[i] = scan.nextInt();
//		}
		
		
		
		
//		System.out.println("the ele are:");
//
//		for (int i = 0; i < num1.length; i++) {
//			System.out.println(num1[i]);
//		}

//		System.out.println("enter the size of second array");
//		int n2 = scan.nextInt();
//		int[] num2 = new int[n2];
//		System.out.println("enter the second array ele:");
//		for (int i = 0; i < num2.length; i++) {
//			num2[i] = scan.nextInt();
//		}
		
		
		
		
//		System.out.println("the ele are:");
//
//		for (int i = 0; i < num2.length; i++) {
//			System.out.println(num2[i]);
//		}
//		

		ArrayOpertions ob = new ArrayOpertions();
//		ob.createArr();
//		ob.printArr(num1);
//		ob.reverseArr(num1);
		System.out.println("==================================================");
//		ob.mergeArr(num1, num2);
		
//		ob.maxNum(num1);
//		ob.minNum(num1);
//		ob.union();
//		ob.OccArr();
//		ob.removeDup();
//		ob.pattren();
//		ob.pattrenAnother();
//		ob.pattrenAnotherOne();
		ob.removeDup();
//		
	}

}
