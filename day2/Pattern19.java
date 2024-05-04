package assignment;

public class Pattern19 {
	
	
/*
    1
   000
  11111
 0000000
111111111

 */

	public static void main(String[] args) {
		
		
		 int n=5;
	        
	        for (int i=0; i<n; i++) {
	            for (int j=0; j<n-i-1; j++) {
	                System.out.print(" ");
	            }	            
	            for (int j=0; j<2*i+1; j++) {
	                if (i% 2==0) {
	                    System.out.print("0");
	                } else {
	                    System.out.print("1");
	                }
	            }
	            
	            System.out.println(); 
	        }
	}

}
