package assignment;

public class Pattern38 {
	
	/*
	1
   010
  10101
 0101010
101010101
	 */

	public static void main(String[] args) {
		int n = 5;

        for (int i=0; i<n; i++) {
            for (int j=0; j <n-i-1; j++) {
                System.out.print(" ");
            }
            for (int j=0; j<2*i+1; j++) {
                if ((i+j)%2==0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }

            System.out.println(); // Move to the next line
        }

	}

}
