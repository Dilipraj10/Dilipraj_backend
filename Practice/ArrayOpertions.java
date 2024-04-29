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

	public void printArr() {
		int[] arr1={1,2,4,5,6,8};
		System.out.println("enter the array ele:");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	public void reverseArr() {
		
		int[] arr1={9,8,7,6,5,3,2,};
		System.out.println("reversed array:");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}

	public void mergeArr() {
		int[] arr1={1,2,4,5,6,8};
		int[] arr2={9,8,7};

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
	
	
	public void maxNum()
	{
		int[] arr1={1,2,4,5,6,8};
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
	
	
	public void minNum()
	{
		int[] arr1={1,2,4,5,6,8};
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
		 int[] arr1 = {1, 2, 3, 4};
	        int[] arr2 = {4, 5, 7, 8};
	        int[] arr3 = new int[arr1.length + arr2.length];

	        int i = 0, j = 0, k = 0;

	        // Compare elements of arr1 and arr2, copy the smaller element to arr3
	        while (i < arr1.length && j < arr2.length) {
	            if (arr1[i] < arr2[j]) {
	                arr3[k++] = arr1[i++];
	            } else if (arr1[i] > arr2[j]) {
	                arr3[k++] = arr2[j++];
	            } else { // If both elements are equal, copy one and move both pointers
	                arr3[k++] = arr1[i++];
	                j++;
	            }
	        }

	        // Copy remaining elements of arr1
	        while (i < arr1.length) {
	            arr3[k++] = arr1[i++];
	        }

	        // Copy remaining elements of arr2
	        while (j < arr2.length) {
	            arr3[k++] = arr2[j++];
	        }

	        // Print arr3
	        System.out.print("arr3 = {");
	        for (int l = 0; l < arr3.length; l++) {
	            System.out.print(arr3[l]);
	            if (l < arr3.length - 1) {
	                System.out.print(", ");
	            }
	        }
	        System.out.println("}");
	}
	
	
	public void intersection()
	{
		int[] arr1 = {2, 4, 5, 6};
        int[] arr2 = {5, 3, 4, 7};
        
        int[] arr3 = new int[Math.min(arr1.length, arr2.length)]; // Maximum possible length is the minimum length of arr1 and arr2

        int k = 0; // Index for arr3

        // Initialize pointers for arr1 and arr2
        int i = 0;
        int j = 0;

        // Merge elements into arr3
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                arr3[k++] = arr1[i]; // If elements are equal, add to arr3 and move both pointers
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++; // If arr1 element is smaller, move arr1 pointer
            } else {
                j++; // If arr2 element is smaller, move arr2 pointer
            }
        }

        // Print arr3
        System.out.print("arr3 = {");
        for (int l = 0; l < k; l++) {
            System.out.print(arr3[l]);
            if (l < k - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
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
	
	public void sortArr()
	{
int[] arr = {5, 3, 8, 1, 2, 4};
        
        // Bubble sort algorithm
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // Swap if the element found is greater than the next element
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        System.out.print("Sorted array: {");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
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
	
	public void printDuplicates()
	{
		int[] arr1 = {1, 2, 3, 5, 6, 7, 5, 5};
        int[] arr2 = new int[arr1.length];
        int k = 0;

        // Iterate through the array to find duplicate elements
        for (int i = 0; i < arr1.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                arr2[k] = arr1[i];
                k++;
            }
        }

        // Print the array with duplicates
        System.out.print("Duplicate elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(arr2[i] + " ");
        }
	}
	
	
	public void zigzag()
	{
		int[] arr1 = {2, 3, 4, 5};
        int[] arr2 = {9, 8, 7, 6};
        int[] arr3 = new int[arr1.length + arr2.length];

        int index1 = 0;
        int index2 = 0;

        // Merge elements of arr1 and arr2 into arr3 alternately
        for (int i = 0; i < arr3.length; i += 2) {
            if (index1 < arr1.length) {
                arr3[i] = arr1[index1++];
            }
            if (index2 < arr2.length) {
                arr3[i + 1] = arr2[index2++];
            }
        }

        // Print the merged array arr3
        System.out.print("arr3 = {");
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i]);
            if (i < arr3.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
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
	
	public void primeNumber()
	{
		int[] arr1 = {1, 2, 3, 5, 6, 7, 5, 5};
		for(int i=0; i<array.length; i++){
	        boolean isPrime = true;
	        
	        //check to see if the numbers are prime
	        for (int j=2; j<array[i]; j++){
	            
	            if(array[i]%j==0){
	                isPrime = false;
	                break;
	            }
	        }
	        //print the number
	        if(isPrime)

	            System.out.println(array[i] + " are the prime numbers in the array ");
	    }
	}
	
	
	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("enter the size of array");
		int n = scan.nextInt();
		int[] num1 = new int[n];
		System.out.println("enter the array ele:");
		for (int i = 0; i < num1.length; i++) {
		num1[i] = scan.nextInt();
		}
		
		
		
		
//		System.out.println("the ele are:");
//
//		for (int i = 0; i < num1.length; i++) {
//			System.out.println(num1[i]);
//		}

		System.out.println("enter the size of second array");
		int n2 = scan.nextInt();
		int[] num2 = new int[n2];
		System.out.println("enter the second array ele:");
		for (int i = 0; i < num2.length; i++) {
			num2[i] = scan.nextInt();
		}
		
		
		
		
//		System.out.println("the ele are:");
//
//		for (int i = 0; i < num2.length; i++) {
//			System.out.println(num2[i]);
//		}
//		

		ArrayOpertions ob = new ArrayOpertions();
		ob.createArr();
		ob.printArr();
		ob.reverseArr();
		ob.mergeArr();
		ob.maxNum();
		ob.minNum();
		ob.union();
		ob.OccArr();
		ob.removeDup();
		ob.pattren();
		ob.pattrenAnother();
		ob.pattrenAnotherOne();
		ob.removeDup();
		ob.primeNumber();
		ob.union();
		ob.intersection();
		ob.printDuplicates();
	
	}

}
