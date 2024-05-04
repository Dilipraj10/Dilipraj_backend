package assignment;

public class Pattern39 {
	
	/*
1 0 1 0 1 
1 0 1 0 1 
1 0 1 0 1 
1 0 1 0 1 
1 0 1 0 1 
	 */

	public static void main(String[] args) {
		
		 int  r=5;
	        int c=5;

	        for (int i=0; i<r; i++) {
	            for (int j=0; j<c; j++) {
	                if (j%2==0) {
	                    System.out.print("1 ");
	                } else {
	                    System.out.print("0 ");
	                }
	            }
	            System.out.println();
	        }

	}

}
