package assignment;

public class Pattern20 {
	
	/*
	1
   101
  10101
 1010101
101010101

	 */

	public static void main(String[] args) {
		
		int n = 5;
        
        for (int i=0; i<n; i++) {
            // Print spaces
            for (int j=0; j<n-i-1; j++) {
                System.out.print(" ");
            }
            
            for (int j=0; j<2*i+1; j++) {
                if (j%2==0) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            
            System.out.println(); 
        }

	}

}
