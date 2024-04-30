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
		int[] arr3 = new int[arr1.length + arr2.length];
		int k = 0;
		for (int i = 0; i < arr1.length; i++) {
			arr3[k] = arr1[i];
			k++;
		}

		for (int i = 0; i < arr2.length; i++) {
			arr3[k] = arr2[i];
			k++;
		}

		for (int i = 0; i < arr3.length; i++) {
			System.out.print(arr3[i]);

		}

	}

	public void sortArr(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {

			if (arr[i] < arr[i + 1]) {
				int temp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = temp;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}

	public void maxNum(int[] arr) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("max value is:" + max);
	}

	public void minNum(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("min value is :" + min);
	}

	public void union() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 4, 5, 6, 8, 9 };

		int[] arr3 = new int[arr1.length + arr2.length];
		int k = 0;
		for (int i = 0; i < arr1.length; i++) {
			arr3[k] = arr1[i];
			k++;
		}

//		
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr3[i] != arr2[j]) {
					arr3[k] = arr2[j];
					k++;
				}
			}

		}

//		for(int i=0;i<arr3.length;i++) {
//			System.out.print(arr3[k]);
//		}
	}

	public void intersectionArr(int[] a, int[] b)

	{
		int k = 0;
		int[] c = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					c[k] = a[i];
					k++;
				}
			}
		}
		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i]);
		}
	}

	public void OccArr() {
		int[] arr = { 1, 2, 3, 5, 6, 7, 5, 5 };
		int k = 5;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == k) {
				count++;
			}
		}

		System.out.println(count);
	}

	public void removeDup(int[] arr) {
		int[] br = new int[arr.length];
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean rs = true;
			for (int j = 0; j < k; j++) {
				if (arr[i] == br[j]) {
					rs = false;
					break;
				}
			}
			if (rs)
				br[k++] = arr[i];
		}
		int[] rs = new int[k];
		for (int i = 0; i < rs.length; i++) {
			rs[i] = br[i];
		}
		for (int i = 0; i < rs.length; i++) {
			System.out.print(rs[i]);
		}
	}

	public void printDuplicate(int[] arr) {
		int[] c = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[i + 1]) {
				c[i] = arr[i];
			}
		}
		for (int k = 0; k < c.length; k++) {
			System.out.print(c[k]);
		}
	}
	
	
	public void countPrimenum(int[] arr)
	{
		int count=0;
		for(int i=0;i<arr.length;i++) {
			boolean rs=isPrime(arr[i]);
			if(rs)
				count++;
		}
		System.out.println(count);
	}

	static boolean isPrime(int n) {
		for(int i=2;i<=n/2;i++) {
			if(n%2==0)
				return false;
		}
		return true;
	}
	
	
	

	public void zigZagArr(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int res = 0;
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			c[res++] = a[i++];
			c[res++] = b[j++];
		}
		while (i < a.length) {
			c[res++] = a[i++];
		}
		while (j < b.length) {
			c[res++] = b[j++];
		}
		for (int k = 0; k < c.length; k++) {
			System.out.print(c[k]);
		}
	}

	public void pattren() {
//		11111
//		22222
//		33333
//		44444
//		55555

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public void pattrenAnother() {
//		12345
//		12345
//		12345
//		12345
//		12345

		int n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
//				row
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public void pattrenAnotherOne() {
//		1
//		23
//		345
//		4567
//		56789

		int n = 5;
		for (int i = 1; i <= n; i++) {
			int k = i;
			for (int j = 1; j <= n; j++) {
//				
				System.out.print(k + " ");
				k++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
//
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
//		ob.removeDup();
//		ob.sortArr(num1);
//		ob.intersectionArr(num1, num2);
//		ob.countPrimenum(num1);
		
	}

}
